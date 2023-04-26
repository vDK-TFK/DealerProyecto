/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DealerProyecto.service;

import com.DealerProyecto.domain.Contactos;
import java.util.List;

/**
 *
 * @author sebgu
 */
public interface ContactosService 
{
    public List<Contactos> getContactos(); //obtener todos los Contactos

    public Contactos getContacto(Contactos contactos); //un Contactos en especifico

    public void save(Contactos contactos); //insertar nuevo registro o modificar (si viene el id Contactos o no)

    public void delete(Contactos contactos); //eliminar
}
