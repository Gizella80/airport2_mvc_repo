package pti.sb_airport2_mvc.dto;

import java.util.List;

public class CaptainDto {
	
	private String name;
	private List<FlightDto> flightDtos;
	
	public CaptainDto(String name, List<FlightDto> flightDtos) {
		super();
		this.name = name;
		this.flightDtos = flightDtos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FlightDto> getFlightDtos() {
		return flightDtos;
	}

	public void setFlightDtos(List<FlightDto> flightDtos) {
		this.flightDtos = flightDtos;
	}

	@Override
	public String toString() {
		return "CaptainDto [name=" + name + ", flightDtos=" + flightDtos + "]";
	}
	
	
	
	

}
