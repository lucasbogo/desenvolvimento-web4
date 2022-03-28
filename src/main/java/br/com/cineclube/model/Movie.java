package br.com.cineclube.model;

import java.math.BigDecimal;

//import javax.persistence.Entity;

//@Entity
public class Movie {
	
	private Long id;
	private String title;
	private String overview;
	private Integer vote_count;
	private BigDecimal vote_average;
	
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public Integer getVote_count() {
		return vote_count;
	}
	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}
	public BigDecimal getVote_average() {
		return vote_average;
	}
	public void setVote_average(BigDecimal vote_average) {
		this.vote_average = vote_average;
	}
	

	
}
