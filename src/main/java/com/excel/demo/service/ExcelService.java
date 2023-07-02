package com.excel.demo.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.excel.demo.Request.insertDataReq;

public interface ExcelService {

	String insertData(insertDataReq req);

	String userHome();

	void getExcel(HttpServletResponse response) throws IOException;

}
