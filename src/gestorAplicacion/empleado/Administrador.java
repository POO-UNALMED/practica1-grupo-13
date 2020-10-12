package gestorAplicacion.empleado;
import java.util.*;

import javax.xml.bind.Unmarshaller.Listener;

import gestorAplicacion.terreno.*;

public class Administrador extends Empleado{
	private static LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private static LinkedList<Campesino> campesinos = new LinkedList<Campesino>();
	public Administrador(String nombre, int sueldo, int cedula) {
		super(nombre, sueldo, cedula);
		this.campesinos = campesinos; 
		this.cultivos = cultivos;
	}
	
	public void renunciar() {System.out.println("Hola");} //abstaracta 
	public void Asignacion() {}
	public void Despedir() {}
	public void Contratar(String nombre, int sueldo, int cedula) {
		
	} //Nuevo (no está en el diagrama)
	public void ExaminarCultivos() {} //Examina los cultivos presentes en todos los terrenos 
	public static void main(String main[]) {
		Scanner Sc = new Scanner(System.in);
		
	}
}