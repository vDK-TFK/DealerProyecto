package com.DealerProyecto.service;

import com.DealerProyecto.domain.Marca;
import java.util.List;

public interface MarcaService {
    public List<Marca> getMarcas(boolean marca); //obtener todos los categorias
    
    public Marca getMarca(Marca marca); //un categoria en especifico
    
    public void save(Marca marca); //insertar nuevo registro o modificar (si viene el id categoria o no)
    
    public void delete(Marca marca); //eliminar
    
}
