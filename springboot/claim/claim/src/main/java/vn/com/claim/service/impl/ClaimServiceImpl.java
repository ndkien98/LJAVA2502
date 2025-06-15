package vn.com.claim.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.com.claim.dto.ClaimDTO;
import vn.com.claim.dto.response.ResponsePage;
import vn.com.claim.entity.ClaimEntity;
import vn.com.claim.mapper.ClaimMapper;
import vn.com.claim.repository.ClaimRepository;
import vn.com.claim.service.ClaimService;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;

    private final ClaimMapper claimMapper;

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
