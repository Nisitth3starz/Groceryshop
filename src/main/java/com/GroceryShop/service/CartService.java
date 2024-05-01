package com.GroceryShop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.GroceryShop.entity.Product;

@Service
public class CartService {
    
    // ใช้เก็บสินค้า
    List<Product> itemList = new ArrayList<>();

    // เพื่มสินค้าเข้าไปใน ArrayList
    public void add(Product item){
        itemList.add(item);
    }

    // แสดงสินค้าใน ArrayList
    public List<Product> getitemList(){
        return itemList;
    }

    //ลบสินค้าบางชิ้น
    public void delete(Product item){
        itemList.remove(item);
    }

    // ลบทุกอย่างที่อยู่ใน ArrayList
    public void clearCart(){
        itemList.clear();
    }

    //นับจำนวนสินค้าในตะกร้า
    public Long countCart () {
        return itemList.stream().count();
    }

    public  Double getTotal(){
        Double total = 0.0;
        for (Product item : itemList) {
            total += item.getPrice();
        }
        return total;
    }

}
