package gestorAplicacion.terreno;
import gestorAplicacion.empleado.*;

import java.util.*;

public class Terreno{
	private final String id; //Nuestro final
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private LinkedList<String> tipos = new LinkedList<String>(); //Tipos de cultivo presentes en el terreno 
	private LinkedList<String> cultivoPermitido = new LinkedList<String>();
	private LinkedList<Campesino> campesinos = new LinkedList<Campesino>(); //Campesinos que tabajan en el terreno
	private static LinkedList<Terreno> terrenosTotales = new LinkedList<Terreno>(); // Se usa para mostrar al usuario todos en los que puede sembrar
	private Agronomo agronomo; //Agrónomo que trabaja en el terreno
	private int tamano;
	private int tamanoDisponible;
	private double nitrogenoDisponible;
	private double potasioDisponible;
	private double fosforoDisponible;
	private double irrigacionActual;
	
	public Terreno(String id, int tamano, double nitrogenoDisponible, double potasioDisponible, double fosforoDisponible, double irrigacionActual) {
		this.id = id; 
		this.tamano = tamano;
		this.nitrogenoDisponible = nitrogenoDisponible;
		this.potasioDisponible = potasioDisponible; 
		this.fosforoDisponible = fosforoDisponible; 
		this.irrigacionActual = irrigacionActual;
		this.tamanoDisponible = tamano;
		terrenosTotales.add(this);       //Agrego terreno creado
	}
	
	public Terreno(String id, int tamano) {   //Debe ser estática !!!
		this(id, tamano, Math.random(), Math.random(), Math.random(), Math.random());//Administrador utiliza este
		// ***this.getCultivoPermitido()*** Necesitamos decir para cuáles cultivos es apropiado cada vez que se cree un terreno
	}
	
	
	//solicitar al usuario el id del terreno que quiere crear
	
	public LinkedList<String> getCultivoPermitido() { //Se ejecuta en cultivo y en funciones de campesino
		if(nitrogenoDisponible >= 0.3 && potasioDisponible >= 0.4 && fosforoDisponible >= 0.4 && irrigacionActual >= 0.2) {
			if(cultivoPermitido.contains("papa") == false) {
				cultivoPermitido.add("papa");
			}
		}
		if(nitrogenoDisponible >= 0.1 && potasioDisponible >= 0.3 && fosforoDisponible >= 0.5 && irrigacionActual >= 0.5) {
			if(cultivoPermitido.contains("sandia") == false) {
				cultivoPermitido.add("sandia");
			}
		}
		if(nitrogenoDisponible >= 0.5 && potasioDisponible >= 0.3 && fosforoDisponible >= 0.2 && irrigacionActual >= 0.3) {
			if(cultivoPermitido.contains("mango") == false) {
				cultivoPermitido.add("mango");
			}
		}
		if(nitrogenoDisponible >= 0.3 && potasioDisponible >= 0.1 && fosforoDisponible >= 0.2 && irrigacionActual >= 0.6) {
			if(cultivoPermitido.contains("banano") == false) {
				cultivoPermitido.add("banano");
			}
		}
		if(nitrogenoDisponible >= 0.3 && potasioDisponible >= 0.4 && fosforoDisponible >= 0.5 && irrigacionActual >= 0.4) {
			if(cultivoPermitido.contains("fresa") == false) {
				cultivoPermitido.add("fresa");
			}
		}
		
		return cultivoPermitido;
	}
	
	
	//Cultivo papa = new Cultivo ("papa", tamañoDeseado, 0.3, 0.4, 0.4, 0.2, terreno);
	//Cultivo sandia = new Cultivo ("sandia", tamañoDeseado, 0.1, 0.3, 0.5, 0.5, terreno);
	//Cultivo mango = new Cultivo ("mango", tamañoDeseado, 0.5, 0.3, 0.2, 0.3, terreno);
	//Cultivo banano = new Cultivo ("banano", tamañoDeseado, 0.3, 0.1, 0.2, 0.6, terreno);
	//Cultivo fresa = new Cultivo ("fresa", tamañoDeseado, 0.3, 0.4, 0.5, 0.4, terreno);
	
	// set cultivo

	public void agregrarCultivoP(String cultivoP) { //cultivoPermitido
		this.cultivoPermitido.add(cultivoP);
	}
	
	public LinkedList<Campesino> getCampesinos(){
		return this.campesinos;
	}
	public void agregarCampesino(Campesino campesino) {
		this.campesinos.add(campesino);
	}
	
	public LinkedList<String> getTipos(){
		return this.tipos;
	}
	public void agregarTipo(String tipo) {
		this.tipos.add(tipo);
	}
	
	public LinkedList<Cultivo> getCultivos(){
		return this.cultivos;
	}
	public void agregarCultivo(Cultivo cultivo) {
		this.cultivos.add(cultivo);
		tamanoDisponible -= cultivo.getTamano();
	}
	
	public static LinkedList<Terreno> getTerreno(){
		return terrenosTotales;
	}
	
	public String cultivosPermitidos() { //se utiliza en cultivo 
		ListIterator iterador = cultivoPermitido.listIterator();
		StringBuffer lista = new StringBuffer("Los cultivos que permite el terreno son:\n");
		while(iterador.hasNext()) {
			String tipo = (String)iterador.next();
			lista.append(tipo + "\n");
		}
		return lista.toString();
	}
	
	public int getTamanoDisponible() {
		return tamanoDisponible;
	}
	public Agronomo getAgronomo() {
		return this.agronomo;
	}
	public void setAgronomo(Agronomo agronomo) {
		this.agronomo = agronomo;
	}
	public String getId() {
		return this.id;
	}
	public static String mostrarTerrenos() {       //saca el linkedList terrenosTotales, y le muestra al usuario sus ids
		String muestra = "";
		for (Integer i = 0; i < terrenosTotales.size(); i ++){
			muestra = muestra + "Opcion " + (i+1) + ": "+ terrenosTotales.get(i).getId() + "\n";
		}
		return(muestra);
	}
	
}
