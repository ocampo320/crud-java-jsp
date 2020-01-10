package com.modelo;

public class Usuario {
	
private String nombre;
private String apellido;
private String direccion;
private int id_usuario;
public int getId() {
	return id_usuario;
}
public void setId(int id) {
	this.id_usuario = id;
}

public Usuario(String nombre, String apellido, String direccion, int id) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.direccion = direccion;
	this.id_usuario = id;
}





public Usuario() {
	// TODO Auto-generated constructor stub
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
@Override
public String toString() {
	return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", id=" + id_usuario + "]";
}


 
}
