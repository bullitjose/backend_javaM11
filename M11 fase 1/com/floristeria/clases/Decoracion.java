package com.floristeria.clases;

public class Decoracion extends Elementos {
	
	
	private String tipoDeco;

	public enum Tipo{
			
			MADERA("MADERA"),PLASTICO("PLASTICO");
			
			private String tipo;
	
			private Tipo(String tipo) {
				this.tipo = tipo;
			}
			
			public String getPuesto() {
				return tipo;
			}
			
	}
	
	public Decoracion(String nombre, Double precio, String tipo) {
		super(nombre, precio);
		this.tipoDeco = tipo;
	}

	public String getTipoDeco() {
		return tipoDeco;
	}

	public void setTipoDeco(String tipoDeco) {
		this.tipoDeco = tipoDeco;
	}
	
	@Override
	public String toString() {
		return "Decoracion [nombre ="+this.getNombre()+" - tipoDeco=" + tipoDeco + " - precio="+this.getPrecio()+"]";
	}

}
