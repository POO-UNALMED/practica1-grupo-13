package uiMain;

import java.util.*;
import gestorAplicacion.terreno.Cultivo;
import gestorAplicacion.terreno.Terreno;

public class ImplementarTerreno {
	
	public static void main (String[] args) {
		Terreno t1 = new Terreno("1", 5);
		Terreno t2 = new Terreno("4", 6);
		Terreno t3 = new Terreno("8", 5);

		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Indique el Id que le desea poner: ");
		String id = sc.next();
		
		Terreno terreno = Terreno.buscarTerreno(id);
		if(terreno == null) {
			System.out.println("Ahora indique el tamano deseado: ");
			int tamano = sc.nextInt();
			Terreno terrenoCreado = new Terreno(id, tamano);
			System.out.println("Terreno agregado exitosamente");
			System.out.println(terrenoCreado.toString());
			
		}else {
			System.out.println("Lo siento, este terreno ya existe");
		}
	}
}
/*Terreno terreno = null;
  for(int i = 0; i < terrenosTotales.size(); i++) {
	if(terrenosTotales.get(i).getId().equals(id)) {
		terreno = terrenosTotales.get(i);
	}
}
return terreno;*/