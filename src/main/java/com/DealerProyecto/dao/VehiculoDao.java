package com.DealerProyecto.dao;

import com.DealerProyecto.domain.Vehiculo;
import org.springframework.data.repository.CrudRepository;

public interface VehiculoDao extends CrudRepository<Vehiculo, Long> {
    
}
