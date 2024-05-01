package com.GroceryShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.GroceryShop.entity.Product;
import com.GroceryShop.service.CartService;
import com.GroceryShop.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    ProductService productService;

    @GetMapping("/addItem/{id}")
    public String addItem(@PathVariable int id){
        boolean found = false;
        for (Product p : cartService.getitemList()) {
            if (p.getId() == id ) {
                p.setQuantity(p.getQuantity() + 1);
                p.setPrice(p.getPrice() * p.getQuantity());
                found = true;
                break;
            }
        }
        if (!found) {
            cartService.add(productService.getProductById(id));
        }
        return "redirect:/";
    }

    // ส่งสินค้าทีอยู่ในตะกร้าไปแสดง
    @GetMapping("/cart")
    public String cart(Model model){

        List<Product> productList = cartService.getitemList();
        model.addAttribute("productList", productList);

        Double total = cartService.getTotal();
        model.addAttribute("total", total);


        Long count = cartService.countCart();
        model.addAttribute("count", count);

        return "cart";
    }

    @GetMapping("/deletep/{id}")
    public String deleteItem(@PathVariable int id){
        System.out.println(id);
        boolean found = false;
        for (Product p : cartService.getitemList()) {
            if (p.getId() == id) {

                if ( p.getQuantity() > 0 ) {
                    p.setQuantity(p.getQuantity() - 1);
                    p.setPrice( p.getPrice() * (p.getQuantity() - 1 ) ) ;
                    found = true;
                    break;
                }

                if ( p.getQuantity() == 0 ) {
                    cartService.delete(p);
                    found = true;
                    break;
                }

            }
        }
        if (!found) {
            cartService.add(productService.getProductById(id));
        }

        return "redirect:/cart";
    }

    @GetMapping("/clearCart")
    public String cearcart(){
        cartService.clearCart();
        return "redirect:/";
    }
}

