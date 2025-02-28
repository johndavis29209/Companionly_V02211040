package com.companionly.prototype.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companionly.prototype.data.OrdersDataAccessInterface;
import com.companionly.prototype.models.OrderModel;

@Service // Register this class as a Spring-managed service
public class OrdersBusinessService implements OrdersBusinessServiceInterface {

    @Autowired
    private OrdersDataAccessInterface ordersDAO; // Dependency injection for data access

    @Override
    public void test() {
        System.out.println("OrdersBusinessService is working");
    }

    @Override
    public List<OrderModel> getOrders() {
        return ordersDAO.getOrders(); // Retrieve a list of orders
    }

    @Override
    public void init() {
        System.out.println("Init method of the OrdersBusinessService");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of the OrdersBusinessService");
    }

    @Override
    public OrderModel getByID(long id) {
        return ordersDAO.getByID(id); // Retrieve an order by its ID
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return ordersDAO.searchOrders(searchTerm); // Search for orders by a search term
    }

    @Override
    public long addOne(OrderModel newOrder) {
        return ordersDAO.addOne(newOrder); // Add a new order
    }

    @Override
    public boolean deleteOne(long id) {
        return ordersDAO.deleteOne(id); // Delete an order by ID
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        return ordersDAO.updateOne(idToUpdate, updateOrder); // Update an order by ID
    }
}
