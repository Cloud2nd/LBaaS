package com.exactsix.mibaas.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseDao {

	/**
	 * MySQL Client (MyBatis)
	 */
	@Autowired
	protected SqlSession sqlSession;

	/**
	 * AbstractBaseDao
	 * 
	 * @param
	 * @exception
	 */
	public AbstractBaseDao() {
	}
}
