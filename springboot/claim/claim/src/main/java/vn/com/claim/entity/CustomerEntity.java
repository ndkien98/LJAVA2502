package vn.com.claim.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

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


    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL)
    List<ClaimEntity> claims;

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
