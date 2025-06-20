package vn.com.claim.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ClaimRequest {

    private String nameProduct;
    private String description;
    private Double amount;
    private LocalDate claimDate;

    private List<DocumentRequest> documents;

    private CustomerRequest customer;
}
