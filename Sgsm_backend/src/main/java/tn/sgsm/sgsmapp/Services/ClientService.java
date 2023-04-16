package tn.sgsm.sgsmapp.Services;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.entity.Role;
import tn.sgsm.sgsmapp.entity.Client;
import tn.sgsm.sgsmapp.repo.UserRepository;
import tn.sgsm.sgsmapp.response.MessageResponse;

@Service
@RequiredArgsConstructor
public class ClientService {
	
	
	private final UserRepository userRepository;
	
	
	public Client getUserById(int id) {
		
		return userRepository.findById(id).orElseThrow();
		
	}
	
	  
	  public Client getClientData() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
	    return userRepository.findByEmail(username).orElseThrow();
	  }
	
	
	public Role getRole(int id) {
		
		Client user = userRepository.findById(id).orElseThrow();
		return user.getRole();
		
	}
	public MessageResponse updateclient(Client user) {
		
		Client usr = userRepository.findById(user.getId()).get();
		
		usr.setRole(usr.getRole());
		usr.setAdresse(user.getAdresse());
		usr.setEmail(user.getEmail());
		usr.setFirstName(user.getFirstName());
		usr.setLastName(user.getLastName());
		usr.setNumFix(user.getNumFix());
		usr.setNumTel(user.getNumTel());
		
		userRepository.save(usr);

			return new MessageResponse(true, "Success", "Mise a jour effectué");
		
	}
	
	public List<Client> getAllUsers() {
		
		return userRepository.findAll();
	}

}
