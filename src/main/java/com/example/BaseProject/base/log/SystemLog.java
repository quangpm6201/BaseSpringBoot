package com.example.BaseProject.base.log;

import com.example.BaseProject.utils.DateUtil;
import com.google.gson.Gson;
import lombok.Data;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SystemLog {

    private final Logger logger = LoggerFactory.getLogger(SystemLog.class);

    private final Gson gson = new Gson();

    public void log(String type, String url, Object body) {
        LogDTO logDTO = new LogDTO();

        logDTO.setUrl(url);
        logDTO.setType(type);
        logDTO.setBody(body);
        logDTO.setDate(DateUtil.getCurrentTime());

        if (type.equalsIgnoreCase("response")) {
            long duration = System.currentTimeMillis() - Long.parseLong(ThreadContext.get("START_TIME"));
            logDTO.setDuration(String.valueOf(duration));
        }


        logger.info(gson.toJson(logDTO));
    }

}
