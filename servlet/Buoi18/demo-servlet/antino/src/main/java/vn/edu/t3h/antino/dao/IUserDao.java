package vn.edu.t3h.antino.dao;

import vn.edu.t3h.antino.model.UserModel;

import java.util.List;

public interface IUserDao {

    List<UserModel> getUsers();
}
