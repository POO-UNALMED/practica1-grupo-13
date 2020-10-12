package gestorAplicacion;

import java.util.*;
import gestorAplicacion.terreno.*;

public class Amenaza {
	private String tipoAmenaza;
	private LinkedList<Object> cultivo = new LinkedList<Object>(); //Se guardará un Cultivo y un Terreno
	private Pesticida pesticida;
	private double cantidad;
	
	public Amenaza(String tipoAmenaza, LinkedList<Object> cultivo, Pesticida pesticida, double cantidad) {
		this.tipoAmenaza = tipoAmenaza; this.cultivo = cultivo; this.pesticida = pesticida; this.cantidad = cantidad;
	}
	
	public void atacarCultivo(Terreno terreno, Cultivo cultivo) {}
	
	public String getTipo() {
		return this.tipoAmenaza;
	}
}
