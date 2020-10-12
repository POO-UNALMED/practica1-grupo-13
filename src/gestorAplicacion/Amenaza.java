package gestorAplicacion;

import java.util.*;
import gestorAplicacion.terreno.*;

public class Amenaza {
	private String tipoAmenaza;
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>(); //Se guardaran los Cultivos
	//Lo hicimos de otra forma, por eso no colocamos pesticida
	private double cantidad;//Cantidad del cultivo afectada en porcentaje
	
	public Amenaza(String tipoAmenaza, Cultivo cultivo, double cantidad) {
		this.tipoAmenaza = tipoAmenaza; this.cultivos.add(cultivo); this.cantidad = cantidad;
	}	
	public void atacarCultivo(Cultivo cultivo) {
		cultivo.setAmenaza(this);
	}
	public String getTipo() {
		return this.tipoAmenaza;
	}
}
