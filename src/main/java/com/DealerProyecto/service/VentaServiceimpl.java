/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.service;

import com.DealerProyecto.dao.VentaDao;
import com.DealerProyecto.domain.Venta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentaServiceimpl implements VentaService {
    
    @Autowired
    VentaDao ventaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Venta> getVentas(boolean activo) {
        var lista = (List<Venta>) ventaDao.findAll(); //4 = 3A y 1I

        if (activo) {
            lista.removeIf(e -> !e.isActivo()); //4 = 3A
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Venta getVenta(Venta venta) {
        return ventaDao.findById(venta.getIdVenta()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Venta venta) {
        ventaDao.save(venta);
    }

    @Override
    @Transactional
    public void delete(Venta venta) {
        ventaDao.deleteById(venta.getIdVenta());
    }

}
