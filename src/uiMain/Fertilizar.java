package uiMain;

import java.util.*;
import gestorAplicacion.terreno.Cultivo;
import gestorAplicacion.terreno.Terreno;

public class Fertilizar {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in); 

		System.out.println(Terreno.mostrarTerrenos());
		System.out.println("Escoja el terreno que desea fertilizar en irrigar: ");
		int id = sc.nextInt();
		Terreno.getTerreno().get(id).fertilizarTerreno();
		Terreno.getTerreno().get(id).getCultivoPermitido();
		System.out.println("Terreno ferlizado, ahora puedes sembrar: ");
        System.out.println(Terreno.getTerreno().get(id).cultivosPermitidos());
	}
}
