package com.DealerProyecto.service;

import com.DealerProyecto.dao.VehiculoDao;
import com.DealerProyecto.domain.Vehiculo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehiculoServiceimpl implements VehiculoService {

    @Autowired
    VehiculoDao vehiculoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> getVehiculos(boolean activos) {
        var lista = (List<Vehiculo>) vehiculoDao.findAll(); //4 = 3A y 1I

        if (activos) {
            lista.removeIf(e -> !e.isActivo()); //4 = 3A
        }

        return lista;
    }
    
     @Override
    public Vehiculo getVehiculo(Vehiculo vehiculo) {
        return vehiculoDao.findById(vehiculo.getIdVehiculo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Vehiculo vehiculo) {
        vehiculoDao.save(vehiculo);
    }

    @Override
    @Transactional
    public void delete(Vehiculo vehiculo) {
        vehiculoDao.deleteById(vehiculo.getIdVehiculo());
    }

   

}
