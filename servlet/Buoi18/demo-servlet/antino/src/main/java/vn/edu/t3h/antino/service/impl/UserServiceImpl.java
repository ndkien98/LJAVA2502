package vn.edu.t3h.antino.service.impl;

import vn.edu.t3h.antino.dao.IUserDao;
import vn.edu.t3h.antino.dao.impl.UserDaoImpl;
import vn.edu.t3h.antino.dao.impl.UserDaoOracleImpl;
import vn.edu.t3h.antino.model.UserModel;
import vn.edu.t3h.antino.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao;
    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserModel> getListUser() {
        return userDao.getUsers();
    }
}
