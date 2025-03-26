package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	List<UserVO> getAllUsers();

	List<UserVO> getUserBySubscriptionId(long id);

	UserVO getUserById(long id);

	UserVO signInUser(UserVO vo);

	UserVO addUserToSubscription(UserVO vo, long subsId);

	void deleteUserFromSubscription(long id);

}