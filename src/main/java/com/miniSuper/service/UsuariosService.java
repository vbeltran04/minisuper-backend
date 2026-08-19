package com.miniSuper.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniSuper.model.Usuarios;
import com.miniSuper.repository.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepository;
	
	public Optional<Usuarios> findByUsuarioAndContrasena(String usuario, String contrasena) {
        return usuariosRepository.findByUsuarioAndContrasena(usuario, contrasena);
    }
	
}
