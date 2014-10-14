package com.exactsix.mibaas.user.dao;

import org.springframework.stereotype.Repository;

import com.exactsix.mibaas.common.dao.AbstractBaseDao;
import com.exactsix.mibaas.user.dto.UserDto;

/**
 * UserDao
 *
 * @author Dave
 * @version 1.0
 */
@Repository
public class UserDao extends AbstractBaseDao {

	/**
	 * UserDao
	 *
	 * @param
	 * @exception
	 */
	public UserDao() {
	}

	public void insertUser(UserDto user) {
		sqlSession.insert("UserMapper.insertUser", user);
	}

	public UserDto getUser(String email) {
		return sqlSession.selectOne("UserMapper.getUser", email);
	}

	public void updateUser(UserDto user) {
		sqlSession.update("UserMapper.updateUser", user);
	}

}