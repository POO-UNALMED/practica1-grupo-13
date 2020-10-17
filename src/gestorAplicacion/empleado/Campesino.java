package gestorAplicacion.empleado;
import gestorAplicacion.terreno.*;
import java.util.*;

public class Campesino extends Empleado{
	public Campesino(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula, terreno);
		terreno.agregarCampesino(this);
	}
	public void renunciar() {
		double x = Math.random();
		if ((x < 0.2) && (Terreno.getTerreno(). > 0)) {
			int numero = (int) (Math.random()*Administrador.getCampesinos().size());
			String nombre = Administrador.getCampesinos().get(numero).getNombre();
			Administrador.getCampesinos().remove(numero);
			System.out.println("El campesino " + nombre + " ha renunciado.");
		}
	}
	public static void renunciar(int j) {
		if(Administrador.getCampesinos().size() > 0) {
			Administrador.getCampesinos().remove(j);
		}
		else {
			System.out.println("Debe contratar primero campesinos pirobo bobo hpta");
		}
	}
}
 