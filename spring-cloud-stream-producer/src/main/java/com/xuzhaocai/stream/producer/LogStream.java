package com.xuzhaocai.stream.producer;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface LogStream {

    String INPUT_LOG_NAME="inputLogChannel";
    String OUTPUT_LOG_NAME="outputLogChannel";
    @Input(INPUT_LOG_NAME)
    SubscribableChannel inputLogChannel();
    @Output(OUTPUT_LOG_NAME)
    MessageChannel outputLogChannel();
}
