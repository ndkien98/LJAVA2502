package vn.com.claim.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.com.claim.dto.ClaimDTO;
import vn.com.claim.dto.request.ClaimRequest;
import vn.com.claim.dto.request.CustomerRequest;
import vn.com.claim.dto.request.DocumentRequest;
import vn.com.claim.dto.response.Response;
import vn.com.claim.dto.response.ResponsePage;
import vn.com.claim.entity.*;
import vn.com.claim.mapper.ClaimMapper;
import vn.com.claim.repository.ClaimRepository;
import vn.com.claim.repository.ClaimStatusRepository;
import vn.com.claim.repository.CustomerRepository;
import vn.com.claim.repository.InsuranceProductEntityRepository;
import vn.com.claim.service.ClaimService;
import vn.com.claim.utils.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Value("${file.root.folder}")
    private String fileRootFolder;
    @Value("${file.document}")
    private String folderDocument;

    private final ClaimRepository claimRepository;

    private final ClaimMapper claimMapper;

    private final ClaimStatusRepository claimStatusRepository;

    private final CustomerRepository customerRepository;

    private final InsuranceProductEntityRepository productEntityRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository, ClaimMapper claimMapper, ClaimStatusRepository claimStatusRepository, CustomerRepository customerRepository, InsuranceProductEntityRepository productEntityRepository) {
        this.claimRepository = claimRepository;
        this.claimMapper = claimMapper;
        this.claimStatusRepository = claimStatusRepository;
        this.customerRepository = customerRepository;
        this.productEntityRepository = productEntityRepository;
    }

    @Override
    public Response<String> createClaim(ClaimRequest claimRequest) {

        // 1.
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setAmount(claimRequest.getAmount());
        claimEntity.setClaimDate(claimRequest.getClaimDate() == null ? LocalDate.now() : claimRequest.getClaimDate());
        claimEntity.setDescription(claimRequest.getDescription());
        Long totalClaim = claimRepository.count();
        claimEntity.setCode(Constants.createCodeClaim(totalClaim));

        //2.
        ClaimStatusEntity status = claimStatusRepository.findByCode(Constants.STATUS_CODE.NEW.name());
        claimEntity.setClaimStatusEntity(status);

        //3
        CustomerRequest customerRequest = claimRequest.getCustomer();
        CustomerEntity customerEntity = customerRepository.findByPhoneAndEmail(customerRequest.getPhoneNumber(), customerRequest.getEmail());
        if (customerEntity == null) {
            customerEntity = new CustomerEntity();
            customerEntity.setPhoneNumber(customerRequest.getPhoneNumber());
            customerEntity.setEmail(customerRequest.getEmail());
            customerEntity.setName(customerRequest.getName());
            customerEntity.setAddress(customerRequest.getAddress());
            customerEntity.setBankName(customerRequest.getBankName());
            customerEntity.setBankNumber(customerRequest.getBankNumber());
            customerEntity.setClaims(new ArrayList<>());
        }
        customerEntity.getClaims().add(claimEntity);

        claimEntity.setCustomerEntity(customerEntity);
        // 4 set product
        InsuranceProductEntity productEntity = productEntityRepository.findByName(claimRequest.getNameProduct());
        claimEntity.setInsuranceProductEntity(productEntity);
        // 5 save file document
        List<DocumentRequest> documentRequests = claimRequest.getDocuments();
        Set<ClaimDocumentEntity> claimDocumentEntities = new HashSet<>();
        for (DocumentRequest document : documentRequests) {

            String strBase64 = document.getFileBase64Encoded();
            if (strBase64.contains(",")){
                strBase64 = strBase64.split(",")[1];
            }

            String extension = "." + document.getDocumentType();
            // tạo ra tên file
            String fileName = new StringBuilder().append(claimEntity.getCode()).append("_").append(document.getDocumentName()).append(extension).toString();

            // tạo folder lưu file
            String folderPath = fileRootFolder + folderDocument;
            File folder = new File(folderPath);
            if (!folder.exists()){
                folder.mkdirs();
            }

            // tạo ra file bằng cách ghi toàn bộ byte vào file
            String filePath = folderPath + fileName;
            File file = new File(filePath);

            byte[] bytes = Base64.getDecoder().decode(strBase64);
            try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
                fileOutputStream.write(bytes);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            ClaimDocumentEntity claimDocumentEntity = new ClaimDocumentEntity();
            claimDocumentEntity.setClaimEntity(claimEntity);
            claimDocumentEntity.setDocumentName(document.getDocumentName());
            claimDocumentEntity.setDocumentType(document.getDocumentType());
            claimDocumentEntity.setFilePath(filePath);
            claimDocumentEntity.setUpdateDate(document.getUpdateDate() != null ? document.getUpdateDate() : LocalDate.now());
            claimDocumentEntities.add(claimDocumentEntity);
        }

        claimEntity.setClaimDocumentEntity(claimDocumentEntities);
        customerRepository.save(customerEntity);

        Response<String> response = new Response<>();
        response.setCode(HttpStatus.OK.value());
        response.setMessage("success");
        response.setData(claimEntity.getCode());
        return response;
    }

    @Override
    public ResponsePage<List<ClaimDTO>> getClaims(String claimCode, LocalDate fromDateClaim, LocalDate toDateClaim, String codeStatus, Pageable pageable) {

        if (StringUtils.isEmpty(claimCode)) {
            claimCode = null;
        }

        if (StringUtils.isEmpty(codeStatus)) {
            codeStatus = null;
        }

        Page<ClaimEntity> claimEntityPage = claimRepository.findByCondition(claimCode, fromDateClaim, toDateClaim, codeStatus, pageable);
        // convert entity -> dto
        List<ClaimDTO> claimDTOS = claimMapper.toDtos(claimEntityPage.getContent());
        // set data to response
        ResponsePage<List<ClaimDTO>> responsePage = new ResponsePage<>();
        responsePage.setData(claimDTOS);
        responsePage.setPageIndex(pageable.getPageNumber());
        responsePage.setPageSize(pageable.getPageSize());
        responsePage.setTotalElement(claimEntityPage.getTotalElements());
        responsePage.setTotalPage(claimEntityPage.getTotalPages());
        responsePage.setCode(HttpStatus.OK.value());
        responsePage.setMessage("success");
        return responsePage;
    }
}
