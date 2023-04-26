
package com.DealerProyecto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "servicios")
public class Servicio 
{
   private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;
    private String Titulo;
    private String descripcion;
    private boolean activo;

    public Servicio() {
    }

    public Servicio(String Titulo, String descripcion, boolean activo) {
        this.Titulo = Titulo;
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    
    
    
}
