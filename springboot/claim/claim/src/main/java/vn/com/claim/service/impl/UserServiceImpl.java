package vn.com.claim.service.impl;

import org.springframework.stereotype.Service;
import vn.com.claim.entity.UserEntity;
import vn.com.claim.repository.UserRepository;
import vn.com.claim.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
