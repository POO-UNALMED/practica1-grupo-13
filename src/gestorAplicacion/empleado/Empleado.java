package gestorAplicacion.empleado;

public class Empleado abstract { //tal vez sea abstracta 
	protected String nombre;
	protected int sueldo;
	protected int cedula;
	
	public Empleado(String nombre, int sueldo, int cedula) {
		this.nombre = nombre; this.sueldo = sueldo; this.cedula = cedula;
	}
	public void renunciar() {
	}
}
