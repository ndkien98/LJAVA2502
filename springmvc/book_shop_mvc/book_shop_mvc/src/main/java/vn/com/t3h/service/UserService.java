package vn.com.t3h.service;

import org.springframework.http.ResponseEntity;
import vn.com.t3h.model.response.PageResponse;
import vn.com.t3h.model.response.UserResponse;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    ResponseEntity<PageResponse<List<UserResponse>>> getAllUser(Long pageIndex,
                                                                Long pageSize,
                                                                String username,
                                                                Boolean active,
                                                                LocalDate createdDate);
}
