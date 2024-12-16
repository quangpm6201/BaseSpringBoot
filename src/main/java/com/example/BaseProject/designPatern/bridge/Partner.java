package com.example.BaseProject.designPatern.bridge;

import com.example.BaseProject.modal.request.compare.CompareFaceRequest;
import com.example.BaseProject.modal.request.liveness.LiveNessRequest;
import com.example.BaseProject.modal.response.compare.CompareResponse;
import com.example.BaseProject.modal.response.liveness.LiveNessResponse;

public interface Partner {

    CompareResponse compareFace(CompareFaceRequest request);

    LiveNessResponse checkLiveNess(LiveNessRequest request) throws Exception;



}
