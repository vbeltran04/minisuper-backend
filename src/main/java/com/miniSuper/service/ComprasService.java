package com.miniSuper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniSuper.model.Compras;
import com.miniSuper.repository.ComprasRepository;

@Service
public class ComprasService {
	
	@Autowired
	private ComprasRepository comprasRepository;
	
	// Método para listar todos los productos
    public List<Compras> obtenerTodos() {
        return comprasRepository.findAll();
    }
    
    public Compras guardar(Compras compras) {
    	return comprasRepository.save(compras);  
    }

}
