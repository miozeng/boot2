package com.mio.boot2.dto;

import java.util.List;

public class District {

	private String district;
	private List<Offices> offices;

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public List<Offices> getOffices() {
		return offices;
	}

	public void setOffices(List<Offices> offices) {
		this.offices = offices;
	}

}
