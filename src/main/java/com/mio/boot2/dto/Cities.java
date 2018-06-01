package com.mio.boot2.dto;

import java.util.List;

public class Cities {

	private String city;
	private List<Branches> branches;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Branches> getBranches() {
		return branches;
	}

	public void setBranches(List<Branches> branches) {
		this.branches = branches;
	}

}
