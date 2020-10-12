package gestorAplicacion;

import gestorAplicacion.terreno.*;

public class Pesticida {
	private String tipo;
	private String color;
	private Amenaza amenaza;
	public Pesticida(Amenaza amenaza) {
		this.amenaza = amenaza;
		if(amenaza.getTipo().equals("Plaga")) {
			this.tipo="Insecticida";
			this.color="Rojo";
		}
		else if(amenaza.getTipo().equals("Maleza")) {
			this.tipo="Herbicida";
			this.color="Verde";
		}
		else if(amenaza.getTipo().equals("Hongo")) {
			this.tipo="Fungicida";
			this.color="Blanco";
		}
	}
	public Pesticida(String tipo, String color) {//segunda opcion para cumplir con sobrecarga de constructores "DUDA"
		this.tipo=tipo;
		this.color=color;
	}
	public void matarAmenaza(Cultivo c) {
		c.setAmenaza(null);
		//Quedamos en eliminar el atributo estadoAmenaza
		//Recibe el terreno y el cultivo donde está la amenaza
		//Busca en los cultivos de Terreno y elimina la amenaza en el cultivo correspondiente 
	}
}
