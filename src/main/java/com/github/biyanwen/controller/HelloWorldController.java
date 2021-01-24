package com.github.biyanwen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10644
 */
@RequestMapping("/web")
@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }
}
