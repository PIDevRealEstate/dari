package tp3.service;

import java.util.List;

import tn.dari.entities.Furniture;
 
public interface IfurnitureService {
	
	public Furniture RetrieveFurniture(int IdFurniture);
	public Furniture UpdateFurniture  (int IdFurniture);
	List<Furniture> RetrieveAllFurniture();
	
  	public void DeleteFurniture  (int IdFurniture);
	public Furniture AjouterFurniture(Furniture furniture);
	
	public List<String> getAllFurnitureNamesJPQL();
	public List<Furniture> findAllFurnitureByNameJPQL(String TitleFurniture);	////
	public List<Furniture> findAllFurnitureByMaxMinPrixJPQL(int minPrix , int MaxPrix);	////

	
}
