package tn.sgsm.sgsmapp.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class MessageResponse {
	
	
	private boolean success;
	private String message;
	private String details;
	
}
