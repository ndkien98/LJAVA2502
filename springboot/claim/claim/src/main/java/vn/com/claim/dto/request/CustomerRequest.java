package vn.com.claim.dto.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String bankName;
    private String bankNumber;
}
