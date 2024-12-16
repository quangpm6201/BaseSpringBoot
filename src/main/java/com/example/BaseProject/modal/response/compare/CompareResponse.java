package com.example.BaseProject.modal.response.compare;

import lombok.Data;

@Data
public class CompareResponse {
    private int status;
    private Boolean isMatch;
    private Float score;
}
