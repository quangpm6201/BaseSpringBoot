package com.example.BaseProject.service.customer;


import com.example.BaseProject.base.responseModal.ResponseBase;
import com.example.BaseProject.modal.request.CustomerRequest;

public interface CustomerService {
    ResponseBase addCustomer(CustomerRequest request) throws Exception;
}
