package com.city.connectivity.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import com.city.connectivity.controllers.CityConnectivityController;
import com.city.connectivity.service.DataService;


/**
 * 
 * @author Sanjay Singh
 * @apiNote This class deals with test cases for class - CityConnectivityController
 *
 */
public class CityConnectivityControllerTests {
	
	@Mock
	DataService dataService;
	
	CityConnectivityController ccc;
	
	@Before
	public void setUp() throws Exception {
		dataService = mock(DataService.class);
		ccc = new CityConnectivityController(dataService);
	}
	
	@Test
	public void TestGetCityConnection_forProperWorking() {
	   when(dataService.verifyCityConnection(anyString(), anyString())).thenReturn(true);
       String result = ccc.getCityConnection("Boston", "Newark");
        
       assertEquals("yes", result);
	}


}
