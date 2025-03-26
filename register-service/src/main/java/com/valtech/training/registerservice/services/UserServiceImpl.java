package com.valtech.training.registerservice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Override
	public UserVO addUserToSubscription(UserVO vo, long subsId) {
		return UserVO.from(userRepo.save(vo.to(subscriptionRepo.getReferenceById(subsId))));
	}
	
	@Override
	public List<UserVO> getAllUsers(){
		return userRepo.findAll().stream().map(u -> UserVO.from(u)).collect(Collectors.toList());
	}
	
	@Override
	public UserVO getUserById(long id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}
	
	@Override
	public List<UserVO> getUserBySubscriptionId(long sid) {
		return UserVO.from(userRepo.findAllBySubscriptionId(sid));
	}
	
	@Override
	public UserVO signInUser(UserVO vo) {
		Subscription sc = new Subscription();
		sc.setAmount(1000);
		sc.setSubscriptionStart(LocalDate.now());
		sc.setSubscriptionEnd(LocalDate.now().plusYears(1));
		sc = subscriptionRepo.save(sc);
//		sc.addUser(vo.to(sc));
		return UserVO.from(userRepo.save(vo.to(sc)));
	}

	@Override
	public void deleteUserFromSubscription(long id) {
		userRepo.deleteById(id);
	}
	
}
