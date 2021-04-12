package tp3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.DeliveryMan;
import tn.dari.entities.LesGouvernorat;
import tn.dari.entities.OrderFurnitureEntity;
import tp3.repository.DeliveryManRepository;
import tp3.repository.OrderRepository;

@Service
public class DeliveryManService implements IDeliveryManService{

	@Autowired
	OrderRepository orderRep;
	@Autowired
	DeliveryManRepository DeliveryManRep	;
	
	@Override
	public void AffecterOrdertoDeliveryMan(int IdOrder ,LesGouvernorat g) {
		int Max = 5;
		int x = 0;
		List<DeliveryMan> L = findAllDeliveryManByGouvernorat(g);
	    
		for (int i = 1; i <= L.size(); i++) {
	        	if(L.get(x).getOrderDelivery().size() > L.get(i).getOrderDelivery().size()){
	        		x = i; // pour affecter au délivreur qui a le min d'ordre
	        	}
	        }
		if(L.get(x).getOrderDelivery().size() > Max) {
			
			OrderFurnitureEntity orderEntity = orderRep.findById(IdOrder).get();
			DeliveryMan   deliveryManeEntity =L.get(x) ;

			if(deliveryManeEntity.getOrderDelivery() == null){

				List<OrderFurnitureEntity> orderDelivery = new ArrayList<>();
				orderDelivery.add(orderEntity);
				deliveryManeEntity.setOrderDelivery(orderDelivery);
			}else{
				deliveryManeEntity.getOrderDelivery().add(orderEntity);	
				}		
		}	
		
		else{
		String Name ="Délivreur est occupé essayer après un moment" ;
	    System.out.println(Name);
		}
	}

	@Override
	public List<DeliveryMan> findAllDeliveryMan() {
		return DeliveryManRep.findAllDeliveryMan();
	}
	
	@Override
	public void BestDeliveryMan() {
		List<DeliveryMan> deliveryMan = findAllDeliveryMan();
		int x = 0;
	    
		for (int i = 1; i <= deliveryMan.size(); i++) {
	        	if(deliveryMan.get(i).getFeed_Back_point() < deliveryMan.get(i).getFeed_Back_point()){
	        		x = i;
	        	}
	        }
		 String Name ="the best deliverer is "+ deliveryMan.get(x).getFirstName()+ deliveryMan.get(x).getLastName() ;
	     System.out.println(Name);
	     
	}

	@Override
	public List<DeliveryMan> findAllDeliveryManByGouvernorat(LesGouvernorat gouvernorat) {
		return DeliveryManRep.findAllDeliveryManByGouvernorat(gouvernorat);
	}	

 }
