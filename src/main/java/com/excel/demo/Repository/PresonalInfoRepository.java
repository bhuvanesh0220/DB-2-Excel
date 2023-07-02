package com.excel.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.excel.demo.Entity.PersonalInfo;

public interface PresonalInfoRepository extends JpaRepository<PersonalInfo, Long>{

	@Query(value = "SELECT PERSONAL_ID_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
	Long getPersonalIdMax();

}
