package com.lee.controller;

import com.lee.config.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("say")
    public String say() {
        kafkaProducer.send("123");
        return "hello";
    }
}
