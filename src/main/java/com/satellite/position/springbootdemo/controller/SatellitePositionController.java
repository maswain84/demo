package com.satellite.position.springbootdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.satellite.position.springbootdemo.model.SatellitePosition;

@RestController
public class SatellitePositionController {

	double lastLongitudeValue = 0;
	double lastLatitudeValue = 0;
	int retryCount = 0;
	
	public static final String url = "https://api.wheretheiss.at/v1/satellites/25544";

	@RequestMapping("/")
	public SatellitePosition getGatellitePosition() {
		int count = 0;
		int maxRetries = 1;
		SatellitePosition position = null;

		while (true) {
			RestTemplate restTemplate = new RestTemplate();
			try {

				position = restTemplate.getForObject(url,
						SatellitePosition.class);
				break;
			} catch (HttpClientErrorException ex) {
				if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
					{
						if (++count == maxRetries) {
							break;
						}
					}
				}
			}
		}

		if (null != position) {
			lastLongitudeValue = position.getLongitude();
			lastLatitudeValue = position.getLatitude();
		} else {
			position = new SatellitePosition();
			position.setLatitude(lastLatitudeValue);
			position.setLongitude(lastLongitudeValue);
		}
		return position;

	}

}
