package com.miniSuper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental en Postgres (Serial)
    private Long idusuarios;
	
	@Column(columnDefinition = "TEXT")
	private String usuario;
	
	@Column(columnDefinition = "TEXT")
	private String contrasena;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidopaterno")
	private String apellidopaterno;
	
	@Column(name = "apellidomaterno")
	private String apellidomaterno;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "idperfil")
	private Integer idperfil;
	
	@Column(name = "idestatus")
	private Integer idestatus;
	
	public Usuarios() {}

	public Usuarios(Long idusuarios, String usuario, String contrasena, String nombre, String apellidopaterno,
			String apellidomaterno, String correo, String telefono, Integer idperfil, Integer idestatus) {
		this.idusuarios = idusuarios;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidopaterno = apellidopaterno;
		this.apellidomaterno = apellidomaterno;
		this.correo = correo;
		this.telefono = telefono;
		this.idperfil = idperfil;
		this.idestatus = idestatus;
	}

	public Long getIdusuarios() {
		return idusuarios;
	}

	public void setIdusuarios(Long idusuarios) {
		this.idusuarios = idusuarios;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidopaterno() {
		return apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidomaterno() {
		return apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}

	public Integer getIdestatus() {
		return idestatus;
	}

	public void setIdestatus(Integer idestatus) {
		this.idestatus = idestatus;
	}
}
