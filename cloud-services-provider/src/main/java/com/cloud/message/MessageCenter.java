package com.cloud.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zhenghuasheng
 * @date 2017/10/26.11:21
 */
public interface MessageCenter {

    String OUT= "message_out";

    String IN = "message_in";


    @Input(MessageCenter.IN)
    SubscribableChannel reciveMessage();

    @Output(value = MessageCenter.OUT)
    MessageChannel sendMessage();

    @Output
    MessageChannel coldDrinks();
}
