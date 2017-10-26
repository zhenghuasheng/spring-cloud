package com.cloud.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author zhenghuasheng
 * @date 2017/10/25.17:16
 */

@Component
public class SourceSender {
    private static final Logger logger = LoggerFactory.getLogger(SourceSender.class);
    private MessageCenter source;

    @Autowired
    public SourceSender(MessageCenter source) {
        this.source = source;
    }


    public boolean sendMessage(String message) {
        boolean result =  source.sendMessage().send(MessageBuilder.withPayload(message).build());
        logger.info("send message:{},result:{}",message,result);
        return result;
    }
}
