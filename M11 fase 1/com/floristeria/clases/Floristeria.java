package com.floristeria.clases;

import java.util.ArrayList;
import java.util.List;

public class Floristeria {
	
	private String nombre;
	private List<Arbol> arboles = new ArrayList<Arbol>();
	private List<Flor> flores = new ArrayList<Flor>();
	private Decoracion decoracion;
	
	
	public Floristeria(String nombre, List<Arbol> arboles, List<Flor> flores, Decoracion decoracion) {
		super();
		this.nombre = nombre;
		this.arboles = arboles;
		this.flores = flores;
		this.decoracion = decoracion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Arbol> getArboles() {
		return arboles;
	}


	public void setArboles(List<Arbol> arboles) {
		this.arboles = arboles;
	}


	public List<Flor> getFlores() {
		return flores;
	}


	public void setFlores(List<Flor> flores) {
		this.flores = flores;
	}


	public Decoracion getDecoracion() {
		return decoracion;
	}


	public void setDecoracion(Decoracion decoracion) {
		this.decoracion = decoracion;
	}


	@Override
	public String toString() {
		return "Floristeria [nombre=" + nombre + ", arboles=" + arboles + ", flores=" + flores + ", decoracion="
				+ decoracion + "]";
	}
	
	

}
