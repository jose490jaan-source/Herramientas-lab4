package com.herramientas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.herramientas.models.Categoria;
import com.herramientas.services.ICategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categoria/nueva")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "nueva-categoria";
    }

    @PostMapping("/categoria/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categoria/nueva"; 
    }
    
    @GetMapping("/categoria/editar/{id}")
    public String editarCategoria(@PathVariable Integer id, Model model) {
        Categoria cat = categoriaService.buscarPorId(id);
        if (cat != null) {
            model.addAttribute("categoria", cat);
            model.addAttribute("categorias", categoriaService.listarTodas());
            return "nueva-categoria";
        }
        return "redirect:/categoria/nueva";
    }
    
    @GetMapping("/categoria/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Integer id) {
        try {
            categoriaService.eliminar(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
        return "redirect:/categoria/nueva";
    }
}