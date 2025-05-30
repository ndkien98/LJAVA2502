package vn.com.t3h.dao;

import vn.com.t3h.entity.UserEntity;

import java.time.LocalDate;
import java.util.List;

public interface UserDao {
    Long countAllUser(String username, Boolean active, LocalDate createdDate);

    List<UserEntity> getAll(Long offset, Long pageSize, String username, Boolean active, LocalDate createdDate);

}
