package com.floristeria.interfaz;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.floristeria.clases.Arbol;
import com.floristeria.clases.Decoracion;
import com.floristeria.clases.Decoracion.Tipo;

import com.floristeria.clases.Flor;
import com.floristeria.clases.Floristeria;
import com.floristeria.clases.Ticket;

public class FloristeriasDAOImpl implements FloristeriaDAO {
	
	private List<Floristeria> floristerias = new ArrayList<Floristeria>();
	private List<Arbol> arboles = new ArrayList<Arbol>();
	private List<Flor> flores = new ArrayList<Flor>();
	private List<Decoracion> decoraciones = new ArrayList<Decoracion>();
	private List<Ticket> tickets = new ArrayList<Ticket>();

	@Override
	public List<Floristeria> getAllFloristerias() {
		
		return floristerias;
	}

	@Override
	public Floristeria getFloristeria(String nombre) {
		
		Floristeria florists = null;
		
		for(Floristeria f:floristerias) {
			
			String nombres = f.getNombre();
				
				if(nombres.equals(nombre)) {
					florists = f;
				}else {
					System.out.println("No encontrada");
				}
			
		}
		
		return florists;
	}
	
	@Override
	public int getFloristeriaPosicion(String nombre) {
		
		int datos = 0;
		
		for(int i=0; i < floristerias.size();i++) {
			
			String nombres = floristerias.get(i).getNombre();
				
				if(nombres.equals(nombre)) {
					datos = i;
				}else {
					System.out.println("No encontrada");
				}
			
		}
		
		return datos;
		
	}
	

	@Override
	public void deleteFloristeria(Floristeria floristeria) {
		
		String nombre = floristeria.getNombre();
		
		for(Floristeria f: floristerias) {
			
			Floristeria florist = f;
			
			if(florist.getNombre() == nombre) {
				
				floristerias.remove(florist);
			} 
			
		}
		
	}

	@Override
	public void addFloristeria(String nombre,String arbol,String flor,String decoracion) {
		
		Arbol a = getArbol(arbol);
		List<Arbol> ar = new ArrayList<Arbol>();
		ar.add(a);
		
		Flor f = getFlor(flor);
		List<Flor> fl = new ArrayList<Flor>();
		fl.add(f);
		
		addDecoracion();
		System.out.println("Tipo: "+decoracion);
		
		Decoracion d = null;
		
		for(Decoracion deco:decoraciones) {
			if(deco.getTipoDeco()==decoracion) {
				d = getDecoracion(Tipo.valueOf(decoracion));
			}
		}
		

		
		Floristeria floristeria = new Floristeria(nombre, ar, fl, d);
		this.floristerias.add(floristeria);
		
		System.out.println(floristeria.toString());
		System.out.println(floristerias.size());
		
	}

	
	@Override
	public void newArbol(Floristeria floristeria,Arbol arbol) {
		floristeria.addArbol(arbol);
	}

	@Override
	public void newFlor(Floristeria floristeria,Flor flor) {
		floristeria.addFlor(flor);
	}

	@Override
	public void newDescoracion(Floristeria floristeria) {
		
	}

	@Override
	public List<Arbol> getAllArbol() {
		
		return arboles;
	}

	@Override
	public Arbol getArbol(String nombre) {
		
		Arbol arbols = null;
		
		for(Arbol a:arboles) {
			
			String nombres = a.getNombre();
				
				if(nombres.equals(nombre)) {
					arbols = a;
				}else {
					System.out.println("No encontrado");
				}
			
		}
		
		return arbols;
		
	}


	@Override
	public void deleteArbol(Arbol arbol) {
		
		String nombre = arbol.getNombre();
		
		for(Arbol a: arboles) {
			
			Arbol arbols = a;
			
			if(arbols.getNombre() == nombre) {
				
				arboles.remove(arbols);
			} 
			
		}
		
	}

	@Override
	public void addArbol(String nombre,double precio,double altura) {
	
		Arbol arbol = new Arbol(nombre, precio, altura);
		this.arboles.add(arbol);
		
	}

	@Override
	public List<Flor> getAllFlor() {
		
		return flores;
		
	}

	@Override
	public Flor getFlor(String nombre) {
		
		Flor flors = null;
		
		for(Flor f:flores) {
			
			String nombres = f.getNombre();
				
				if(nombres.equals(nombre)) {
					flors = f;
				}else {
					System.out.println("No encontrada");
				}
			
		}
		
		return flors;
		
	}


	@Override
	public void deleteFlor(Flor flor) {
		
		String nombre = flor.getNombre();
		
		for(Flor f: flores) {
			
			Flor flors = f;
			
			if(flors.getNombre() == nombre) {
				
				flores.remove(flors);
			} 
			
		}
		
	}

	@Override
	public void addFlor(String nombre, Double precio, String color) {
		
		Flor flor = new Flor(nombre, precio, color);
		this.flores.add(flor);
		
	}

	@Override
	public List<Decoracion> getAllDecoracion() {
		
		return decoraciones;
	}

	
	@Override
	public Decoracion getDecoracion(Tipo tipo) {
		
		Decoracion decor = null;
		
		System.out.println("El nombre es: "+tipo.getTipo());
		
		for(Decoracion d:decoraciones) {
			
			String nombres = d.getTipoDeco();
			
			System.out.println("Tipo nombre es: "+nombres);
				
				if(nombres.equals(tipo.getTipo())) {
					decor = d;
				}else {
					System.out.println("No encontrada");
				}
			
		}
		
		return decor;
		
	}


	@Override
	public void deleteDecoracion(Decoracion decoracion) {
		
		String nombre = decoracion.getNombre();
		
		for(Decoracion d: decoraciones) {
			
			Decoracion decor = d;
			
			if(decor.getNombre() == nombre) {
				
				decoraciones.remove(decor);
			} 
			
		}
		
	}

	@Override
	public void addDecoracion() {
		
		Tipo[] tipos = Tipo.values();
		
		for(int i=0;i<tipos.length;i++) {
			decoraciones.add(new Decoracion("Mesa", 20.00, tipos[i].getTipo()));
		}
		
	}

	@Override
	public List<Ticket> getAllTicket() {
		// TODO Auto-generated method stub
		return tickets;
	}

	@Override
	public Ticket getTicket(int id) {
		
		Ticket ticket = null;
		
		for(Ticket t:tickets) {
			
			int num = t.getId();
				
				if(num == id) {
					ticket = t;
				}else {
					System.out.println("No encontrado");
				}
			
		}
		
		return ticket;
		
	}

	@Override
	public void addTicket(int id,String nombre, List<Arbol> ar,List<Flor> fl,Decoracion de) {
		
		Ticket ticket = new Ticket(id,nombre,ar,fl,de);
		this.tickets.add(ticket);
		
	}

	@Override
	public List<Ticket> getTickets(String nombre) {
		
		List<Ticket> listaTikect = new ArrayList<Ticket>();
		
		for(Ticket t:tickets) {
			
			String nombres = t.getNombre();
				
				if(nombres == nombre) {
					listaTikect.add(t);
				}else {
					System.out.println("No encontrado");
				}
			
		}
		
		return listaTikect;
	}

}
