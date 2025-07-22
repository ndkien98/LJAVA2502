package vn.com.claim.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import vn.com.claim.dto.UserDTO;
import vn.com.claim.dto.request.UserRequest;
import vn.com.claim.dto.response.ResponsePage;
import vn.com.claim.entity.RoleEntity;
import vn.com.claim.entity.UserEntity;
import vn.com.claim.repository.RoleRepository;
import vn.com.claim.repository.UserRepository;
import vn.com.claim.service.FileService;
import vn.com.claim.service.UserService;
import vn.com.claim.utils.Constants;
import vn.com.claim.utils.SessionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    private final FileService fileService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, FileService fileService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.fileService = fileService;
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
                .map(this::getUserDTO)
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

    private UserDTO getUserDTO(UserEntity user) {
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
        userDTO.setCreatedDate(user.getCreatedDate());
        userDTO.setLastModifiedDate(user.getLastModifiedDate());
        userDTO.setCreatedBy(user.getCreatedBy());
        userDTO.setLastModifiedBy(user.getLastModifiedBy());
        userDTO.setStringBase64Avatar(fileService.getBase64FromFile(user.getPathAvatar()));
        userDTO.setMimeType(user.getMimeType());
        return userDTO;
    }

    @Override
    public UserDTO getUserById(Long id) {

        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()){
            throw new RuntimeException("User not found with id: " + id);
        }

        UserDTO userDTO = getUserDTO(userEntity.get());
        return userDTO;
    }

    @Override
    public String createUser(UserRequest userRequest) {

        // validate user request
        validateUserRequest(userRequest);

        UserDetails currentUser = SessionUtils.getCurrentUser();

        // create user entity
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(userRequest.getUsername().trim());
        userEntity.setFullName(userRequest.getFirstName() + " " + userRequest.getLastName());
        userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setEmail(userRequest.getEmail().trim());
        userEntity.setAge(userRequest.getAge());
        userEntity.setPhone(userRequest.getPhoneNumber());
        userEntity.setAddress(userRequest.getAddress().trim());
        userEntity.setCode(Constants.createCode(userRepository.count(), Constants.PREFIX_CODE_USER,Constants.VALUE_CODE_USER));
        userEntity.setCreatedBy(currentUser.getUsername());
        userEntity.setLastModifiedBy(currentUser.getUsername());

        // set role for user
        RoleEntity roleEntity = roleRepository.findByCode(Constants.ROLE.USER.name());
        if (roleEntity == null) {
            throw new IllegalArgumentException("Role not found");
        }
        userEntity.setRoles(Set.of(roleEntity));
        // save file avatar if provided
        fileService.setAvatarUser(userRequest,userEntity);
        // save user entity
        userRepository.save(userEntity);
        // return user code
        return userEntity.getUsername();
    }

    private void validateUserRequest(UserRequest userRequest) {
        if (userRequest == null) {
            throw new IllegalArgumentException("User request cannot be null");
        }
        if (!StringUtils.hasText(userRequest.getUsername())) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (!StringUtils.hasText(userRequest.getFirstName())) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }
        if (userRequest.getAge() != null && userRequest.getAge() < 0) {
            throw new IllegalArgumentException("Age must be a non-negative integer");
        }
        if (!StringUtils.hasText(userRequest.getEmail())) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (!StringUtils.hasText(userRequest.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }
        if (!StringUtils.hasText(userRequest.getAddress())) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        if (userRepository.existsAllByUsernameOrEmailOrPhone(userRequest.getUsername(), userRequest.getEmail(), userRequest.getPhoneNumber())) {
            throw new IllegalArgumentException("User already exists");
        }

    }
}
