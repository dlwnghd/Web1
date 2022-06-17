package com.example.ex02.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class CustomError implements ErrorController {   // ErrorController가 있어야지만 에러를 잡아줄 수 있음
    @GetMapping("/error")
    public String error(){
        return "error/error";
    }
}
