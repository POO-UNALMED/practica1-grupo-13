package gestorAplicacion.empleado;
import gestorAplicacion.terreno.*;
import java.util.*;

public class Campesino extends Empleado{
	private Cultivo cultivo;
	private Administrador administrador;
	public Campesino(String nombre, int sueldo, int cedula, Administrador administrador) {
		super(nombre, sueldo, cedula);
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
