package com.htjs.action.tags;

import com.htjs.base.BaseAction;

public class TagsAction extends BaseAction{
	private String action_param;
    
	/**
	 * 跳转到标签页面
	 * @return
	 */
	public String toTags(){
		return "success";
	}
	
	
	/**
	 * 获取jsp的action标签中param中的参数
	 */
	public void tag_action(){
		addRequestAttribute("param", "oooooo");
		System.out.println("action标签中param中的参数==="+action_param);
	}
	
	
	
	public String getAction_param() {
		return action_param;
	}

	public void setAction_param(String action_param) {
		this.action_param = action_param;
	}
	
	
	
	
	
    
    
}
