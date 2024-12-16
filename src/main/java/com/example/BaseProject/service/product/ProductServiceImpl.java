//package com.example.BaseProject.service.product;
//
//import com.example.BaseProject.entity.Product;
//import com.example.BaseProject.repository.ProductRepository;
//import org.apache.logging.log4j.ThreadContext;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ProductServiceImpl implements ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Override
//    public Product demoInsertElastic(Product product) {
//        String us = ThreadContext.get("UUID");
////        product.setCreatedDate(new Date());
////        product.setUpdatedDate(new Date());
//        productRepository.save(product);
//
//        return productRepository.save(product);
//    }
//
//    @Override
//    public List<Product> getAll() {
//        List<Product> products = new ArrayList<>();
//        var as = productRepository.findAll();
//
//        as.forEach((item) -> {
//            Product product = new Product();
//            BeanUtils.copyProperties(item, product);
//            products.add(product);
//        });
//
//        return products;
//    }
//}
