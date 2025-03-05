package com.valtech.training.restApis.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restApis.entities.Watch;
import com.valtech.training.restApis.repos.WatchRepo;
import com.valtech.training.restApis.vos.WatchVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WatchServiceImpl implements WatchService {

	@Autowired
	private WatchRepo watchRepo;

	public WatchVO createWatch(WatchVO watch) {
		return WatchVO.from(watchRepo.save(watch.toWatch()));
	}

	public WatchVO updateWatch(long id, WatchVO watch) {
		Watch watch1 = watchRepo.getReferenceById(id);
		watch.updateWatchFromVO(watch1);
//		watch1.setBrand(watch.getBrand());
//		watch1.setColor(watch.getColor());
//		watch1.setModel(watch.getModel());
//		watch1.setPrice(watch.getPrice());
//		watch1.setType(watch.getType());
		return WatchVO.from(watchRepo.save(watch1));

//		Watch watch1 = getWatch(id);
//		watch1.setBrand(watch.getBrand());
//		watch1.setColor(watch.getColor());
//		watch1.setModel(watch.getModel());
//		watch1.setPrice(watch.getPrice());
//		watch1.setType(watch.getType());
//		return watchRepo.save(watch1);
	}

	public WatchVO getWatch(long id) {
		return WatchVO.from(watchRepo.getReferenceById(id));
	}

	public List<WatchVO> getAllWatches() {
//		return watchRepo.findAll().stream().map(w -> WatchVO.from(w)).collect(Collectors.toList());
		return WatchVO.toWatchVO(watchRepo.findAll());
	}

	@Override
	public List<WatchVO> getWatchesByBrand(String brand) {
		return WatchVO.toWatchVO(watchRepo.findAllByBrand(brand));
	
	}

}
