package gestorAplicacion.empleado;
import java.util.LinkedList;
import gestorAplicacion.terreno.*;
import gestorAplicacion.*;

public class Agronomo extends Empleado{
	private static LinkedList<Agronomo> agronomos = new LinkedList<Agronomo>();
	public Agronomo() {	
	}
	public Agronomo(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula, terreno);
		terreno.setAgronomo(this);
		agronomos.add(this);
	}
	public static void erradicarAmenaza(Amenaza amenaza, Cultivo cultivo) {
		Pesticida pesticida = new Pesticida(amenaza);
		pesticida.matarAmenaza(cultivo);
	}
	public void renunciar() {
		double x = Math.random();
		int y = (int) Math.random()*agronomos.size();
		if ((x < 0.15) && (agronomos.size() > 0)) {
			System.out.println(agronomos.get(y));
			System.out.println("Ha renunciado.");
			agronomos.get(y).getTerreno().setAgronomo(null);
			agronomos.remove(y);
		}
	}
	public void renunciar(int opcionElegida) {
		System.out.println(agronomos.get(opcionElegida));
		System.out.println("Ha sido despedido.");
		agronomos.get(opcionElegida).getTerreno().setAgronomo(null);
		agronomos.remove(opcionElegida);
	}
	public static String mostrarAgronomos() {
		String muestra = ""; int contador = 1;
		for (Integer i = 0; i < agronomos.size(); i ++){
				muestra = muestra + (contador) + ". " + agronomos.get(i).getCedula()  + "\n";
		}
		return(muestra);
	}
	public String toString() {
		return("\n" + "El agronomo con:" + "\n" + "Nombre: " + this.getNombre() + "\n" + "Cedula: " + this.getCedula() + "\n" +
				"Sueldo: " + this.getSueldo() + "\n" + "Vinculado a terreno: " + this.getTerreno().getId());
	}
	public static LinkedList<Agronomo> getAgronomos(){
		return agronomos;
	}
}