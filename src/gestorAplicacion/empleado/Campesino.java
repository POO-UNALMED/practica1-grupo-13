package gestorAplicacion.empleado;
import gestorAplicacion.terreno.*;
import java.util.*;

public class Campesino extends Empleado{
	public Campesino(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula, terreno);
		terreno.agregarCampesino(this);
	}
	public void renunciar() {
		double x = Math.random();
		if ((x < 0.2) && (Terreno.getTerreno().size() > 0)) {
			for(int i = 0; i < Terreno.getTerreno().size(); i++) {
				if(Terreno.getTerreno().get(i).getCampesinos().size() > 0) {
					System.out.println(Terreno.getTerreno().get(i).getCampesinos().get(i));
					System.out.println("Ha renunciado");
					Terreno.getTerreno().get(i).getCampesinos().remove(i);
				}
			}
		}
	}
	public void renunciar(int opcionElegida, int opcionElegida2) {
		Terreno.getTerreno().get(opcionElegida).getCampesinos().remove(opcionElegida2);
	}
	public static String mostrarCampesinos(Terreno terreno) {
		String muestra = "";
		for (Integer i = 0; i < terreno.getCampesinos().size(); i ++){
			muestra = muestra + (i+1) + ". "+ terreno.getCampesinos().get(i).getCedula() + "\n";
		}
		return(muestra);
	}
	public String toString() {
		return("El campesino con:" + "\n " + "Nombre: " + this.getNombre() + "\n" + "Cedula: " + this.getCedula() + "\n" +
				"Sueldo: " + this.getSueldo() + "Vinculado a terreno: " + this.getTerreno().getId());
	}
	
	public void recolectar(Cultivo cultivo) {
		//Modificar el size disponible del terreno que contiene el cultivo que se esta recolectando
		int tempSize = cultivo.getTamano();
		int tempGroundSizeAvailable = cultivo.getTerreno().getTamanoDisponible();
		cultivo.getTerreno().setTamanoDisponible(tempGroundSizeAvailable+=tempSize);
		
		//Sumar la candidad producida por tipo 
		String tempTypeCrop = cultivo.getTipoCultivo();
		switch(tempTypeCrop) {
		case "papas": cultivo.setPapaProducida(tempSize); break;
		case "sandias": cultivo.setSandiaProducida(tempSize); break;
		case "mango": cultivo.setMangoProducido(tempSize); break;
		case "banano": cultivo.setBananoProducido(tempSize); break;
		case "fresas": cultivo.setFresaProducida(tempSize); break;
		}
		
		//Remove del cultivo en la lista de los cultivos estan en el terreno
		this.getTerreno().getCultivos().remove(cultivo);
		Cultivo.getCultivos().remove(cultivo);
	}
}
 