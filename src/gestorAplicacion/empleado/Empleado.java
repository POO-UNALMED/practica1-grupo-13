package gestorAplicacion.empleado;

public abstract class Empleado  {
	protected String nombre;
	protected int sueldo;
	protected int cedula;
	
	public Empleado(String nombre, int sueldo, int cedula) {
		this.nombre = nombre; this.sueldo = sueldo; this.cedula = cedula;
	}
	abstract public void renunciar();
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public int getSueldo() {
		return sueldo;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
}
