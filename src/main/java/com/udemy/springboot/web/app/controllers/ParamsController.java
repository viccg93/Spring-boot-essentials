package com.udemy.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsController {
    @GetMapping("/string")
    //mediante el requestparam se reciben parametros y se indica como vendra la peticion
    public String param(@RequestParam(name = "t1", defaultValue = "") String texto, Model model){
        model.addAttribute("texto", "enviaste la cadena " + texto);
        model.addAttribute("titulo","recepcion de params");
        return "params/ver";
    }

    //multiples rp
    @GetMapping("/mixed-params")
    public String mixedParams(@RequestParam(name = "t1", defaultValue = "") String texto, @RequestParam Integer numero, Model model){
        model.addAttribute("texto", "enviaste la cadena " + texto);
        model.addAttribute("numero", numero);
        model.addAttribute("titulo","recepcion de params");
        return "params/ver";
    }

    //servlet
    @GetMapping("/servlet-params")
    public String mixedParams(HttpServletRequest servlet, Model model){
        String texto = servlet.getParameter("t1");
        Integer numero = null;
        try{
            numero = Integer.parseInt(servlet.getParameter("numero"));
        }catch(NumberFormatException nfe){
            System.out.println("error al convertir numero, default 0");
            numero = 0;
        }
        model.addAttribute("texto", "enviaste la cadena " + texto);
        model.addAttribute("numero", numero);
        model.addAttribute("titulo","recepcion de params");
        return "params/ver";
    }


    @GetMapping({"/",""})
    public String index( Model model){
        model.addAttribute("titulo","envio de parametros");
        return "params/index";
    }
}
