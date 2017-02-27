package com.htjs.action.login;


import java.util.*;

import org.apache.log4j.Logger;

import com.htjs.base.BaseAction;
import com.htjs.bean.login.User;
import com.htjs.bo.login.IboLogin;

/**
 * Created by Administrator on 2017/1/22.
 */
public class LoginAction extends BaseAction{
	Logger log = Logger.getLogger(LoginAction.class.getName());
    private IboLogin boLogin;
    private User user;

    /**
     * 登陆
     * @return
     */
    public String login() {
    	Map<String,Object> parameterMap = new HashMap<String, Object>();
    	String name = getRequest().getParameter("name");
    	System.out.println("登陆action="+name);
    	parameterMap.put("name", name);
    	log.info("登陆=====");
    	addRequestAttribute("parameterMap", parameterMap);
    	
    	addRequestAttribute("name", "name==");
        return "success";
    }

    /**
     * 跳转到文件处理页面
     * @return
     */
    public String toFilePage(){
        return "success";
    }

    /**
     * 用户列表
     * @return
     */
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
