package com.herramientas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.herramientas.models.Herramienta;
import com.herramientas.services.ICategoriaService;
import com.herramientas.services.IHerramientaService;

@Controller
public class HomeController {
    
    @Autowired
    private IHerramientaService herramientaService;
    
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("herramientas", herramientaService.listarTodas());
        return "home";
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        model.addAttribute("herramientas", herramientaService.listarTodas());
        return "tabla";
    }

    @GetMapping("/nueva")
    public String nuevaHerramienta(Model model) {
        model.addAttribute("herramienta", new Herramienta());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarHerramienta(@ModelAttribute Herramienta herramienta) {
        herramientaService.guardar(herramienta);
        return "redirect:/tabla";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarHerramienta(@PathVariable Integer id) {
        herramientaService.eliminar(id);
        return "redirect:/tabla";
    }
    
    @GetMapping("/editar/{id}")
    public String editarHerramienta(@PathVariable Integer id, Model model) {
        Herramienta herramienta = herramientaService.buscarPorId(id);
        if (herramienta != null) {
            model.addAttribute("herramienta", herramienta);
            model.addAttribute("categorias", categoriaService.listarTodas());
            return "formulario"; 
        }
        return "redirect:/tabla";
    }    
}
