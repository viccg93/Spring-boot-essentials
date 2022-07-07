package com.udemy.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathVariablesController {

    @GetMapping({"/",""})
    public String index( Model model){
        model.addAttribute("titulo","Enviar parametros de la ruta");
        return "variables/index";
    }

    @GetMapping("/string/{texto}")
    public String variables(@PathVariable(name = "texto") String texto, Model model){
        model.addAttribute("titulo","Recibir parametros de la ruta");
        model.addAttribute("resultado", texto);
        return "variables/ver";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable(name = "texto") String texto, @PathVariable Integer numero, Model model){
        model.addAttribute("titulo","Recibir parametros de la ruta");
        model.addAttribute("resultado", texto + "/" + numero);
        return "variables/ver";
    }
}
