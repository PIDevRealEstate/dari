package tn.dari.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.fasterxml.jackson.databind.ObjectMapper;
import tn.dari.entities.OrderFurnitureEntity;
import tn.dari.repositories.OrderFurnitureRepository;

@Service
public class OrderFurnitureServiceImpl implements OrderFurnitureService {
	
	@Autowired
	OrderFurnitureRepository orderFRepo;
	
	@Autowired
	ResourceLoader resourceloader;
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private float totalPrice = 0.0F;

	@Override
	public OrderFurnitureEntity addOrders(OrderFurnitureEntity order) {
		order.getFurnitures().forEach((k,v)->{
			totalPrice += (v.getPrice()*k);
		});
		order.setTotalPrice(totalPrice);
		OrderFurnitureEntity savedOrder = orderFRepo.save(order);
		this.totalPrice= 0.0F;
		try {
			confirmOrder("yosra.nasri@esprit.tn",savedOrder.getId(),savedOrder.getTotalPrice());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return savedOrder;
		
	}

	@Override
	public void deleteOrders(int id) {
		orderFRepo.deleteOrders(id);
		
	}

	/*@Override
	public OrderFurnitureEntity findById(int id) {

		return orderFRepo.findById(id);
	}*/
	
	
	
	private String getOutputContent(String templateFileName, String variablesPath, int orderId, float totalPrice)
			throws IOException {
		Context context = new Context();
		
			variablesPath += "-en.json";
	
		@SuppressWarnings("unchecked")
		Map<String, Object> variables = new ObjectMapper()
				.readValue(resourceloader.getResource("classpath:" + variablesPath).getInputStream(), HashMap.class);

		context.setVariables(variables);
		context.setVariable("orderId", orderId);
		context.setVariable("totalPrice", totalPrice);
		return templateEngine.process(templateFileName, context);
	}
	
	public void confirmOrder(String userEmail, int orderId, float totalPrice) throws IOException {
		String subject = "Order Confirmation";		
		String content = getOutputContent("confirm-order.html", "templates/confirm-order",
				orderId, totalPrice);

		send(content, subject, userEmail , "api");

	}
	
	public boolean send(String content, String subject, String email, String type) {

		MimeMessage message = mailSender.createMimeMessage();
		try {

			MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(content, true);
		
			message.setContent(content, "text/html; charset=utf-8");
			mailSender.send(message);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public List<OrderFurnitureEntity> getAllOrders() {
		return this.orderFRepo.findAll();
	}

	@Override
	public void updateOrder(int id, OrderFurnitureEntity newO) {
		OrderFurnitureEntity order= orderFRepo.findById(id).get();
		order.setDelivery(newO.getDelivery());
		order.setDeliveryStat(newO.getDeliveryStat());
		order.setFurnitures(newO.getFurnitures());
		order.setReference(newO.getReference());
		newO.getFurnitures().forEach((k,v)->{
			totalPrice += (v.getPrice()*k);
		});
		order.setTotalPrice(totalPrice);
		orderFRepo.save(order);
		this.totalPrice=0.0F;
		
	}


}
