package com.example.BaseProject.designPatern.bridge;

import com.example.BaseProject.modal.request.compare.CompareFaceRequest;
import com.example.BaseProject.modal.request.liveness.LiveNessRequest;
import com.example.BaseProject.modal.response.compare.CompareResponse;
import com.example.BaseProject.modal.response.liveness.LiveNessResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TrustingPartner implements Partner {

    @Override
    public CompareResponse compareFace(CompareFaceRequest request) {
        // Xu li compare face request

        // Xu li compare face response
        CompareResponse response = new CompareResponse();
        response.setStatus(200);
        response.setIsMatch(true);
        return response;
    }

    @Override
    public LiveNessResponse checkLiveNess(LiveNessRequest request) throws Exception {
        Thread.sleep(1000);
        LiveNessResponse response = new LiveNessResponse();
        response.setStatus(200);
        response.setIsLive(true);
        return response;
    }
}
