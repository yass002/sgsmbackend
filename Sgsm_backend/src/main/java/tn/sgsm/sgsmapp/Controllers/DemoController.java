package tn.sgsm.sgsmapp.Controllers;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.Services.AscenseurService;
import tn.sgsm.sgsmapp.Services.ClientService;
import tn.sgsm.sgsmapp.entity.Ascenseur;
import tn.sgsm.sgsmapp.entity.Client;
import tn.sgsm.sgsmapp.entity.Role;
import tn.sgsm.sgsmapp.response.MessageResponse;


@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DemoController {
	
	private final ClientService userService;
	private final AscenseurService ascenseurService;

	
	@GetMapping("/getrole/{id}")
	public ResponseEntity<Role> getRole(@PathVariable int id){
		return ResponseEntity.ok(userService.getRole(id));
				}
	
	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<Client> getOneUserById(@PathVariable Integer id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	@GetMapping("/getascbyid/{id}")
	public ResponseEntity<Ascenseur> getascbyid(@PathVariable Integer id){
		return ResponseEntity.ok().body(ascenseurService.getAscById(id)); 
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
	  
	  @GetMapping("/getAsc/{id}")
	  public ResponseEntity<List<Ascenseur>>  getClientAsc(@PathVariable Integer id){
		  
		  return  ResponseEntity.ok(userService.getClientAsc(id));
				  
	  }
	  static String path_dir = "C:\\Users\\yassi\\git\\sgsmbackends\\Sgsm_backend\\src\\main\\resources\\static\\images";

	  @PostMapping(path = "/ajoutAsc/{id}" , consumes = { MediaType.MULTIPART_FORM_DATA_VALUE})
	  public MessageResponse ajouterAsc(@RequestPart("ascenseur") Ascenseur asc ,
			  @RequestParam("image") MultipartFile file ,
			  @PathVariable int id
			  
			  ) {
		  try {
			  Files.copy(file.getInputStream(), Paths.get(path_dir+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			  asc.setImageName("http://localhost:8081/api/v1/demo/image/"+file.getOriginalFilename());
			  userService.ajoutAsc(asc,id);
			  return new MessageResponse(true, "Done", "Ajout effectue avec success");
		  } catch (Exception e) {
			  System.out.println(e.getMessage());
			  return new MessageResponse(false, "Undone", "Something happen");
		  }

	  }
	  @GetMapping("/image/{fileName}")
	  public ResponseEntity<Resource> getImage(@PathVariable String fileName) throws IOException {
	      Resource resource = new FileSystemResource(path_dir +File.separator + fileName);
	      return ResponseEntity.ok()
	              .contentType(MediaType.IMAGE_JPEG)
	              .contentLength(resource.contentLength())
	              .body(resource);
	  }
	  
	 

	
	
	
	
	
}
