package tn.dari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import tp3.service.IOrderService;

@RestController
@RequestMapping("/Order")
public class RestControlOrder {

	@Autowired
	IOrderService oS;
	// http://localhost:8081/SpringMVC/servlet/Order/add-Order
		@PostMapping("/add-Order")
		@ResponseBody
		public OrderFurnitureEntity AjouterOrder(@RequestBody OrderFurnitureEntity order) {
			OrderFurnitureEntity order_ = oS.AjouterOrder(order);
		return order_;
		}
		
		// http://localhost:8081/SpringMVC/servlet//Order/retrieve-all-Order
		@GetMapping("/retrieve-all-Order")
		@ResponseBody
		public List<OrderFurnitureEntity> RetrieveAllOrder(){
		List<OrderFurnitureEntity> list = oS.RetrieveAllOrder();
		return list;
		}
		
		// http://localhost:8081/SpringMVC/servlet//Order/retrieve-all-Order
		@GetMapping("/retrieve-Order")
		@ResponseBody
		public OrderFurnitureEntity RetrieveOrder(int IdOrder){
		return oS.RetrieveOrder(IdOrder);
		}
		
		// http://localhost:8081/SpringMVC/servlet//Order/remove-Order/{Order-id}
		@DeleteMapping("/DeleteOrder/{Order-Id}")
		@ResponseBody
		public void DeleteOrder(@PathVariable("Order-Id") int OrderId) {
			oS.DeleteOrder(OrderId);
		}
		
		// http://localhost:8081/SpringMVC/servlet//Order/modify-Order
		@PutMapping("/Update-Order")
		@ResponseBody
		public OrderFurnitureEntity UpdateOrder(@RequestBody int IdOrder) {
		return oS.UpdateOrder(IdOrder);
		}
		
		///////////// le rest
		
}
