package gestorAplicacion.terreno;

import java.util.*;

public class Terreno {
	private int id;
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private LinkedList<String> tipos = new LinkedList<String>();
	private int tamano;
	private double nitrogenoDisponible;
	private double potasioDisponible;
	private double fosforoDisponible;
	private double irrigacionActual;
	
	public Terreno(int id, int tamano, double nitrogenoDisponible, double potasioDisponible, double fosforoDisponible, double irrigacionActual) {
		this.id = id; 
		this.tamano = tamano;
		this.nitrogenoDisponible = nitrogenoDisponible;
		this.potasioDisponible = potasioDisponible; 
		this.fosforoDisponible = fosforoDisponible; 
		this.irrigacionActual = irrigacionActual;
	}

	
	
	// set cultivo
	public void agregarCultivo(Cultivo cultivo) {
		this.cultivos.add(cultivo);
	}
	public void agregarTipo(String tipo) {
		this.tipos.add(tipo);
	}
	
}
