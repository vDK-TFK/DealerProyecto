package com.DealerProyecto.service;

import com.DealerProyecto.dao.MarcaDao;
import com.DealerProyecto.domain.Marca;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarcaServiceimpl implements MarcaService {

    @Autowired
    MarcaDao marcaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Marca> getMarcas(boolean activos) {
        var lista = (List<Marca>) marcaDao.findAll(); //4 = 3A y 1I

        if (activos) {
            lista.removeIf(e -> !e.isActivo()); //4 = 3A
        }

        return lista;
    }

    @Override
    public Marca getMarca(Marca marca) {
        return marcaDao.findById(marca.getIdMarca()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Marca categoria) {
        marcaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Marca categoria) {
        marcaDao.deleteById(categoria.getIdMarca());
    }

}
