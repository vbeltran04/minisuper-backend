package com.miniSuper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miniSuper.model.Producto;
import com.miniSuper.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	// Método para listar todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }
    
    public Producto guardar(Producto Producto) {
    	return productoRepository.save(Producto);  
    }
    
    public Page<Producto> buscarProductos(String criterio, Pageable pageable) {
        if (criterio != null && !criterio.trim().isEmpty()) {
            String termino = criterio.trim();
            return productoRepository.findByNombreContainingIgnoreCaseOrClaveContainingIgnoreCase(
                    termino, termino, pageable);
        }
        return productoRepository.findAll(pageable);
    }

}
