package gestorAplicacion;

import gestorAplicacion.terreno.*;

public class Pesticida {
	private String tipo;
	private String color;
	
	public Pesticida(String tipo, String color) {
		this.tipo = tipo; this.color = color;
	}
	
	public void matarAmenaza(Terreno t, Cultivo c) {
		//Recibe el terreno y el cultivo donde está la amenaza
		//Busca en los cultivos de Terreno y elimina la amenaza en el cultvio correspondiente 
	}
}
