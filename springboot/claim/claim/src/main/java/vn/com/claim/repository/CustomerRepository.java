package vn.com.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.claim.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {


    @Query(value = "select c from CustomerEntity c where c.phoneNumber =:phone and c.email =:email")
    CustomerEntity findByPhoneAndEmail(@Param("phone") String phoneNumber, String email);
}
