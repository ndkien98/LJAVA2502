package vn.com.claim.service;

import org.springframework.data.domain.Pageable;
import vn.com.claim.dto.ClaimDTO;
import vn.com.claim.dto.response.ResponsePage;

import java.time.LocalDate;
import java.util.List;

public interface ClaimService {


    ResponsePage<List<ClaimDTO>> getClaims(String claimCode, LocalDate fromDateClaim, LocalDate toDateClaim, String codeStatus, Pageable pageable);
}
