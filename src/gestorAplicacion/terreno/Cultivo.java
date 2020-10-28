package gestorAplicacion.terreno;
import java.util.*;
import java.io.Serializable;

import gestorAplicacion.Amenaza;

/**
 * Esta clase define objetos de tipo Cultivo que tienen un tipo pudiendo ser (papa, sandia, mango, banano o fresa), pueden tener 
 * una Amenaza asociada, un Terreno asociado y parametros de los nutrientes que posee (numeros entre 0 y 1)
 *
 */
public class Cultivo implements Serializable{
	//Atributos de la clase 
	private static LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>();// 
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
	/**
	 * Metodo constructor para crear una instancia de la clase Cultivo
	 * define el tipo de cultivo que va a ser, los parametros de nutrientes que posee, y el Terreno en el que estara
	 * @param tipoCultivo, El parametro tipoCultivo representa el tipo de cultivo que sera (papa, sandia, mango, banano o fresa)
	 * @param tamano, El parametro tamano representa el tamano en hectareas que sera cultivado
	 * @param nitrogeno, El parametro nitrogeno representa el nitrogeno que tiene el cultivo
	 * @param potasio, El parametro potasio representa el potasio que tiene el cultivo
	 * @param fosforo, El parametro fosforo representa el fosforo que tiene el cultivo
	 * @param irrigacion, El parametro irrigacion representa la irrigacion que tiene el cultivo
	 * @param terreno, El parametro terreno representa el terreno en el cual se siembra el cultivo
	 */
	public Cultivo(String tipoCultivo, int tamano, double nitrogeno, double potasio, double fosforo, double irrigacion, Terreno terreno) {
		this.tipoCultivo = tipoCultivo; 
		this.tamano = tamano; 
		this.nitrogeno = nitrogeno; 
		this.potasio = potasio; 
		this.fosforo = fosforo; 
		this.irrigacion = irrigacion;
		this.terreno = terreno;
		this.agregarCultivo(this);
	}
	//Cierre del Constructor
	// Se le pide al usuario ingresar el tipo de cultivo que quiere sembrar y el tamaño(dentro del Main), si es papa se ejecuta esta funcion o una de las siguientes:
	// Se agrega el cultivo a el arreglo "cultivos" en terreno
	// Comprobar capacidad en el Main
	/**
	 * Metodo crearCultivo, recibe como parametro el tipo de cultivo que sera, el tamano y el terreno en el que se cultiva
	 * primero filtra el tipo de cultivo pasado como parametro y verifica si el cultivo de este tipo no esta sembrado ya en el terreno pasado como parametro
	 * ademas que el Terreno pasado como parametro tenga un tamano disponible superior al pasado como parametro si se cumplen todas las condiciones llama al metodo 
	 * crear#tipoCultivo# de acuerdo a tipo de cultivo que se quiere cultivar retorna si 
	 * se creo exitosamente o si el cultivo ya estaba sembrado en el terreno
	 * @param tipo, El parametro tipo corresponde al tipo de cultivo que se quiere sembrar en el terreno
	 * @param tamañoDeseado, El parametro tamanoDeseado corresponde al tamano del cultivo que se quiere cultivar (en hectareas)
	 * @param terreno, El parametro Terreno corresponde al la instancia de la clase Terreno en el cual se va a cultivar
	 * @return retorna un String, que informa si fue cultivado con exito o no
	 */
	public static String crearCultivo(String tipo, int tamañoDeseado, Terreno terreno) {
		if (tipo.equals("papa") && terreno.getCultivoPermitido().contains("papa") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("papa") == false ) {
			Cultivo.crearPapa(tamañoDeseado, terreno);
			return ("Se ha creado exitosamente");
		}
		else if (tipo.equals("sandia") && terreno.getCultivoPermitido().contains("sandia") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("sandia") == false) {
			Cultivo.crearSandia(tamañoDeseado, terreno);
			return ("Se ha creado exitosamente");
		}
		else if (tipo.equals("mango") && terreno.getCultivoPermitido().contains("mango") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("mango") == false) {
			Cultivo.crearMango(tamañoDeseado, terreno);
			return ("Se ha creado exitosamente");
		}
		else if (tipo.equals("banano") && terreno.getCultivoPermitido().contains("banano") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("banano") == false) {
			Cultivo.crearBanano(tamañoDeseado, terreno);
			return ("Se ha creado exitosamente");
		}
		else if (tipo.equals("fresa") && terreno.getCultivoPermitido().contains("fresa") && terreno.getTamanoDisponible() >= tamañoDeseado && terreno.getTipos().contains("fresa") == false) {
			Cultivo.crearFresa(tamañoDeseado, terreno);
			return ("Se ha creado exitosamente");
		}else{
			return ("Este cultivo ya estaba creado en este terreno o este tipo no es valido");
		}
			
	}
	//Cierre del metodo crearCultivo
	/**
	 * Metodo crearPapa, recibe el tamano del cultivo que se va a cultivar y el terreno en el que se va a hacer, llamando al constructor con los parametros pasados,
	 * los parametros de nutrientes necesarios para ser cultivado, y el tipo de cultivo papa
	 * @param tamañoDeseado, El parametro tamanoDeseado representa el tamano en hectareas del cultivo se va a cultivar
	 * @param terreno, El parametro terreno representa la instancia de la clase Terreno en el que se cultivara
	 */
	public static void crearPapa(int tamañoDeseado, Terreno terreno) {    
		Cultivo papa = new Cultivo ("papa", tamañoDeseado, 0.3, 0.4, 0.4, 0.2, terreno);
		terreno.agregarCultivo(papa);
		terreno.agregarTipo("papa");
	}
	//Cierre del metodo crearPapa
	/**
	 * Metodo crearSandia, recibe el tamano del cultivo que se va a cultivar y el terreno en el que se va a hacer, llamando al constructor con los parametros pasados,
	 * los parametros de nutrientes necesarios para ser cultivado, y el tipo de cultivo sandia
	 * @param tamañoDeseado, El parametro tamanoDeseado representa el tamano en hectareas del cultivo se va a cultivar
	 * @param terreno, El parametro terreno representa la instancia de la clase Terreno en el que se cultivara
	 */
	public static void crearSandia(int tamañoDeseado, Terreno terreno) {
		Cultivo sandia = new Cultivo ("sandia", tamañoDeseado, 0.1, 0.3, 0.5, 0.5, terreno);
		terreno.agregarCultivo(sandia);
		terreno.agregarTipo("sandia");
	}
	//Cierre del metodo crearSandia
	/**
	 * Metodo crearMango, recibe el tamano del cultivo que se va a cultivar y el terreno en el que se va a hacer, llamando al constructor con los parametros pasados,
	 * los parametros de nutrientes necesarios para ser cultivado, y el tipo de cultivo mango
	 * @param tamañoDeseado, El parametro tamanoDeseado representa el tamano en hectareas del cultivo se va a cultivar
	 * @param terreno, El parametro terreno representa la instancia de la clase Terreno en el que se cultivara
	 */
	public static void crearMango(int tamañoDeseado, Terreno terreno) {
		Cultivo mango = new Cultivo ("mango", tamañoDeseado, 0.5, 0.3, 0.2, 0.3, terreno);
		terreno.agregarCultivo(mango);
		terreno.agregarTipo("mango");
	}
	//Cierre del metodo crearMango
	/**
	 * Metodo crearBanano, recibe el tamano del cultivo que se va a cultivar y el terreno en el que se va a hacer, llamando al constructor con los parametros pasados,
	 * los parametros de nutrientes necesarios para ser cultivado, y el tipo de cultivo banano
	 * @param tamañoDeseado, El parametro tamanoDeseado representa el tamano en hectareas del cultivo se va a cultivar
	 * @param terreno, El parametro terreno representa la instancia de la clase Terreno en el que se cultivara
	 */
	public static void crearBanano(int tamañoDeseado, Terreno terreno) {
		Cultivo banano = new Cultivo ("banano", tamañoDeseado, 0.3, 0.1, 0.2, 0.6, terreno);
		terreno.agregarCultivo(banano);
		terreno.agregarTipo("banano");
	}
	//Cierre del metodo crearBanano
	/**
	 * Metodo crearFresa, recibe el tamano del cultivo que se va a cultivar y el terreno en el que se va a hacer, llamando al constructor con los parametros pasados,
	 * los parametros de nutrientes necesarios para ser cultivado, y el tipo de cultivo fresa
	 * @param tamañoDeseado, El parametro tamanoDeseado representa el tamano en hectareas del cultivo se va a cultivar
	 * @param terreno, El parametro terreno representa la instancia de la clase Terreno en el que se cultivara
	 */
	public static void crearFresa(int tamañoDeseado, Terreno terreno) {
		Cultivo fresa = new Cultivo ("fresa", tamañoDeseado, 0.3, 0.4, 0.5, 0.4, terreno);
		terreno.agregarCultivo(fresa);
		terreno.agregarTipo("fresa");
	}
	//Cierre del metodo crearFresa
	/**
	 * Metodo que suma a la cantidad producida de papa el parametro papaRecolectada que recibe como parametro
	 * @param papaRecolectada, El parametro papaRecolectada representa la cantidad de papa recogida
	 */
	public static void setPapaProducida(int papaRecolectada) {
		papaProducida += papaRecolectada;
	}
	//Cierre del metodo setPapaProducida
	/**
	 * Metodo que suma a la cantidad producida de sandia el parametro sandiaRecolectada que recibe como parametro
	 * @param sandiaRecolectada, El parametro sandiaRecolectada representa la cantidad de sandia recogida
	 */
	public static void setSandiaProducida(int sandiaRecolectada) {
		sandiaProducida += sandiaRecolectada;
	}
	//Cierre del metodo setSandiaProducida
	/**
	 * Metodo que suma a la cantidad producida de mango el parametro mangoRecolectado que recibe como parametro
	 * @param mangoRecolectado, El parametro mangoRecolectado representa la cantidad de mango recogido
	 */
	public static void setMangoProducido(int mangoRecolectado) {
		mangoProducido += mangoRecolectado;
	}
	//Cierre del metodo setMangoProducido
	/**
	 * Metodo que suma a la cantidad producida de banano el parametro bananoRecolectado que recibe como parametro
	 * @param bananoRecolectado, El parametro bananoRecolectado representa la cantidad de banano recogido
	 */
	public static void setBananoProducido(int bananoRecolectado) {
		bananoProducido += bananoRecolectado;
	}
	//Cierre del metodo setBananoProducido
	/**
	 * Metodo que suma a la cantidad producida de fresa el parametro fresaRecolectada que recibe como parametro
	 * @param fresaRecolectada, El parametro fresaRecolectada representa la cantidad de fresa recogida
	 */
	public static void setFresaProducida(int fresaRecolectada) {
		fresaProducida += fresaRecolectada;
	}
	//Cierre del metodo setFresaProducida
	
	/**
	 * Metodo que devuelve la cantidad de papa producida que se tiene hasta el momento
	 * @return papaProducida, parametro de la clase
	 */
	public static double getPapaProducida() {
		return (papaProducida);
	}
	// Cierre del metodo getPapaProducida
	/**
	 * Metodo que devuelve la cantidad de sandia producida que se tiene hasta el momento
	 * @return sandiaProducida, parametro de la clase
	 */
	public static double getSandiaProducida() {
		return (sandiaProducida);
	}
	//Cierre del metodo getSandiaProducida
	/**
	 * Metodo que devuelve la cantidad de mango producido que se tiene hasta el momento
	 * @return mangoProducido, parametro de la clase
	 */
	public static double getMangoProducido() {
		return (mangoProducido);
	}
	//Cierre del metodo getMangoProducido
	/**
	 * Metodo que devuelve la cantidad de banano producido que se tiene hasta el momento
	 * @return bananoProducido, parametro de la clase
	 */
	public static double getBananoProducido() {
		return (bananoProducido);
	}
	//Cierre del metodo getBananoProducido
	/**
	 * Metodo que devuelve la cantidad de fresa producido que se tiene hasta el momento
	 * @return fresaProducida, parametro de la clase
	 */
	public static double getFresaProducida() {
		return (fresaProducida);
	}
	// Ciere del metodo getFresaProducida
	/**
	 * Metodo getAmenaza, que devuelve la instancia de amenza que esta atacando el cultivo
	 * @return amenaza, atributo que representa la amenaza bajo la cual esta siendo atacado el cultivo
	 */
	public Amenaza getAmenaza() {
		return (this.amenaza);
	}
	//Cierre del metodo getAmenaza
	/**
	 * Metodo que recibe como parametro la instancia de la clase Amenaza que va a atacar el cultivo
	 * @param amenazaNueva, representa la amenaza que va a atacar
	 */
	public void setAmenaza(Amenaza amenazaNueva) {
		this.amenaza = amenazaNueva;
	}
	//Cierre del metodo setAmenaza
	
	public int getTamano() {
		return (this.tamano);
	}
		
	public String getTipoCultivo() { 
		return this.tipoCultivo;
	}
	/**
	 * Metodo que agrega un cultivo a la lista de todos los cultivos que se han cultivado hasta el momento
	 * @param cultivo, Parametro que representa la instancia de la clase Cultivo que se creo y debe ser agregada a la lista de cultivos creados
	 */
	public void agregarCultivo(Cultivo cultivo) { 
		cultivos.add(cultivo);
	}
	//Cierre del metodo agregarCultivo
	/**
	 * Metodo que devulve toda la lista de cultivos creados
	 * @return represente el atributo de clase que guarda todos los cultivos creados
	 */
	public static LinkedList<Cultivo>  getCultivos(){
		return (cultivos);
	}
	//Cierre del metodo getCultivos
	public Terreno getTerreno() {
		return (this.terreno);
	}
	/**
	 * Metodo que devulve como string la lista de todos los cultivos creados mostrando el tipo de cultivo que es y el terreno en el que se encuentra
	 * @return muestra, representa el String que devuelve el metodo
	 */
	public static String mostrarCultivos() {
		String muestra = "";
		for (Integer i = 0; i < cultivos.size(); i ++) {
			muestra = muestra + (i + 1) + ". " + "El cultivo de " + cultivos.get(i).tipoCultivo + ". En el terreno con id: " + cultivos.get(i).terreno.getId() + "\n";
		}
		return (muestra);
	}
	//Cierre del metodo mostrarCultivos
	/**
	 * Metodo que devuelve como la descripcion del cultivo, devolviendo su tipo, el terreno en el que se ubica, si esta o no bajo amenaza y el tipo de esta
	 */
	@Override
	public String toString() {
		if(this.getAmenaza() != null) {
			return "El cultivo de tipo " + this.getTipoCultivo() + " ubicado en el terreno " + this.getTerreno().getId() + " se encuentra bajo amenaza." + "\n" +
		    "La amenaza que lo ataca es de tipo " + this.getAmenaza().getTipo();
		}
		else {
			return "El cultivo de tipo " + this.getTipoCultivo() + " ubicado en el terreno " + this.getTerreno().getId() + " no se encuentra bajo amenaza";
		}
	}
	//Cierre del metodo toString
}
