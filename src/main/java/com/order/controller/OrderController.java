package com.order.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.order.exception.OrderException;
import com.order.model.Order;
import com.order.service.OrderServices;

@Controller
@RequestMapping(value="/order")
public class OrderController {

	@Autowired
	private OrderServices orderServices;
	
	@RequestMapping(value= {"/","{invalid}",""}, method=RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView createNewOrder(){
		ModelAndView mav = new ModelAndView("order-create","order",new Order());
		return mav;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView submitNewOrder(@ModelAttribute Order order){
		ModelAndView mav = new ModelAndView();
		orderServices.create(order);
		mav.setViewName("redirect:/index");
		return mav;
		
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView retrieveListOfOrder(){
		ModelAndView mav = new ModelAndView("order-list");
		List<Order> orderList = orderServices.findAllOrders();
		mav.addObject("orderList",orderList);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView retrieveEditOrder(@PathVariable Integer id){
		ModelAndView mav = new ModelAndView("order-edit");
		Order order = orderServices.findById(id);
		mav.addObject("order", order);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView submitEditOrder(@ModelAttribute Order order, @PathVariable Integer id) throws OrderException{
		ModelAndView mav = new ModelAndView();
		 orderServices.update(order,id);
		 mav.setViewName("redirect:/index");
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ModelAndView deleteOrder(@PathVariable Integer id) throws OrderException{
		ModelAndView mav = new ModelAndView();
		Order deleteOrder = orderServices.delete(id);
		mav.setViewName("redirect:/index");
		return mav;
	}
	
}
