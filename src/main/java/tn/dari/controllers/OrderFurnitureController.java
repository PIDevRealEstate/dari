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

import tn.dari.entities.OrderFurnitureEntity;
import tn.dari.repositories.OrderFurnitureRepository;
import tn.dari.services.OrderFurnitureServiceImpl;


@RestController
@RequestMapping("/api/order")
public class OrderFurnitureController {
	
	@Autowired
	OrderFurnitureServiceImpl orderFservice;
	@Autowired
	OrderFurnitureRepository orderFrepo;
	
	@DeleteMapping("/deleteOrders/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteOrders(@PathVariable("id")int id) {
		OrderFurnitureEntity o = orderFrepo.findById(id).get();
		if(!o.isAdmin()){
			orderFservice.deleteOrders(id);
		return new ResponseEntity<>("Order deleted successefully.", HttpStatus.OK);
		}else{
			return new ResponseEntity<>("You can't delete the order.", HttpStatus.UNAUTHORIZED);
		}
		}
	
	@PostMapping("/addOrders")
	@ResponseBody
	public  ResponseEntity<String>  addOrders(@RequestBody OrderFurnitureEntity orderFurnitureEntity ) 
	{	OrderFurnitureEntity result = orderFservice.addOrders(orderFurnitureEntity);
	if(result == null) {
		return new ResponseEntity<>("Order failed to be added.", HttpStatus.FORBIDDEN);
	}
		return new ResponseEntity<>("Order added successefully.", HttpStatus.CREATED);
		
	}
	@GetMapping("/all")
	public List<OrderFurnitureEntity> findAll(){
		return this.orderFservice.getAllOrders();
	}
	@PutMapping("/updateOrder/{id}")
	@ResponseBody
	public ResponseEntity<String> updateOrder(@RequestBody OrderFurnitureEntity newO, @PathVariable("id") int id){
		orderFservice.updateOrder(id, newO);
		return new ResponseEntity<>("Your order is updated successefully.", HttpStatus.CREATED);
		
	}
}
