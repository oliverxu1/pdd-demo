package com.pdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello Pdd!";
    }

}
