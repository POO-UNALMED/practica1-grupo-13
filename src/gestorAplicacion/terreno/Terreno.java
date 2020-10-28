package gestorAplicacion.terreno;

import gestorAplicacion.empleado.*;

import java.io.Serializable;
import java.util.*;

/**
 * Esta clase define objetos de tipo Terreno que tiene un id que no puede ser
 * modificado una vez es definido la lista de cultivos que estan sembrados en
 * el, lista del tipo de cultivos presentes en el terreno, la lista de los
 * cultivos que en el momento permite que sean cultivados (solo uno por tipo),
 * la lista de todas las instancias creadas, la lista de campesinos que estan
 * trabajando en el terreno, el agronomo que se encuentra trabajando en el
 * momento ademas posee un tamano en hectareas, el tamano disponible que le
 * queda para cultivar y los parametros de nutrientes con los que quedo al
 * momento de ser creado
 */
public class Terreno implements Serializable {
	// Atributos de la clase
	private final String id;
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();
	private LinkedList<String> tipos = new LinkedList<String>();
	private LinkedList<String> cultivoPermitido = new LinkedList<String>();
	private LinkedList<Campesino> campesinos = new LinkedList<Campesino>();
	// Usado para mostrar al usuario todos los terrenos creados
	private static LinkedList<Terreno> terrenosTotales = new LinkedList<Terreno>();
	private Agronomo agronomo;
	private int tamano;
	private int tamanoDisponible;
	private double nitrogenoDisponible;
	private double potasioDisponible;
	private double fosforoDisponible;
	private double irrigacionActual;

	/**
	 * Metodo constructor para crear una instancia de la clase Terreno define su id
	 * El tamano en hectareas que tiene, los parametros de nutrientes (entre 0 y 1)
	 * y la irrigacion que tiene (entre 0 y 1) agrega el terreno a la lista de
	 * terrenos creados
	 * 
	 * @param id                  El parametro id, representa un numero que
	 *                            identifica el terreno
	 * @param tamano              El parametro tamano representa el tamano en
	 *                            hectareas del terreno
	 * @param nitrogenoDisponible El parametro nitrogeno representa el nitrogeno que
	 *                            tiene el terrreno
	 * @param potasioDisponible   El parametro potasio representa el potasio que
	 *                            tiene el terrreno
	 * @param fosforoDisponible   El parametro fosforo representa el fosforo que
	 *                            tiene el terrreno
	 * @param irrigacionActual    El parametro irrigacion representa la irrigacion
	 *                            que tiene el terrreno
	 */
	public Terreno(String id, int tamano, double nitrogenoDisponible, double potasioDisponible,
			double fosforoDisponible, double irrigacionActual) {
		this.id = id;
		this.tamano = tamano;
		this.nitrogenoDisponible = nitrogenoDisponible;
		this.potasioDisponible = potasioDisponible;
		this.fosforoDisponible = fosforoDisponible;
		this.irrigacionActual = irrigacionActual;
		this.tamanoDisponible = tamano;
		terrenosTotales.add(this);
	}

	// Cierre del constructor
	/**
	 * Metodo constructor para crear una instancia de la clase de Terreno con
	 * parametros de nutrientes e irrigacion aleatorios
	 * 
	 * @param id     El parametro id, representa un numero que identifica el terreno
	 * @param tamano El parametro tamano representa el tamano en hectareas del
	 *               terreno
	 */
	public Terreno(String id, int tamano) {
		this(id, tamano, Math.random(), Math.random(), Math.random(), Math.random());
	}
	// Cierre del constructor

	/**
	 * Metodo que verifica si posee los parametros de nutrientes y nivel de
	 * irrigacion necesarios para cultivar el tipo de cultivo correspondiente (papa,
	 * sandia, mango, banano o fresa), si cumple con los requisitos, agrega a la
	 * lista cultivoPermitido el tipo si no estaba cultivado
	 * 
	 * @return cultivoPermitido, lista de los cultivos que se encuentran sembrados
	 *         en el tereno
	 */
	public LinkedList<String> getCultivoPermitido() {
		if (nitrogenoDisponible >= 0.3 && potasioDisponible >= 0.4 && fosforoDisponible >= 0.4
				&& irrigacionActual >= 0.2) {
			if (cultivoPermitido.contains("papa") == false) {
				cultivoPermitido.add("papa");
			}
		}
		if (nitrogenoDisponible >= 0.1 && potasioDisponible >= 0.3 && fosforoDisponible >= 0.5
				&& irrigacionActual >= 0.5) {
			if (cultivoPermitido.contains("sandia") == false) {
				cultivoPermitido.add("sandia");
			}
		}
		if (nitrogenoDisponible >= 0.5 && potasioDisponible >= 0.3 && fosforoDisponible >= 0.2
				&& irrigacionActual >= 0.3) {
			if (cultivoPermitido.contains("mango") == false) {
				cultivoPermitido.add("mango");
			}
		}
		if (nitrogenoDisponible >= 0.3 && potasioDisponible >= 0.1 && fosforoDisponible >= 0.2
				&& irrigacionActual >= 0.6) {
			if (cultivoPermitido.contains("banano") == false) {
				cultivoPermitido.add("banano");
			}
		}
		if (nitrogenoDisponible >= 0.3 && potasioDisponible >= 0.4 && fosforoDisponible >= 0.5
				&& irrigacionActual >= 0.4) {
			if (cultivoPermitido.contains("fresa") == false) {
				cultivoPermitido.add("fresa");
			}
		}

		return cultivoPermitido;
	}

	// Cierre del metodo getCultivoPermitido

	public void agregrarCultivoP(String cultivoP) { // cultivoPermitido
		this.cultivoPermitido.add(cultivoP);
	}

	public LinkedList<Campesino> getCampesinos() {
		return this.campesinos;
	}

	public void agregarCampesino(Campesino campesino) {
		this.campesinos.add(campesino);
	}

	public LinkedList<String> getTipos() {
		return this.tipos;
	}

	public void agregarTipo(String tipo) {
		this.tipos.add(tipo);
	}

	public LinkedList<Cultivo> getCultivos() {
		return this.cultivos;
	}

	public void agregarCultivo(Cultivo cultivo) {
		this.cultivos.add(cultivo);
		tamanoDisponible -= cultivo.getTamano();
	}

	public static LinkedList<Terreno> getTerreno() {
		return terrenosTotales;
	}

	public static Terreno buscarTerreno(String id) {
		Iterator<Terreno> terreno = terrenosTotales.iterator();
		Terreno tExistente = null;
		while (terreno.hasNext()) {
			Terreno t = (Terreno) terreno.next();
			if (t.getId().equals(id)) {
				tExistente = t;
			}
		}
		return tExistente;
	}

	public String cultivosPermitidos() { // se utiliza en cultivo
		ListIterator iterador = cultivoPermitido.listIterator(); /// También funcionaría con el iterador declarado en la
																	/// anterior
		StringBuffer lista = new StringBuffer("Los cultivos que permite el terreno son:\n");
		while (iterador.hasNext()) {
			String tipo = (String) iterador.next();
			lista.append(tipo + "\n");
		}
		return lista.toString();
	}

	public String mostrarCultivos() {
		ListIterator iterador = tipos.listIterator();
		StringBuffer lista = new StringBuffer("Eliga una de las siguientes opciones \n");
		int i = 1;
		while (iterador.hasNext()) {
			String tipo = (String) iterador.next();
			lista.append("Opcion " + (i++) + ": " + tipo + "\n");
		}
		return lista.toString();
	}

	public String fertilizarTerreno() {
		this.nitrogenoDisponible = 0.7;
		this.potasioDisponible = 0.7;
		this.fosforoDisponible = 0.7;
		this.irrigacionActual = 0.7;
		return this.toString();
	}

	public int getTamanoDisponible() {
		return tamanoDisponible;
	}

	public void setTamanoDisponible(int tamano) {
		this.tamanoDisponible += tamano;
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

	public static String mostrarTerrenos() { // saca el linkedList terrenosTotales, y le muestra al usuario sus ids
		String muestra = "";
		for (Integer i = 0; i < terrenosTotales.size(); i++) {
			muestra = muestra + "Opcion " + (i + 1) + ": " + terrenosTotales.get(i).getId() + "\n";
		}
		return (muestra);
	}

	public String toString() {
		return "Se ha creado un nuevo terreno con las siguientes propiedades:\n" + "Nitrogeno disponible: "
				+ (Math.round(this.nitrogenoDisponible * 100.0) / 100.0) + "\n" + "Potasio disponible: "
				+ (Math.round(this.potasioDisponible * 100.0) / 100.0) + "\n" + "Fosforo disponible: "
				+ (Math.round(this.fosforoDisponible * 100.0) / 100.0) + "\n" + "Nivel de irrigacion: "
				+ (Math.round(this.irrigacionActual * 100.0) / 100.0);
	}

}
