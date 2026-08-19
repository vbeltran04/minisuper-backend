package com.miniSuper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras")
public class Compras {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental en Postgres (Serial)
    private Long idcompras;
	
	private Double pagocompra;
	private Double totalcompra;
	@Column(columnDefinition = "TEXT")
	private String fecha;
	
	public Compras() {}

    public Compras(Long idcompras, Double pagocompra, Double totalcompra, String fecha) {
        this.idcompras = idcompras;
        this.pagocompra = pagocompra;
        this.totalcompra = totalcompra;
        this.fecha = fecha;
    }

	public Long getIdcompras() {
		return idcompras;
	}

	public void setIdcompras(Long idcompras) {
		this.idcompras = idcompras;
	}

	public Double getPagocompra() {
		return pagocompra;
	}

	public void setPagocompra(Double pagocompra) {
		this.pagocompra = pagocompra;
	}

	public Double getTotalcompra() {
		return totalcompra;
	}

	public void setTotalcompra(Double totalcompra) {
		this.totalcompra = totalcompra;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
