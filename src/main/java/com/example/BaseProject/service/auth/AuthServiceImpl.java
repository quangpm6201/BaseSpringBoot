package com.example.BaseProject.service.auth;

import com.example.BaseProject.base.exception.BusinessException;
import com.example.BaseProject.base.responseModal.ResponseBase;
import com.example.BaseProject.modal.request.User.UserLoginRequest;
import com.example.BaseProject.utils.JwtUtils;
import com.example.BaseProject.utils.StringUtils;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.text.Document;
import java.security.cert.X509Certificate;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseBase login(UserLoginRequest request) throws Exception {

//        if (StringUtils.isNotNullOrEmpty(request.getUsername()) || StringUtils.isNotNullOrEmpty(request.getPassword())) {
//            throw new BusinessException(100, "Login info is not enough");
//        }

        TrustManager[] trustAllCertificates = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCertificates, new java.security.SecureRandom());
        SSLContext.setDefault(sc);

        String url = "https://mntuoihoa.badinh.edu.vn/chi-tiet/cac-em-be-lop-c3-tham-quan-trai-nghiem-tai-xu-so-v-pmtd22sw4487?fbclid=IwY2xjawHCJo1leHRuA2FlbQIxMAABHToj-falB53QazdLVq2Me9W1qPYphHbgu3iIJQhtEsrg1PnHLJt4BTbtjQ_aem_qyA9sHI7nNUorD4D1WKNoghttps://mntuoihoa.badinh.edu.vn/chi-tiet/cac-em-be-lop-c3-tham-quan-trai-nghiem-tai-xu-so-v-pmtd22sw4487?fbclid=IwY2xjawHCJo1leHRuA2FlbQIxMAABHToj-falB53QazdLVq2Me9W1qPYphHbgu3iIJQhtEsrg1PnHLJt4BTbtjQ_aem_qyA9sHI7nNUorD4D1WKNog";


        // Kết nối đến trang web mà không kiểm tra chứng chỉ SSL
        for (int i =0; i < 2000; i++) {
//            Thread.sleep(100);
//            var doc = Jsoup.connect(url).get();
            Jsoup.connect(url).get();
        }
//        System.out.println(doc.html());


        // Check CSDL

        // Check password



        return new ResponseBase().success(jwtUtils.generateToken(request));
    }
}
