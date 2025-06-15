package vn.com.claim.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "claim")
@Data
public class ClaimEntity extends BaseEntity{

    private Double amount;
    private LocalDate claimDate;
    private String code;
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private ClaimStatusEntity claimStatusEntity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private InsuranceProductEntity insuranceProductEntity;

    @OneToMany(mappedBy = "claimEntity")
    private Set<ClaimDocumentEntity> claimDocumentEntity;

}
