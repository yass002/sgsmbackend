package tn.sgsm.sgsmapp.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.entity.Role;
import tn.sgsm.sgsmapp.entity.Ascenseur;
import tn.sgsm.sgsmapp.entity.Client;
import tn.sgsm.sgsmapp.repo.AscenseurRepository;
import tn.sgsm.sgsmapp.repo.UserRepository;
import tn.sgsm.sgsmapp.response.MessageResponse;

@Service
@RequiredArgsConstructor
public class ClientService {
	
	
	private final UserRepository userRepository;
	private final AscenseurRepository ascenseurRepository;
	
	
	public Client getUserById(int id) {
		
		return userRepository.findById(id).orElseThrow();
		
	}
	public MessageResponse ajouterClientAsc(Client cl, List<Ascenseur> asc) throws IOException {
		//il faut mettre le mot de passe echangeable aprés ..
		cl.setPassword(cl.getFirstName()+cl.getLastName()+"sgsm");
		cl.setRole(Role.Client);
		cl.setAsc(asc);
		userRepository.save(cl);
		asc.forEach(asce -> asce.setClient(cl) );
		asc.forEach(asce -> ascenseurRepository.save(asce) );
		
		
		return new MessageResponse(true, "Success", "ajout effectue");
	}
	  
	  public Client getClientData() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName();
	    return userRepository.findByEmail(username).orElseThrow();
	  }
	  
	  public int getAuthUserId() {
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  String username= authentication.getName();
		  Client cl = userRepository.findByEmail(username).get();
		  return cl.getId();
	  }
	  
	  
	  public List<Ascenseur> getClientAsc(int id){
		  
		  Client client = userRepository.findById(id).orElseThrow();
		  
		  List<Ascenseur> asc = new ArrayList<>();
		  
		  asc =  client.getAsc();
		 for (Ascenseur a: asc) {
			 a.setRef("ASC"+a.getId()+"-"+client.getId());
			 
		 }
		  
		  return asc;
	  }
	  public MessageResponse ajoutAsc(Ascenseur asc, int id ) throws IOException {
		   		
		  Client client = userRepository.findById(id).get();
			
		  asc.setClient(client);
		   ascenseurRepository.save(asc);
		
		  
		 
			 
		  return new MessageResponse(true, "Success", "Ajout effectue avec success");
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
		
		List<Client> clients = userRepository.findAll().stream().filter(c -> c.getRole() == Role.Client ).
				collect(Collectors.toList());
		return clients;
	}

}
