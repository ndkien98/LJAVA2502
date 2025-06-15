package vn.com.claim.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String code;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private String stringBase64Avatar;
    private String mimeType;
    private String roleName;


}
