package com.udemy.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        //si se usa redirect, se actualiza la ruta
        //forward no se puede usar en sitios externos
        return "forward:/app/"; //ruta con uso de endpoint
    }
}
