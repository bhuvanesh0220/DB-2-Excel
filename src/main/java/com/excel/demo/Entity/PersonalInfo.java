package com.excel.demo.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(PersonalInfoId.class)
public class PersonalInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//ENTER INTO DATA FIELDS
	
	@Id
	@Column(name = "PERSONAL_ID")
	private Long personalId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "AGE")
	private Long age;
	
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "MOBILE_NO")
	private Long mobileno;
	
	@Column(name = "GENDER")
	private String gender;

}
