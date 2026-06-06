package com.herramientas.services;

import java.util.List;
import com.herramientas.models.Categoria;

public interface ICategoriaService {
    List<Categoria> listarTodas();
    void guardar(Categoria categoria);
    Categoria buscarPorId(Integer id);
    void eliminar(Integer id);
}
