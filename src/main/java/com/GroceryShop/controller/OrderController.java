package com.GroceryShop.controller;

import com.GroceryShop.entity.Order;
import com.GroceryShop.service.CartService;
import com.GroceryShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @GetMapping("/shopdetail")
    public String shopdetail( Model model) {

        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        Long count = cartService.countCart();
        model.addAttribute("count", count);
        return "shopdetail";
    }

    @GetMapping("/shopdetail/{id}")
    public String findOrderById(@PathVariable Integer id, Model model) {

        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "shopcomplete";
    }


}
