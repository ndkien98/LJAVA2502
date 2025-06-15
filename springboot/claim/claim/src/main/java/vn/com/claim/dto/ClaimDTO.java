package vn.com.claim.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClaimDTO {

    private String code;
    private String customerName;
    private String nameProduct;
    private LocalDate claimDate;
    private String coverageProduct;
    private String statusName;
    private String statusCode;

}
