package com.excel.demo.Entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	ENTER INTO ID CLASS -- AS WELL AS PRIMARY_KEY
	
	private Long personalId;
}
