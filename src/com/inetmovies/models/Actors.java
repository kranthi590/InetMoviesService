package com.inetmovies.models;

public class Actors {

	private Integer id;
	private String first_name;
	private String last_name;
	private Character gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Actors [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender
				+ "]";
	}

	public void empty() {

		this.first_name = null;
		this.last_name = null;
		this.id = null;
		this.gender = null;
	}

}
