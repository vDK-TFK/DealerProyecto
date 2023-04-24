package com.DealerProyecto.service;

import com.DealerProyecto.domain.Servicios;
import java.util.List;

public interface ServicioService {
    
    public List<Servicios> getServicios(boolean servicio); //obtener todos los categorias
    
    public Servicios getServicio(Servicios servicio); //un categoria en especifico
    
    public void save(Servicios servicio); //insertar nuevo registro o modificar (si viene el id categoria o no)
    
    public void delete(Servicios servicio); //eliminar   
}
