package gestorAplicacion.empleado;

import java.util.*;
import gestorAplicacion.terreno.*;

public class Administrador extends Empleado{
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	public LinkedList<Campesino> campesinos = new LinkedList<Campesino>();
	public Administrador(String nombre, int sueldo, int cedula, LinkedList<Campesino> campesinos, LinkedList<Cultivo> cultivos) {
		super(nombre, sueldo, cedula);
		this.campesinos = campesinos ; this.cultivos = cultivos;
	}
	
	public void renunciar() {} //abstaracta 
	public void Asignacion() {}
	public void Despedir() {}
	public void Contratar() {} //Nuevo (no está en el diagrama)
	public void ExaminarCultivos() {} //Examina los cultivos presentes en todos los terrenos 
}
