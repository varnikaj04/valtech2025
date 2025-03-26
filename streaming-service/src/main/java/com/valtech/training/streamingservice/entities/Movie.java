package com.valtech.training.streamingservice.entities;

import jakarta.persistence.Entity;

@Entity
public class Movie extends Content {

	private long duration;
	
	public Movie() {}

	public Movie(String name, String genre, String language, long duration, long costPerView) {
		super(name, genre, language, costPerView);
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}


}
