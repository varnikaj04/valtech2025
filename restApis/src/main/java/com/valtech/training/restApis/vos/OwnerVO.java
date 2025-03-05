package com.valtech.training.restApis.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.restApis.entities.Owner;

public class OwnerVO {

	private long id;
	private String name;
	private String mobile;
	private String email;
	private List<Long> watches;

	public OwnerVO() {
	}

	public OwnerVO(long id, String name, String mobile, String email, List<Long> watches) {
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.watches = watches;
	}
	
	public static List<OwnerVO> toOwnerVO(List<Owner> owners){
		return owners.stream().map(o -> OwnerVO.from(o)).collect(Collectors.toList());
	}

	public Owner toOwner() {
		Owner o = new Owner(name, mobile, email);
		o.setId(id);
		return o;
	}
	
	public void updateOwnerFromVO(Owner o) {
		o.setName(name);
		o.setMobile(mobile);
		o.setEmail(email);
	}

	public static OwnerVO from(Owner o) {
		List<Long> watches = o.getWatches() == null ? List.of() : o.getWatches().stream().map(ow -> ow.getId()).collect(Collectors.toList());
		return new OwnerVO(o.getId(), o.getName(), o.getMobile(), o.getEmail(), watches);
	}
	
	public List<Long> getWatches() {
		return watches;
	}
	
	public void setWatches(List<Long> watches) {
		this.watches = watches;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "OwnerVO [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", watches="
				+ watches + "]";
	}

	
	
}
