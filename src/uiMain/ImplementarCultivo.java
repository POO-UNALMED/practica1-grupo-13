package uiMain;
import java.util.Scanner;

import gestorAplicacion.empleado.Campesino;
import gestorAplicacion.terreno.Cultivo;
import gestorAplicacion.terreno.Terreno;

public class ImplementarCultivo {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Terreno tt = new Terreno("11",12,1,1,1,1);
		
		//Leimar copie de aquí para abajo :DDDD
		
		System.out.println("Escoja la funcion a realizar:\nPara crear un cultivo ingrese 1\nPara recolectar un cultivo ingrese 2");
		int opcion = sc.nextInt();
		if (opcion == 1) {
			if (Terreno.getTerreno().size() !=0 ) {
				System.out.println("Escoja el id del terreno en el que quiere sembrar: ");
				System.out.println(Terreno.mostrarTerrenos());
				int entrada = sc.nextInt();
				Terreno terreno = Terreno.getTerreno().get(entrada - 1);
				terreno.getCultivoPermitido();     //Funcion que actualiza los tipos disponibles
				
				if (terreno.getCultivoPermitido().size() != 0) {
					System.out.println(terreno.cultivosPermitidos());
					System.out.println("Escriba el tipo que quiere sembrar: ");
					String tipo = sc.next();
					System.out.println("Escriba el tamaño que desea que tenga el cultivo: ");
					int tamaño = sc.nextInt();
					if (tamaño <= terreno.getTamanoDisponible()) {
						Cultivo.crearCultivo(tipo, tamaño, terreno);
						System.out.println("Se ha creado un terreno de " + tipo + ", con tamaño " + tamaño);
					}else {
						System.out.println("Se ha cancelado la operacion, el tamaño del cultivo no concuerda con el del terreno");
					}
					
				}else {
					System.out.println("No dispone con los requerimientos suficientes para sembrar en este terreno, por favor irrigue o fertilice");
				}
				
			}else {
				System.out.println("No dispone de terrenos, por favor cree uno");
			}
		}else if (opcion == 2) {
			if (Terreno.getTerreno().size() != 0 ) {
				System.out.println("Escoja el id del terreno en el que quiere recolectar: ");
				System.out.println(Terreno.mostrarTerrenos());
				int entrada = sc.nextInt();	
				Terreno terreno = Terreno.getTerreno().get(entrada - 1);
				if (terreno.getCampesinos().isEmpty() == false) {
					if (terreno.getCultivos().isEmpty() == false) {
						System.out.println("Ingrese la opcion que corresponde al tipo: ");
						System.out.println(terreno.mostrarCultivos());
						int eleccion = sc.nextInt();
						Cultivo cultivo = terreno.getCultivos().get(eleccion - 1);
						Campesino campesino = terreno.getCampesinos().peek();
						campesino.recolectar(cultivo);
						
					}else {
						System.out.println("El terreno no tiene cultivos, por favor cree uno");
					}
					
				}else {
					System.out.println("El terreno no tiene campesinos que puedan recolectar, por favor asigne al menos 1");
				}
				
				
				
			}else {
				System.out.println("No dispone de terrenos, por favor cree uno");
			}
		}
		
		
	}
}
