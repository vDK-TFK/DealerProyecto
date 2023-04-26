/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DealerProyecto.service;

import com.DealerProyecto.domain.Venta;
import java.util.List;


public interface VentaService 
{
    public List<Venta> getVentas(boolean activo); //obtener todas las Ventas

    public Venta getVenta(Venta venta); //una Venta en especifico

    public void save(Venta venta); //insertar nuevo registro o modificar (si viene el id Venta o no)

    public void delete(Venta venta); //eliminar
}
