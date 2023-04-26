/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DealerProyecto.dao;

import com.DealerProyecto.domain.Contactos;
import org.springframework.data.repository.CrudRepository;

public interface ContactosDao extends CrudRepository<Contactos, Long>{
    
}
