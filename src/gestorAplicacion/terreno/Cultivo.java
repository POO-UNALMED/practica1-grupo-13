package gestorAplicacion.terreno;
import java.util.*;
import java.lang.Comparable; //Interface Comparable

import gestorAplicacion.Amenaza;
// import gestorAplicacion.empleado.Administrador; //Esto se debe quitar 

public class Cultivo {
	
	private static LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();// Faltan crear funciones-- Sergio 
	private String tipoCultivo;
	private int tamano;
	private Amenaza amenaza;
	private Terreno terreno;
	private static double papaProducida;
	private static double sandiaProducida;
	private static double mangoProducido;
	private static double bananoProducido;
	private static double fresaProducida;
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
	
	public static void crearPapa(int tamañoDeseado, Terreno terreno) {    
		Cultivo papa = new Cultivo ("papa", tamañoDeseado, 0.3, 0.4, 0.4, 0.2, terreno);
		terreno.agregarCultivo(papa);
		terreno.agregarTipo("papa");
	}
	public static void crearSandia(int tamañoDeseado, Terreno terreno) {
		Cultivo sandia = new Cultivo ("sandia", tamañoDeseado, 0.1, 0.3, 0.5, 0.5, terreno);
		terreno.agregarCultivo(sandia);
		terreno.agregarTipo("sandia");
	}
	public static void crearMango(int tamañoDeseado, Terreno terreno) {
		Cultivo mango = new Cultivo ("mango", tamañoDeseado, 0.5, 0.3, 0.2, 0.3, terreno);
		terreno.agregarCultivo(mango);
		terreno.agregarTipo("mango");
	}
	public static void crearBanano(int tamañoDeseado, Terreno terreno) {
		Cultivo banano = new Cultivo ("banano", tamañoDeseado, 0.3, 0.1, 0.2, 0.6, terreno);
		terreno.agregarCultivo(banano);
		terreno.agregarTipo("banano");
	}
	public static void crearFresa(int tamañoDeseado, Terreno terreno) {
		Cultivo fresa = new Cultivo ("fresa", tamañoDeseado, 0.3, 0.4, 0.5, 0.4, terreno);
		terreno.agregarCultivo(fresa);
		terreno.agregarTipo("fresa");
	}
	
	public static void setPapaProducida(double papaRecolectada) {
		papaProducida += papaRecolectada;
	}
	public static void setSandiaProducida(double sandiaRecolectada) {
		sandiaProducida += sandiaRecolectada;
	}
	public static void setMangoProducido(double mangoRecolectado) {
		mangoProducido += mangoRecolectado;
	}
	public static void setBananoProducido(double bananoRecolectado) {
		bananoProducido += bananoRecolectado;
	}
	public static void setFresaProducida(double fresaRecolectada) {
		fresaProducida += fresaRecolectada;
	}
	public static double getPapaProducida() {
		return (papaProducida);
	}
	public static double getSandiaProducida() {
		return (sandiaProducida);
	}
	public static double getMangoProducido() {
		return (mangoProducido);
	}
	public static double getBananoProducido() {
		return (bananoProducido);
	}
	public static double getFresaProducida() {
		return (fresaProducida);
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
	public static LinkedList<Cultivo>  getCultivos(){
		return (cultivos);
	}
	public Terreno getTerreno() {
		return (this.terreno);
	}
	
	public static String mostrarCultivos() {
		String muestra = "";
		for (Integer i = 0; i < cultivos.size(); i ++) {
			muestra = muestra + (i + 1) + ". " + "El cultivo de " + cultivos.get(i).tipoCultivo + ". En el terreno con id: " + cultivos.get(i).terreno.getId();
		}
		return (muestra);
	}

	
}
