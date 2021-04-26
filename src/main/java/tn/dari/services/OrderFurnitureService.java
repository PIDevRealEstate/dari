package tn.dari.services;

import java.util.List;

import tn.dari.entities.OrderFurnitureEntity;


public interface OrderFurnitureService {
	public OrderFurnitureEntity addOrders(OrderFurnitureEntity order);
	public void deleteOrders(int id);
	public  OrderFurnitureEntity findById(int id);
	public List <OrderFurnitureEntity> getAllOrders();
	public void updateOrder(int id, OrderFurnitureEntity newO);

}
