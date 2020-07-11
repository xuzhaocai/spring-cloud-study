package com.xuzhaocai.stream.producer.service;


import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MessageProducerServiceTest {




    @Autowired
    private  MessageProducerService messageProducerService;


    @Test
    public void testSendMes(){
        messageProducerService.sendMes("hello spring cloud stream ");
    }
}
