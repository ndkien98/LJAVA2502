package vn.com.claim.service;

import org.springframework.data.domain.Pageable;
import vn.com.claim.dto.UserDTO;
import vn.com.claim.entity.UserEntity;

import java.time.LocalDate;
import java.util.List;

public interface UserService {


    List<UserDTO> getUsers(String username, LocalDate fromDate, LocalDate toDate, String phone, Pageable pageable);
}
