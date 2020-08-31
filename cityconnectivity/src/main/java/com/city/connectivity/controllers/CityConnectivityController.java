package com.city.connectivity.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.city.connectivity.service.DataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * 
 * @author Sanjay Singh
 * @apiNote This class deals with REST API for finding city to city connections
 *
 */
@RestController
@RequestMapping("/connected")
@Api(value="CityConnectivityController", description = "REST Apis related to CityConnectivityController")
public class CityConnectivityController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataService dataService;
	
	public CityConnectivityController(DataService dataService){
		this.dataService = dataService;
	}
	
	@ApiOperation(value = "Check if cities are connected")
	@ApiResponses({ @ApiResponse(code = 200, message = "", response = String.class) })
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCityConnection(@RequestParam("origin") String origin,	@RequestParam("destination") String destination) {
		logger.info("inside - checking if cities are connected...");
		boolean result = false;
		
		try {
			result = dataService.verifyCityConnection(origin, destination);
		} catch(Exception ex){
			logger.error(">>> Error: {}",ex );
			result = false;
		}
		
		logger.info(">>> result ==> {}", result);
		return (result? "yes" : "no");	
	}

}
