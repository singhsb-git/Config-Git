package com.city.connectivity.service;

import java.util.List;

import com.city.connectivity.model.CityConnection;

public interface DataService {
	
	public List<CityConnection> getCityConnections();
	public boolean verifyCityConnection(String origin, String destination);
}
