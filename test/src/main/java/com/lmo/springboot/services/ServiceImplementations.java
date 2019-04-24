package com.lmo.springboot.services;

import org.springframework.stereotype.Service;

@Service
public class ServiceImplementations {
	public String K2_GetCustomerProfile(String convid,String ban) {
		return  convid+"-"+ban;
	}
}
