package com.order.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.order.model.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {

/*	@Query("SELECT DISTINCT o FROM Order o WHERE s.order_id = (:order_id)")
    public Order retrieveByOrderId(@Param("order_id") String orderId);
	
	@Query("DELETE FROM Order o WHERE s.order_id = (:order_id)")
	public void deleteByOrderId(@Param("order_id") String orderId); */
}
