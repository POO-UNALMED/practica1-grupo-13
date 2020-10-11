package gestorAplicacion.terreno;

import gestorAplicacion.Amenaza;

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
	private boolean estadoAmenaza;
	
	public Cultivo(String tipoCultivo, int tamano, Amenaza amenaza, Terreno terreno, double cantProducida, double cantSembrada, double nitrogeno, double potasio,
			double fosforo, double irrigacion, int cantCampesino, boolean estadoAmenaza) {
		this.tipoCultivo = tipoCultivo; this.tamano = tamano; this.amenaza = amenaza; this.terreno = terreno; this.cantProducida = cantProducida;
		this.cantSembrada = cantSembrada; this.nitrogeno = nitrogeno; this.potasio = potasio; this.fosforo = fosforo; this.irrigacion = irrigacion;
		this.cantCampesino = cantCampesino; this.estadoAmenaza = estadoAmenaza;
	}
}
