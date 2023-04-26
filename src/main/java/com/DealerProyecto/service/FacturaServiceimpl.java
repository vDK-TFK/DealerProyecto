/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.service;

import com.DealerProyecto.dao.FacturaDao;
import com.DealerProyecto.domain.Factura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaServiceimpl implements FacturaService {

    @Autowired
    FacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> getFacturas(boolean estado) {
        var lista = (List<Factura>) facturaDao.findAll();

        if (estado) {
            lista.removeIf(e -> !e.isEstado());
        }
        return lista;
    }

    @Override
    public Factura getFactura(Factura factura) {
        return facturaDao.findById(factura.getIdFactura()).orElse(null);
    }

    @Override
    public void save(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    public void delete(Factura factura) {
        facturaDao.delete(factura);
    }

}
