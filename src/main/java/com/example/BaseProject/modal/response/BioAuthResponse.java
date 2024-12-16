package com.example.BaseProject.modal.response;

import com.example.BaseProject.modal.response.compare.CompareResponse;
import com.example.BaseProject.modal.response.liveness.LiveNessResponse;
import lombok.Data;

@Data
public class BioAuthResponse {
    private CompareResponse compareResponse;
    private LiveNessResponse liveNessResponse;
}
