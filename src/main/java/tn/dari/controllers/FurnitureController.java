package tn.dari.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Furniture;
import tn.dari.repositories.FurnitureRepository;
import tn.dari.services.FurnitureService;

@RestController
@RequestMapping("/api/furniture")
public class FurnitureController {

		@Autowired
		FurnitureService furnitureService;
		@Autowired
		FurnitureRepository furnitureRepository;
		
	//Add a Furniture
	//http://localhost:8081/api/furniture/addFurniture
		@PostMapping("/addFurniture")
		@ResponseBody
		public ResponseEntity<String> addFurniture(@RequestBody Furniture furniture){
			if (furniture.getPrice()<=0) {
				return new ResponseEntity<>("Enter a valid price", HttpStatus.BAD_REQUEST);
			} else {
				furnitureService.addFurniture(furniture);
			}
			return new ResponseEntity<>("Furniture Is Added Successfully", HttpStatus.CREATED);
		}
	//Get All Furnitures
	//http://localhost:8081/api/furniture/all	
		@GetMapping("/all")
		public List<Furniture> getAll(){
			return this.furnitureService.getAll();
		}
		
	//Get Furniture by Name
	//http://localhost:8081/api/furniture/getByName/lule
		@GetMapping("/getByName/{name}")
		public List<Furniture> findByName(@PathVariable("name")String name){
			return furnitureService.findByName(name);
			
		}
	//Get Furniture by Type
	//http://localhost:8081/api/furniture/getByType/Chair
		@GetMapping("/getByType/{type}")
		public List<Furniture> findByType(@PathVariable("type")String type){
			return furnitureService.findByType(type);
		}
	//Delete Furniture
	//http://localhost:8081/api/furniture/deleteFurniture/{id}
		@DeleteMapping("/deleteFurniture/{id}")
		@ResponseBody
		public ResponseEntity<String> deleteFurniture(@PathVariable("id")int id) {
			furnitureService.deleteFurniture(id);
			return new ResponseEntity<>("Furniture deleted successfully.", HttpStatus.CREATED);
		}
	
	//Update Furniture
		
		@PutMapping("/updateFurniture/{id}")
		@ResponseBody
		public ResponseEntity<String> updateFurniture(@RequestBody Furniture newF,@PathVariable("id")int id) {
			furnitureService.updateFurniture(id,newF);
			return new ResponseEntity<>("Furniture updated successefully.", HttpStatus.CREATED);
		}
		
		
	//Get Furniture Available
	//http://localhost:8081/api/furniture/getByAvailability
		@GetMapping("/getByAvailability")
		@ResponseBody
		public List<Furniture> findByAvailability(){
			return furnitureService.getFurnitureAvailable();
		}
		
		
		
		
		/*@GetMapping("/ok")
		public String ok () {
			return ("ok");
		}*/
		
		
		
}
