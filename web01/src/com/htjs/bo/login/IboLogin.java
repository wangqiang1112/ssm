package com.htjs.bo.login;

import java.util.List;
import com.htjs.bean.login.User;

/**
 * Created by Administrator on 2017/1/22.
 */
public interface IboLogin {
    User findById(int id);
    List<User> userList();
}
