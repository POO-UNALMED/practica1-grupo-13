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
	
	// Se le pide al usuario ingresar el tipo (dentro del Main), si es papa se ejecuta esta funcion o una de las siguientes:
	static Cultivo crearPapa(int tamaņoDeseado) {    
		return (new Cultivo ("papa", tamaņoDeseado, 0.3, 0.4, 0.4, 0.2));
	}
	static Cultivo crearSandia(int tamaņoDeseado) {
		return (new Cultivo ("sandia", tamaņoDeseado, 0.1, 0.3, 0.5, 0.5));
	}
	static Cultivo crearMango(int tamaņoDeseado) {
		return (new Cultivo ("mango", tamaņoDeseado, 0.5, 0.3, 0.2, 0.3));
	}
	static Cultivo crearBanano(int tamaņoDeseado) {
		return (new Cultivo ("banano", tamaņoDeseado, 0.3, 0.1, 0.2, 0.6));
	}
	static Cultivo crearFresa(int tamaņoDeseado) {
		return (new Cultivo ("fresa", tamaņoDeseado, 0.3, 0.4, 0.5, 0.4));
	}
	
	//Funciones relacionadas a la produccion
	
}
