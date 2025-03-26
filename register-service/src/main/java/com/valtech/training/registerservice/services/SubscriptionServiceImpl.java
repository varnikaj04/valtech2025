package com.valtech.training.registerservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SubscriptionServiceImpl implements SubscriptionService  {

	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public SubscriptionVO saveOrUpdateSubscription(SubscriptionVO subscriptionVO) {
		return SubscriptionVO.from(subscriptionRepo.save(subscriptionVO.to(userRepo.findAll())));
	}

	@Override
	public SubscriptionVO getSubscriptionById(long id) {
		return SubscriptionVO.from(subscriptionRepo.getReferenceById(id));
	}

	@Override
	public List<SubscriptionVO> getAllSubscriptions() {
		return subscriptionRepo.findAll().stream().map(s -> SubscriptionVO.from(s)).collect(Collectors.toList());
	}
	
}
