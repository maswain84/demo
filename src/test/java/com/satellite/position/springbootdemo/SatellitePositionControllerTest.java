package com.satellite.position.springbootdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.satellite.position.springbootdemo.controller.SatellitePositionController;
import com.satellite.position.springbootdemo.model.SatellitePosition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SatellitePositionControllerTest {

	private SatellitePositionController satellitePositionController;
	private RestTemplate restTemplate;

	@Before
	public void init() {

		satellitePositionController = new SatellitePositionController();
		restTemplate = mock(RestTemplate.class);

	}

	@Test
	public void getGatellitePositionTest01() {
		when(restTemplate.getForObject(any(URI.class), (Class<SatellitePosition>) any(Class.class))).thenReturn(null);
		SatellitePosition position = satellitePositionController.getGatellitePosition();
		assertNotNull(position);
	}

	@Test
	public void getGatellitePositiontest02() {
		SatellitePosition pos = new SatellitePosition();
		pos.setLatitude(-13.522097901408);
		pos.setLatitude(-14.075636933771);

		when(restTemplate.getForObject(any(URI.class), (Class<SatellitePosition>) any(Class.class))).thenReturn(pos);
		SatellitePosition position = satellitePositionController.getGatellitePosition();
		assertNotNull(position);
	}

}
