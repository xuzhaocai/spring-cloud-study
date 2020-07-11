package com.xuzhaocai.stream.producer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;


//因为我们这边是个消息生产这，所以说是个消息的源头，用Source
@EnableBinding(Source.class)
public class MessageProducerServiceImpl  implements MessageProducerService {


    @Autowired
    private Source source;


    @Override
    public void sendMes(String content) {
        // 使用spring cloud stream提供的通道写出消息
        source.output().send(MessageBuilder.withPayload(content).build());
    }
}
