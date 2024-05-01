package com.GroceryShop.controller;

import com.GroceryShop.entity.Order;
import com.GroceryShop.entity.Product;
import com.GroceryShop.service.CartService;
import com.GroceryShop.service.OrderService;
import io.micrometer.core.instrument.Clock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CompleteController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    private final Clock micrometerClock;

    public CompleteController(Clock micrometerClock) {
        this.micrometerClock = micrometerClock;
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam("name") String name,
                           @RequestParam("quantity") Integer quantity ,
                           @RequestParam("price") Double price ) {

        Double total = cartService.getTotal();
        Long tex = micrometerClock.monotonicTime();

        Order order = new Order();
        order.setTex(String.valueOf(tex));
        order.setTotalPrice(total);

        orderService.saveOrder(order);

        List<Product> products = cartService.getitemList();
        orderService.saveOrder(order);

        cartService.clearCart();

        return "redirect:/shopdetail";
    }
}
