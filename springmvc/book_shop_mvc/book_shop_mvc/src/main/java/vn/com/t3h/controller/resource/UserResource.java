package vn.com.t3h.controller.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.t3h.model.response.PageResponse;
import vn.com.t3h.model.response.UserResponse;
import vn.com.t3h.service.UserService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<PageResponse<List<UserResponse>>> getAllUsers(
            @RequestParam(name = "pageIndex") Long pageIndex, @RequestParam(name = "pageSize") Long pageSize,
            @RequestParam(name = "username",required = false) String username,
            @RequestParam(name = "active",required = false) Boolean active,
            @RequestParam(name = "createdDate",required = false)LocalDate createDate
            ) {
        return userService.getAllUser(pageIndex, pageSize, username, active, createDate);
    }

}
