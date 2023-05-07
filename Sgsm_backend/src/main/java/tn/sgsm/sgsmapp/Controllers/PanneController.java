package tn.sgsm.sgsmapp.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.sgsm.sgsmapp.Services.PanneService;
import tn.sgsm.sgsmapp.entity.Ascenseur;
import tn.sgsm.sgsmapp.entity.Panne;
import tn.sgsm.sgsmapp.response.MessageResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/panne")
public class PanneController {
	
	private final PanneService panneService;
	
	
	
	
@PostMapping("/ajoutpanne/{id}")
public MessageResponse ajoutPanne(@RequestBody Panne panne , @PathVariable Integer id) {
   return 	panneService.ajoutPanne(panne,id);

}

}
