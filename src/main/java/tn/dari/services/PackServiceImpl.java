package tn.dari.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Pack;
import tn.dari.repositories.PackRepository;


@Service
public class PackServiceImpl implements PackService {
	
	
	@Autowired
	PackRepository packRepository ; 

	@Override
	public void ajouterPack(Pack pack) {
		packRepository.save(pack);
		
	}

	@Override
	public void supprimerPack( int id) {
		Pack pack = packRepository.findById(id).orElse(null);
		packRepository.delete(pack);
		
	}

	@Override
	public Pack modifierPack(Pack pack) {
		return packRepository.save(pack);
	}

	@Override
	public Pack getPackById(int id) {
		
		return this.packRepository.findById(id).get();
	}

}
