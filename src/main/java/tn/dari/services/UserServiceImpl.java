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
		if(!user.getFavoris().stream().anyMatch(el-> el.getId() == furniture.getId())) {
			user.getFavoris().add(furniture);
			userRepo.save(user);
			return true;
		}
		
		return false;
	}

	@Override
	public User getUserById(int userId) {
		return this.userRepo.findById(userId).get();
	}

	@Override
	public void deleteFavoriteFurniture(Furniture furniture, int userId) {
		
		
	}

}
