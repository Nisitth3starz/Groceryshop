package com.GroceryShop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.GroceryShop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.GroceryShop.entity.Product;
import com.GroceryShop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductControlller {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/store")
    public String store( Model model ){
        List<Product> product = productService.productAll();
        model.addAttribute("products", product);

        Long count = cartService.countCart();
        model.addAttribute("count", count);

        return "store";
    }

    // เพื่มสินค้า
    @PostMapping("/addproduct")
    public String postMethodName(
                                @RequestParam("name") String name ,
                                @RequestParam("price") Double price ,
                                @RequestParam("quantity") int quantity ,
                                @RequestParam("stock") int stock,
                                @RequestParam("image") MultipartFile file) throws IOException {

        // เรียกใช้ Object Product
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setQuantity(quantity);
        p.setStock(stock);

        // ขั้นตอนเก็บไฟส์รูปภาพ
        String forderImage = "src/main/resources/static/images/products/";
        byte[] bytes = file.getBytes();
        long micrometer = java.time.Instant.now().toEpochMilli();
        String fileName = micrometer  + "_" + ".jpg";
        Path path = Paths.get(forderImage + fileName);
        Files.write(path, bytes);
       
        p.setImage(fileName);
        productService.save(p);

        return "redirect:/product/store";
    }
    
    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam int id,
                                @RequestParam("newImage") MultipartFile file,
                                @RequestParam("image") String image,
                                @RequestParam("name") String name ,
                                @RequestParam("price") Double price ,
                                @RequestParam("stock") int stock
    ) throws IOException {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(1);
        product.setStock(stock);

        if ( file !=null && !file.isEmpty()) {
            productService.deleteImageById(id);
            long micrometer = java.time.Instant.now().toEpochMilli();
            String folder = "src/main/resources/static/images/products/";
            byte[] bytes = file.getBytes();
            String fileName = micrometer  + "_" + ".jpg";
            Path path = Paths.get(folder + fileName);
            Files.write(path, bytes);
            product.setImage(fileName);
        } else {
            product.setImage(image);
        }
        productService.save(product);
        return "redirect:/product/store";
    }


    // ลบสินค้า
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteById(id);
        return "redirect:/product/store";
    }


}
