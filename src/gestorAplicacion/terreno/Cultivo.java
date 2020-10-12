package gestorAplicacion.terreno;

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
	
	// Se le pide al usuario ingresar el tipo de cultivo que quiere sembrar y el tamaņo(dentro del Main), si es papa se ejecuta esta funcion o una de las siguientes:
	// Se agrega el cultivo a el arreglo "cultivos" en terreno
	// Comprobar capacidad en el Main
	
	public static void crearCultivo(String tipo, int tamaņoDeseado, Terreno terreno) {
		if (tipo.equals("papa") && terreno.getCultivoPermitido.contains("papa")) {
			Cultivo.crearPapa(tamaņoDeseado, terreno);
		}
		else if (tipo.equals("sandia") && terreno.getCultivoPermitido.contains("sandia")) {
			Cultivo.crearSandia(tamaņoDeseado, terreno);
		}
		else if (tipo.equals("mango") && terreno.getCultivoPermitido.contains("mango")) {
			Cultivo.crearMango(tamaņoDeseado, terreno);
		}
		else if (tipo.equals("banano") && terreno.getCultivoPermitido.contains("banano")) {
			Cultivo.crearBanano(tamaņoDeseado, terreno);
		}
		else if (tipo.equals("fresa") && terreno.getCultivoPermitido.contains("fresa")) {
			Cultivo.crearFresa(tamaņoDeseado, terreno);
		}	
	}
	
	public static Cultivo crearPapa(int tamaņoDeseado, Terreno terreno) {    
		Cultivo papa = new Cultivo ("papa", tamaņoDeseado, 0.3, 0.4, 0.4, 0.2, terreno);
		terreno.agregarCultivo(papa);
		terreno.agregarTipo("papa");
		Administrador.agregarCultivo(papa);
		return (papa);
	}
	public static Cultivo crearSandia(int tamaņoDeseado, Terreno terreno) {
		Cultivo sandia = new Cultivo ("sandia", tamaņoDeseado, 0.1, 0.3, 0.5, 0.5, terreno);
		terreno.agregarCultivo(sandia);
		terreno.agregarTipo("sandia");
		Administrador.agregarCultivo(sandia);
		return (sandia);
	}
	public static Cultivo crearMango(int tamaņoDeseado, Terreno terreno) {
		Cultivo mango = new Cultivo ("mango", tamaņoDeseado, 0.5, 0.3, 0.2, 0.3, terreno);
		terreno.agregarCultivo(mango);
		terreno.agregarTipo("mango");
		Administrador.agregarCultivo(mango);
		return (mango);
	}
	public static Cultivo crearBanano(int tamaņoDeseado, Terreno terreno) {
		Cultivo banano = new Cultivo ("banano", tamaņoDeseado, 0.3, 0.1, 0.2, 0.6, terreno);
		terreno.agregarCultivo(banano);
		terreno.agregarTipo("banano");
		Administrador.agregarCultivo(banano);
		return (banano);
	}
	public static Cultivo crearFresa(int tamaņoDeseado, Terreno terreno) {
		Cultivo fresa = new Cultivo ("fresa", tamaņoDeseado, 0.3, 0.4, 0.5, 0.4, terreno);
		terreno.agregarCultivo(fresa);
		terreno.agregarTipo("fresa");
		Administrador.agregarCultivo(fresa);
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
	
//	public String toString() {
//		return ("Cultivo de +" this.tipoCultivo + ", con tamaņo de " + this.tamano);
//	}
	
}
