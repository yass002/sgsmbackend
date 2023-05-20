package tn.sgsm.sgsmapp.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.Services.PanneService;
import tn.sgsm.sgsmapp.entity.Ascenseur;
import tn.sgsm.sgsmapp.entity.Client;
import tn.sgsm.sgsmapp.entity.Panne;
import tn.sgsm.sgsmapp.response.MessageResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/panne")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PanneController {
	
	private final PanneService panneService;
	
	
	
	
@PostMapping("/ajoutpanne/{id}")
public MessageResponse ajoutPanne(@RequestBody Panne panne , @PathVariable Integer id) {
   return 	panneService.ajoutPanne(panne,id);

}

@GetMapping("/getpanne/{id}")
public Panne getPanne(@PathVariable int id) {
	return panneService.getPanneById(id);
}
@GetMapping("/getallpanne/{id}")
public List<Panne> getallPanne(@PathVariable int id) {
	return panneService.getAllPanne(id);
}
@GetMapping("/getlastpanne/{id}")
public Panne getlastPanne(@PathVariable int id) {
	return panneService.getlastPanne(id);
}
@GetMapping("/getallpannes")
public List<Panne> getAllPannes(){
	return panneService.getAllPannes();
}
@GetMapping("/getclientbyascid/{id}")
public Client getClientByascId(@PathVariable int id) {
	return panneService.getClientByIdAsc(id);
}
}
