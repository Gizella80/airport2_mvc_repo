package pti.sb_airport2_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pti.sb_airport2_mvc.dto.CaptainListDto;
import pti.sb_airport2_mvc.dto.FlightListDto;
import pti.sb_airport2_mvc.service.AppService;

@Controller
public class AppController {
	
	private AppService service;
	
	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	@GetMapping("/")
	public String index() {
		
		return "index.html";
	}
	
	@GetMapping("/flights")
	public String getAllFligths(Model model) {
		
		FlightListDto flightListDto = service.getAllFlights();
		model.addAttribute("flightlistdto", flightListDto);
		
		return "flights.html";
	}
	@GetMapping("/flighttime")
	public String getFlightDuration(Model model) {
		

		FlightListDto flightListDto = service.getAllFlightsWithFlightTime();
		model.addAttribute("flightlistdto", flightListDto);
		
		return "flighttime.html";
	}
	
	@GetMapping("/captains")
	public String showCaptains(Model model) {
		
		CaptainListDto captainDtoList = service.getAllCaptains();
		
		model.addAttribute("captainlistdto", captainDtoList);
		return "captains.html";
	}
	
	@GetMapping("/captainresult")
	public String showCaptainReturnigWithTransfer(Model model) {
		 CaptainListDto captainListDto = service.getCaptainReturningWithTransfer();
		 
		 model.addAttribute("captainlistdto", captainListDto);
		 
		
		return "captainresult.html";
	}
	
	
	
	
	
	
}
