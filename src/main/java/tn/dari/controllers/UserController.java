package tn.dari.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Furniture;
import tn.dari.entities.OrderFurnitureEntity;
import tn.dari.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/addFavoris/{userId}")
	@ResponseBody
	public  ResponseEntity<String>  addOrders(@RequestBody Furniture furniture, @PathVariable int userId) 
	{
		boolean result = userService.addFavoriteFurniture(furniture, userId);
		if(result) {
			return new ResponseEntity<>("Furniture added successefully.", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Furniture already Exist .", HttpStatus.ALREADY_REPORTED);
		
	}
	
}
