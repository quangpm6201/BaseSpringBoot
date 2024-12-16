package com.example.BaseProject.service.customer;

import com.example.BaseProject.base.exception.BusinessException;
import com.example.BaseProject.base.responseModal.ResponseBase;
import com.example.BaseProject.designPatern.bridge.Partner;
import com.example.BaseProject.designPatern.bridge.TrustingPartner;
import com.example.BaseProject.modal.request.CustomerRequest;
import com.example.BaseProject.modal.response.BioAuthResponse;
import com.example.BaseProject.modal.response.CustomerResponse;
import com.example.BaseProject.modal.response.compare.CompareResponse;
import com.example.BaseProject.modal.response.liveness.LiveNessResponse;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {


//    @Value("${test}")
//    private String test;

    @Override
    public ResponseBase addCustomer(CustomerRequest request) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        if (request.getId() == null) {
            throw new BusinessException(1000, "Customer Id is null");
        }

        CustomerResponse response = new CustomerResponse();
        response.setId(request.getId());
        response.setUsername(request.getUsername());
        return new ResponseBase().success(response);
    }
}
