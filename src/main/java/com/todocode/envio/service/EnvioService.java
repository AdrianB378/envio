package com.todocode.envio.service;


import com.todocode.envio.model.Envio;
import com.todocode.envio.repository.IEnvioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvioService implements IEnvioService {
    
    @Autowired
    private IEnvioRepository envioRepo;
    
    

    @Override
    public String saveEnvio(Envio envio) {
        
        envioRepo.save(envio);
        
        return "El envio se ha creado correctamente";
    }

    @Override
    public List<Envio> getEnvios() {
        return envioRepo.findAll();
        
    }

    @Override
    public Envio findEnvio(Long id) {
        return envioRepo.findById(id).orElse(null);
        
    }

    @Override
    public String editEnvio(Long id, Envio envio) {
        
        Envio env = envioRepo.findById(id).orElse(null);
        
        if (env != null) {
        
        env.setFechaCreacion(envio.getFechaCreacion());
        env.setEstado(envio.getEstado());
        env.setDescripcion(envio.getDescripcion());
       
        
    
        envioRepo.save(env);
        
        return "El envio se ha actualizado correctamente.";
        } else {
            return "No se ha encontrado ningun envio con el Id proporcionado";    
        }    
        
    }
   

    @Override
    public String deleteEnvio(Long idEnvio) {
        envioRepo.deleteById(idEnvio);
        return "El envio se elimino correctamente";
    }
    
}
