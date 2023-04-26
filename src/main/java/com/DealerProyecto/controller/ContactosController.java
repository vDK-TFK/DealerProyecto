/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.controller;

import com.DealerProyecto.domain.Contactos;
import com.DealerProyecto.service.ContactosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactosController 
{
    @Autowired
    ContactosService contactosService;
    
    @GetMapping("/contactos/listado")
    public String inicio(Model model) {
        var contactos=contactosService.getContactos();
        
        model.addAttribute("totalContactos",contactos.size());
        
        model.addAttribute("contactoss",contactos);
        return "/contactos/listado"; 
    }

    @GetMapping("/contactos/nuevo")
    public String nuevoContacto(Contactos contactos) {
        return "/contactos/modificar";
    }

    @PostMapping("/contactos/guardar")
    public String guardarContacto(Contactos contactos) {
        contactosService.save(contactos);
        return "redirect:/contactos/listado";
    }

    @GetMapping("/contactos/modificar/{idContacto}")
    public String modificarContacto(Contactos contactos, Model model) {
        contactos = contactosService.getContacto(contactos);
        model.addAttribute("contactos", contactos);
        return "/contactos/modificar";
    }

    @GetMapping("/contactos/eliminar/{idContacto}")
    public String eliminarContacto(Contactos contactos) {
        contactosService.delete(contactos);
        return "redirect:/contactos/listado";
    }
}
