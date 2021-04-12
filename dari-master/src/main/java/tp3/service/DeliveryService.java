package tp3.service;

import java.util.ArrayList;
import java.util.List;
import tp3.repository.DeliveryRepository;
import tp3.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Delivery;
 

@Service
public class DeliveryService implements IDeliveryService {
	
	@Autowired
	OrderRepository orderRep;
	@Autowired
	DeliveryRepository deliveryrep;
	
	@Override
	public Delivery AjouterDelivery(Delivery delivery) {
		return deliveryrep.save(delivery);
	}
	
	@Override
	public void DeleteDelivery(int IdDelivery) {
		deliveryrep.deleteById(IdDelivery);
	}
	
	@Override
	public Delivery RetrieveDelivery(int IdDelivery) {
		Delivery delivery = deliveryrep.findById(IdDelivery).orElse(null);
		return delivery;
	}
	@Override
	public Delivery UpdateDelivery(int IdDelivery) {
		Delivery delivery = deliveryrep.findById(IdDelivery).orElse(null);
		delivery.setDateDelivery(delivery.getDateDelivery());
		delivery.setLocation(delivery.getLocation());
		delivery.setLocation(delivery.getLocation());
		delivery.setAreaCovered(delivery.GetAreaCovered());
		return delivery;
		}
	
	@Override
	public List<Delivery> RetrieveAllDelivery() {
		List<Delivery> DeliveryList = new ArrayList<>();
		return DeliveryList;
	}	
	
	
	
}
