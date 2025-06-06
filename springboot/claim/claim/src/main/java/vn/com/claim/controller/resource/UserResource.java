package vn.com.claim.controller.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.claim.entity.UserEntity;
import vn.com.claim.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> userEntities = userService.getUsers();
        return ResponseEntity.ok(userEntities);
    }
}
