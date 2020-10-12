package gestorAplicacion.empleado;

import gestorAplicacion.terreno.*;

public class Campesino extends Empleado{
	private Cultivo cultivo; //en el que trabja
	private Administrador administrador; //Se podría quitar
	
	public Campesino(String nombre, int sueldo, int cedula, Cultivo cultivo, Administrador administrador) {
		super(nombre, sueldo, cedula);
		this.cultivo = cultivo; this.administrador = administrador; 
	}
	
	public void renunciar() {} //abstaracta 
	//funciones
}
