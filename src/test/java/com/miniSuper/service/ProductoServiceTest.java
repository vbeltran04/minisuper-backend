package com.miniSuper.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.miniSuper.model.Producto;
import com.miniSuper.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    private Producto productoPrueba;

    @BeforeEach
    void setUp() {
        productoPrueba = new Producto();
        productoPrueba.setNombre("Leche Entera");
        productoPrueba.setClave("LEC001");
        productoPrueba.setStockminimo(10);
        productoPrueba.setStockmaximo(50);
    }

    @Test
    @DisplayName("Debe retornar la lista completa de productos")
    void testObtenerTodos() {
        when(productoRepository.findAll()).thenReturn(Arrays.asList(productoPrueba));

        List<Producto> resultado = productoService.obtenerTodos();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Leche Entera", resultado.get(0).getNombre());
        verify(productoRepository).findAll();
    }

    @Test
    @DisplayName("Debe guardar un producto correctamente")
    void testGuardar() {
        when(productoRepository.save(any(Producto.class))).thenReturn(productoPrueba);

        Producto resultado = productoService.guardar(productoPrueba);

        assertNotNull(resultado);
        assertEquals("LEC001", resultado.getClave());
        verify(productoRepository).save(productoPrueba);
    }

    @Test
    @DisplayName("Debe buscar productos con un criterio de búsqueda")
    void testBuscarProductosConCriterio() {
        String criterio = "Leche";
        Pageable pageable = PageRequest.of(0, 10);
        Page<Producto> paginaMock = new PageImpl<>(Arrays.asList(productoPrueba));

        when(productoRepository.findByNombreContainingIgnoreCaseOrClaveContainingIgnoreCase(
                criterio, criterio, pageable)).thenReturn(paginaMock);

        Page<Producto> resultado = productoService.buscarProductos(criterio, pageable);

        assertNotNull(resultado);
        assertEquals(1, resultado.getTotalElements());
        verify(productoRepository).findByNombreContainingIgnoreCaseOrClaveContainingIgnoreCase(criterio, criterio, pageable);
    }

    @Test
    @DisplayName("Debe sumar correctamente dos enteros")
    void testSumar() {
        int resultado = productoService.sumar(10, 50);

        assertEquals(60, resultado);
    }
}