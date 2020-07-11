package com.xuzhaocai.stream.consumer.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(LogStream.class)
public class MultiMessageCousumerService {
    @Autowired
    private LogStream logStream;


    @StreamListener(LogStream.INPUT_LOG_NAME)
    public void receiveMes(Message<String> mes){
        String receiveMsg = mes.getPayload();

        System.out.println("接受到的msg:"+receiveMsg);

        logStream.outputLogChannel().send(MessageBuilder.withPayload(receiveMsg+" ~").build());
    }
}
