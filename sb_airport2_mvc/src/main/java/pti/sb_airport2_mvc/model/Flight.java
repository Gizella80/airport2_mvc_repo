package pti.sb_airport2_mvc.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="flights")
public class Flight {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="cityofdepature")
	private String cityOfDepature;
	
	@Column(name="timeofdepature")
	private LocalDateTime timeOfDepature;
	
	@Column(name="cityofarrival")
	private String cityOfArrival;
	
	@Column(name="timeofarrival")
	private LocalDateTime timeOfArrival;
	
	@Column(name="flightnumber")
	private String flightNumber;
	
	@Column(name="captain")
	private String captain;
	
	@Transient
	private long flightMinutes ;
	
	public Flight() {
		
	}

	public Flight(int id, String cityOfDepature, LocalDateTime timeOfDepature, String cityOfArrival,
			LocalDateTime timeOfArrival, String flightNumber, String captain) {
		super();
		this.id = id;
		this.cityOfDepature = cityOfDepature;
		this.timeOfDepature = timeOfDepature;
		this.cityOfArrival = cityOfArrival;
		this.timeOfArrival = timeOfArrival;
		this.flightNumber = flightNumber;
		this.captain = captain;
		this.flightMinutes = ChronoUnit.MINUTES.between(this.timeOfDepature,this.timeOfArrival);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	
	
	

}
