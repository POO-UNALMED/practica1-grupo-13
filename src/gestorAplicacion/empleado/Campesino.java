package gestorAplicacion.empleado;
import gestorAplicacion.terreno.*;
import java.util.*;

public class Campesino extends Empleado{
	public Campesino() {
	}
	public Campesino(String nombre, int sueldo, int cedula, Terreno terreno) {
		super(nombre, sueldo, cedula, terreno);
		terreno.agregarCampesino(this);
	}
	public void renunciar() {
		double x = Math.random();
		if ((x < 0.15) && (Terreno.getTerreno().size() > 0)) {
			for(int i = 0; i < Terreno.getTerreno().size(); i++) {
				if(Terreno.getTerreno().get(i).getCampesinos().size() > 0) {
					System.out.println(Terreno.getTerreno().get(i).getCampesinos().get(0));
					System.out.println("Ha renunciado");
					Terreno.getTerreno().get(i).getCampesinos().remove(0);
					break;
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
		return("\n" + "El campesino con:" + "\n" + "Nombre: " + this.getNombre() + "\n" + "Cedula: " + this.getCedula() + "\n" +
				"Sueldo: " + this.getSueldo() + "\n" + "Vinculado a terreno: " + this.getTerreno().getId());
	}
	
	public void recolectar(Cultivo cultivo) {
		//Modificar el size disponible del terreno que contiene el cultivo que se esta recolectando
		int tempSize = cultivo.getTamano();
		cultivo.getTerreno().setTamanoDisponible(tempSize);
		
		//Sumar la candidad producida por tipo 
		String tempTypeCrop = cultivo.getTipoCultivo();
		switch(tempTypeCrop) {
		case "papa": Cultivo.setPapaProducida(tempSize); break;
		case "sandia": Cultivo.setSandiaProducida(tempSize); break;
		case "mango": Cultivo.setMangoProducido(tempSize); break;
		case "banano": Cultivo.setBananoProducido(tempSize); break;
		case "fresa": Cultivo.setFresaProducida(tempSize); break;
		}

		//Remove del cultivo en la lista de los cultivos estan en el terreno
		this.getTerreno().getCultivos().remove(cultivo);
		this.getTerreno().getTipos().remove(cultivo.getTipoCultivo());
		Cultivo.getCultivos().remove(cultivo);
	}
	
	public void fertilizar(Terreno terreno) {
		terreno.fertilizarTerreno();
	}
}
 