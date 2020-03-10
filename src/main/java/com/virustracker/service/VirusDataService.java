package com.virustracker.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VirusDataService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VirusDataService.class.getName());
	private static final String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
	
	@PostConstruct
	public void fetchVirusData() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(VIRUS_DATA_URL))
			.build();
		
		 HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		 LOGGER.debug(httpResponse.body());
	}
	
}
