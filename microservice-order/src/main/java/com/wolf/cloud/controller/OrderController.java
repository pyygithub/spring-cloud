package com.wolf.cloud.controller;

import com.wolf.cloud.pojo.Order;
import com.wolf.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/order/{orderId}")
	public Order queryOrderById(@PathVariable("orderId") String orderId) {
		return this.orderService.queryOrderById(orderId);
	}

}
