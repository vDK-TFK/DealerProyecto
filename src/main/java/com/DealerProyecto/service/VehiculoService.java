package com.DealerProyecto.service;

import com.DealerProyecto.domain.Vehiculo;
import java.util.List;

public interface VehiculoService {

    public List<Vehiculo> getVehiculos(boolean vehiculo); //obtener todos los articulos

    public Vehiculo getVehiculo(Vehiculo vehiculo); //un articulo en especifico

    public void save(Vehiculo vehiculo); //insertar nuevo registro o modificar (si viene el id articulo o no)

    public void delete(Vehiculo vehiculo); //eliminar
}
