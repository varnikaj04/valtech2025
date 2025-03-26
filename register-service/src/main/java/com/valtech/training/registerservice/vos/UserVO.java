package com.valtech.training.registerservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record UserVO(long id, String name, String mobileNo, int age, String email, Boolean kid, long subs_id) {

	public static UserVO from(User u) {
		return new UserVO(u.getId(), u.getName(), u.getMobileNo(), u.getAge(), u.getEmail(), u.getKid(), u.getSubscription().getId());
	}
	
	public static List<UserVO> from(List<User> user){
		return user.stream().map(u -> UserVO.from(u)).collect(Collectors.toList());
	}
	
	public User to(Subscription sub) {
		User user = new User(id, name, mobileNo, age, email, kid);
		user.setSubscription(sub);
		return user;
	}
	
}
