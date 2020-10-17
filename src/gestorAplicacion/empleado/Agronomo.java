package gestorAplicacion.empleado;
import java.util.LinkedList;
import java.util.Scanner;

import gestorAplicacion.terreno.*;

public class Agronomo extends Empleado{
	private static LinkedList<Cultivo> agronomos = new LinkedList<Cultivo>();
	public Agronomo(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula, terreno);
	}
	public void examinarCultivos() {} //Examina los cultivos presentes en todos los terrenos 
	public LinkedList<Cultivo> getCultivos(){
		return cultivos;
	}
	public void agregarCampesinos(Campesino campesino) {
		campesinos.add(campesino);
	}
	public  LinkedList<Campesino> getCampesinos(){
		return campesinos;
	}
}
