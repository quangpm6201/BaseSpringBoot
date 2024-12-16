//package com.example.BaseProject.controller;
//
//import com.example.BaseProject.base.responseModal.ResponseBase;
//import com.example.BaseProject.entity.Product;
//import com.example.BaseProject.service.product.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/product")
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @PostMapping("/add")
//    public ResponseEntity<?> add(@RequestBody Product product) {
//        try {
//            return ResponseEntity.ok(productService.demoInsertElastic(product));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @GetMapping("/get-all")
//    public ResponseEntity<?> getAll() {
//        try {
//            return ResponseEntity.ok(new ResponseBase().success(productService.getAll()));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
