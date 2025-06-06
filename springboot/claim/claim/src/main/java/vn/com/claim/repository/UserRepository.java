package vn.com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.claim.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


}
