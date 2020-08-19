package com.city.connectivity.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.city.connectivity.model.CityConnection;
import com.city.connectivity.utility.CSVReaderWriterUtil;


/**
 * 
 * @author Sanjay Singh
 * @apiNote This class deals with data from csv and all the supporting apis
 *  
 */
@Service
public class DataServiceImpl implements DataService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${city.data.path}")
	private String cityDataPath;
	
	private List<String> cityNetwork = null; 

	/**
	 * This function gets all connections from the csv data file.
	 */
	@Override
	public List<CityConnection> getCityConnections() {
		List<CityConnection> cityConnections = null;
		try {
			cityConnections = CSVReaderWriterUtil.readCsv(cityDataPath);
		} catch(Exception ex) {
			logger.error(">>> Error: {}", ex );
		}
		return cityConnections;
	}
	
	
	/**
	 * This function verifies if the cities are connected.
	 */
	@Override
	public boolean verifyCityConnection(String origin, String destination) {
		cityNetwork = mapCityNetwork();
		origin = "|"+origin+"|";
		destination = "|"+destination+"|";
		for(String cityConnects : cityNetwork) {
			if(cityConnects.toUpperCase().contains(origin.toUpperCase()) && 
					cityConnects.toUpperCase().contains(destination.toUpperCase())) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * @return List<String> - returns list of city connections created
	 */
	private List<String> mapCityNetwork() {
		List<CityConnection> cityConnections = getCityConnections();
		List<String> cityNet = new ArrayList<>();
		for(CityConnection cityCon: cityConnections) {
			String origin = "|"+cityCon.getOrigin()+"|";
			String dest = "|"+cityCon.getDestination()+"|";
			boolean added = false;
			if(cityNet.size() > 0) {
				for(int i = 0; i < cityNet.size(); i++) {
					String roadLinks = cityNet.get(i);
					if(roadLinks.contains(origin) || roadLinks.contains(dest)) {
						roadLinks = roadLinks + origin + dest;
						cityNet.set(i, roadLinks); 
						added = true;
					} 
				}
				
			} 
			if(!added){
				cityNet.add(origin+dest);
			}
			
		}
	 
		logger.info(">>> complete roadLinks = {}", cityNet);
		return cityNet;
	}
	

}
