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
@Table(name = "servicios")
public class Servicios implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;
    private String titulo;
    private String descripcion;
    private boolean activo;

    public Servicios() {
    }

    public Servicios(Long idServicio, String titulo, String descripcion, boolean activo) {
        this.idServicio = idServicio;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
}
