package com.floristeria.clases;

public class Arbol extends Elementos{
	
	private Double altura;
	private String id;
	
	public Arbol(String nombre, Double precio, Double altura) {
		super(nombre, precio);
		this.altura = altura;
	}

	public Arbol(String id, String nombre, double precio, double altura2) {
		// TODO Auto-generated constructor stub
		super(nombre, precio);
		this.altura=altura;
		this.id=id;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Arbol [nombre ="+this.getNombre()+" - altura=" + altura + " - precio="+this.getPrecio()+"]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	
	

}
