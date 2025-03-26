package com.valtech.training.registerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.services.SubscriptionService;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;
	
	@PostMapping("/subscription")
	public SubscriptionVO saveOrUpdateSubscription(@RequestBody SubscriptionVO subscriptionVO) {
		return subscriptionService.saveOrUpdateSubscription(subscriptionVO);
	}
	
	@GetMapping("/{id}")
	public SubscriptionVO getSubscriptionById(@PathVariable("id") long id) {
		return subscriptionService.getSubscriptionById(id);
	}
	
	@GetMapping("/")
	public List<SubscriptionVO> getAllSubscriptions(){
		return subscriptionService.getAllSubscriptions();
	}
	
}
