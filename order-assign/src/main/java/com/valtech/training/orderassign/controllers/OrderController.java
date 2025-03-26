package com.valtech.training.orderassign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.orderassign.services.OrderService;
import com.valtech.training.orderassign.vos.PlaceOrderVO;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/order")
	public String addOrders(@ModelAttribute PlaceOrderVO placeOrderVO, Model model) {
		orderService.save(placeOrderVO);
		return "order";
	}

	@GetMapping("/order")
	public String getOrder(Model model) {
		return "order";
	}

}
