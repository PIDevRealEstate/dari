package tp3.service;

import java.util.List;

import tn.dari.entities.Delivery;

 
public interface IDeliveryService {
	
  	public void DeleteDelivery  (int IdDelivery);
	public Delivery RetrieveDelivery(int IdDelivery);
	public Delivery UpdateDelivery  (int IdDelivery);
	public Delivery AjouterDelivery(Delivery delivery);
	List<Delivery> RetrieveAllDelivery();
	
	

 
}
