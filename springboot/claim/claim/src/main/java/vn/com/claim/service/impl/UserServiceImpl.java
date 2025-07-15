package vn.com.claim.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import vn.com.claim.dto.UserDTO;
import vn.com.claim.dto.response.ResponsePage;
import vn.com.claim.entity.RoleEntity;
import vn.com.claim.entity.UserEntity;
import vn.com.claim.repository.UserRepository;
import vn.com.claim.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public ResponsePage<List<UserDTO>> getUsers(String username, String fullName, LocalDate fromDate, LocalDate toDate, Integer age, Pageable pageable) {
        username = StringUtils.hasText(username) ? username.trim() : null;

        fullName = StringUtils.hasText(fullName) ? fullName.trim() : null;

        LocalDateTime fromDateTime = fromDate != null ? fromDate.atStartOfDay() : null;

        LocalDateTime toDateTime = toDate != null ? toDate.atTime(23, 59, 59) : null;

        if (age != null && age < 0) {
            throw new IllegalArgumentException("Age must be a non-negative integer");
        }

        var page = userRepository.findAllByCondition(username,fullName ,fromDateTime, toDateTime, age, pageable);
        var users = page.getContent();

        List<UserDTO> userDTOS = users.stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(user.getId());
                    userDTO.setUsername(user.getUsername());
                    userDTO.setFullName(user.getFullName());
                    userDTO.setEmail(user.getEmail());
                    userDTO.setAge(user.getAge());
                    userDTO.setCode(user.getCode());
                    userDTO.setPhone(user.getPhone());
                    userDTO.setAddress(user.getAddress());
                    if (!CollectionUtils.isEmpty(user.getRoles())){
                        userDTO.setRoleName(user.getRoles().stream().map(RoleEntity::getName).collect(Collectors.joining(",")));
                    }
                    return userDTO;
                })
                .toList();
        ResponsePage<List<UserDTO>> response = new ResponsePage<>();
        response.setPageIndex(pageable.getPageNumber());
        response.setPageSize(pageable.getPageSize());
        response.setTotalElement(page.getTotalElements());
        response.setCode(200);
        response.setData(userDTOS);
        response.setMessage("Success");
        response.setTotalPage(page.getTotalPages());
        return response;
    }
}
