package uiMain;
import java.util.Scanner;

import gestorAplicacion.terreno.Cultivo;
import gestorAplicacion.terreno.Terreno;

public class ImplementarCultivo {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escoja el id del terreno en el que quiere sembrar");
		
		if (Terreno.getTerreno().size() !=0 ) {
			System.out.println(Terreno.mostrarTerrenos());
			int entrada = sc.nextInt();
			Terreno terreno = Terreno.getTerreno().get(entrada - 1);
			terreno.getCultivoPermitido();     //Funcion que actualiza los tipos disponibles
			
			if (terreno.getCultivoPermitido().size() != 0) {
				System.out.println(terreno.cultivosPermitidos());
				System.out.println("Escriba el tipo que quiere sembrar:");
				String tipo = sc.next();
				System.out.println("Escriba el tamaño que desea que tenga el cultivo");
				int tamaño = sc.nextInt();
				Cultivo.crearCultivo(tipo, tamaño, terreno);
			}else {
				System.out.println("No dispone con los requerimientos suficientes para sembrar en este terreno, por favor irrigue o fertilice");
			}
			
		}else {
			System.out.println("No dispone de terrenos, por favor cree uno");
		}
		
		
		
	}
}
