package vn.com.t3h.service.impl;

import org.springframework.stereotype.Service;
import vn.com.t3h.service.UserService;

import java.util.ArrayList;
import java.util.List;

/*
Spring IOC :
    khi start service lên sẽ tu đọng tìm kiếm các class được đánh dấu annotaion và khởi tạo tạo bean
    UserService beanUserService = new UserServiceImpl()

    beanUserService.getUsers();
    beanUserService singertance => chỉ có 1 bean duy nhất
    màn nhình a -> beanUserService.name = "admin1";
    màn hình b -> beanUserService.name = "admin2";

 */
@Service()
public class UserServiceImpl implements UserService {

    public String name = "admin";


    List<Object> getUsers() {
        List<Object> users = new ArrayList<Object>();
        return users;
    }
}
