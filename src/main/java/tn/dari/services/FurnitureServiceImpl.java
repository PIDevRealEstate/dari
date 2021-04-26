package tn.dari.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Furniture;
import tn.dari.repositories.FurnitureRepository;

@Service
public class FurnitureServiceImpl implements FurnitureService {
	
	@Autowired
	FurnitureRepository furnitureRepository;

	@Override
	public void addFurniture(Furniture furniture) {
		furniture.setAvailability(true);
		furnitureRepository.save(furniture);
		
	}

	@Override
	public List<Furniture> getAll() {
		return this.furnitureRepository.findAll();
	}

	@Override
	public List<Furniture> findByName(String name) {
		return furnitureRepository.findByName(name);
	}

	@Override
	public List<Furniture> findByType(String type) {
		return furnitureRepository.findByType(type);
	}

	@Override
	public void deleteFurniture(int id) {
		Furniture furniture= furnitureRepository.findById(id).orElse(null);
		furnitureRepository.delete(furniture);
	}

	@Override
	public void updateFurniture(int id, Furniture newF) {
		Furniture furniture= furnitureRepository.findById(id).get();
		furniture.setName(newF.getName());
		furniture.setDescription(newF.getDescription());
		furniture.setType(newF.getType());
		furniture.setPrice(newF.getPrice());
		furnitureRepository.save(furniture);
		
	}

	@Override
	public List<Furniture> getFurnitureAvailable() {
		return  furnitureRepository.getFurnitureAvailable();
	}


}
