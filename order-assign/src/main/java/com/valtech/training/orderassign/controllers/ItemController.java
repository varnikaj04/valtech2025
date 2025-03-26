package com.valtech.training.orderassign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.orderassign.entities.Item;
import com.valtech.training.orderassign.services.ItemService;
import com.valtech.training.orderassign.vos.ItemVO;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@PostMapping("/item")
	public String addItems(@ModelAttribute ItemVO itemVO, Model model) {
		itemService.save(itemVO);
		model.addAttribute("item", itemService.getAll());
		return "item";
	}
	
	@GetMapping("/item")
	public String items(Model model) {
		model.addAttribute("item", itemService.getAll());
		return "item";
	}
	
}
