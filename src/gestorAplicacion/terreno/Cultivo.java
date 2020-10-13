package gestorAplicacion.terreno;
import java.util.*;

import gestorAplicacion.Amenaza;
import gestorAplicacion.empleado.Administrador;

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
	// Comprobar capacidad en el Main
	
	public static void crearCultivo(String tipo, int tama�oDeseado, Terreno terreno) {
		if (tipo.equals("papa") && terreno.getCultivoPermitido().contains("papa") && terreno.getTamanoDisponible() >= tama�oDeseado) {
			Cultivo.crearPapa(tama�oDeseado, terreno);
		}
		else if (tipo.equals("sandia") && terreno.getCultivoPermitido().contains("sandia") && terreno.getTamanoDisponible() >= tama�oDeseado) {
			Cultivo.crearSandia(tama�oDeseado, terreno);
		}
		else if (tipo.equals("mango") && terreno.getCultivoPermitido().contains("mango") && terreno.getTamanoDisponible() >= tama�oDeseado) {
			Cultivo.crearMango(tama�oDeseado, terreno);
		}
		else if (tipo.equals("banano") && terreno.getCultivoPermitido().contains("banano") && terreno.getTamanoDisponible() >= tama�oDeseado ) {
			Cultivo.crearBanano(tama�oDeseado, terreno);
		}
		else if (tipo.equals("fresa") && terreno.getCultivoPermitido().contains("fresa") && terreno.getTamanoDisponible() >= tama�oDeseado) {
			Cultivo.crearFresa(tama�oDeseado, terreno);
		}	
	}
	
	public static Cultivo crearPapa(int tama�oDeseado, Terreno terreno) {    
		Cultivo papa = new Cultivo ("papa", tama�oDeseado, 0.3, 0.4, 0.4, 0.2, terreno);
		terreno.agregarCultivo(papa);
		terreno.agregarTipo("papa");
		Administrador.agregarCultivos(papa);
		return (papa);
	}
	public static Cultivo crearSandia(int tama�oDeseado, Terreno terreno) {
		Cultivo sandia = new Cultivo ("sandia", tama�oDeseado, 0.1, 0.3, 0.5, 0.5, terreno);
		terreno.agregarCultivo(sandia);
		terreno.agregarTipo("sandia");
		Administrador.agregarCultivos(sandia);
		return (sandia);
	}
	public static Cultivo crearMango(int tama�oDeseado, Terreno terreno) {
		Cultivo mango = new Cultivo ("mango", tama�oDeseado, 0.5, 0.3, 0.2, 0.3, terreno);
		terreno.agregarCultivo(mango);
		terreno.agregarTipo("mango");
		Administrador.agregarCultivos(mango);
		return (mango);
	}
	public static Cultivo crearBanano(int tama�oDeseado, Terreno terreno) {
		Cultivo banano = new Cultivo ("banano", tama�oDeseado, 0.3, 0.1, 0.2, 0.6, terreno);
		terreno.agregarCultivo(banano);
		terreno.agregarTipo("banano");
		Administrador.agregarCultivos(banano);
		return (banano);
	}
	public static Cultivo crearFresa(int tama�oDeseado, Terreno terreno) {
		Cultivo fresa = new Cultivo ("fresa", tama�oDeseado, 0.3, 0.4, 0.5, 0.4, terreno);
		terreno.agregarCultivo(fresa);
		terreno.agregarTipo("fresa");
		Administrador.agregarCultivos(fresa);
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
	
//	public String toString() {
//		return ("Cultivo de +" this.tipoCultivo + ", con tama�o de " + this.tamano);
//	}
	
}
