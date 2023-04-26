/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.controller;

import com.DealerProyecto.domain.Factura;
import com.DealerProyecto.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FacturaController 
{
    @Autowired
    FacturaService facturaService;
    
    @GetMapping("/factura/listado")
    public String inicio(Model model)
    {
        var facturas = facturaService.getFacturas(false);
        model.addAttribute("facturas", facturas);
        
        
        return "/factura/listado";  
    }
    
    @GetMapping("/factura/nuevo")
    public String nuevoFactura(Factura factura, Model model) {
        var facturas = facturaService.getFacturas(true);
        model.addAttribute("facturas", facturas);
        return "/factura/modificar";
    }

    @PostMapping("/factura/guardar")
    public String guardarFactura(Factura factura) {
        facturaService.save(factura);
        return "redirect:/factura/listado";
    }

    @GetMapping("/factura/modificar/{descripcion}")
    public String modificarFactura(Factura factura, Model model) {
        factura = facturaService.getFactura(factura);
        var facturas = facturaService.getFacturas(true);
        model.addAttribute("facturas", facturas);
        model.addAttribute("factura", factura);
        return "/factura/modificar";
    }

    @GetMapping("/factura/eliminar/{descripcion}")
    public String eliminarFactura(Factura factura) {
        facturaService.delete(factura);
        return "redirect:/factura/listado";
    }
    
    
}
