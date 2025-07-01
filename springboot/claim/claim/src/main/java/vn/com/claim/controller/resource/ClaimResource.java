package vn.com.claim.controller.resource;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.claim.dto.ClaimDTO;
import vn.com.claim.dto.request.ClaimRequest;
import vn.com.claim.dto.response.Response;
import vn.com.claim.dto.response.ResponsePage;
import vn.com.claim.service.ClaimService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/claim")
@AllArgsConstructor
public class ClaimResource {

    private final ClaimService claimService;
    /*
    http://localhost:8080/api/claim?page=0&size=6&claimCode=&fromDate=&toDate=&codeStatus=
     */
    @GetMapping
    public ResponseEntity<ResponsePage<List<ClaimDTO>>> getListClaim(
            @RequestParam(required = false) String claimCode,
            @RequestParam(required = false) LocalDate fromDate,
            @RequestParam(required = false) LocalDate toDate,
            @RequestParam(required = false) String codeStatus,
            Pageable pageable
            /*
            pageable: là class sử dụng để phân trang trong spring data jpa
                đại diện cho 2 param:
                    1. page
                    2. size
                vẫn sẽ truyền 2 param page, size trong url như bình thường, tự động spring sẽ tạo ra pageable từ 2 param đó
             */
    ) {
        ResponsePage<List<ClaimDTO>> responsePage = claimService.getClaims(claimCode, fromDate, toDate, codeStatus, pageable);
        return ResponseEntity.ok(responsePage);
    }

    @PostMapping("/create")
    public ResponseEntity<Response<String>> createdClaim(@RequestBody ClaimRequest claimRequest){
        Response<String> response = claimService.createClaim(claimRequest);
        return ResponseEntity.ok(response);
    }

}
