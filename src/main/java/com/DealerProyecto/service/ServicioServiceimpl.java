package com.DealerProyecto.service;

import com.DealerProyecto.dao.ServiciosDao;
import com.DealerProyecto.domain.Servicios;
import com.DealerProyecto.domain.Vehiculo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioServiceimpl implements ServicioService {

    @Autowired
    ServiciosDao servicioDao;

    @Override
    public List<Servicios> getServicios(boolean activos) {
        var lista = (List<Servicios>) servicioDao.findAll(); //4 = 3A y 1I

        if (activos) {
            lista.removeIf(e -> !e.isActivo()); //4 = 3A
        }

        return lista;
    }

    @Override
    public Servicios getServicio(Servicios servicio) {
        return servicioDao.findById(servicio.getIdServicio()).orElse(null);
    }

    @Override
    public void save(Servicios servicio) {
        servicioDao.save(servicio);
    }

    @Override
    public void delete(Servicios servicio) {
         servicioDao.deleteById(servicio.getIdServicio());
    }

}
