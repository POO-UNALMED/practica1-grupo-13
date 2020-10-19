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
	private static int papaProducida;
	private static int sandiaProducida;
	private static int mangoProducido;
	private static int bananoProducido;
	private static int fresaProducida;
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
	
	// Se le pide al usuario ingresar el tipo de cultivo que quiere sembrar y el tama�o(dentro del Main), si es papa se ejecuta esta funcion o una de las siguientes:
	// Se agrega el cultivo a el arreglo "cultivos" en terreno
	// Comprobar capacidad en el Main
	
	public static String crearCultivo(String tipo, int tama�oDeseado, Terreno terreno) {
		if (tipo.equals("papa") && terreno.getCultivoPermitido().contains("papa") && terreno.getTamanoDisponible() >= tama�oDeseado && terreno.getTipos().contains("papa") == false ) {
			Cultivo.crearPapa(tama�oDeseado, terreno);
			return ("Se ha creado exitosamente");
		}
		else if (tipo.equals("sandia") && terreno.getCultivoPermitido().contains("sandia") && terreno.getTamanoDisponible() >= tama�oDeseado && terreno.getTipos().contains("sandia") == false) {
			Cultivo.crearSandia(tama�oDeseado, terreno);
			return ("Se ha creado exitosamente");
		}
		else if (tipo.equals("mango") && terreno.getCultivoPermitido().contains("mango") && terreno.getTamanoDisponible() >= tama�oDeseado && terreno.getTipos().contains("mango") == false) {
			Cultivo.crearMango(tama�oDeseado, terreno);
			return ("Se ha creado exitosamente");
		}
		else if (tipo.equals("banano") && terreno.getCultivoPermitido().contains("banano") && terreno.getTamanoDisponible() >= tama�oDeseado && terreno.getTipos().contains("banano") == false) {
			Cultivo.crearBanano(tama�oDeseado, terreno);
			return ("Se ha creado exitosamente");
		}
		else if (tipo.equals("fresa") && terreno.getCultivoPermitido().contains("fresa") && terreno.getTamanoDisponible() >= tama�oDeseado && terreno.getTipos().contains("fresa") == false) {
			Cultivo.crearFresa(tama�oDeseado, terreno);
			return ("Se ha creado exitosamente");
		}else{
			return ("Este cultivo ya estaba creado en este terreno o este tipo no es valido");
		}
			
	}
	
	public static void crearPapa(int tama�oDeseado, Terreno terreno) {    
		Cultivo papa = new Cultivo ("papa", tama�oDeseado, 0.3, 0.4, 0.4, 0.2, terreno);
		terreno.agregarCultivo(papa);
		terreno.agregarTipo("papa");
	}
	public static void crearSandia(int tama�oDeseado, Terreno terreno) {
		Cultivo sandia = new Cultivo ("sandia", tama�oDeseado, 0.1, 0.3, 0.5, 0.5, terreno);
		terreno.agregarCultivo(sandia);
		terreno.agregarTipo("sandia");
	}
	public static void crearMango(int tama�oDeseado, Terreno terreno) {
		Cultivo mango = new Cultivo ("mango", tama�oDeseado, 0.5, 0.3, 0.2, 0.3, terreno);
		terreno.agregarCultivo(mango);
		terreno.agregarTipo("mango");
	}
	public static void crearBanano(int tama�oDeseado, Terreno terreno) {
		Cultivo banano = new Cultivo ("banano", tama�oDeseado, 0.3, 0.1, 0.2, 0.6, terreno);
		terreno.agregarCultivo(banano);
		terreno.agregarTipo("banano");
	}
	public static void crearFresa(int tama�oDeseado, Terreno terreno) {
		Cultivo fresa = new Cultivo ("fresa", tama�oDeseado, 0.3, 0.4, 0.5, 0.4, terreno);
		terreno.agregarCultivo(fresa);
		terreno.agregarTipo("fresa");
	}
	
	public static void setPapaProducida(int papaRecolectada) {
		papaProducida += papaRecolectada;
	}
	public static void setSandiaProducida(int sandiaRecolectada) {
		sandiaProducida += sandiaRecolectada;
	}
	public static void setMangoProducido(int mangoRecolectado) {
		mangoProducido += mangoRecolectado;
	}
	public static void setBananoProducido(int bananoRecolectado) {
		bananoProducido += bananoRecolectado;
	}
	public static void setFresaProducida(int fresaRecolectada) {
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
	public static LinkedList<Cultivo>  getCultivos(){
		return (cultivos);
	}
	public Terreno getTerreno() {
		return (this.terreno);
	}
	
	public static String mostrarCultivos() {
		String muestra = "";
		for (Integer i = 0; i < cultivos.size(); i ++) {
			muestra = muestra + (i + 1) + ". " + "El cultivo de " + cultivos.get(i).tipoCultivo + ". En el terreno con id: " + cultivos.get(i).terreno.getId() + "\n";
		}
		return (muestra);
	}

	public String toString() {
		if(this.getAmenaza() != null) {
			return "El cultivo de tipo " + this.getTipoCultivo() + " ubicado en el terreno " + this.getTerreno().getId() + " se encuentra bajo amenaza.\n " +
		    "La amenaza que lo ataca es es de tipo " + this.getAmenaza().getTipo();
		}
		else {
			return "El cultivo de tipo " + this.getTipoCultivo() + " ubicado en el terreno " + this.getTerreno().getId() + " no se encuentra bajo amenaza";
		}
	}
}
