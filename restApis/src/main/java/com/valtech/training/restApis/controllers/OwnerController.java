package com.valtech.training.restApis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.restApis.services.OwnerService;
import com.valtech.training.restApis.vos.OwnerVO;

@RestController
@RequestMapping("/api/v1/owners")									// so that we dont have to define owners again and again
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
//	@PutMapping("/owners/{id}/watches")				
	@PutMapping("/{id}/watches")									
	public OwnerVO updateWatches(@PathVariable("id") long id, @RequestBody List<Long> watches) {
		return ownerService.addWatchesToOwner(id, watches);
	}

	@GetMapping("/{id}")
	public OwnerVO getOwner(@PathVariable("id") long id) {
		return ownerService.getOwner(id);
	}

	@GetMapping("/")
	public List<OwnerVO> getOwners() {
		return ownerService.getAllOwners();
	}

	@PostMapping("/")
	public OwnerVO addOwner(@RequestBody OwnerVO owner) {
		return ownerService.addOwner(owner);
	}

	@PutMapping("/{id}")
	public OwnerVO updateOwner(@PathVariable("id") long id, @RequestBody OwnerVO owner) {
		return ownerService.updateOwner(id, owner);
	}

}
