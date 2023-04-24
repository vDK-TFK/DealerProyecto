package com.DealerProyecto.controller;

import com.DealerProyecto.domain.Marca;
import com.DealerProyecto.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MarcaController {

    @Autowired
    MarcaService marcaService;

    @GetMapping("/marca/listado")
    public String inicio(Model model) {
        var marcas = marcaService.getMarcas(false);
        model.addAttribute("marcas", marcas);

        return "/marca/listado";
    }

    @GetMapping("/marca/nuevo")
    public String nuevoMarca(Marca marca) {
        return "/marca/modificar";
    }

    @PostMapping("/marca/guardar")
    public String guardarMarca(Marca marca) {
        marcaService.save(marca);
        return "redirect:/marca/listado";
    }

    @GetMapping("/marca/modificar/{idMarca}")
    public String modificarMarca(Marca marca, Model model) {
        marca = marcaService.getMarca(marca);
        model.addAttribute("marca", marca);
        return "/marca/modificar";
    }

    @GetMapping("/marca/eliminar/{idMarca}")
    public String eliminarMarca(Marca marca) {
        marcaService.delete(marca);
        return "redirect:/marca/listado";
    }

}
