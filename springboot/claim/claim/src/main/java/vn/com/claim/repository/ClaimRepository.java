package vn.com.claim.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.claim.entity.ClaimEntity;

import java.time.LocalDate;

@Repository
public interface ClaimRepository extends JpaRepository<ClaimEntity,Long> {


    @Query(value = "select c from ClaimEntity c " +
            "left join c.claimStatusEntity s where " +
            "(:claimCode is null or c.code = :claimCode) and " +
            "(:fromDateClaim is null or c.claimDate >= :fromDateClaim) and " +
            "(:toDateClaim is null or c.claimDate <= :toDateClaim) and " +
            "(:codeStatus is null or s.code = :codeStatus)")
    Page<ClaimEntity> findByCondition(@Param("claimCode") String claimCode,
                                      LocalDate fromDateClaim,
                                      LocalDate toDateClaim,
                                      String codeStatus,
                                      Pageable pageable);
}
