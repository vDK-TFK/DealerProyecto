package com.DealerProyecto.dao;

import com.DealerProyecto.domain.Marca;
import org.springframework.data.repository.CrudRepository;

public interface MarcaDao extends CrudRepository<Marca, Long> {
    
}
