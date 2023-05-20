package tn.sgsm.sgsmapp.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.Services.TechnicienService;
import tn.sgsm.sgsmapp.entity.Technicien;
import tn.sgsm.sgsmapp.response.MessageResponse;

@RestController
@RequestMapping("/api/v1/technicien")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
public class TechnicienController {
	
	private final TechnicienService technicienService;
	
	@PostMapping("/ajoutertechnicien")
	public MessageResponse ajoutTech(@RequestBody Technicien tech)  {
		return technicienService.ajouterTechnicien(tech);
	}
	
	@GetMapping("/getalltechnicien")
	public List<Technicien> getAlltechnicien(){
		return technicienService.getAllTech();
	}
	
}
