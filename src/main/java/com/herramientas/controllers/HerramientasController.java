package com.herramientas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.herramientas.models.Herramienta;
import com.herramientas.repository.ICategoriaRepository;
import com.herramientas.repository.IHerramientaRepository;

@Controller
public class HerramientasController {
	
	@Autowired
    private IHerramientaRepository herramientaRepo;
    
    @Autowired
    private ICategoriaRepository categoriaRepo;

    // Vista Home: Muestra todas las herramientas
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("herramientas", herramientaRepo.findAll());
        return "home";
    }

    // Vista Tabla: Muestra todas las herramientas en formato tabla 
    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        model.addAttribute("herramientas", herramientaRepo.findAll());
        return "tabla";
    }

    // Rutas para el CRUD 
    @GetMapping("/nueva")
    public String nuevaHerramienta(Model model) {
        model.addAttribute("herramienta", new Herramienta());
        model.addAttribute("categorias", categoriaRepo.findAll());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarHerramienta(@ModelAttribute Herramienta herramienta) {
        herramientaRepo.save(herramienta);
        return "redirect:/tabla";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarHerramienta(@PathVariable Integer id) {
        herramientaRepo.deleteById(id);
        return "redirect:/tabla";
    }
	
	
	

}
