/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.service;

import com.DealerProyecto.dao.ServicioDao;
import com.DealerProyecto.domain.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    ServicioDao servicioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> getServicios(boolean activo) {
        var lista = (List<Servicio>) servicioDao.findAll();

        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    public Servicio getServicio(Servicio servicio) {
        return servicioDao.findById(servicio.getIdServicio()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Servicio servicio) {
        servicioDao.save(servicio);
    }

    @Override
    @Transactional
    public void delete(Servicio servicio) {
        servicioDao.delete(servicio);
    }

}
