package gestorAplicacion.terreno;

import gestorAplicacion.Amenaza;

public class Cultivo {
	private String tipoCultivo;
	private int tamano;
	private Amenaza amenaza;
	private Terreno terreno;
	private double cantProducida;
	private double cantSembrada;
	private double nitrogeno;
	private double potasio;
	private double fosforo;
	private double irrigacion;
	private int cantCampesino;
	private boolean estadoAmenaza;
	
	public Cultivo(String tipoCultivo, int tamano, double nitrogeno, double potasio, double fosforo, double irrigacion) {
		this.tipoCultivo = tipoCultivo; 
		this.tamano = tamano; 
		this.nitrogeno = nitrogeno; 
		this.potasio = potasio; 
		this.fosforo = fosforo; 
		this.irrigacion = irrigacion;
	}
	
	// Se le pide al usuario ingresar el tipo de cultivo que quiere sembrar (dentro del Main), si es papa se ejecuta esta funcion o una de las siguientes:
	static Cultivo crearPapa(int tama�oDeseado) {    
		return (new Cultivo ("papa", tama�oDeseado, 0.3, 0.4, 0.4, 0.2));
	}
	static Cultivo crearSandia(int tama�oDeseado) {
		return (new Cultivo ("sandia", tama�oDeseado, 0.1, 0.3, 0.5, 0.5));
	}
	static Cultivo crearMango(int tama�oDeseado) {
		return (new Cultivo ("mango", tama�oDeseado, 0.5, 0.3, 0.2, 0.3));
	}
	static Cultivo crearBanano(int tama�oDeseado) {
		return (new Cultivo ("banano", tama�oDeseado, 0.3, 0.1, 0.2, 0.6));
	}
	static Cultivo crearFresa(int tama�oDeseado) {
		return (new Cultivo ("fresa", tama�oDeseado, 0.3, 0.4, 0.5, 0.4));
	}
	
	//Funciones relacionadas a la produccion
	public void sembrar(int cantidad) {
		this.cantSembrada += cantidad;
	}
	public void cultivar() {
		this.cantProducida += this.cantSembrada;
	}
}
