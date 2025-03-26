package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.WebSeriesRepo;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WebSeriesServiceImpl implements WebSeriesService {

	@Autowired
	public WebSeriesRepo webSeriesRepo;
	
	@Override
	public WebSeriesVO createOrUpdateWebSeries(WebSeriesVO vo) {
		return WebSeriesVO.from(webSeriesRepo.save(vo.to()));
	}
	
	@Override
	public List<WebSeriesVO> getAllWebSeries(){
		return WebSeriesVO.from(webSeriesRepo.findAll());
	}
	
	@Override
	public WebSeriesVO getWebSeries(long id) {
		return WebSeriesVO.from(webSeriesRepo.getReferenceById(id));
	}
	
	@Override
	public List<WebSeriesVO> getWebSeriesByEpisodeCount(int episodeCount){
		return WebSeriesVO.from(webSeriesRepo.findAllByEpisodeCount(episodeCount));
	}
	
	@Override
	public List<WebSeriesVO> getWebSeriesByDurationOfEpisodes(long episodeDuration){
		return WebSeriesVO.from(webSeriesRepo.findAllByEpisodeDuration(episodeDuration));
	}
	
}
