package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.WebSeriesVO;

public interface WebSeriesService {

	WebSeriesVO createOrUpdateWebSeries(WebSeriesVO vo);

	List<WebSeriesVO> getAllWebSeries();

	WebSeriesVO getWebSeries(long id);

	List<WebSeriesVO> getWebSeriesByEpisodeCount(int episodeCount);

	List<WebSeriesVO> getWebSeriesByDurationOfEpisodes(long episodeDuration);

}