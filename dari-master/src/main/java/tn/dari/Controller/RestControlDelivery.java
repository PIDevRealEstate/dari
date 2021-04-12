package tn.dari.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Delivery;
import tp3.service.IDeliveryService;

@RestController

public class RestControlDelivery {

	
	@Autowired
	IDeliveryService iDeliveryService;
	
	@PostMapping("/ajouterDelivery")
	@ResponseBody
	public Delivery ajouterEmploye(@RequestBody Delivery delivery)
	{
		iDeliveryService.AjouterDelivery(delivery);
		return delivery;
	}
	
	
	
}
