package com.floristeria.clases;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.statushandlers.StatusManager.INotificationTypes;

public class Ticket {

	private int id;
	private String nombre;
	// private List<Elementos> elementos = new ArrayList<Elementos>();
	private List<Arbol> arboles = new ArrayList<Arbol>();
	private List<Flor> flores = new ArrayList<Flor>();
	private Decoracion decoracion;

	/*public Ticket(int id,String nombre, List<Elementos> elementos) {
		this.id=id;
		this.nombre = nombre;

	}*/

	public Ticket(int id,String nombre, List<Arbol> ar, List<Flor> fl, Decoracion d) {
		this.id=id;
		this.nombre = nombre;
		this.arboles = ar;
		this.flores = fl;
		this.decoracion = d;
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

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "\nNumero de ticket: "+ id +"\nFloristeria=" + nombre + ",\n Arboles=" + arboles + ",\n Flores=" + flores + ",\n Decoracion="
				+ decoracion +",\n Valor Total "+valorTotal();
	}

	public double valorTotal() {

		double total = 0;

		
			for (Arbol a : arboles) {
				if(a!=null) {
					total += a.getPrecio();
				}
			}
		
		
		
			for (Flor f : flores) {
				if(f!=null) {
					total += f.getPrecio();
				}
			}
		

		if(decoracion != null) {
			total+=decoracion.getPrecio();
		}
		

		return total;

	}

}