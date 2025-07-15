package vn.com.claim.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    private Long id;
    private String code;
    private String username;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phone;
    private String roleName;
    private String address;
    private String fullName;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private String stringBase64Avatar;
    private String mimeType;

}
