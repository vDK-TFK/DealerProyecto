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
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;
    private Long idMarca;
    private String descripcion;
    private String detalle;
    private double precio;
    private boolean activo;
    @Column(name="ruta_imagen")
    private String rutaImagen;
    
    public Vehiculo() {
    } 

    public Vehiculo(Long idMarca, String descripcion, String detalle, double precio, boolean activo) {
        this.idMarca = idMarca;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.activo = activo;
    }
}