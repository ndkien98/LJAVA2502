package vn.com.claim.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import vn.com.claim.utils.Constants;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime lastModifiedDate = LocalDateTime.now();
    private String createdBy = Constants.SYSTEM.ADMIN.toString();;
    private String lastModifiedBy = Constants.SYSTEM.ADMIN.toString();
    private Boolean deleted = Boolean.FALSE;


}
