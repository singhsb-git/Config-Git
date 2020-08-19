package com.city.connectivity.model;

/**
 * @author Sanjay Singh
 * @apiNote This is the pojo class for each csv row of data
 * 
 */
public class CityConnection {
	private String origin;
	private String destination;
	
	public CityConnection(){
		
	}
	
	public CityConnection(String origin, String destination){
		this.origin = origin;
		this.destination = destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{origin:"+origin+", destination:"+destination+"}";
	}
	
	public String contains(String city) {
		if(city != null) {
			if(this.origin.equalsIgnoreCase(city)) {
				return this.destination;
			}
			if(this.destination.equalsIgnoreCase(city)) {
				return this.origin;
			} 
		}
		return null;
	}
	
	public boolean containsBoth(Object obj) {
		if(obj != null) {
			if((((CityConnection)obj).getOrigin().equalsIgnoreCase(origin) || 
					((CityConnection)obj).getOrigin().equalsIgnoreCase(destination)) &&
					(((CityConnection)obj).getDestination().equalsIgnoreCase(origin) || 
							((CityConnection)obj).getDestination().equalsIgnoreCase(destination))) {
				return true;
			} 
		}
		
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		
		if(((CityConnection)obj).getOrigin().equalsIgnoreCase(origin) && 
				((CityConnection)obj).getDestination().equalsIgnoreCase(destination)) {
			return true;
		}

		return false;
	}
	
	

}
