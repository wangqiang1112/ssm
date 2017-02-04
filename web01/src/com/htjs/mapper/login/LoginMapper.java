package com.htjs.mapper.login;

import java.util.List;

import com.htjs.bean.login.User;

/**
 * Created by Administrator on 2017/1/23.
 */
public interface LoginMapper {
    User findUserById(int id);
    List<User> userList();
}
