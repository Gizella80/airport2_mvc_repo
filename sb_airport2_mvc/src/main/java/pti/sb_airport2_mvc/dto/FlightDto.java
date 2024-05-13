package pti.sb_airport2_mvc.dto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FlightDto {
	
	private String cityOfDepature;
	private LocalDateTime timeOfDepature;
	private String cityOfArrival;
	private LocalDateTime timeOfArrival;
	private String flightNumber;
	private String captain;
	private long flightMinutes;
	
	public FlightDto(String cityOfDepature, LocalDateTime timeOfDepature, String cityOfArrival,
			LocalDateTime timeOfArrival, String flightNumber, String captain, long flightMinutes) {
		super();
		this.cityOfDepature = cityOfDepature;
		this.timeOfDepature = timeOfDepature;
		this.cityOfArrival = cityOfArrival;
		this.timeOfArrival = timeOfArrival;
		this.flightNumber = flightNumber;
		this.captain = captain;
		this.flightMinutes = flightMinutes;
	}

	public String getCityOfDepature() {
		return cityOfDepature;
	}

	public void setCityOfDepature(String cityOfDepature) {
		this.cityOfDepature = cityOfDepature;
	}

	public LocalDateTime getTimeOfDepature() {
		return timeOfDepature;
	}

	public void setTimeOfDepature(LocalDateTime timeOfDepature) {
		this.timeOfDepature = timeOfDepature;
	}

	public String getCityOfArrival() {
		return cityOfArrival;
	}

	public void setCityOfArrival(String cityOfArrival) {
		this.cityOfArrival = cityOfArrival;
	}

	public LocalDateTime getTimeOfArrival() {
		return timeOfArrival;
	}

	public void setTimeOfArrival(LocalDateTime timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public long getFlightMinutes() {
		return flightMinutes;
	}

	public void setFlightMinutes() {
		this.flightMinutes = ChronoUnit.MINUTES.between(this.timeOfDepature,this.timeOfArrival);
	}

	@Override
	public String toString() {
		return "FlightDto [cityOfDepature=" + cityOfDepature + ", timeOfDepature=" + timeOfDepature + ", cityOfArrival="
				+ cityOfArrival + ", timeOfArrival=" + timeOfArrival + ", flightNumber=" + flightNumber + ", captain="
				+ captain + ", flightMinutes=" + flightMinutes + "]";
	}
	

}
