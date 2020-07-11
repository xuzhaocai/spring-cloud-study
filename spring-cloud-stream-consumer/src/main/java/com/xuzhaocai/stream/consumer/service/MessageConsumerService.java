package com.xuzhaocai.stream.consumer.service;



import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

//这里是消息消费者，所以就就是接收者，所以使用Sink
@EnableBinding(Sink.class)
public class MessageConsumerService {


    @StreamListener(Sink.INPUT)
    public void recevieMes(Message<String> message){
        System.out.println("-----我接受到的消息是："+message.getPayload());
    }


}
