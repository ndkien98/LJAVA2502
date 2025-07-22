package vn.com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.claim.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    /**
     * Finds a RoleEntity by its code.
     *
     * @param code the code of the role
     * @return the RoleEntity with the specified code, or null if not found
     */
    RoleEntity findByCode(String code);
}
