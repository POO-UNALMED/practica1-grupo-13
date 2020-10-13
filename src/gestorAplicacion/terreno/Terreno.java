package gestorAplicacion.terreno;

import java.util.*;

public class Terreno {
	private int id;
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private LinkedList<String> tipos = new LinkedList<String>();
	private LinkedList<String> cultivoPermitido = new LinkedList<String>();
	private int tamano;
	private int tamanoDisponible;
	private double nitrogenoDisponible;
	private double potasioDisponible;
	private double fosforoDisponible;
	private double irrigacionActual;
	
	public Terreno(int id, int tamano, double nitrogenoDisponible, double potasioDisponible, double fosforoDisponible, double irrigacionActual) {
		this.id = id; 
		this.tamano = tamano;
		this.nitrogenoDisponible = nitrogenoDisponible;
		this.potasioDisponible = potasioDisponible; 
		this.fosforoDisponible = fosforoDisponible; 
		this.irrigacionActual = irrigacionActual;
	}
	
	public Terreno(int id, int tamano) {
		this(id, tamano, Math.random(), Math.random(), Math.random(), Math.random()); //Administrador utiliza este
		
		// ***this.getCultivoPermitido()*** Necesitamos decir para cuáles cultivos es apropiado cada vez que se cree un terreno
	}
	
	
	//solicitar al usuario el id del terreno que quiere crear
	public void agregrarCultivoP(String cultivoP) { //cultivoPermitido
		this.cultivoPermitido.add(cultivoP);
	}
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
	public int getTamanoDisponible() {
		return tamanoDisponible;
	}
	public void agregarCultivo(Cultivo cultivo) {
		this.cultivos.add(cultivo);
		tamanoDisponible -= cultivo.getTamano();
	}
	public void agregarTipo(String tipo) {
		this.tipos.add(tipo);
	}
	
}
