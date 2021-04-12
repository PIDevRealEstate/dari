package tn.dari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Furniture;
import tn.dari.entities.User;
import tn.dari.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public boolean addFavoriteFurniture(Furniture furniture, int userId) {
		User user= userRepo.getOne(userId);
		if(!user.getFavoris().contains(furniture)) {
			user.getFavoris().add(furniture);
			
			return true;
		}
		
		return false;
	}

}
