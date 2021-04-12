package tn.dari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Furniture;
import tp3.service.IfurnitureService;

@RestController
public class RestControlFurniture {

	@Autowired
	IfurnitureService iFurnitureservice;
	
	
    @GetMapping(value = "/RetrieveFurniture/{idFurniture}")
    @ResponseBody
	public Furniture RetrieveFurniture(@PathVariable("idFurniture") int IdFurniture) {

		return iFurnitureservice.RetrieveFurniture(IdFurniture);
	}
    
    @GetMapping(value = "/RetrieveAllFurniture/")
    @ResponseBody
	public List<Furniture>  RetrieveAllFurniture() {

		return iFurnitureservice.RetrieveAllFurniture();
	}
    
	// http://localhost:8081/SpringMVC/servlet/ajouterFurniture
	//{"id":1,"nom":"kallel", "prenom":"khaled", "email":"Khaled.kallel@ssiiconsulting.tn", "isActif":true, "role":"INGENIEUR"}
	
	@PostMapping("/ajouterFurniture")
	@ResponseBody
	public Furniture ajouterFurniture(@RequestBody Furniture furniture)
	{
		iFurnitureservice.AjouterFurniture(furniture);
		return furniture;
	}
	
	 // URL : http://localhost:8081/SpringMVC/servlet/deleteFurniture/1
    @DeleteMapping("/deleteFurniture/{idFurniture}") 
	@ResponseBody 
	public void deleteFurniture(@PathVariable("idFurniture")int FurnitureId) {
    	iFurnitureservice.DeleteFurniture(FurnitureId);
		
	}
    
    // Modifier email : http://localhost:8081/SpringMVC/servlet/mettreAjourEmailByFurnitureIdJPQL/2/newemail
 	@PutMapping(value = "/UpdateFurniture/{id}") 
 	@ResponseBody
	public void UpdateFurniture(@PathVariable("id") int IdFurniture) {	
 		iFurnitureservice.UpdateFurniture(IdFurniture);	
	}
    
	   // URL : http://localhost:8081/SpringMVC/servlet/getNombreFurnitureJPQL
    @GetMapping(value = "/getNombreFurnitureJPQL")
    @ResponseBody
	public List<Furniture> findAllFurnitureByNameJPQL(String TitleFurniture) {
		
		return iFurnitureservice.findAllFurnitureByNameJPQL(TitleFurniture);
	}

    
    // URL : http://localhost:8081/SpringMVC/servlet/getNombreFurnitureJPQL
    @GetMapping(value = "/getNombreFurnitureJPQL")
    @ResponseBody
	public  List<Furniture> findAllFurnitureByMaxMinPrixJPQL(int minPrix , int MaxPrix) {
		
		return iFurnitureservice.findAllFurnitureByMaxMinPrixJPQL(minPrix , MaxPrix);
	}
    
    // URL : http://localhost:8081/SpringMVC/servlet/getNombreFurnitureJPQL
    @GetMapping(value = "/getNombreFurnitureJPQL")
    @ResponseBody
	public List<String> getAllFurnitureNamesJPQL() {
		
		return iFurnitureservice.getAllFurnitureNamesJPQL();
	}
}
