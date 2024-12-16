package com.example.BaseProject.controller;

import com.example.BaseProject.base.exception.BusinessException;
import com.example.BaseProject.base.responseModal.ResponseBase;
import com.example.BaseProject.modal.request.CustomerRequest;
import com.example.BaseProject.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestBody CustomerRequest request) {
        try {
            return ResponseEntity.ok().body(customerService.addCustomer(request));
        } catch (BusinessException e) {
            return ResponseEntity.ok(new ResponseBase().error(e.getStatus(), e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseBase().error(400, e.getMessage()));
        }
    }

    @PostMapping("/test-2")
    public ResponseEntity<?> test2(@RequestBody CustomerRequest request) {
        try {
            return ResponseEntity.ok().body("success roi nhe");
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseBase().error(400, e.getMessage()));
        }
    }

    @PostMapping("/test-3")
    public ResponseEntity<?> test3(@RequestBody CustomerRequest request) {
        try {
            return ResponseEntity.ok().body("Lan test 3 success roi nhe");
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseBase().error(400, e.getMessage()));
        }
    }

    @PostMapping("/test-4")
    public ResponseEntity<?> test4(@RequestBody CustomerRequest request) {
        try {
            return ResponseEntity.ok().body("Lan test 4 success roi nhe");
        } catch (Exception e) {
            return ResponseEntity.ok(new ResponseBase().error(400, e.getMessage()));
        }
    }
}
