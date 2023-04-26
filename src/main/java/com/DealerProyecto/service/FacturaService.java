/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DealerProyecto.service;

import com.DealerProyecto.domain.Factura;
import java.util.List;

/**
 *
 * @author sebgu
 */
public interface FacturaService 
{
    public List<Factura> getFacturas(boolean estado); //obtener todas las Facturas

    public Factura getFactura(Factura factura); //una Factura en especifico

    public void save(Factura factura); //insertar nuevo registro o modificar (si viene el id Factura o no)

    public void delete(Factura factura); 
}
