package vn.com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.claim.entity.InsuranceProductEntity;

@Repository
public interface InsuranceProductEntityRepository extends JpaRepository<InsuranceProductEntity,Long> {

    InsuranceProductEntity findByName(String name);
}
