package tn.dari.services;

import tn.dari.entities.Furniture;
import tn.dari.entities.User;

public interface UserService {
	
	public boolean addFavoriteFurniture(Furniture furniture, int userId);

}
