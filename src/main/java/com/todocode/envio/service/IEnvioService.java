package com.todocode.envio.service;

import com.todocode.envio.model.Envio;
import java.util.List;

public interface IEnvioService {
    
    // Método para crear un nuevo envío
    public String saveEnvio(Envio envio);
    
    // Método para obtener todos los envíos
    public List<Envio> getEnvios();
    
    // Método para obtener un envío por su ID
    public Envio findEnvio(Long id);
    
    // Método para actualizar un envío existente
    public String editEnvio(Long id, Envio envio);
    
    // Método para eliminar un envío por su ID
    public String deleteEnvio(Long id);
    
}

