package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/webSeries")
public class WebSeriesController {

	@Autowired
	private WebSeriesService webSeriesService;
	
	@PostMapping("/")
	public WebSeriesVO addWebSeries(@RequestBody WebSeriesVO vo) {
		return webSeriesService.createOrUpdateWebSeries(vo);
	}
	
	@GetMapping("/")
	public List<WebSeriesVO> getAllWebServices(){
		return webSeriesService.getAllWebSeries();
	}
	
	@GetMapping("/{id}")
	public WebSeriesVO getWebSeriesById(@PathVariable("id") long id) {
		return webSeriesService.getWebSeries(id);
	}
	
	@GetMapping("/episodes/{episodeCount}")
	public List<WebSeriesVO> getWebSeriesByEpisodeCount(@PathVariable("episodeCount") int episodeCount){
		return webSeriesService.getWebSeriesByEpisodeCount(episodeCount);
	}
	
	@GetMapping("/duration/{episodeDuration}")
	public List<WebSeriesVO> getWebSeriesByEpisodeDuration(@PathVariable("episodeDuration") long episodeDuration){
		return webSeriesService.getWebSeriesByDurationOfEpisodes(episodeDuration);
	}
	
}
