package com.cg.sprint.dto;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="showdetails")
public class Show 
{
     @Id
     @Column(name="show_id")
     int showId;
     @Column(name="show_name")
     String showName;
     @Column(name="time")
     LocalTime showTime;
     @OneToOne
     @JoinColumn(name="movie_id")
     Movie movie;
     public Show() { }
	public Show(int showId, String showName, LocalTime showTime, Movie movie) 
	{
		this.showId = showId;		this.showName = showName;		this.showTime = showTime;		this.movie = movie;		
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public LocalTime getShowTime() {
		return showTime;
	}
	public void setShowTime(LocalTime showTime) {
		this.showTime = showTime;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
