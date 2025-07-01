package vn.com.claim.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ClaimRequest {

    private CustomerRequest customer;

    private String nameProduct;
    private Double amount;
    private LocalDate claimDate;
    private String description;


    private List<DocumentRequest> documents;

}
