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
	
	public Cultivo(String tipoCultivo, int tamano, double nitrogeno, double potasio, double fosforo, double irrigacion, Terreno terreno) {
		this.tipoCultivo = tipoCultivo; 
		this.tamano = tamano; 
		this.nitrogeno = nitrogeno; 
		this.potasio = potasio; 
		this.fosforo = fosforo; 
		this.irrigacion = irrigacion;
		this.terreno = terreno;
	}
	
	// Se le pide al usuario ingresar el tipo de cultivo que quiere sembrar y el tama�o(dentro del Main), si es papa se ejecuta esta funcion o una de las siguientes:
	// Se agrega el cultivo a el arreglo "cultivos" en terreno
	static Cultivo crearPapa(int tama�oDeseado, Terreno terreno) {    
		Cultivo papa = new Cultivo ("papa", tama�oDeseado, 0.3, 0.4, 0.4, 0.2, terreno);
		terreno.agregarCultivo(papa);
		return (papa);
	}
	static Cultivo crearSandia(int tama�oDeseado, Terreno terreno) {
		Cultivo sandia = new Cultivo ("sandia", tama�oDeseado, 0.1, 0.3, 0.5, 0.5, terreno);
		terreno.agregarCultivo(sandia);
		return (sandia);
	}
	static Cultivo crearMango(int tama�oDeseado, Terreno terreno) {
		Cultivo mango = new Cultivo ("mango", tama�oDeseado, 0.5, 0.3, 0.2, 0.3, terreno);
		terreno.agregarCultivo(mango);
		return (mango);
	}
	static Cultivo crearBanano(int tama�oDeseado, Terreno terreno) {
		Cultivo banano = new Cultivo ("banano", tama�oDeseado, 0.3, 0.1, 0.2, 0.6, terreno);
		terreno.agregarCultivo(banano);
		return (banano);
	}
	static Cultivo crearFresa(int tama�oDeseado, Terreno terreno) {
		Cultivo fresa = new Cultivo ("fresa", tama�oDeseado, 0.3, 0.4, 0.5, 0.4, terreno);
		terreno.agregarCultivo(fresa);
		return (fresa);
	}
	
	//Funciones relacionadas a la produccion
	public void sembrar(int cantidad) {
		this.cantSembrada += cantidad;
	}
	public void cultivar() {
		this.cantProducida += this.cantSembrada;
	}
}
