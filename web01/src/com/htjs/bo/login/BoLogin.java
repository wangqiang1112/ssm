package com.htjs.bo.login;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.htjs.bean.login.User;
import com.htjs.mapper.login.LoginMapper;

/**
 * Created by Administrator on 2017/1/22.
 */
public class BoLogin implements IboLogin {
	@Autowired
	private LoginMapper loginMapper;
	
    public BoLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

    //根据id查询
	public User findById(int id){
        User user = loginMapper.findUserById(id);
        return user;
    }
	
	/**
	 * 查询所有用户
	 */
	public List<User> userList() {
		List<User> userList = loginMapper.userList();
		return userList;
	}
    
    
    //set get方法
	public LoginMapper getLoginMapper() {
		return loginMapper;
	}

	public void setLoginMapper(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

}
