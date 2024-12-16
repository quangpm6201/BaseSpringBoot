package com.example.BaseProject.base.responseModal;

import lombok.Data;
import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

@Data
public class ResponseBase {
    private String uuid;
    private int status;
    private String message;
    private Object data;


    public ResponseBase success(Object data) {
        ResponseBase responseBase = new ResponseBase();
        responseBase.setUuid(ThreadContext.get("UUID"));
        responseBase.setStatus(200);
        responseBase.setMessage("success");
        responseBase.setData(data);
        return responseBase;
    }

    public ResponseBase error(int status, String message) {
        ResponseBase responseBase = new ResponseBase();
        responseBase.setStatus(status);
        responseBase.setMessage(message);
        return responseBase;
    }
}
