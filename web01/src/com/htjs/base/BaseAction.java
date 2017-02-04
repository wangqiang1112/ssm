package com.htjs.base;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2017/1/22.
 */
public class BaseAction extends ActionSupport{
	protected HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }

    protected HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    protected HttpSession getSession() {
        return getRequest().getSession();
    }

    protected void addRequestAttribute(String s, Object o) {
        getRequest().setAttribute(s, o);
    }

    protected Object getRequestAttribute(String s) {
        return getRequest().getAttribute(s);
    }

    protected void addSessionAttribute(String s, Object o) {
        getSession().setAttribute(s, o);
    }

    protected Object getSessionAttribute(String s) {
        return getSession().getAttribute(s);
    }

    protected List<Map<String, Object>> map(List<Map<String, Object>> list, final String[] keys) {
        Collection collection = CollectionUtils.collect(list, new Transformer() {
            @Override
            public Object transform(Object o) {
                Map<String, Object> origin = (Map<String, Object>) o;
                Map<String, Object> ret = new HashMap<String, Object>();
                for (String key : keys) {
                    ret.put(key, origin.get(key));
                }
                return ret;
            }
        });
        return (List<Map<String, Object>>) collection;
    }

    protected List<Map<String, Object>> map(List<Map<String, Object>> list, final String[] fromKeys, final String[] toKeys) {
        Collection collection = CollectionUtils.collect(list, new Transformer() {
            @Override
            public Object transform(Object o) {
                Map<String, Object> origin = (Map<String, Object>) o;
                Map<String, Object> ret = new HashMap<String, Object>();
                for (int i = 0; i < fromKeys.length && i < toKeys.length; i++) {
                    ret.put(toKeys[i], origin.get(fromKeys[i]));
                }
                return ret;
            }
        });
        return (List<Map<String, Object>>) collection;
    }

    protected List<Map<String, Object>> map(List<Map<String, Object>> list, final Map<String, String> keyMap) {
        Collection collection = CollectionUtils.collect(list, new Transformer() {
            @Override
            public Object transform(Object o) {
                Map<String, Object> origin = (Map<String, Object>) o;
                Map<String, Object> ret = new HashMap<String, Object>();
                for (String key : keyMap.keySet()) {
                    ret.put(keyMap.get(key), origin.get(key));
                }
                return ret;
            }
        });
        return (List<Map<String, Object>>) collection;
    }

    protected static final String MSG_OK = "操作成功！";
    protected static final String MSG_ERROR = "操作失败!";
}
