package com.companionly.prototype.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.companionly.prototype.models.OrderModel;

@Repository
public class OrdersFakeDAO implements OrdersDataAccessInterface{
	
	List<OrderModel> orders = new ArrayList<OrderModel>();


	public OrdersFakeDAO() {
		
		orders.add(new OrderModel(0L, "AAA", "Spicy Noodles", 35f, 1));
		orders.add(new OrderModel(1L, "AAB", "Hot N Spicy", 335f, 2));
		orders.add(new OrderModel(2L, "AAC", "Jack in the box tacos", 325f, 1));
		orders.add(new OrderModel(3L, "AAD", "Buttered Tortillas", 355f, 3));
		orders.add(new OrderModel(4L, "AAE", "Nachos Bell Grande", 37f, 4));
		
		}

	@Override
	public OrderModel getByID(long id) {
		for(int i = 0; i<orders.size(); i++) {
			if(orders.get(i).getId() == id) {
				return orders.get(i);
			}
		}
		return null;
		
	}

	@Override
	public List<OrderModel> getOrders() {
	
		return orders;
	}

	@Override
	public List<OrderModel> searchOrders(String searchTerm) {
		
//		List<OrderModel> foundItems = new ArrayList<OrderModel>();
//	
//		for(int i = 0; i < orders.size(); i++) {
//		if(orders.get(i).getProductName().toLowerCase().contains(searchTerm.toLowerCase())) {
//			foundItems.add(orders.get(i));
//			}
//		}
//		return foundItems;
		
		List<OrderModel> foundItems = orders
				.stream()
				.filter(order -> order.getProductName().toLowerCase()
						.contains(searchTerm.toLowerCase()))
				.collect(Collectors.toList());
		
		return foundItems;
	}

	@Override
	public long addOne(OrderModel newOrder) {
		boolean success = orders.add(newOrder);
		
		if (success) {
			return 1;
		} else return 0;

	}

	@Override
	public boolean deleteOne(long id) {
		for(int i = 0; i<orders.size(); i++) {
			if(orders.get(i).getId() == id) {
					orders.remove(i);
			return true;
			}
		} return false;
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		for(int i = 0; i<orders.size(); i++) {
			if(orders.get(i).getId() == idToUpdate) {
					orders.set(i, updateOrder);
					return orders.get(i);
				}
		}
		return null;
	}
}
