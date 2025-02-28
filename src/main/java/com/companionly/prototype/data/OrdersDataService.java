package com.companionly.prototype.data;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.companionly.prototype.models.OrderModel;
import com.companionly.prototype.models.OrdersMapper;

@Repository
public class OrdersDataService implements OrdersDataAccessInterface {

    private final JdbcTemplate jdbcTemplate;

    // Constructor Injection
    public OrdersDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public OrderModel getByID(long id) {
        return null; 
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> results = jdbcTemplate.query("SELECT * FROM ORDERS", new OrdersMapper());
        return results;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return null; 
    }

    @Override
    public long addOne(OrderModel newOrder) {
        return 0; 
    }

    @Override
    public boolean deleteOne(long id) {
        return false; 
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel update) {
        return null; 
    }
}
