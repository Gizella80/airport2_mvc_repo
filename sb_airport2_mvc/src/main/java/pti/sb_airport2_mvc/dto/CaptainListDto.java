package pti.sb_airport2_mvc.dto;

import java.util.List;

public class CaptainListDto {
	
	private List<CaptainDto> captainDtos;

	public CaptainListDto(List<CaptainDto> captainDtos) {
		super();
		this.captainDtos = captainDtos;
	}

	public List<CaptainDto> getCaptainDtos() {
		return captainDtos;
	}

	public void setCaptainDtos(List<CaptainDto> captainDtos) {
		this.captainDtos = captainDtos;
	}

	@Override
	public String toString() {
		return "CaptainListDto [captainDtos=" + captainDtos + "]";
	}
	
	

}
