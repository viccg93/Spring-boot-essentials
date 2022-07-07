package com.udemy.springboot.web.app.controllers;

import com.udemy.springboot.web.app.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;

@Controller //controlador de sb
@RequestMapping("/app") // define la ruta del controlador completo, es parent de los handlers
public class IndexController {
    //inyeccion de cadenas
    @Value("${texto.indexController}")
    private String textoIndex;
    @Value("${texto.indexController.perfil}")
    private String textoPerfil;
    @Value("${texto.indexController.listar}")
    private String textoListar;

    //handlers
    @RequestMapping(value = "/indexSimple", method = RequestMethod.GET)
    // @GetMapping("/index") atajo
    //Se puede pasar un Model o ModelMap
    public String indexSimple(Model model){
        model.addAttribute("titulo","Home");
        return "index";
    }

    //variacion con modelMap
    public String indexMM(ModelMap modelMap){
        modelMap.addAttribute("titulo", "titulo con modelMap");
        return "indexMM";
    }

    //variacion con modelAndView que permite enlazar atributos a vista en el mismo obj
    public ModelAndView indexMV(ModelAndView mv){
        mv.setViewName("indexMV");
        mv.addObject("titulo","home");
        return mv;
    }

    //Variacion con Map

    @RequestMapping(value = {"/index","/home","/",""}, method = RequestMethod.GET)
    // @GetMapping("/index") atajo
    //Se puede pasar un Model o ModelMap
    public String index(Map <String,Object> map){
        map.put("titulo",textoIndex);
        map.put("header",textoIndex);
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Vic");
        usuario.setApellido(("Cruz"));
        model.addAttribute("titulo",textoPerfil);
        model.addAttribute("usuario",usuario);
        return "perfil";

    }

    @GetMapping("/listar")
    public String listar(Model model){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("Vic","Cruz","vic@email.com"));
        usuarios.add(new Usuario("Tacho","Cruz"));
        model.addAttribute("titulo",textoListar);
        model.addAttribute("usuarios",usuarios);
        return "listar";

    }
}
