package tn.sgsm.sgsmapp.Controllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.Services.ClientService;
import tn.sgsm.sgsmapp.entity.Client;
import tn.sgsm.sgsmapp.entity.Role;
import tn.sgsm.sgsmapp.response.MessageResponse;


@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DemoController {
	private final ClientService userService;
	@GetMapping("/c")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Heelo");
	}
	
	@GetMapping("/getrole/{id}")
	public ResponseEntity<Role> getRole(@PathVariable int id){
		return ResponseEntity.ok(userService.getRole(id));
				}
	
	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<Client> getOneUserById(@PathVariable Integer id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<Client>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PutMapping("updateuser")
	public ResponseEntity<MessageResponse> updateUser(@RequestBody Client client){
		return ResponseEntity.ok(userService.updateclient(client));
	}
	
	  @GetMapping("/user")
	  public Client getUserData() {
	    
	    return userService.getClientData();
	  }
	
	
	
	
	
}
