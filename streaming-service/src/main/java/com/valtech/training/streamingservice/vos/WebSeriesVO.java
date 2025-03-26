package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.WebSeries;

public record WebSeriesVO(long id, String name, String genre, String language, long costPerView, int episodeCount, long episodeDuration) {

	public static WebSeriesVO from(WebSeries ws) {
		return new WebSeriesVO(ws.getId(), ws.getName(), ws.getGenre(), ws.getLanguage(), ws.getCostPerView(), ws.getEpisodeCount(), ws.getEpisodeDuration());
	}
	
	public WebSeries to() {
		return new WebSeries(name, genre, language, costPerView, episodeCount, episodeDuration);
	}
	
	public static List<WebSeriesVO> from(List<WebSeries> webServices){
		return webServices.stream().map(ws -> WebSeriesVO.from(ws)).collect(Collectors.toList());
	}
	
}
