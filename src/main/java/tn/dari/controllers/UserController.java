package tn.dari.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import tn.dari.entities.Furniture;
import tn.dari.entities.OrderFurnitureEntity;
import tn.dari.entities.User;
import tn.dari.repositories.UserRepository;
import tn.dari.security.AppSecurityConfig;
import tn.dari.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
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
	@GetMapping("/details/{userId}")
	public User findUserById(@PathVariable int userId) {
		return this.userService.getUserById(userId);
	}


	@PostMapping("/register")
	public  int addNewUser (@RequestBody User user) {

		User u = userService.findUserByUserName(user.getUsername());
		if(u==null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return 200;
		}
		return 400;
	}

	@PostMapping("/userinfo")
	public  int UserInfo (@RequestBody User user,@RequestHeader(value="Authorization") String jwt) {
		jwt=jwt.replaceFirst("Bearer","");
		User u = userService.findUserByUserName(AppSecurityConfig.decodeJWT(jwt).getSubject());
		if(u!=null) {
			u.setLastName(user.getLastName());
			u.setEmail(user.getEmail());
			u.setFirstName(user.getFirstName());
			userRepository.save(u);

			return 200;
		}
		return 400;
	}
	@PostMapping("/changepassword")
	public  int UserInfo (@RequestBody JSONObject jsonObject, @RequestHeader(value="Authorization") String jwt) {
		jwt=jwt.replaceFirst("Bearer","");
		User user = userService.findUserByUserName(AppSecurityConfig.decodeJWT(jwt).getSubject());
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		if(user!=null) {
			if(bCryptPasswordEncoder.matches((CharSequence) jsonObject.get("password"),user.getPassword())){
				System.out.println(user+"ok");
				user.setPassword(passwordEncoder.encode((String) jsonObject.get("newpassword")));
				userRepository.save(user);
				return 200;
			}
			return 400;

		}
		return 400;
	}

	@GetMapping("/all")
	public List<User> getAll(){
		return userRepository.findAll();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@GetMapping("/jwt")
	public void JWT(){
	}
	@GetMapping("/user")
	public User getUser(@RequestHeader(value="Authorization") String jwt){
		jwt=jwt.replaceFirst("Bearer","");
		User user = userService.findUserByUserName(AppSecurityConfig.decodeJWT(jwt).getSubject());
		user.setPassword(null);
		return user;
	}


}
