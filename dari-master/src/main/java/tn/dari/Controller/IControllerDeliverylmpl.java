package tn.dari.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.dari.entities.Delivery;
import tp3.service.IDeliveryService;

@Controller
public class IControllerDeliverylmpl {
	@Autowired
	IDeliveryService iDeliveryService;
	
 	
	public Delivery ajouterEmploye(Delivery delivery)
	{
		iDeliveryService.AjouterDelivery(delivery);
		return delivery;
	}
	
	
	
	
}
