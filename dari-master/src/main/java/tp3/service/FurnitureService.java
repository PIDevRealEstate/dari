package tp3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Furniture;
import tp3.repository.FurnitureRepository;
import tp3.repository.OrderRepository;

@Service
public class FurnitureService implements IfurnitureService {

	@Autowired
	FurnitureRepository furnitureRep;
	@Autowired
	OrderRepository orderRep;
	
	@Override
	public void DeleteFurniture(int IdFurniture) {
		furnitureRep.deleteById(IdFurniture);
	}

	@Override
	public Furniture RetrieveFurniture(int IdFurniture) {
		Furniture furniture = furnitureRep.findById(IdFurniture).orElse(null);
		return furniture;
	}

	@Override
	public Furniture UpdateFurniture(int IdFurniture) {
		Furniture furniture = furnitureRep.findById(IdFurniture).orElse(null);	
		
		furniture.setTitleFurniture(furniture.getTitleFurniture());
		furniture.setEtat_Furniture  (furniture.getEtat_Furniture());
		furniture.setDescription  (furniture.getDescription());
		furniture.setPrixFurniture(furniture.getPrixFurniture());
		furniture.setPrixFurniture(furniture.getPrixFurniture());
		furniture.setOrder(furniture.getOrder());
		furniture.setUser(furniture.getUser());
		return furniture;		
	}

	@Override
	public Furniture AjouterFurniture(Furniture furniture) {
		return 	furnitureRep.save(furniture);
	}

	@Override
	public List<Furniture> RetrieveAllFurniture() {
		List<Furniture> FurnitureList = new ArrayList<>();
		return FurnitureList;
 	}

	@Override
	public List<String> getAllFurnitureNamesJPQL() {
//	   	return FurnitureRepository.FurnitureTitle();
	 	return null;
 	}

	@Override
	public List<Furniture> findAllFurnitureByNameJPQL(String TitleFurniture) {
		return furnitureRep.findAllFurnitureByNameJPQL(TitleFurniture);
 	}

	@Override
	public List<Furniture> findAllFurnitureByMaxMinPrixJPQL(int MinPrix, int MaxPrix) {
		return furnitureRep.findAllFurnitureByMaxMinPrixJPQL(MinPrix,MaxPrix);				
	}
	
}
