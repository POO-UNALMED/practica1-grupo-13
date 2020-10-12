package gestorAplicacion.empleado;
import java.util.*;
import gestorAplicacion.terreno.*;

public class Administrador extends Empleado{
	private static LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private static LinkedList<Campesino> campesinos = new LinkedList<Campesino>();
	public Administrador(String nombre, int sueldo, int cedula) {
		super(nombre, sueldo, cedula);
	}
	
	public void renunciar() {System.out.println("Hola");} //abstaracta 
	public void Asignacion() {}
	public void Despedir() {}
	public void Contratar() {
		Scanner Sc = new Scanner(System.in);
		String nombre = Sc.next();
		int sueldo = Sc.nextInt();
		int cedula = Sc.nextInt();
		Campesino jaja = new Campesino(nombre, sueldo, cedula, admin);
	}
	public static void agregarCultivos(Cultivo cultivo) {
		cultivos.add(cultivo);
	}
	public static LinkedList<Cultivo> getCultivos(){
		return cultivos;
	}
	public static void agregarCampesinos(Campesino campesino) {
		campesinos.add(campesino);
	}
	public static LinkedList<Campesino> getCampesinos(){
		return campesinos;
	}
	public void ExaminarCultivos() {} //Examina los cultivos presentes en todos los terrenos 
	public static void main(String main[]) {
		Scanner Sc = new Scanner(System.in);
		Administrador admin = new Administrador(Sc.next(), Sc.nextInt(), Sc.nextInt());
	}
}