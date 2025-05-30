package vn.com.t3h.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.com.t3h.dao.UserDao;
import vn.com.t3h.entity.ProductionEntity;
import vn.com.t3h.entity.RoleEntity;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.model.response.PageResponse;
import vn.com.t3h.model.response.UserResponse;
import vn.com.t3h.service.UserService;
import vn.com.t3h.utils.CaculatorUtils;
import vn.com.t3h.utils.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Spring IOC :
    khi start service lên sẽ tu đọng tìm kiếm các class được đánh dấu annotaion và khởi tạo tạo bean
    UserService beanUserService = new UserServiceImpl()

    beanUserService.getUsers();
    beanUserService singertance => chỉ có 1 bean duy nhất
    màn nhình a -> beanUserService.name = "admin1";
    màn hình b -> beanUserService.name = "admin2";

 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ResponseEntity<PageResponse<List<UserResponse>>> getAllUser(Long pageIndex, Long pageSize, String username, Boolean active, LocalDate createdDate) {

        username = StringUtils.formatQueryStr(username);

        Long totalElement = userDao.countAllUser(username, active, createdDate);
        Long totalPage = CaculatorUtils.getTotalPage(totalElement, pageIndex, pageSize);
        Long offset = CaculatorUtils.getOffset(pageIndex, pageSize);

        List<UserEntity> userEntities = userDao.getAll(offset,pageSize,username,active,createdDate);
        // convert entity -> dto (response)
        List<UserResponse> userResponses = userEntities.stream()
                .map(userEntity -> {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setId(userEntity.getId());
                    userResponse.setUsername(userEntity.getUsername());
                    userResponse.setActive(userEntity.getActive());
                    userResponse.setFullName(userEntity.getFullName());
                    userResponse.setCreated(userEntity.getCreated().format(DateTimeFormatter.ISO_DATE));
                    userResponse.setAge(userEntity.getAge());
                    if (!CollectionUtils.isEmpty(userEntity.getRoles())) {
                        userResponse.setRoleName(userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.joining(",")));
                    }
                    return userResponse;
                }).collect(Collectors.toList());

        PageResponse<List<UserResponse>> pageResponse = new PageResponse<>();
        pageResponse.setMessage("Success");
        pageResponse.setCode(HttpStatus.OK.name());
        pageResponse.setData(userResponses);
        pageResponse.setPageIndex(pageIndex);
        pageResponse.setPageSize(pageSize);
        pageResponse.setTotalPages(totalPage);
        pageResponse.setTotalElements(totalElement);
        return ResponseEntity.ok(pageResponse);
    }


}
