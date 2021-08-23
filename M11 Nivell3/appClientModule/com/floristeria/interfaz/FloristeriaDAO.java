package com.floristeria.interfaz;

import java.util.List;

import com.floristeria.clases.Arbol;
import com.floristeria.clases.Decoracion;
import com.floristeria.clases.Decoracion.Tipo;
import com.floristeria.clases.Flor;
import com.floristeria.clases.Floristeria;
import com.floristeria.clases.Ticket;


public interface FloristeriaDAO {
	
	public List<Floristeria> getAllFloristerias();
	public Floristeria getFloristeria(String nombre);
	public void deleteFloristeria(Floristeria floristeria);
	public void addFloristeria(String nom,String ar,String fl,String de);
	public void newArbol(Floristeria floristeria,Arbol arbol);
	public void newFlor(Floristeria floristeria,Flor flor);
	public void newDescoracion(Floristeria floristeria);
	public int getFloristeriaPosicion(String nombre);
	
	public List<Arbol> getAllArbol();
	public Arbol getArbol(String nombre);
	public void deleteArbol(Arbol arbol);
	public void addArbol(String nombre,double precio,double altura);
	
	public List<Flor> getAllFlor();
	public Flor getFlor(String nombre);
	public void deleteFlor(Flor flor);
	public void addFlor(String nombre, Double precio, String color);
	
	public List<Decoracion> getAllDecoracion();
	public Decoracion getDecoracion(Tipo tipo);
	public void deleteDecoracion(Decoracion decoracion);
	public void addDecoracion();
	
	public List<Ticket> getAllTicket();
	public Ticket getTicket(int id);
	public List<Ticket> getTickets(String nombre);
	public void addTicket(int id,String nombre, List<Arbol> ar,List<Flor> fl,Decoracion de);

}
