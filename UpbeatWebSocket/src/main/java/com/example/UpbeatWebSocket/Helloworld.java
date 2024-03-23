package com.example.UpbeatWebSocket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
