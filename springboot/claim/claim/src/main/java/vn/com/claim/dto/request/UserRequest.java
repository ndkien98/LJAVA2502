package vn.com.claim.dto.request;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Integer age;
    private String avatarStringBase64;


}
