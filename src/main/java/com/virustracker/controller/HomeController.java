package com.virustracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.virustracker.service.VirusDataService;

@Controller
public class HomeController {
	
	@Autowired
	VirusDataService dataService;

	@GetMapping("/")
	public String home(Model model ) {
		model.addAttribute("locationStats", dataService.getAllStats());
		return "home";
	}
	
}
