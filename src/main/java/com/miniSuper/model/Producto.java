package com.miniSuper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental en Postgres (Serial)
    private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String nombre;
	
	@Column(columnDefinition = "TEXT")
	private String clave;
	
	@Column(name = "stockminimo")
	private Integer stockminimo;
	
	@Column(name = "stockmaximo")
	private Integer stockmaximo;
	
	@Column(name = "preciocompra")
	private Double preciocompra;
	
	@Column(name = "precioventa")
	private Double precioventa;
	
	@Column(name = "numeropiezas")
	private Integer numeropiezas;
	
	public Producto() {}

	public Producto(Long id, String nombre, String clave, Integer stockMinimo, Integer stockMaximo, Double precioCompra,
			Double precioVenta, Integer numeroPieza) {
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.stockminimo = stockminimo;
		this.stockmaximo = stockmaximo;
		this.preciocompra = preciocompra;
		this.precioventa = precioventa;
		this.numeropiezas = numeropiezas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Integer getStockminimo() {
		return stockminimo;
	}

	public void setStockminimo(Integer stockminimo) {
		this.stockminimo = stockminimo;
	}

	public Integer getStockmaximo() {
		return stockmaximo;
	}

	public void setStockmaximo(Integer stockmaximo) {
		this.stockmaximo = stockmaximo;
	}

	public Double getPreciocompra() {
		return preciocompra;
	}

	public void setPreciocompra(Double preciocompra) {
		this.preciocompra = preciocompra;
	}

	public Double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(Double precioventa) {
		this.precioventa = precioventa;
	}

	public Integer getNumeropiezas() {
		return numeropiezas;
	}

	public void setNumeropiezas(Integer numeropiezas) {
		this.numeropiezas = numeropiezas;
	}

}
