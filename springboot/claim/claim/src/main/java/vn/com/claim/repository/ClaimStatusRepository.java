package vn.com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.claim.entity.ClaimStatusEntity;

@Repository
public interface ClaimStatusRepository extends JpaRepository<ClaimStatusEntity, Long> {

    ClaimStatusEntity findByCode(String code);
}
