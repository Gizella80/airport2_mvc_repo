package pti.sb_airport2_mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pti.sb_airport2_mvc.db.Database;
import pti.sb_airport2_mvc.dto.CaptainDto;
import pti.sb_airport2_mvc.dto.CaptainListDto;
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
			
			flightDtoList.add(currentFlightDto);
			
			
		}
		
		flightListDto = new FlightListDto(flightDtoList);
		
		
		return flightListDto;
	}
	
	
	public FlightDto converFlightToFlightDto(Flight flight) {
		
		FlightDto flightDto = new FlightDto(
				flight.getCityOfDepature(),
				flight.getTimeOfDepature(),
				flight.getCityOfArrival(),
				flight.getTimeOfArrival(),
				flight.getFlightNumber(),
				flight.getCaptain())
			;
		
		
		return flightDto;
	}

	public CaptainListDto getAllCaptains() {
		CaptainListDto captainListDto = null;
		List<Flight> flights = db.getAllFlights();
		List<CaptainDto> captains = new ArrayList<>(); 
		
		for(int index = 0; index < flights.size();index++) {
			
			Flight currentFlight = flights.get(index);
			FlightDto currentFlightDto = converFlightToFlightDto(currentFlight);
			Long flightMinutes = currentFlight.getFlightMinutes();
			List<FlightDto> flightsOfCaptain = new ArrayList<>();
			flightsOfCaptain.add(currentFlightDto);
			CaptainDto currentCaptainDto = new CaptainDto(currentFlight.getCaptain(),flightMinutes,flightsOfCaptain);
			
			boolean contains = false;
			
			for(int index_captains = 0; index_captains < captains.size(); index_captains++) {
				CaptainDto currCaptainDto = captains.get(index_captains);
				if(currCaptainDto.getName().equals(currentCaptainDto.getName())) {
					currCaptainDto.addFlightMinutes(currentFlight.getFlightMinutes());
					currCaptainDto.getFlights().add(currentFlightDto);
					contains = true;
					break;
				}
				
			}
			if(contains == false) {
				
				currentCaptainDto.getFlights().add(currentFlightDto);
				captains.add(currentCaptainDto);
			}
			
		}
		
		captainListDto = new CaptainListDto(captains);
		return  captainListDto;
	}

	public CaptainListDto getCaptainReturningWithTransfer() {
		
		CaptainListDto searchedDtos = null;
		CaptainListDto captainListDto = getAllCaptains();
		
		List<CaptainDto> captainDtoList = captainListDto.getCaptainDtos();
		CaptainDto checkDto =captainDtoList.get(1);
		for(int i = 0; i < checkDto.getFlights().size();i++) {
			System.out.println(checkDto.getFlights().get(i).getFlightNumber()+" from service");
		}
	
		List<CaptainDto> searchedCaptains = new ArrayList<>();
		
		for(int index_captainDtoList = 0;index_captainDtoList < captainDtoList.size(); index_captainDtoList++) {
			CaptainDto currentCaptainDto = captainDtoList.get(index_captainDtoList);
			if(currentCaptainDto.returnedWithTransfer() == true) {
				searchedCaptains.add(currentCaptainDto);
			}
				
		}
		searchedDtos = new CaptainListDto(searchedCaptains);
		
		return searchedDtos;
	}
	
	

}
