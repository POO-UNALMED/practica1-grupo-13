package gestorAplicacion.empleado;
import java.util.LinkedList;
import java.util.Scanner;

import gestorAplicacion.terreno.*;

public class Agronomo extends Empleado{
	private Terreno terreno; //Terreno en el que trabaja
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private LinkedList<Campesino> campesinos = new LinkedList<Campesino>();
	
	public Agronomo(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula);
		this.terreno = terreno; 
	}
	public void asignacion() {}
	public void despedir() {
		for(int i = 0; i <Administrador.getCampesinos().size(); i++) {
			System.out.println((i+1) + ". " + Administrador.getCampesinos().get(i).getNombre() + " con c�dula: " + Administrador.getCampesinos().get(i).getCedula());
		}
		int j = Sc.nextInt();
		Campesino.renunciar(j-1);
	}
	public void examinarCultivos() {} //Examina los cultivos presentes en todos los terrenos 
	public void contratar(String nombre, int sueldo, int cedula) {
		Campesino campesino = new Campesino(nombre, sueldo, cedula, this); //el admin invoca el contratar
		agregarCampesinos(campesino);
	}
	public void agregarCultivos(Cultivo cultivo) {
		cultivos.add(cultivo);
	}
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
