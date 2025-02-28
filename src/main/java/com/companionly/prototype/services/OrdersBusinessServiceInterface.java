package com.companionly.prototype.services;

import java.util.List;

import com.companionly.prototype.models.OrderModel;

public interface OrdersBusinessServiceInterface {
	public void test();
	
	public void init();
	
	public void destroy();
	
public OrderModel getByID(long id);
	
	public List<OrderModel> getOrders();
	
	public List<OrderModel> searchOrders(String searchTerm);
	
	public long addOne(OrderModel newOrder);
	
	public boolean deleteOne(long id);
	
	public OrderModel updateOne(long idToUpdate, OrderModel update);
	
	
	
	

}
