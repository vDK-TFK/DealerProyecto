/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DealerProyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "venta")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    
    private Long idVenta;
    private Long idFactura;
    private Long idVehiculo;
    private double precio;
    private boolean activo;

    public Venta() {
    }

    public Venta(Long idFactura, Long idVehiculo, double precio, boolean activo) {
        this.idFactura = idFactura;
        this.idVehiculo = idVehiculo;
        this.precio = precio;
        this.activo = activo;
    }

}
