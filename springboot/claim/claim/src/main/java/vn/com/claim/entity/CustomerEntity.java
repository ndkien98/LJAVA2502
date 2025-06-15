package vn.com.claim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
@Data
public class CustomerEntity extends BaseEntity {


    private String address;
    private String bankName;
    private String bankNumber;
    private String email;
    private String name;
    private String phoneNumber;


}
