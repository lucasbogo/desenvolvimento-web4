package br.com.cineclube.model;

//import javax.persistence.Entity;

//@Entity
public class PersonTMDB {

	private Long person_id;
	private String name;
	private Integer popularity;
	private String profile_path;

	public Long getId() {
		return person_id;
	}

	public void setId(Long person_id) {
		this.person_id = person_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	public String getProfile_path() {
		return profile_path;
	}

	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}

}
