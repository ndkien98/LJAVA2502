package vn.com.claim.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.com.claim.dto.UserDTO;
import vn.com.claim.entity.UserEntity;
import vn.com.claim.repository.UserRepository;
import vn.com.claim.service.UserService;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDTO> getUsers(String username, LocalDate fromDate, LocalDate toDate, String phone, Pageable pageable) {

        if (StringUtils.isEmpty(username)) {
            username = null;
        }
        if (StringUtils.isEmpty(phone)) {
            phone = null;
        }


        return List.of();
    }
}
