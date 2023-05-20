package tn.sgsm.sgsmapp.Services;


import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import tn.sgsm.sgsmapp.entity.Technicien;
import tn.sgsm.sgsmapp.repo.TechnicienRepository;
import tn.sgsm.sgsmapp.response.MessageResponse;

@Service
@RequiredArgsConstructor
public class TechnicienService {

	private final TechnicienRepository technicienRepository;
	private final BCryptPasswordEncoder encoder;
	
	
	public MessageResponse ajouterTechnicien(Technicien tech)  {
		
		tech.setPassword(encoder.encode("sgsm_tech"));
		technicienRepository.save(tech);
		
		return new MessageResponse(true, "Success", "ajout effectue");
	}
	
	
	public List<Technicien> getAllTech(){
		return technicienRepository.findAll();
	}
}
