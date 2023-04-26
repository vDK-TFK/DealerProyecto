/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.service;


import com.DealerProyecto.dao.ContactosDao;
import com.DealerProyecto.domain.Contactos;
import com.DealerProyecto.domain.Contactos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactosServiceimpl implements ContactosService
{
    
    @Autowired
    ContactosDao contactosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contactos> getContactos() {
        return (List<Contactos>) contactosDao.findAll();
    }

    @Override
    public Contactos getContacto(Contactos contactos) {
        return contactosDao.findById(contactos.getIdContacto()).orElse(null);
    }

    @Override
    public void save(Contactos contactos) {
        contactosDao.save(contactos);
    }

    @Override
    public void delete(Contactos contactos) {
        contactosDao.delete(contactos);
    }
    
}
