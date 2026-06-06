package com.herramientas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herramientas.models.Herramienta;
import com.herramientas.repository.IHerramientaRepository;

@Service
public class HerramientaServiceImpl implements IHerramientaService {

    @Autowired
    private IHerramientaRepository herramientaRepo;

    @Override
    public List<Herramienta> listarTodas() {
        return (List<Herramienta>) herramientaRepo.findAll();
    }

    @Override
    public void guardar(Herramienta herramienta) {
        herramientaRepo.save(herramienta);
    }

    @Override
    public Herramienta buscarPorId(Integer id) {
        return herramientaRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        herramientaRepo.deleteById(id);
    }
}
