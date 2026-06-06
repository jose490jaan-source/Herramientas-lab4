package com.herramientas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herramientas.models.Categoria;
import com.herramientas.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepo;

    @Override
    public List<Categoria> listarTodas() {
        return (List<Categoria>) categoriaRepo.findAll();
    }

    @Override
    public void guardar(Categoria categoria) {
        categoriaRepo.save(categoria);
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return categoriaRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        categoriaRepo.deleteById(id);
    }
}
