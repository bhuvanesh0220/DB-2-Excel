package com.excel.demo.serviceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.demo.Entity.PersonalInfo;
import com.excel.demo.Repository.PresonalInfoRepository;
import com.excel.demo.Request.insertDataReq;
import com.excel.demo.service.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private PresonalInfoRepository personalRepo;
	
	@Override
	public String insertData(insertDataReq req) {
		String result= "FAILED";
		try {
			PersonalInfo infoSave = PersonalInfo.builder()
			.personalId(personalRepo.getPersonalIdMax())
			.name(req.getName())
			.age(Long.parseLong(req.getAge()))
			.dob(sdf.parse(req.getDob()))
			.email(req.getEmail())
			.address(req.getAddress())
			.mobileno(Long.parseLong(req.getMobileNo()))
			.gender(req.getGender())
			.build();
			personalRepo.save(infoSave);
			result = "Data Insert SuccessFully";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String userHome() {
		return "Welcome to UserHome";
		
	}

	@Override
	public void getExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String HeaderKey = "Content-Disposition";
		String HeaderValue = "attachment;filename=BhuvaneshExcelDemo.xls";
		response.setHeader(HeaderKey, HeaderValue);
		
		List<PersonalInfo> personalinfo = personalRepo.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Personal info");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("PERSONAL ID");
		row.createCell(1).setCellValue("ADDRESS");
		row.createCell(2).setCellValue("AGE");
		row.createCell(3).setCellValue("DateOfBirth");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("GENDER");
		row.createCell(6).setCellValue("MOBILE NO");
		row.createCell(7).setCellValue("NAME");
		
		int datarowindex = 1;
		
		for(PersonalInfo c:personalinfo) {
			HSSFRow datarow = sheet.createRow(datarowindex);
			datarow.createCell(0).setCellValue(c.getPersonalId());
			datarow.createCell(1).setCellValue(c.getAddress());
			datarow.createCell(2).setCellValue(c.getAge());
			datarow.createCell(3).setCellValue(sdf.format(c.getDob()));
			datarow.createCell(4).setCellValue(c.getEmail());
			datarow.createCell(5).setCellValue("M".equalsIgnoreCase(c.getGender())?"Male":"Female");
			datarow.createCell(6).setCellValue(c.getMobileno().toString());
			datarow.createCell(7).setCellValue(c.getName());
			datarowindex++;
		}
		
		ServletOutputStream sos = response.getOutputStream();
		workbook.write(sos);
		workbook.close();
		
	}

}
