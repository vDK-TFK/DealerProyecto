/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.controller;

import com.DealerProyecto.domain.Venta;
import com.DealerProyecto.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VentaController 
{
    
    @Autowired
    VentaService ventaService;
    
    
    @GetMapping("/venta/listado")
    public String inicio(Model model)
    {
        var ventas = ventaService.getVentas(false);
        model.addAttribute("ventas", ventas);
        
        return "/venta/listado";  
    }
    
    @GetMapping("/venta/nuevo")
    public String nuevaVenta(Venta venta, Model model) {
        var ventas = ventaService.getVentas(true);
        model.addAttribute("ventas", ventas);
        return "/venta/modifica";
    }

    @PostMapping("/venta/guardar")
    public String guardarVenta(Venta venta) {
        ventaService.save(venta);
        return "redirect:/venta/listado";
    }

    @GetMapping("/venta/modificar/{descripcion}")
    public String modificarVenta(Venta venta, Model model) {
        venta = ventaService.getVenta(venta);
        var ventas = ventaService.getVentas(true);
        model.addAttribute("ventas", ventas);
        model.addAttribute("venta", venta);
        return "/venta/modificar";
    }

    @GetMapping("/venta/eliminar/{descripcion}")
    public String eliminarVenta(Venta venta) {
        ventaService.delete(venta);
        return "redirect:/venta/listado";
    }
}
