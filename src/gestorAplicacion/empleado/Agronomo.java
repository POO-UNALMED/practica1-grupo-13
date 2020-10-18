package gestorAplicacion.empleado;
import java.util.LinkedList;
import java.util.Scanner;
import gestorAplicacion.terreno.*;

public class Agronomo extends Empleado{
	private static LinkedList<Agronomo> agronomos = new LinkedList<Agronomo>();
	public Agronomo(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula, terreno);
		terreno.setAgronomo(this);
		agronomos.add(this);
	}
	public void examinarCultivos() {} //Examina los cultivos presentes en todos los terrenos
	public void renunciar() {
	}
	public static String mostrarAgronomos() {
		String muestra = ""; int contador = 1;
		for (Integer i = 0; i < agronomos.size(); i ++){
				muestra = muestra + (contador) + ". " + agronomos.get(i).getCedula()  + "\n";
		}
		return(muestra);
	}
	public String toString() {
		return("El agronomo con:" + "\n " + "Nombre: " + this.getNombre() + "\n" + "Cedula: " + this.getCedula() + "\n" +
				"Sueldo: " + this.getSueldo() + "Vinculado a terreno: " + this.getTerreno().getId());
	}
}