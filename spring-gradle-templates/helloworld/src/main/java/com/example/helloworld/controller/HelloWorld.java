package com.example.helloworld.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorld {

    private String url;

    private String welcomeStr;

    @Autowired
    public HelloWorld(@Value("${rdm.url}") String url, @Value("${welcome.value}") String welcomeStr) {
        this.url = url;
        this.welcomeStr = welcomeStr;
    }
    @RequestMapping("/hello")
    public String hello() {
        log.info("System env, url:{}", url);
        log.info("System evn, welcome: {}", welcomeStr);
        return "Hello World, Lucas ...";
    }



}
