package com.exactsix.mibaas.login.dao;

import org.springframework.stereotype.Repository;

import com.exactsix.mibaas.common.dao.AbstractBaseDao;
import com.exactsix.mibaas.login.dto.UserDto;

/**
 * UserDao
 *
 * @author Bong-Jin Kwon
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

	public UserDto getUser(String userId) {
		return sqlSession.selectOne("UserMapper.getUser", userId);
	}

	public void updateUser(UserDto user) {
		sqlSession.update("UserMapper.updateUser", user);
	}

	public void deleteUser(int userId) {
		sqlSession.delete("UserMapper.deleteUser", userId);
	}

	public UserDto getLoginUser(String loginId, String passwd) {
		UserDto user = new UserDto();
		user.setLoginId(loginId);
		user.setPasswd(passwd);

		return sqlSession.selectOne("UserMapper.getLoginUser", user);
	}

	public UserDto getLoginUser(String loginId) {

		return sqlSession
				.selectOne("UserMapper.getLoginUserByLoginId", loginId);
	}

	public void updateLastLogon(int userId) {
		sqlSession.update("UserMapper.updateLastLogon", userId);
	}
}