package vn.com.claim.service;

import org.springframework.data.domain.Pageable;
import vn.com.claim.dto.UserDTO;
import vn.com.claim.dto.request.UserRequest;
import vn.com.claim.dto.response.ResponsePage;
import vn.com.claim.entity.UserEntity;

import java.time.LocalDate;
import java.util.List;

public interface UserService {


    ResponsePage<List<UserDTO>> getUsers(String username, String fullName, LocalDate fromDate, LocalDate toDate, Integer age, Pageable pageable);


    String createUser(UserRequest userRequest);

}
