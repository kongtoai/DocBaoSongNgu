package com.java.news.bilingual.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/settings")
public class GeneralSettingController {

	@RequestMapping(value = "/general", method = RequestMethod.GET)
	public String damadmin(HttpServletRequest request,
			HttpServletResponse response) {

		return "settings";
	}

}