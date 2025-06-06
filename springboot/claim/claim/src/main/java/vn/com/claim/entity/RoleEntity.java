package vn.com.claim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
@Data
public class RoleEntity extends BaseEntity {

    private String name;
    private String code;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;


}
