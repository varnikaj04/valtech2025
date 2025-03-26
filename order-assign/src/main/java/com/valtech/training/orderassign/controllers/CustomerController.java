package com.valtech.training.orderassign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.orderassign.services.CustomerService;
import com.valtech.training.orderassign.vos.CustomerVO;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public String addCustomers(@ModelAttribute CustomerVO customerVO, Model model) {
		customerService.save(customerVO);
		model.addAttribute("customer", customerService.getAll());
		return "customer";
	}
	
	@GetMapping("/customer")
	public String customers(Model model) {
		model.addAttribute("customer", customerService.getAll());	
		return "customer";
	}
	
}
