package com.miniSuper.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniSuper.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{
	
	// Método derivado automático
    Optional<Usuarios> findByUsuarioAndContrasena(String usuario, String contrasena);
	
}
