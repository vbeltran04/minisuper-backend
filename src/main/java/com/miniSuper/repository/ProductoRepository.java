package com.miniSuper.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniSuper.model.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	Page<Producto> findByNombreContainingIgnoreCaseOrClaveContainingIgnoreCase(
            String nombre, String clave, Pageable pageable);

}
