package vn.com.claim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "roles")
@Data
public class RoleEntity extends BaseEntity {

    private String name;
    private String code;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<UserEntity> users;

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }


}
