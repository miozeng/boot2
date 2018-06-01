package com.mio.boot2.dto;

import java.util.List;

public class Agency2 {

	private String province;
	
	private List<District> districts;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

}
