package tn.sgsm.sgsmapp.Services;


import tn.sgsm.sgsmapp.entity.Client;
import tn.sgsm.sgsmapp.request.AuthenticateRequest;
import tn.sgsm.sgsmapp.request.RegisterRequest;
import tn.sgsm.sgsmapp.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationClientService {
  private final tn.sgsm.sgsmapp.repo.UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var client = Client.builder()
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .numTel(request.getNumTel())
        .numFix(request.getNumFix())
        .adresse(request.getAdresse())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(request.getRole())
        .build();
    repository.save(client);
    var jwtToken = jwtService.generateToken(client);
    return AuthenticationResponse.builder()
        .accesToken(jwtToken)
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticateRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var client = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(client);
   
    
    return AuthenticationResponse.builder()
        .accesToken(jwtToken)
        .firstName(client.getFirstName())
        .lastName(client.getLastName())
        .build();
  }

  

 

    
}