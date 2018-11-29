package com.wolf.cloud.controller;

import com.wolf.cloud.config.JdbcConfigBean;
import com.wolf.cloud.pojo.Item;
import com.wolf.cloud.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private JdbcConfigBean jdbcConfigBean;

	@GetMapping(value = "/item/{id}")
	public Item queryItemById(@PathVariable("id") Long id) {
		return this.itemService.queryItemById(id);
	}


	@GetMapping(value = "test")
	public String test(){
		return this.jdbcConfigBean.toString();
	}
}
