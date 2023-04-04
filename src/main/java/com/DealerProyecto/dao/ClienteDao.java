package com.DealerProyecto.dao;

import com.DealerProyecto.domain.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends CrudRepository<Cliente, Long> {

}
