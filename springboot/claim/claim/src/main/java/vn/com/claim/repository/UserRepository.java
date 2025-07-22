package vn.com.claim.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.claim.entity.UserEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    @Query("select u from UserEntity u " +
            "where (:username is null or u.username = :username) " +
            "and (:fullName is null or lower(u.fullName) like lower(concat('%', :fullName, '%'))) " +
            "and (:fromDate is null or u.createdDate >= :fromDate) " +
            "and (:toDate is null or u.createdDate <= :toDate) " +
            "and (:age is null or u.age = :age)")
    Page<UserEntity> findAllByCondition(String username, String fullName, LocalDateTime fromDate, LocalDateTime toDate, Integer age, Pageable pageable);

    UserEntity findByUsername(String username);


    Boolean existsAllByUsernameOrEmailOrPhone(String username, String email, String phone);

}
