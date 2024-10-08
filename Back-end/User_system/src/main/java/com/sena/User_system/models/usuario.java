package com.sena.User_system.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="usuario")
public class usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_usuario", nullable= false, length = 36)
	private String id_usuario;
	
	@Column(name = "nombre_completo", nullable= false, length = 50)
	private String nombre_completo;
	
	@Column(name = "tipo_doc", nullable= false, length = 3)
	private String tipo_doc;
	
	@Column(name = "numero_doc", nullable= false, length = 11)
	private int numero_doc;
	
	@Column(name = "fecha_nac", nullable= false, length = 11)
	private Date fecha_nac;
	
	@Column(name = "correo", nullable= false, length = 256)
	private String correo;
	
	@Column(name = "contrasena", nullable= false, length = 25)
	private String contrasena;
	
	@Column(name = "fecha_actualizacion", nullable= false, length = 50)
	private Date fecha_actualizacion;
	
	@Column(name = "fecha_inicio_sesion", nullable= false, length = 50)
	private Date fecha_inicio_sesion;
	
	@Column(name = "estado", nullable= false, length = 10)
	private String estado;

	public usuario() {
	}

	public usuario(String id_usuario, String nombre_completo, String tipo_doc, int numero_doc, Date fecha_nac,
			String correo, String contrasena, Date fecha_actualizacion, Date fecha_inicio_sesion, String estado) {
		this.id_usuario = id_usuario;
		this.nombre_completo = nombre_completo;
		this.tipo_doc = tipo_doc;
		this.numero_doc = numero_doc;
		this.fecha_nac = fecha_nac;
		this.correo = correo;
		this.contrasena = contrasena;
		this.fecha_actualizacion = fecha_actualizacion;
		this.fecha_inicio_sesion = fecha_inicio_sesion;
		this.estado = estado;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public int getNumero_doc() {
		return numero_doc;
	}

	public void setNumero_doc(int numero_doc) {
		this.numero_doc = numero_doc;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(Date fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public Date getFecha_inicio_sesion() {
		return fecha_inicio_sesion;
	}

	public void setFecha_inicio_sesion(Date fecha_inicio_sesion) {
		this.fecha_inicio_sesion = fecha_inicio_sesion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
