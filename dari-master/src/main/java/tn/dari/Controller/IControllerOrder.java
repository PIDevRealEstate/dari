package tn.dari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
 
import tn.dari.entities.OrderFurnitureEntity;
import tp3.service.IOrderService;
 
@Controller
public class IControllerOrder {

	@Autowired
	IOrderService oS;
	
	public int AjouterOrder(OrderFurnitureEntity Order)
	{
		oS.AjouterOrder(Order);
		return Order.getIdOrder();
	}
	
	public void DeleteOrder(int OrderId) {
		oS.DeleteOrder(OrderId);
		
	}
	
	
	public List<OrderFurnitureEntity> RetrieveAllOrder() {
		
		return oS.RetrieveAllOrder();
	}

	public  OrderFurnitureEntity RetrieveOrder(int IdOrder){
		return oS.RetrieveOrder(IdOrder);
	}

	

	public OrderFurnitureEntity UpdateOrder(int IdOrder) {	
		return oS.UpdateOrder(IdOrder);
		
	}
	// crud seul completer les autre

}
