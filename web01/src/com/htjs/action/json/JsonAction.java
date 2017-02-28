package com.htjs.action.json;

import java.util.HashMap;
import java.util.Map;

import com.htjs.base.BaseAction;

public class JsonAction extends BaseAction{
	public Map modelMap = new HashMap();
	/**
	 * 跳转到json页面
	 * @return
	 */
	public String toJsonPage(){
		modelMap.put("name", "zhangsan");
		modelMap.put("age", 3);
		return SUCCESS;
	}
	
	
	public Map getModelMap() {
		return modelMap;
	}
	public void setModelMap(Map modelMap) {
		this.modelMap = modelMap;
	}
	
	

}
