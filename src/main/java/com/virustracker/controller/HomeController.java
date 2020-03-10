package com.virustracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.virustracker.model.LocationStats;
import com.virustracker.service.VirusDataService;

@Controller
public class HomeController {

	@Autowired
	VirusDataService dataService;

	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = dataService.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);

		return "home";
	}

}
