package pti.sb_airport2_mvc.dto;

import java.util.ArrayList;
import java.util.List;


public class CaptainDto {
	
	private String name;
	private long flightMinutes;
	private List<FlightDto> flights;
	
	public CaptainDto(String name, long flightMinutes, List<FlightDto> flights) {
		super();
		this.name = name;
		this.flightMinutes = flightMinutes;
		this.flights = new ArrayList<>();;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getFlightMinutes() {
		return flightMinutes;
	}

	public void setFlightMinutes(long flightMinutes) {
		this.flightMinutes = flightMinutes;
	}

	public List<FlightDto> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightDto> flights) {
		this.flights = flights;
	}
	public void addFlightMinutes(long minutes) {
		this.flightMinutes += minutes;
	}
	

	@Override
	public String toString() {
		return "CaptainDto [name=" + name + ", flightMinutes=" + flightMinutes + ", flights=" + flights + "]";
	}
	
	public boolean returnedWithTransfer() {
		boolean result = false;
		
		if(flights.size()>2) {
			
			for(int index_flights = 0; index_flights < flights.size()-2; index_flights++) {
				FlightDto currentFlightDto = flights.get(index_flights);
				
				 for(int index_secFlights = (index_flights+1); index_secFlights < flights.size()-1; index_secFlights++) {
					 
					 FlightDto nextFlightDto = flights.get(index_secFlights);
					 
					 if(currentFlightDto.getTimeOfArrival().isBefore(nextFlightDto.getTimeOfDepature()) == true) {
						 
						 for(int index_triFlightDtoList = (index_secFlights+1); index_triFlightDtoList < flights.size();index_triFlightDtoList++) {
							 FlightDto afterNextFlightDto = flights.get(index_triFlightDtoList);
							 
							if( nextFlightDto.getTimeOfArrival().isBefore(afterNextFlightDto.getTimeOfDepature())){
								
								if( currentFlightDto.getCityOfDepature().equals(afterNextFlightDto.getCityOfArrival())) {
									result = true;
								
								}
								
							}
						
						 }
					 } 
					 
				 }
			}
		}else {
			result = false;
		}
		return result;
	}
	
	
	
	
	
	
	

}
