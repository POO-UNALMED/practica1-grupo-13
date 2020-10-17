package uiMain;
import java.util.Scanner;

import gestorAplicacion.terreno.Cultivo;
import gestorAplicacion.terreno.Terreno;

public class ImplementarCultivo {

	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Terreno a = new Terreno("12" , 100 ,0.1, 0.3, 0.5, 0.5);
		Terreno b = new Terreno("13" , 200 , 1 ,1 ,1 ,1);
		Terreno x = new Terreno("14" , 12);
		
		
		System.out.println("Escoja el terreno en el que quiere sembrar");
		System.out.println(Terreno.mostrarTerrenos());
		int entrada = sc.nextInt();
		Terreno terreno = Terreno.getTerreno().get(entrada - 1);
		terreno.getCultivoPermitido();     //Funcion que actualiza los tipos disponibles
		System.out.println(terreno.cultivosPermitidos());     //Funcion que muestra los tipos disponibles
		
		System.out.println("Escriba el tipo que quiere sembrar:");
		String tipo = sc.next();
		System.out.println("Escriba el tamaño que desea que tenga el cultivo");
		int tamaño = sc.nextInt();
		Cultivo.crearCultivo(tipo, tamaño, terreno);
		
		
		
		
	
		
	
		
		
		
	}
	
	
	
	
	
	
}
