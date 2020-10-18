package gestorAplicacion.empleado;

import gestorAplicacion.terreno.*;

public abstract class Empleado {
	protected String nombre;
	protected int sueldo;
	protected int cedula;
	protected Terreno terreno;

	public Empleado(String nombre, int sueldo, int cedula, Terreno terreno) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.cedula = cedula;
		this.terreno = terreno;
	}

	public Empleado(String nombre, int cedula, Terreno terreno) {
		this.nombre = nombre;
		this.sueldo = 1000000;
		this.cedula = cedula;
		this.terreno = terreno;
	}

	public abstract void renunciar();

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

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	public Terreno getTerreno() {
		return this.terreno;
	}
}
