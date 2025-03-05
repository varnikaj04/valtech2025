package com.valtech.training.restApis.services;

import java.util.List;

import com.valtech.training.restApis.vos.OwnerVO;

public interface OwnerService {

	OwnerVO addOwner(OwnerVO owner);

	OwnerVO updateOwner(long id, OwnerVO owner);

	OwnerVO getOwner(long id);

	List<OwnerVO> getAllOwners();

	OwnerVO addWatchesToOwner(long id, List<Long> watches);


}