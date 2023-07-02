package com.excel.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.demo.Request.insertDataReq;
import com.excel.demo.service.ExcelService;

@RestController
@RequestMapping("/common")
public class ExcelController {
	
	@Autowired
	private ExcelService service;
	
	@PostMapping("/insert")
	public String insertData(@RequestBody insertDataReq req) {
		return service.insertData(req);
	}
	
	@GetMapping("user/page")
	public String userHome() {
		return service.userHome();
	}
	
	@GetMapping("/getExcel")
	public void getExcel(HttpServletResponse response) throws IOException {
		service.getExcel(response);
	}

}
