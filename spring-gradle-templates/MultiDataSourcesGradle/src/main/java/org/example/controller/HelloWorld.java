package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello() {
        log.info("Print hello ....");
        return "Hello World, Lucas ...";
    }
}
