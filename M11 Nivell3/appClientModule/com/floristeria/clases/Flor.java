package com.floristeria.clases;

public class Flor extends Elementos {
	
	private String color;

	public Flor(String nombre, Double precio, String color) {
		super(nombre, precio);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "nombre ="+this.getNombre()+" - color=" + color + " - precio="+this.getPrecio();
	}

}
