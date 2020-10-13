package gestorAplicacion.empleado;
import java.util.*;
import gestorAplicacion.terreno.*;

public class Administrador extends Empleado{
	private static boolean activo = false;
	private static LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private static LinkedList<Campesino> campesinos = new LinkedList<Campesino>();
	public Administrador(String nombre, int sueldo, int cedula) {
		super(nombre, sueldo, cedula);
	}
	public void renunciar() {System.out.println("Hola");} //abstaracta 
	public void asignacion() {}
	public void despedir() {
		Scanner Sc = new Scanner(System.in);
		for(int i = 0; i <Administrador.getCampesinos().size(); i++) {
			System.out.println((i+1) + ". " + Administrador.getCampesinos().get(i).getNombre() + " con cédula: " + Administrador.getCampesinos().get(i).getCedula());
		}
		int j = Sc.nextInt();
		Campesino.renunciar(j-1);
	}
	public void examinarCultivos() {} //Examina los cultivos presentes en todos los terrenos 
	public void contratar(String nombre, int sueldo, int cedula) {
		Campesino campesino = new Campesino(nombre, sueldo, cedula, this); //el admin invoca el contratar
		agregarCampesinos(campesino);
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
	public static void main(String args[]) {
		Scanner Sc = new Scanner(System.in);
		Administrador admin = new Administrador("Jairo", 10, 10);
	}
}