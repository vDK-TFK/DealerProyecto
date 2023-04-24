package com.DealerProyecto.controller;

import com.DealerProyecto.domain.Servicios;
import com.DealerProyecto.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServicioController {
    
    @Autowired
    ServicioService servicioService;
    
    @GetMapping("/servicio/listado")
    public String inicio(Model model) {
        var servicios = servicioService.getServicios(false);
        model.addAttribute("servicios", servicios);

        return "/servicio/listado";
    }
    
    @GetMapping("/servicio/nuevo")
    public String nuevoServicio(Servicios servicio) {
        return "/servicio/modificar";
    }

    @PostMapping("/servicio/guardar")
    public String guardarServicio(Servicios servicio) {
        servicioService.save(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/servicio/modificar/{idServicio}")
    public String modificarCategoria(Servicios servicio, Model model) {
        servicio = servicioService.getServicio(servicio);
        model.addAttribute("servicio", servicio);
        return "/servicio/modificar";
    }

    @GetMapping("/servicio/eliminar/{idServicio}")
    public String eliminarServicio(Servicios servicio) {
        servicioService.delete(servicio);
        return "redirect:/servicio/listado";
    }
}
