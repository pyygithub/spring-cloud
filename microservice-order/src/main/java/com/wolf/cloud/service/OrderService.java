package com.wolf.cloud.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wolf.cloud.pojo.Item;
import com.wolf.cloud.pojo.Order;
import com.wolf.cloud.pojo.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

	private static final Map<String, Order> MAP = new HashMap<String, Order>();

	static {
		// 构造测试数据
		Order order = new Order();
		order.setOrderId("59193738268961441");
		order.setCreateDate(new Date());
		order.setUpdateDate(order.getCreateDate());
		order.setUserId(1L);
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

		Item item = new Item();// 此处并没有商品的数据，需要调用商品微服务获取
		item.setId(1L);
		orderDetails.add(new OrderDetail(order.getOrderId(), item));

		item = new Item(); // 构造第二个商品数据
		item.setId(2L);
		orderDetails.add(new OrderDetail(order.getOrderId(), item));

		order.setOrderDetails(orderDetails);

		MAP.put(order.getOrderId(), order);
	}
	
	@Autowired
	private ItemService itemService;
	
	public Order queryOrderById(String orderId) {
		Order order = MAP.get(orderId);
		if(null == order){
			return null;
		}
		
		List<OrderDetail> orderDetails = order.getOrderDetails();
		for (OrderDetail orderDetail : orderDetails) {
			// 通过商品微服务查询商品数据
			Item item = this.itemService.queryItemById(orderDetail.getItem()
					.getId());
			if (null == item) {
				continue;
			}
			orderDetail.setItem(item);
		}

		return order;
	}

}
