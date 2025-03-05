package com.valtech.training.restApis.services;

import java.util.List;

import com.valtech.training.restApis.entities.Watch;
import com.valtech.training.restApis.vos.WatchVO;

public interface WatchService {

	WatchVO createWatch(WatchVO watch);

	WatchVO getWatch(long id);

	List<WatchVO> getAllWatches();

	WatchVO updateWatch(long id, WatchVO watch);

	List<WatchVO> getWatchesByBrand(String brand);

}