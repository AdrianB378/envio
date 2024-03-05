package com.todocode.envio.controller;

import com.todocode.envio.model.Envio;
import com.todocode.envio.service.IEnvioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/envios")
public class EnvioController {
    
    @Autowired
    private IEnvioService envioServ;
    
    // Creamos el envio
    @PostMapping("/crear")
    public String saveEnvio(@RequestBody Envio envio) {
        return envioServ.saveEnvio(envio);
    
    }
    
    // Traemos todos los envios
    @GetMapping("/todo")
    public List<Envio>getEnvios() {
        //List<Envio> envios = envioServ.getEnvios();
        return envioServ.getEnvios();
        
    }
    
    // Traemos un envio por id
    @GetMapping("/traerid/{id}")
    public Envio findEnvio(@PathVariable Long id) {
        return envioServ.findEnvio(id);
    }
    
    // Editamos un envio
    @PutMapping("/editar/{id}")
    public Envio editEnvio (@PathVariable Long id,
                            @RequestBody Envio envioEditar) {
    
    envioServ.editEnvio(id, envioEditar);
    Envio envioEditado = envioServ.findEnvio(id);
    
    return envioEditado;
    
    }
    
    // Borramos un envio
    @DeleteMapping ("/borrar/{id}")
    public String deleteEnvio (@PathVariable Long id) {
        envioServ.deleteEnvio(id);
        
        return "El envio fue eliminado correctamente";
        
    }
    
    
    
}
