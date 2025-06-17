package vn.com.claim.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import vn.com.claim.dto.UserDTO;
import vn.com.claim.entity.UserEntity;
//import vn.com.claim.mapper.impl.UserMapperImpl;

import java.util.List;

@Mapper(componentModel = "spring")
//@DecoratedWith(UserMapperImpl.class)
public interface UserMapper {

    UserDTO toDto(UserEntity userEntity);

    List<UserDTO> toDto(List<UserEntity> userEntities);
}
