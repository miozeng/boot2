package com.mio.boot2.dto;

import java.util.List;

public class Location {

	 private String name;
	    private int id;
	    private double latitude;
	    private double longtitude;
	    private String address;
	    private String officeHours;
	    private List<Phones> phones;
	    private String phoneDescription;
	    private String fax;
	    private String email;
	    private String registrationNumber;
	    private List<Member> members;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongtitude() {
			return longtitude;
		}
		public void setLongtitude(double longtitude) {
			this.longtitude = longtitude;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getOfficeHours() {
			return officeHours;
		}
		public void setOfficeHours(String officeHours) {
			this.officeHours = officeHours;
		}
		public List<Phones> getPhones() {
			return phones;
		}
		public void setPhones(List<Phones> phones) {
			this.phones = phones;
		}
		public String getPhoneDescription() {
			return phoneDescription;
		}
		public void setPhoneDescription(String phoneDescription) {
			this.phoneDescription = phoneDescription;
		}
		public String getFax() {
			return fax;
		}
		public void setFax(String fax) {
			this.fax = fax;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public List<Member> getMembers() {
			return members;
		}
		public void setMembers(List<Member> members) {
			this.members = members;
		}
		public String getRegistrationNumber() {
			return registrationNumber;
		}
		public void setRegistrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
		}
	    
	    
	    
}



