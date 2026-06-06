package com.herramientas.services;

import java.util.List;
import com.herramientas.models.Herramienta;

public interface IHerramientaService {
    List<Herramienta> listarTodas();
    void guardar(Herramienta herramienta);
    Herramienta buscarPorId(Integer id);
    void eliminar(Integer id);
}
