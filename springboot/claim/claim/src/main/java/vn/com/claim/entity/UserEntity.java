package vn.com.claim.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private String phone;
    private String pathAvatar;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private String mimeType;

    @ManyToMany()
    @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<RoleEntity>();

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
