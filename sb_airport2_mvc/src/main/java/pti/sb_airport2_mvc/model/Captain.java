package pti.sb_airport2_mvc.model;

import java.util.ArrayList;
import java.util.List;

public class Captain {
	
	private String name;
	
	private List<Flight> flights;
	
	private long flightMinutes;
	

	public Captain(String name) {
		super();
		this.name = name;
		this.flights = new ArrayList<>();;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public long getFlightMinutes() {
		return flightMinutes;
	}

	public void setFlightMinutes(long flyMin) {
		
		this.flightMinutes += flyMin;
		
	}
	
	public void addFlightMinutes(long minutes) {
		this.flightMinutes += minutes;
	}
	
	
	

}
