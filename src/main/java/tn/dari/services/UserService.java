package tn.dari.services;

import tn.dari.entities.Furniture;
import tn.dari.entities.User;

public interface UserService {
	
	public boolean addFavoriteFurniture(Furniture furniture, int userId);
	public User getUserById(int userId);
	public void deleteFavoriteFurniture(Furniture furniture, int userId);

	User findUserByUserName(String username);
}
