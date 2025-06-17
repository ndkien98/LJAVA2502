//package vn.com.claim.mapper.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import vn.com.claim.dto.UserDTO;
//import vn.com.claim.entity.RoleEntity;
//import vn.com.claim.entity.UserEntity;
//import vn.com.claim.mapper.UserMapper;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class UserMapperImpl implements UserMapper {
//
//    @Autowired
//    @Qualifier("delegate")
//    private UserMapper userMapper;
//
//    @Override
//    public UserDTO toDto(UserEntity userEntity) {
//        UserDTO userDTO = userMapper.toDto(userEntity);
//        userDTO.setRoleName(userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.joining(",")));
//        return userDTO;
//    }
//
//    @Override
//    public List<UserDTO> toDto(List<UserEntity> userEntities) {
//        return userEntities.stream().map(this::toDto).collect(Collectors.toList());
//    }
//}
