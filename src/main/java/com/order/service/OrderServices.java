package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.exception.OrderException;
import com.order.model.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	private OrderRepository orderReposiotry;
		
	public Order create (Order order){
		Order newOrder = order;
		return orderReposiotry.saveAndFlush(newOrder);
	}
	
	public Order findById(Integer id){
		return orderReposiotry.findOne(id);
	}
	
	public Order update(Order order,Integer id) throws OrderException{
		Order updateOrder= orderReposiotry.findOne(id);
		if(updateOrder == null)
			throw new OrderException();
		
		updateOrder.setOrderName(order.getOrderName());
		updateOrder.setOrderDescription(order.getOrderDescription());
		updateOrder.setOrderPrice(order.getOrderPrice());
		orderReposiotry.saveAndFlush(updateOrder);
		return updateOrder;
		
	}
	public Order delete(Integer id) throws OrderException{
		Order deleteOrder = orderReposiotry.findOne(id);
		if(deleteOrder == null)
			throw new OrderException();
		orderReposiotry.delete(deleteOrder);
		return deleteOrder;
	}
	
	public List<Order> findAllOrders(){
		return orderReposiotry.findAll();
	}
	
	
}
