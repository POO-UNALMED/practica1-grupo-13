package gestorAplicacion;

import java.io.Serializable;
import java.util.*;
import gestorAplicacion.terreno.*;
/**
 * Esta clase define objetos de tipo Amenaza que tienen asociado un cultivo 
 * al momento de crearse, que representa el cultivo que va a atacar, la cantidad
 * de hectareas de siembra que va a afectar y el tipo de Amenaza que es 
 * pudiendo ser (plaga, maleza u hongo)
 */
public class Amenaza implements Serializable {
	//Atributos de la clase
	private String tipoAmenaza;
	private Cultivo cultivo; 
	private double cantidad;
	
	/**
	 * Constructor para crear una instancia de Amenaza
	 * Establece el tipo de amenza que es, el cultivo que va a amenazar
	 * y la cantidad de siembra que va a afectar 
	 * @param tipoAmenaza El parametro tipoAmenaza representa el tipo de amenaza 
	 * @param cultivo El parametro cultivo representa el cultivo que va a atacar 
	 * @param cantidad El parametro cantidad representa la cantidad de hectareas
	 * de siembra que va a afectar cuando ataque
	 */
	public Amenaza(String tipoAmenaza, Cultivo cultivo, double cantidad) {
		this.tipoAmenaza = tipoAmenaza;
		this.cultivo = cultivo;
		this.cantidad = cantidad;
	}
	// Cierre del metodo Amenaza
	/**
	 * Metodo atacarCultivo, le asocia al cultivo recibido como parametro una instancia 
	 * de amenaza pasada como paramatro
	 * @param amenaza El Parametro amenenaza representa una instanca de Amenaza que va a atacar
	 * @param cultivo El Parametro cultivo representa la instancia de Cultivo que va a ser atacada
	 */
	public static void atacarCultivo(Amenaza amenaza, Cultivo cultivo) {
		cultivo.setAmenaza(amenaza);
	}
	// Cierre del metodo atacarCultivo
	/**
	 * El Metodo Amenazar define la variable Random_Para_AMENAZAR que representa la probabilidad de que una amenaza ataque a algun cultivo, 
	 * luego define la variable Random_Para_TipoPeste que representa la aletoreidad del tipo de Amenaza que se va a crear
	 * Selecciona un cultivo de manera aleatoria y verifica que no este asociado a una amenaza
	 * Define la variable cantidad_infectada que representa la cantidad de hectareas que afectara en el cultivo que va a atacar, se asegura 
	 * que la cantidad que va a infectar estre en los limites de dicho cultivo
	 * Para la variable Random_Para_TipoPeste si es menor a 0.3 el tipo de peste sera Plaga, si esta entre 0.3 y 0.6 el tipo de peste sera Maleza
	 * si esta entre 0.6 y 1 el tipo de peste sera de Hongo
	 * Por ultimo crea la instancia de tipo Amenaza con el tipo de peste generada, el cultivo aleatorio, y la cantiad aleatoria que va a afectar 
	 * 
	 * las instancas de tipo Amenaza solo son creadas en este metodo estatico
	 */
	public static void Amenazar() {
		double Random_Para_AMENAZAR = Math.random();
		if (Random_Para_AMENAZAR >= 0 && Random_Para_AMENAZAR <= 0.15) {
			double Random_Para_TipoPeste = Math.random();
			LinkedList<Cultivo> cultivatrones = Cultivo.getCultivos();
			String TipoPeste;
			int cantidad_de_cultivos = cultivatrones.size();
			if (cantidad_de_cultivos != 0) {
				int Random_Para_Sacar_Cultivo = (int) Random_Para_TipoPeste * (cantidad_de_cultivos - 1);
				if (cultivatrones.get(Random_Para_Sacar_Cultivo).getAmenaza() == null
						&& cultivatrones.get(Random_Para_Sacar_Cultivo).getTamano() > 0) {
					double cantidad_infectada = Math.random()
							* cultivatrones.get(Random_Para_Sacar_Cultivo).getTamano();
					if (Random_Para_TipoPeste >= 0 && Random_Para_TipoPeste <= 0.3) {
						TipoPeste = "Plaga";
						Amenaza amenaza = new Amenaza(TipoPeste, cultivatrones.get(Random_Para_Sacar_Cultivo),
								cantidad_infectada);
						atacarCultivo(amenaza, cultivatrones.get(Random_Para_Sacar_Cultivo));
						System.out.println("Una plaga esta atacando al cultivo " + amenaza.getCultivo().getTipoCultivo()
								+ " en el terreno con id " + amenaza.getCultivo().getTerreno().getId() + "\n");
					} else if (Random_Para_TipoPeste > 0.3 && Random_Para_TipoPeste < 0.6) {
						TipoPeste = "Maleza";
						Amenaza amenaza = new Amenaza(TipoPeste, cultivatrones.get(Random_Para_Sacar_Cultivo),
								cantidad_infectada);
						atacarCultivo(amenaza, cultivatrones.get(Random_Para_Sacar_Cultivo));
						System.out
								.println("Una maleza esta atacando al cultivo " + amenaza.getCultivo().getTipoCultivo()
										+ " en el terreno con id " + amenaza.getCultivo().getTerreno().getId() + "\n");
					} else {
						TipoPeste = "Hongo";
						Amenaza amenaza = new Amenaza(TipoPeste, cultivatrones.get(Random_Para_Sacar_Cultivo),
								cantidad_infectada);
						atacarCultivo(amenaza, cultivatrones.get(Random_Para_Sacar_Cultivo));
						System.out.println("Un hongo esta atacando al cultivo " + amenaza.getCultivo().getTipoCultivo()
								+ " en el terreno con id " + amenaza.getCultivo().getTerreno().getId() + "\n");
					}
				}
			}
		}
	}
	// Cierre del metodo Amenazar
	/**
	 * Metodo toString
	 * @return devuelve un string con todos los atributos de la instancia Amenaza
	 */
	@Override
	public String toString() {
		return ("La amenaza" + "\n" + "De tipo: " + this.getTipo() + "\n" + "Infecto " + this.cantidad + " hectareas"
				+ "\n" + "Del cultivo: " + this.cultivo + "\n" + "Del terreno: " + this.cultivo.getTerreno());
	}
	// Cierre del metodo toString
	/**
	 * Metodo getCultivo que devuelve el cultivo al que esta asociado la amenaza
	 * @return cultivo, representa un instancia de la clase Cultivo
	 */
	public Cultivo getCultivo() {
		return cultivo;
	}
	// Cierre del metodo getCultivo
	/**
	 * Metodo getTipo que devuelve el tipo de amenaza al que esta asociado la amenaza
	 * @return tipoAmenza, representa el tipo de Amenaza de la cual es la instancia
	 */
	public String getTipo() {
		return this.tipoAmenaza;
	}
	// Cierre del metodo getTipo
}
