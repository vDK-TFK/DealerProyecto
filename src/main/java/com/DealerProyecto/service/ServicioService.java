/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DealerProyecto.service;

import java.util.List;
import com.DealerProyecto.domain.Servicio;

public interface ServicioService 
{
    public List<Servicio> getServicios(boolean activo);
    
    public Servicio getServicio(Servicio servicio);
    
    public void save(Servicio servicio);
    
    public void delete(Servicio servicio);
    
}
