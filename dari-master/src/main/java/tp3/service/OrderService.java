package tp3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.dari.entities.DeliveryMan;
import tn.dari.entities.Furniture;
import tn.dari.entities.OrderFurnitureEntity;
import tp3.repository.DeliveryManRepository;
import tp3.repository.DeliveryRepository;
import tp3.repository.FurnitureRepository;
import tp3.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRep;
	@Autowired
	DeliveryRepository deliveryRep;
	@Autowired
	FurnitureRepository furnitureRep;
	@Autowired
	DeliveryManRepository deliveryManRep;
	
	@Override
	public void DeleteOrder(int IdOrder) {
		deliveryRep.deleteById(IdOrder);
	}
	
	@Override
	public OrderFurnitureEntity RetrieveOrder(int IdOrder) {
		OrderFurnitureEntity order = orderRep.findById(IdOrder).orElse(null);
		return order;
	}
	@Override
	public OrderFurnitureEntity UpdateOrder(int IdOrder) {
		OrderFurnitureEntity order = orderRep.findById(IdOrder).orElse(null);
		order.setPrice(order.getPrice());
		order.setDateOrder(order.getDateOrder());
		order.setNbOfOrders(order.getNbOfOrders());
		order.setFurnitures(order.getFurnitures());
		order.setDeliveryMan(order.getDeliveryMan());
		return order;
 	}
	
	@Override
	public OrderFurnitureEntity AjouterOrder(OrderFurnitureEntity Order) {
		return orderRep.save(Order);
	}
	@Override
	public List<OrderFurnitureEntity> RetrieveAllOrder() {
		List<OrderFurnitureEntity> FurnitureList = new ArrayList<>();
		return FurnitureList;
	}
	
	@Override
	public void SupprimerFurniturefromOrder(int IdFurniture, int idOrder) {
		OrderFurnitureEntity orderEntity = orderRep.findById(idOrder).get();

		int orderNb = orderEntity.getFurnitures().size();
		for(int index = 0; index < orderNb; index++){
			if(orderEntity.getFurnitures().get(index).getIdFurniture() == IdFurniture){
				orderEntity.getFurnitures().remove(index);
				break; //a revoir
			}
		}
	}
	
	@Override
	public void Ajouter_Furniture_to_Order(int IdFurniture, int idOrder) {
		OrderFurnitureEntity orderEntity = orderRep.findById(idOrder).get();
		Furniture furnitureEntity = furnitureRep.findById(IdFurniture).get();

		if(orderEntity.getFurnitures() == null){

			List<Furniture> furniture = new ArrayList<>();
			furniture.add(furnitureEntity);
			orderEntity.setFurnitures(furniture);
		}else{
			orderEntity.getFurnitures().add(furnitureEntity);	
		}
		
		/*Furniture furnitureEntity = furnitureRep.findById(IdFurniture).get();
		int x =0;
		
		for (int i = 0; i < user.getOrder().size(); i++){
			if( user.getOrder().get(i).getGouvernorat() == furnitureEntity.getGouvernorat()){
				user.getOrder().get(i).getFurnitures().add(furnitureEntity);	
				x = i;
			}
		}
		
		if(user.getOrder().get(x).getFurnitures() == null){
			List<Furniture> furniture = new ArrayList<>();
			furniture.add(furnitureEntity);
			user.getOrder().get(x).setFurnitures(furniture);	
			user.getOrder().get(x).setGouvernorat(String gouvernorat)
		}
		*/
	}

	@Override
	public float CalculPrixOrder_tot (OrderFurnitureEntity order) {
		float somme = 0;
		int i;
		
 		for(i = 0; i < order.getFurnitures().size(); i++){
			somme =+ ((Furniture) order.getFurnitures()).getPrixFurniture();
		}
		somme = somme + CalculPrixLivriseur (somme ,order);
		return somme;	
	}
	
	@Override	
	public float CalculPrixLivriseur (float somme ,OrderFurnitureEntity order){
		float prixLivrison = 10;
		float prixLivriseurtot = (float) (somme * 0.1 + prixLivrison)  ;
		return prixLivriseurtot;
	}

	@Override
	public void FeedBackLivraison(int idDeliveryMan, int FeedBackPoint) {
		int x ;
		
		DeliveryMan deliveryMan = deliveryManRep.findById(idDeliveryMan).get();
		x = deliveryMan.getFeed_Back_point() + FeedBackPoint ;
		deliveryMan.setFeed_Back_point(x);
	}
	
}