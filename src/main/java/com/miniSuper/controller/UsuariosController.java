package com.miniSuper.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniSuper.dto.UsuariosRequest;
import com.miniSuper.model.Usuarios;
import com.miniSuper.service.UsuariosService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5000")
public class UsuariosController {

	@Autowired
	private UsuariosService usuariosService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UsuariosRequest loginRequest) {
		System.out.println("Usuario: "+ loginRequest.getUsuario());
		System.out.println("Contraseña: "+ loginRequest.getContrasena());
		Optional<Usuarios> usuarioOpt = usuariosService.findByUsuarioAndContrasena(
                loginRequest.getUsuario(), 
                loginRequest.getContrasena()
        );
		if (usuarioOpt.isPresent()) {
            Usuarios usuario = usuarioOpt.get();
            System.out.println("se inicio sesion correctamente");
            // Construimos la respuesta de éxito
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login exitoso");
            response.put("usuario", usuario.getUsuario());
            // Si en el futuro agregas JWT, devolverías response.put("token", token);

            return ResponseEntity.ok(response);
        } else {
        	System.out.println("No se encontro el usuario");
            // Si no se encuentra el usuario, enviamos error 401 Unauthorized
            Map<String, String> error = new HashMap<>();
            error.put("message", "Usuario o contraseña incorrectos.");
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }		
	}
	
}
