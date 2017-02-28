package com.htjs.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation actioninvocation) throws Exception {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		String result = actioninvocation.invoke();
		long end = System.currentTimeMillis();
		System.out.println("action time = "+(end - start));
		return result;
	}

}
