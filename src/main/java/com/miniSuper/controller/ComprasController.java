package com.miniSuper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniSuper.model.Compras;
import com.miniSuper.service.ComprasService;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "http://localhost:4200")
public class ComprasController {
	
	@Autowired
    private ComprasService comprasService;
	
	@GetMapping
    public List<Compras> listarCompras() {
        return comprasService.obtenerTodos();
    }
	
	@PostMapping
    public Compras crearProducto(@RequestBody Compras compras) {
        return comprasService.guardar(compras);
    }

}
