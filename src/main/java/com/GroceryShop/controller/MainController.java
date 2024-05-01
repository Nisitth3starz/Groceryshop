package com.GroceryShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.GroceryShop.entity.Product;
import com.GroceryShop.service.CartService;
import com.GroceryShop.service.ProductService;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String index( Model model) {

        List<Product> products = productService.productAll();
        model.addAttribute("product", products);

        Long count = cartService.countCart();
        model.addAttribute("count", count);

        return "index";
    }

}
