package com.companionly.prototype.data;

import java.util.List;

import com.companionly.prototype.models.OrderModel;

public interface OrdersDataAccessInterface {
	
	public OrderModel getByID(long id);
	
	public List<OrderModel> getOrders();
	
	public List<OrderModel> searchOrders(String searchTerm);
	
	public long addOne(OrderModel newOrder);
	
	public boolean deleteOne(long id);
	
	public OrderModel updateOne(long idToUpdate, OrderModel update);

}
