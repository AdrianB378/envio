package com.todocode.envio.repository;

import com.todocode.envio.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnvioRepository extends JpaRepository<Envio, Long> {
    
}
