package com.example.BTH4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.BTH4.entities.Orders;
import com.example.BTH4.entities.OtherItems;
import com.example.BTH4.request.OrdersRequest;
import com.example.BTH4.response.OtherItemsResponse;
import com.example.BTH4.response.ProductsResponse;
import com.example.BTH4.service.OrdersService;
import com.example.BTH4.service.RequestOtherPortService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private RequestOtherPortService requestOtherPortService;

	@GetMapping()
	private List<Orders> getAllOrders(@RequestHeader("Authorization") String token) {
		requestOtherPortService.checkAuthentication(token);
		return ordersService.getAllOrders();
	}

	@GetMapping("/{id}")
	private Optional<Orders> getInforOfOrders(@PathVariable int id,
			@RequestHeader("Authorization") String token) {
		requestOtherPortService.checkAuthentication(token);
		return ordersService.getOrderById(id);
	}

	@PostMapping()
	private Boolean addNewOrder(@RequestBody OrdersRequest ordersRequest, @RequestHeader("Authorization") String token) {
		requestOtherPortService.checkAuthentication(token);
		return ordersService.addNewOrder(ordersRequest);
	}

	@PutMapping("/{id}")
	private Boolean updateStatusOrder(@PathVariable int id, @RequestBody OrdersRequest ordersRequest, @RequestHeader("Authorization") String token) {
		requestOtherPortService.checkAuthentication(token);
		return ordersService.updateStatusOrder(id, ordersRequest);
	}

	@DeleteMapping("/{id}")
	private Boolean deleteOrder(@PathVariable int id, @RequestHeader("Authorization") String token) {
		requestOtherPortService.checkAuthentication(token);
		return ordersService.deleteOrder(id);
	}

}
