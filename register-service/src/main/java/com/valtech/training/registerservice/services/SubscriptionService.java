package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.SubscriptionVO;

public interface SubscriptionService {

	SubscriptionVO saveOrUpdateSubscription(SubscriptionVO subscriptionVO);

	SubscriptionVO getSubscriptionById(long id);

	List<SubscriptionVO> getAllSubscriptions();

}
