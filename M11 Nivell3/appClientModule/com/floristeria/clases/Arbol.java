package com.floristeria.clases;

public class Arbol extends Elementos{
	
	private Double altura;
	
	
	public Arbol(String nombre, Double precio, Double altura) {
		super(nombre, precio);
		this.altura = altura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "nombre ="+this.getNombre()+" - altura=" + altura + " - precio="+this.getPrecio();
	}
	
	

}
