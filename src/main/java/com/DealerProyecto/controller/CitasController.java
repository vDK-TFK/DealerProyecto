/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.controller;

import com.DealerProyecto.domain.Citas;
import com.DealerProyecto.service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CitasController 
{
    @Autowired
    CitasService citasService;
    
    @GetMapping("/citas/listado")
    public String inicio(Model model) {
        var Citas=citasService.getCitas();
        
        model.addAttribute("totalCitas",Citas.size());
        
        model.addAttribute("Citas",Citas);
        return "/citas/listado"; 
    }
    
    @GetMapping("/citas/nuevo")
    public String nuevoCitas(Citas citas) {
        return "/citas/modificar";
    }

    @PostMapping("/citas/guardar")
    public String guardarCitas(Citas citas) {
        citasService.save(citas);
        return "redirect:/citas/listado";
    }

    @GetMapping("/citas/modificar/{idCitas}")
    public String modificarCitas(Citas citas, Model model) {
        citas = citasService.getCita(citas);
        model.addAttribute("citas", citas);
        return "/citas/modificar";
    }

    @GetMapping("/citas/eliminar/{idCitas}")
    public String eliminarCitas(Citas citas) {
        citasService.delete(citas);
        return "redirect:/citas/listado";
    }
    
    
    
}
