package gestorAplicacion.empleado;
import java.util.LinkedList;

import gestorAplicacion.terreno.*;

public class Agronomo extends Empleado{
	private Terreno terreno; //Terreno en el que trabaja
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private LinkedList<Campesino> campesinos = new LinkedList<Campesino>();
	
	public Agronomo(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula);
		this.terreno = terreno;
	}
}
