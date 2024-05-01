package com.GroceryShop.service;

import com.GroceryShop.entity.Order;
import com.GroceryShop.repositoty.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(int orderId) {
        return orderRepo.findById(orderId).get();
    }

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

    public void deleteOrder(int orderId) {
        orderRepo.deleteById(orderId);
    }

    public void deleteAllOrders() {
        orderRepo.deleteAll();
    }

    public void deleteAllOrdersByCustomerId(int customerId) {

    }

    public void saveAll(List<Order> orders) {
        for (Order order : orders) {
            saveOrder(order);
        }
    }


}
