package com.exactsix.mibaas.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exactsix.mibaas.common.dao.AbstractBaseDao;
import com.exactsix.mibaas.user.dto.DeviceDto;
import com.exactsix.mibaas.user.dto.UserDeviceDto;
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

	public List<UserDto> getUsers() {
		return sqlSession.selectList("UserMapper.getUsers");
	}

	public UserDto getUserLogin(UserDto dto) {
		return sqlSession.selectOne("UserMapper.getUserLogin", dto);
	}

	public void updateUser(UserDto user) {
		sqlSession.update("UserMapper.updateUser", user);
	}

	public void insertDevice(DeviceDto device) {
		sqlSession.update("UserMapper.insertDevice", device);
	}

	public void insertUserDevice(UserDeviceDto userDevice) {
		sqlSession.update("UserMapper.insertUserDevice", userDevice);
	}

}