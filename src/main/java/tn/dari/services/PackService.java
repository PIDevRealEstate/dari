package tn.dari.services;

import tn.dari.entities.Pack;

public interface PackService {
	public Pack getPackById(int id);
	
	public void ajouterPack(Pack pack);

	public void supprimerPack(int id);

	public Pack modifierPack(Pack pack);

}
