package pti.sb_airport2_mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_airport2_mvc.db.Database;

import pti.sb_airport2_mvc.dto.FlightDto;
import pti.sb_airport2_mvc.dto.FlightListDto;
import pti.sb_airport2_mvc.model.Flight;


@Service
public class AppService {
	
	private Database db;
	
	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}

	public FlightListDto getAllFlights() {
		
		FlightListDto flightListDto = null;
		List<Flight> flights = db.getAllFlights();
		
		List<FlightDto> flightDtoList = new ArrayList<>();
		
		
		for(int index = 0; index < flights.size(); index++ ) {
			Flight currentFlight = flights.get(index);
			
			FlightDto currentFlightDto = converFlightToFlightDto(currentFlight);
			//currentFlightDto.setFlightMinutes();
			flightDtoList.add(currentFlightDto);
			
			
		}
		
		flightListDto = new FlightListDto(flightDtoList);
		flightListDto.orderByDepatureTime();
		
		return flightListDto;
	}
public FlightListDto getAllFlightsWithFlightTime() {
		
		FlightListDto flightListDto = null;
		List<Flight> flights = db.getAllFlights();
		
		List<FlightDto> flightDtoList = new ArrayList<>();
		
		
		for(int index = 0; index < flights.size(); index++ ) {
			Flight currentFlight = flights.get(index);
			
			FlightDto currentFlightDto = converFlightToFlightDto(currentFlight);
			currentFlightDto.setFlightMinutes();
			flightDtoList.add(currentFlightDto);
			
			
		}
		
		flightListDto = new FlightListDto(flightDtoList);
		flightListDto.orderByDepatureTime();
		
		return flightListDto;
	}
	
	
	public FlightDto converFlightToFlightDto(Flight flight) {
		
		FlightDto flightDto = new FlightDto(
				flight.getCityOfDepature(),
				flight.getTimeOfDepature(),
				flight.getCityOfArrival(),
				flight.getTimeOfArrival(),
				flight.getFlightNumber(),
				flight.getCaptain(),
				flight.getFlightMinutes());
		
		
		return flightDto;
	}
	
	

}
