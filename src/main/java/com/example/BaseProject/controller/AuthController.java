package com.example.BaseProject.controller;

import com.example.BaseProject.base.exception.BusinessException;
import com.example.BaseProject.base.responseModal.ResponseBase;
import com.example.BaseProject.modal.request.User.UserLoginRequest;
import com.example.BaseProject.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest request) {
        try {
            return ResponseEntity.ok().body(authService.login(request));
        } catch (BusinessException e) {
            return ResponseEntity.ok(new ResponseBase().error(e.getStatus(), e.getMessage()));
        }
        catch (Exception e) {
            return ResponseEntity.ok("System error. Message: " + e.getMessage());
        }
    }

}
