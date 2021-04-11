package tn.dari.services;

import java.util.List;

import tn.dari.entities.Furniture;

public interface FurnitureService {
	public void addFurniture(Furniture furniture);
	public List<Furniture> getAll();
	public List<Furniture> findByName(String name);
	public List<Furniture> findByType(String type);
	public void deleteFurniture(int id);
	public void updateFurniture(int id, Furniture newF);
	public List<Furniture> getFurnitureAvailable();
}
