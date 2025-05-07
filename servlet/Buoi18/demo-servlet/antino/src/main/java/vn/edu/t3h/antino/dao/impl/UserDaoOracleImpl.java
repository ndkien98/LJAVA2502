package vn.edu.t3h.antino.dao.impl;

import vn.edu.t3h.antino.dao.IUserDao;
import vn.edu.t3h.antino.model.UserModel;

import java.util.List;

public class UserDaoOracleImpl implements IUserDao {
    @Override
    public List<UserModel> getUsers() {
        return List.of();
    }
}
