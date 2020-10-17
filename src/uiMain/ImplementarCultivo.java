package uiMain;
import java.util.Scanner;

import gestorAplicacion.terreno.Cultivo;
import gestorAplicacion.terreno.Terreno;

public class ImplementarCultivo {

	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Terreno a = new Terreno("12" , 1 , 1 ,1 ,1 ,1);
		Terreno b = new Terreno("13" , 1 , 1 ,1 ,1 ,1);
		Terreno x = new Terreno("14" , 12);
		
		
		System.out.println("Escoja el terreno en el que quiere sembrar");
		System.out.println(Terreno.mostrarTerrenos());
		int entrada = sc.nextInt();
		Terreno terreno = Terreno.getTerreno().get(entrada - 1);
		
		
		System.out.println();
		
		
		System.out.println("Escriba el tipo ");
		Cultivo.crearCultivo(tipo, tamañoDeseado, terreno);

	
		
	
		
		
		
	}
	
	
	
	
	
	
}
