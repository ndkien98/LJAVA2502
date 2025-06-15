package vn.com.claim.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.claim.entity.UserEntity;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    @Query(value = "select u from UserEntity u where (:username is null or u.username=:username) " +
            "and (:fromDate is null or u.createdDate >= :fromDate) " +
            "and (:toDate is null or u.createdDate <= :toDate)" +
            "and (:phone is null or u.phone = :phone)")
    Page<UserEntity> findAllByCondition(String username, LocalDate fromDate, LocalDate toDate, String phone, Pageable pageable);

}
