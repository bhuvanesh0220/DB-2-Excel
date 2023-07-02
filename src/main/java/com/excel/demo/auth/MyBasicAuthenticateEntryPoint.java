package com.excel.demo.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class MyBasicAuthenticateEntryPoint extends BasicAuthenticationEntryPoint{
	
	public void commence(HttpServletRequest request,HttpServletResponse response,AuthenticationException authExcep) throws IOException {
		response.setHeader("WWW-Authenticate", getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("HTTP STATUS 401 - "+ authExcep.getMessage());
	}

	public void afterPropertiesSet() {
		setRealmName("DB-2-ExcelDemoApi");
		super.afterPropertiesSet();
	}
}
