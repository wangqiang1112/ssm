package com.htjs.base;

import org.springframework.orm.ibatis.SqlMapClientCallback;

/**
 * Created by Administrator on 2017/1/22.
 */
public class BaseDao {
	protected SqlMapClientCallback sqlMap;

	public SqlMapClientCallback getSqlMap() {
		return sqlMap;
	}

	public void setSqlMap(SqlMapClientCallback sqlMap) {
		this.sqlMap = sqlMap;
	}
	
	
	
	
}
