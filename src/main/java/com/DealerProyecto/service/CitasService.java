/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DealerProyecto.service;

import com.DealerProyecto.domain.Citas;
import java.util.List;


public interface CitasService 
{
    public List<Citas> getCitas(); //obtener todas las citas

    public Citas getCita(Citas citas); //una cita en especifico

    public void save(Citas citas); //insertar nuevo registro o modificar (si viene el id citas o no)

    public void delete(Citas citas); //eliminar
}
