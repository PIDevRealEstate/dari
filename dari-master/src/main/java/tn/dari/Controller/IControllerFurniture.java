package tn.dari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.dari.entities.Furniture; 
import tp3.service.IfurnitureService;

@Controller
public class IControllerFurniture {

	@Autowired
	IfurnitureService iFurnitureservice;
	
	public int ajouterFurniture(Furniture furniture)
	{
		iFurnitureservice.AjouterFurniture(furniture);
		return furniture.getIdFurniture();
	}
	
	public void deleteFurniture(int FurnitureId) {
		iFurnitureservice.DeleteFurniture(FurnitureId);
		
	}
	
	
	public List<String> getAllFurnitureNamesJPQL() {
		
		return iFurnitureservice.getAllFurnitureNamesJPQL();
	}

	public List<Furniture> findAllFurnitureByNameJPQL(String TitleFurniture) {
		return iFurnitureservice.findAllFurnitureByNameJPQL(TitleFurniture);
	}

	public List<Furniture> findAllFurnitureByMaxMinPrixJPQL(int minPrix , int MaxPrix) {
		return iFurnitureservice.findAllFurnitureByMaxMinPrixJPQL(minPrix,MaxPrix);
	}

	public void UpdateFurniture(int IdFurniture) {	
		iFurnitureservice.UpdateFurniture(IdFurniture);
		
	}
	
	public Furniture RetrieveFurniture(int IdFurniture) {	
		return iFurnitureservice.RetrieveFurniture(IdFurniture);
		
	}
	
	public List<Furniture> RetrieveAllFurniture() {	
		return iFurnitureservice.RetrieveAllFurniture( );
		
	}
}
