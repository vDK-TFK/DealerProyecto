package com.DealerProyecto.controller;

import com.DealerProyecto.domain.Vehiculo;
import com.DealerProyecto.service.VehiculoService;
import com.DealerProyecto.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    MarcaService marcaService;

    @GetMapping("/vehiculo/mostrar")
    public String inicio(Model model) {
        var vehiculos = vehiculoService.getVehiculos(false);
        model.addAttribute("vehiculos", vehiculos);

        return "/vehiculo/mostrar";
    }

    @GetMapping("/vehiculo/nuevo")
    public String nuevoVehiculo(Vehiculo vehiculo, Model model) {
        var marcas = marcaService.getMarcas(true);
        model.addAttribute("marcas", marcas);
        return "/vehiculo/modificar";
    }

    @PostMapping("/vehiculo/guardar")
    public String guardarVehiculo(Vehiculo vehiculo) {
        vehiculoService.save(vehiculo);
        return "redirect:/vehiculo/listado";
    }

    @GetMapping("/vehiculo/modificar/{idVehiculo}")
    public String modificarVehiculo(Vehiculo vehiculo, Model model) {
        vehiculo = vehiculoService.getVehiculo(vehiculo);
        var marcas = marcaService.getMarcas(true);
        model.addAttribute("marcas", marcas);
        model.addAttribute("vehiculo", vehiculo);
        return "/vehiculo/modificar";
    }

    @GetMapping("/vehiculo/eliminar/{idVehiculo}")
    public String eliminarVehiculo(Vehiculo vehiculo) {
        vehiculoService.delete(vehiculo);
        return "redirect:/vehiculo/listado";
    }

    @GetMapping("/vehiculo/listado")
    public String listadoVehiculo(Model model) {
        var vehiculos = vehiculoService.getVehiculos(false);
        model.addAttribute("vehiculos", vehiculos);

        return "/vehiculo/listado";
    }
}
