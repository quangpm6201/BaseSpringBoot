package com.example.BaseProject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {

    protected Date createdDate;
    protected Date updatedDate;
}
