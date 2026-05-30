package com.herramientas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.herramientas.models.Categoria;
import com.herramientas.repository.ICategoriaRepository;

@Controller
public class CategoriaController {

    @Autowired
    private ICategoriaRepository categoriaRepo;

    // Mostrar el formulario Y la lista de categorías al mismo tiempo
    @GetMapping("/categoria/nueva")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", categoriaRepo.findAll()); // Envía la lista a la tabla
        return "nueva-categoria";
    }

    // Guardar o Actualizar categoría
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaRepo.save(categoria);
        // Redirecciona a la misma pantalla para ver los cambios reflejados inmediatamente
        return "redirect:/categoria/nueva"; 
    }
    
    // Cargar una categoría existente en el formulario para Editar
    @GetMapping("/categoria/editar/{id}")
    public String editarCategoria(@PathVariable Integer id, Model model) {
        java.util.Optional<Categoria> cat = categoriaRepo.findById(id);
        if (cat.isPresent()) {
            model.addAttribute("categoria", cat.get()); // Carga la categoría elegida en el formulario
            model.addAttribute("categorias", categoriaRepo.findAll()); // Mantiene la tabla cargada
            return "nueva-categoria";
        }
        return "redirect:/categoria/nueva";
    }
    
    // Eliminar una categoría
    @GetMapping("/categoria/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Integer id) {
        try {
            categoriaRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
        return "redirect:/categoria/nueva";
    }
}