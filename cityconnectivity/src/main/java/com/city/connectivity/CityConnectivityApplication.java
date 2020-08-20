package com.city.connectivity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CityConnectivityApplication {
	private final static Logger logger = LoggerFactory.getLogger(CityConnectivityApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CityConnectivityApplication.class, args);
	}

}
