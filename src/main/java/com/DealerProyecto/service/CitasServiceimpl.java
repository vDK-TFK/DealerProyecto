/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.service;

import com.DealerProyecto.dao.CitasDao;
import com.DealerProyecto.domain.Citas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitasServiceimpl implements CitasService {

    @Autowired
    CitasDao citasDao;
    
    @Autowired

    @Override
    @Transactional(readOnly = true)
    public List<Citas> getCitas() 
    {
        return (List<Citas>) citasDao.findAll();
    }

    @Override
    public Citas getCita(Citas citas) {
        return citasDao.findById(citas.getIdCita()).orElse(null);
    }

    @Override
    public void save(Citas citas) {
        citasDao.save(citas);
    }

    @Override
    public void delete(Citas citas) {
        citasDao.delete(citas);
    }

}
