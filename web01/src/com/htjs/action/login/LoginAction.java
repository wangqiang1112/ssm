package com.htjs.action.login;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.htjs.base.BaseAction;
import com.htjs.bean.login.User;
import com.htjs.bo.login.IboLogin;

/**
 * Created by Administrator on 2017/1/22.
 */
public class LoginAction extends BaseAction{
	
    private IboLogin boLogin;

    public String login() {
        return "success";
    }
    
    public String userList(){
    	List<User> userList = boLogin.userList();
    	addRequestAttribute("userList", userList);
    	System.out.println(userList);
        return "success";
    }

    //set get方法
    public IboLogin getBoLogin() {
        return boLogin;
    }

    public void setBoLogin(IboLogin boLogin) {
        this.boLogin = boLogin;
    }
}
