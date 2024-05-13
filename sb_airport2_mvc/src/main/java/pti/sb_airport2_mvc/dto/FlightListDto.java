package pti.sb_airport2_mvc.dto;

import java.util.List;

public class FlightListDto {
	
	private List<FlightDto> flightDtos;
	
	
	

	public FlightListDto(List<FlightDto> flightDtos) {
		super();
		this.flightDtos = flightDtos;
	
	}

	public List<FlightDto> getFlightDtos() {
		return flightDtos;
	}

	public void setFlightDtos(List<FlightDto> flightDtos) {
		this.flightDtos = flightDtos;
	}

	

	public void addFlightDto(FlightDto flightDto) {
		this.flightDtos.add(flightDto);
	}

	@Override
	public String toString() {
		return "FlightListDto [flightDtos=" + flightDtos + "]";
	}
	
	public void orderByDepatureTime() {
		for(int currentIndex = 0; currentIndex < this.flightDtos.size(); currentIndex++) {
			
			FlightDto currentFlightDto = this.flightDtos.get(currentIndex);
			for(int nextIndex = currentIndex+1; nextIndex < this.flightDtos.size(); nextIndex++) {
				
				FlightDto nextFlightDto = this.flightDtos.get(nextIndex);
				if(currentFlightDto.getTimeOfDepature().compareTo(nextFlightDto.getTimeOfDepature()) > 0) {
					
					this.flightDtos.set(currentIndex, nextFlightDto);
					this.flightDtos.set(nextIndex, currentFlightDto);
					currentIndex = -1;
					break;
				}
			}
		}
	}
	
	
	

}
