package tn.dari.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Assurance;
import tp3.service.AssuranceService;
 
@RestController
@RequestMapping("/Assurance")
public class RestControlAssurance {
	
	@Autowired
	AssuranceService aS;
	// http://localhost:8081/SpringMVC/servlet/Assurance/Ajouter-Assurance
		@PostMapping("/Ajouter-Assurance")
		@ResponseBody
		public Assurance AjouterAssurance(@RequestBody Assurance ass) {
		Assurance  assurance = aS.AjouterAssurance(ass);
		return assurance;
		}
		
		// http://localhost:8081/SpringMVC/servlet//Assurance/retrieve-all-Assurance
		@GetMapping("/retrieve-all-Assurance")
		@ResponseBody
		public List<Assurance> RetrieveAllAssurance() {
		List<Assurance> list = aS.RetrieveAllAssurance();
		return list;
		}
		
		// http://localhost:8081/SpringMVC/servlet//Assurance/Delete-Assurance/{Assurance-id}
		@DeleteMapping("/Delete-Assurance/{Assurance-id}")
		@ResponseBody
		public void DeleteAssurance(@PathVariable("Assurance-id") int AssurancetId) {
			aS.DeleteAssurance(AssurancetId);
		}
		
		// http://localhost:8081/SpringMVC/servlet//Assurance/Update-Assurance
		@PutMapping("/Update-Assurance")
		@ResponseBody
		public Assurance UpdateAssurance(@RequestBody Assurance assurance) {
		return aS.UpdateAssurance(assurance);
		}
		
		// http://localhost:8081/SpringMVC/servlet//Assurance/retrieve-Assurance/{Assurance-id}
		@GetMapping("/retrieve-Assurance/{Assurance-id}")
		@ResponseBody
		public Assurance retrieveAssurance(@PathVariable("Assurance-id") int idAssurance) {
		return aS.RetrieveAssurance(idAssurance);
		}

}