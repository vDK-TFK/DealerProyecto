package com.DealerProyecto.controller;

import com.DealerProyecto.service.VehiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    VehiculoService  vehiculoService;
    
    @GetMapping("/")
    public String inicio() {
        return "index";
    }     
    
    @GetMapping("/vehiculo/mostrar")
    public String inicio(Model model) {

        var vehiculos = vehiculoService.getVehiculos(true);
        model.addAttribute("vehiculos", vehiculos);


        return "/vehiculo/mostrar";
    }  
}