package tp3.service;

import java.util.List;

import tn.dari.entities.OrderFurnitureEntity;
  
public interface IOrderService {
	
	public void DeleteOrder  (int IdOrder);
	public OrderFurnitureEntity RetrieveOrder (int IdOrder);
	public OrderFurnitureEntity UpdateOrder  (int IdOrder);
	public OrderFurnitureEntity AjouterOrder(OrderFurnitureEntity Order);
	List<OrderFurnitureEntity> RetrieveAllOrder();
	
	// Restcontroller
	public void SupprimerFurniturefromOrder (int IdFurniture, int idOrder) ;
	public void Ajouter_Furniture_to_Order(int IdFurniture, int idOrder) ;

	
	public float CalculPrixOrder_tot (OrderFurnitureEntity Order) ;
	public float CalculPrixLivriseur (float somme ,OrderFurnitureEntity order) ;

	public void FeedBackLivraison(int idDeliveryMan, int FeedBackPoint);

}
