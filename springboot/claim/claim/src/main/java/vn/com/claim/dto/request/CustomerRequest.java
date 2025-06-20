package vn.com.claim.dto.request;

import lombok.Data;

@Data
public class CustomerRequest {
    private String address;
    private String bankName;
    private String bankNumber;
    private String email;
    private String name;
    private String phoneNumber;
}
