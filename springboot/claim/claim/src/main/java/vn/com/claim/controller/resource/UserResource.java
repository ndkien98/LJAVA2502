package vn.com.claim.controller.resource;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.claim.dto.UserDTO;
import vn.com.claim.dto.response.ResponsePage;
import vn.com.claim.entity.UserEntity;
import vn.com.claim.service.UserService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<ResponsePage<List<UserDTO>>> findAll(@RequestParam(required = false) String username,
                                                @RequestParam(required = false) String fullName,
                                                @RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) LocalDate fromDate,
                                                @RequestParam(required = false) LocalDate toDate,
                                                Pageable pageable) {
        return ResponseEntity.ok(userService.getUsers(username, fullName, fromDate, toDate, age, pageable));
    }
}
