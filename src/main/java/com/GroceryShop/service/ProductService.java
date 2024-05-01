package com.GroceryShop.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GroceryShop.entity.Product;
import com.GroceryShop.repositoty.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void save( Product product){
        productRepo.save(product);
    }

    public List<Product> productAll(){
        return productRepo.findAll();
    }

    public Product getProductById( int id) {
        Optional<Product> product = productRepo.findById(id);
        return product.orElse(null);
    }

    // ลบภาพสินค้า
    public void deleteImageById(Integer id) {
        Optional<Product> optionalImage = productRepo.findById(id);
        try {
            if (optionalImage.isPresent()) {
                Product image = optionalImage.get();
                File file = new File("src/main/resources/static/images/products/" + image.getImage());
                if (file.exists()) {
                    file.delete();
                }
                
                productRepo.deleteById(id);
            }
        } catch ( Exception e) {
            System.out.println(e);
        }
    }

    // ลบสินค้า
    public void deleteById( int id){
        productRepo.deleteById(id);
    }

}
