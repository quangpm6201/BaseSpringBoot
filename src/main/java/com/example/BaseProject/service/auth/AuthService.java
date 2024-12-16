package com.example.BaseProject.service.auth;

import com.example.BaseProject.base.responseModal.ResponseBase;
import com.example.BaseProject.modal.request.User.UserLoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseBase login(UserLoginRequest request) throws Exception;
}
