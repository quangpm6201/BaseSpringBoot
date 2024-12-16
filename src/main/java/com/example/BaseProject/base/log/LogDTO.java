package com.example.BaseProject.base.log;

import lombok.Data;

@Data
public class LogDTO {
    private String type;
    private String url;
    private Object body;
    private String duration;
    private String date;
}
