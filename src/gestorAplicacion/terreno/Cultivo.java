package gestorAplicacion.terreno;
import java.util.*;
import java.lang.Comparable; //Interface Comparable

import gestorAplicacion.Amenaza;
// import gestorAplicacion.empleado.Administrador; //Esto se debe quitar 

public class Cultivo {
	
	public static LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();// Faltan crear funciones-- Sergio 
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
	
	public Cultivo(String tipoCultivo, int tamano, double nitrogeno, double potasio, double fosforo, double irrigacion, Terreno terreno) {
		this.tipoCultivo = tipoCultivo; 
		this.tamano = tamano; 
		this.nitrogeno = nitrogeno; 
		this.potasio = potasio; 
		this.fosforo = fosforo; 
		this.irrigacion = irrigacion;
		this.terreno = terreno;
		this.agregarCultivo(this); //Agrego cultivos cada vez que se cree uno
	}
	
	// Se le pide al usuario ingresar el tipo de cultivo que quiere sembrar y el tamaño(dentro del Main), si es papa se ejecuta esta funcion o una de las siguientes:
	// Se agrega el cultivo a el arreglo "cultivos" en terreno
	// Comprobar capacidad en el Main
	
	public static void crearCultivo(String tipo, int tamañoDeseado, Terreno terreno) {
		if (tipo.equals("papa") && terreno.getCultivoPermitido().contains("papa") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("papa") == false ) {
			Cultivo.crearPapa(tamañoDeseado, terreno);
		}
		else if (tipo.equals("sandia") && terreno.getCultivoPermitido().contains("sandia") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("sandia") == false) {
			Cultivo.crearSandia(tamañoDeseado, terreno);
		}
		else if (tipo.equals("mango") && terreno.getCultivoPermitido().contains("mango") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("mango") == false) {
			Cultivo.crearMango(tamañoDeseado, terreno);
		}
		else if (tipo.equals("banano") && terreno.getCultivoPermitido().contains("banano") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("banano") == false) {
			Cultivo.crearBanano(tamañoDeseado, terreno);
		}
		else if (tipo.equals("fresa") && terreno.getCultivoPermitido().contains("fresa") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("fresa") == false) {
			Cultivo.crearFresa(tamañoDeseado, terreno);
		}	
	}
	
	public static Cultivo crearPapa(int tamañoDeseado, Terreno terreno) {    
		Cultivo papa = new Cultivo ("papa", tamañoDeseado, 0.3, 0.4, 0.4, 0.2, terreno);
		terreno.agregarCultivo(papa);
		terreno.agregarTipo("papa");
		return (papa);
	}
	public static Cultivo crearSandia(int tamañoDeseado, Terreno terreno) {
		Cultivo sandia = new Cultivo ("sandia", tamañoDeseado, 0.1, 0.3, 0.5, 0.5, terreno);
		terreno.agregarCultivo(sandia);
		terreno.agregarTipo("sandia");
		return (sandia);
	}
	public static Cultivo crearMango(int tamañoDeseado, Terreno terreno) {
		Cultivo mango = new Cultivo ("mango", tamañoDeseado, 0.5, 0.3, 0.2, 0.3, terreno);
		terreno.agregarCultivo(mango);
		terreno.agregarTipo("mango");
		return (mango);
	}
	public static Cultivo crearBanano(int tamañoDeseado, Terreno terreno) {
		Cultivo banano = new Cultivo ("banano", tamañoDeseado, 0.3, 0.1, 0.2, 0.6, terreno);
		terreno.agregarCultivo(banano);
		terreno.agregarTipo("banano");
		return (banano);
	}
	public static Cultivo crearFresa(int tamañoDeseado, Terreno terreno) {
		Cultivo fresa = new Cultivo ("fresa", tamañoDeseado, 0.3, 0.4, 0.5, 0.4, terreno);
		terreno.agregarCultivo(fresa);
		terreno.agregarTipo("fresa");
		return (fresa);
	}
	
	//Funciones relacionadas a la produccion
	public void sembrar(int cantidad) {
		this.cantSembrada += cantidad;
	}
	public void cultivar() {
		this.cantProducida += this.cantSembrada;
	}
	
	public Amenaza getAmenaza() {
		return (this.amenaza);
	}
	public void setAmenaza(Amenaza amenazaNueva) {
		this.amenaza = amenazaNueva;
	}
	public int getTamano() {
		return (this.tamano);
	}
	
	
	public String getTipoCultivo() { //Sergio 
		return this.tipoCultivo;
	}
	
	public void agregarCultivo(Cultivo cultivo) { //Sergio
		cultivos.add(cultivo);
	}
	public double getCantSembrada(){
		return (this.cantSembrada);
	}
	public void setCantSembrada(int cantidadPlaga) {
		this.cantSembrada -= cantidadPlaga;
		if (this.cantSembrada < 0) {
			this.cantSembrada = 0;
		}
	}
	public static LinkedList<Cultivo>  getCultivos(){
		return (cultivos);
	}
	
	
//	public String toString() {
//		return ("Cultivo de +" this.tipoCultivo + ", con tamaño de " + this.tamano);
//	}
	
}
