package com.lmo.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lmo.springboot.services.ServiceImplementations;

@RestController
@RequestMapping(path="/msgroup3")
public class Group1Controller {
	@Autowired
	private ServiceImplementations services;

	@RequestMapping(method = RequestMethod.GET, path = "/K2_GetCustomerProfile")
	public String K2_GetCustomerProfile(@RequestParam(name = "conversation_id", required = false) String convid,
			@RequestParam(name = "ban") String ban) {
		return services.K2_GetCustomerProfile(convid, ban);
	}

}
