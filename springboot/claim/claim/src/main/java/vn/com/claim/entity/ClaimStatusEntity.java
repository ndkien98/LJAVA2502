package vn.com.claim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Entity
@Table(name = "claim_status")
@Data
public class ClaimStatusEntity extends BaseEntity{

    private String code;
    private String description;

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }
}
