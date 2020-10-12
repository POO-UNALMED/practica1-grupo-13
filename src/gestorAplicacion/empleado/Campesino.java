package gestorAplicacion.empleado;

import gestorAplicacion.terreno.*;
import java.util.*;

public class Campesino extends Empleado{
	private Cultivo cultivo; //en el que trabja
	private Administrador administrador; //Se podría quitar
	
	public Campesino(String nombre, int sueldo, int cedula, Cultivo cultivo, Administrador administrador) {
		super(nombre, sueldo, cedula);
		this.cultivo = cultivo; 
		this.administrador = administrador; 
	}
	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}
	public Cultivo getCultivo() {
		return cultivo;
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public Administrador getAdministrador() {
		return administrador;
	}
	public void renunciar(Campesino campesino) {
		campesino = null;
	}
	public void renunciaAleatoria(Campesino campesino) {
		double x = Math.random();
		if (x > 0.2) {
			campesino = null;
			System.out.println("El campesino: " + this.getNombre() + " ha renunciado.");
		}
	}
}
