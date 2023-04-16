package tn.sgsm.sgsmapp.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.request.AuthenticateRequest;
import tn.sgsm.sgsmapp.request.RegisterRequest;
import tn.sgsm.sgsmapp.response.AuthenticationResponse;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
public class AuthController {
	
	private final tn.sgsm.sgsmapp.Services.AuthenticationClientService authenticationService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(authenticationService.register(request));
	}
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticateRequest request){
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}

}
