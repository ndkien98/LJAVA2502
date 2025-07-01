package vn.com.claim.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(mappedBy = "claimEntity",cascade = CascadeType.ALL)
    private Set<ClaimDocumentEntity> claimDocumentEntity;

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

}
