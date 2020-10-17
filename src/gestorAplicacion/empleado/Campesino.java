package gestorAplicacion.empleado;
import gestorAplicacion.terreno.*;
import java.util.*;

public class Campesino extends Empleado{
	private Terreno terreno;
	public Campesino(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula);
		this.terreno = terreno;
		terreno.agregarCampesino(this);
	}
	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}
	public Terreno getTerreno() {
		return terreno;
	}
	public void renunciar() {
		double x = Math.random();
		if ((x < 0.2) && (Administrador.getCampesinos().size() > 0)) {
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
 