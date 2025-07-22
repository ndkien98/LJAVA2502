package vn.com.claim.service.impl;

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
import vn.com.claim.service.FileService;
import vn.com.claim.utils.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;

    private final ClaimMapper claimMapper;

    private final ClaimStatusRepository claimStatusRepository;

    private final CustomerRepository customerRepository;

    private final InsuranceProductEntityRepository productEntityRepository;

    private final FileService fileService;

    public ClaimServiceImpl(ClaimRepository claimRepository, ClaimMapper claimMapper, ClaimStatusRepository claimStatusRepository, CustomerRepository customerRepository, InsuranceProductEntityRepository productEntityRepository, FileService fileService) {
        this.claimRepository = claimRepository;
        this.claimMapper = claimMapper;
        this.claimStatusRepository = claimStatusRepository;
        this.customerRepository = customerRepository;
        this.productEntityRepository = productEntityRepository;
        this.fileService = fileService;
    }

    @Override
    public Response<String> createClaim(ClaimRequest claimRequest) {

        // 1.
        ClaimEntity claimEntity = getClaimEntity(claimRequest);
        //2.
        ClaimStatusEntity status = claimStatusRepository.findByCode(Constants.STATUS_CODE.NEW.name());
        claimEntity.setClaimStatusEntity(status);

        //3
        CustomerRequest customerRequest = claimRequest.getCustomer();
        CustomerEntity customerEntity = getCustomerEntity(customerRequest, claimEntity);
        // 4 set product
        InsuranceProductEntity productEntity = productEntityRepository.findByName(claimRequest.getNameProduct());
        claimEntity.setInsuranceProductEntity(productEntity);
        // 5 set claim document
        Set<ClaimDocumentEntity> claimDocumentEntities = fileService.getClaimDocumentEntities(claimRequest, claimEntity);
        claimEntity.setClaimDocumentEntity(claimDocumentEntities);

        // 6 save data to database
        customerRepository.save(customerEntity);

        Response<String> response = new Response<>();
        response.setCode(HttpStatus.OK.value());
        response.setMessage("success");
        response.setData(claimEntity.getCode());
        return response;
    }

    private ClaimEntity getClaimEntity(ClaimRequest claimRequest) {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setAmount(claimRequest.getAmount());
        claimEntity.setClaimDate(claimRequest.getClaimDate() == null ? LocalDate.now() : claimRequest.getClaimDate());
        claimEntity.setDescription(claimRequest.getDescription());
        Long totalClaim = claimRepository.count();
        claimEntity.setCode(Constants.createCode(totalClaim, Constants.PREFIX_CODE_CLAIM, Constants.VALUE_CODE_CLAIM));
        return claimEntity;
    }

    private CustomerEntity getCustomerEntity(CustomerRequest customerRequest, ClaimEntity claimEntity) {
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
        return customerEntity;
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
