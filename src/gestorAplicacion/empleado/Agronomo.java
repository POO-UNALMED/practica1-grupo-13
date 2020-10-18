package gestorAplicacion.empleado;
import java.util.LinkedList;
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
		double x = Math.random();
		int y = (int) Math.random()*agronomos.size();
		if ((x < 0.15) && (agronomos.size() > 0)) {
			System.out.println(agronomos.get(y));
			System.out.println("Ha renunciado.");
		}
	}
	public void renunciar(int opcionElegida) {
		System.out.println(agronomos.get(opcionElegida));
		System.out.println("Ha renunciado.");
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
		return("El agronomo con:" + "\n " + "Nombre: " + this.getNombre() + "\n" + "Cedula: " + this.getCedula() + "\n" +
				"Sueldo: " + this.getSueldo() + "Vinculado a terreno: " + this.getTerreno().getId());
	}
	public static LinkedList<Agronomo> getAgronomos(){
		return agronomos;
	}
}