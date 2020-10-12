package gestorAplicacion.terreno;

import java.util.*;

public class Terreno {
	private int id;
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private int tamano;
	private double nitrogenoDisponible;
	private double potasioDisponible;
	private double fosforoDisponible;
	private double irrigacionActual;
	
	public Terreno(int id, LinkedList<Cultivo> cultivos, int tamano, double nitrogenoDisponible, double potasioDisponible, double fosforoDisponible, double irrigacionActual) {
		this.id = id; this.cultivos = cultivos; this.tamano = tamano; this.nitrogenoDisponible = nitrogenoDisponible;
		this.potasioDisponible = potasioDisponible; this.fosforoDisponible = fosforoDisponible; this.irrigacionActual = irrigacionActual;
	}
	
	
	public void agregarCultivo(Cultivo cultivo) {
		this.cultivos.add(cultivo);
	}
}
