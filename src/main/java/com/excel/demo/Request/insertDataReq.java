package com.excel.demo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class insertDataReq {
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Age")
	private String age;
	
	@JsonProperty("DOB")
	private String dob;
	
	@JsonProperty("Email")
	private String email;
	
	@JsonProperty("Address")
	private String address;
	
	@JsonProperty("MobileNo")
	private String mobileNo;
	
	@JsonProperty("Gender")
	private String gender;

}
