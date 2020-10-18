package uiMain;
import java.util.*;
import gestorAplicacion.empleado.*;
import gestorAplicacion.terreno.*;

public class Usuario {
	static Scanner Sc = new Scanner(System.in);
	static int readInt() {
		return Sc.nextInt();
	}
	static String readLine() {
		return Sc.next();
	}
	public static void contratar() {
		int opcionElegida;
		System.out.println("¿Qué trabajador desea contratar?");
		System.out.println("1. Campesino");
		System.out.println("2. Agronomo");
		System.out.println("3. Volver");
		opcionElegida = readInt();
		if((opcionElegida == 1) || (opcionElegida == 2) && (Terreno.getTerreno().size() > 0)) {
			String nombre; int sueldo; int cedula; int terreno;
			System.out.println("Ingrese el nombre:");
			nombre = readLine();
			System.out.println("Ingrese el sueldo:");
			sueldo = readInt();
			System.out.println("Ingrese el numero de cedula");
			cedula = readInt();
			System.out.println("Seleccione un terreno para vincular al trabajador");
			System.out.println(Terreno.mostrarTerrenos());
			terreno = readInt() - 1;
			if(opcionElegida == 1) {
				Campesino campe = new Campesino(nombre, sueldo, cedula, Terreno.getTerreno().get(terreno));
				System.out.println("Se ha creado un campesino.");
				System.out.println(campe);
			}
			else if(opcionElegida == 2) {
				if(Terreno.getTerreno().get(terreno).getAgronomo().equals(null)) {
					Agronomo agro = new Agronomo(nombre, sueldo, cedula, Terreno.getTerreno().get(terreno));
					System.out.println("Se ha creado un agronomo.");
					
				}
				else {
					System.out.println("Este terreno ya tiene un agronomo vinculado");
				}
			}
		}
		else if((opcionElegida == 1) || (opcionElegida == 2) && (Terreno.getTerreno().size() == 0)){
			System.out.println("Debe agregar primero un terreno para vincular trabajadores");
		}
		else {}
	}
	public static void despedir() {
		int opcionElegida, opcionElegida2;
		if(Terreno.getTerreno().size() > 0) {
			System.out.println("¿Qué trabajador desea despedir?");
			System.out.println("1. Campesino");
			System.out.println("2. Agronomo");
			System.out.println("3. Volver");
			opcionElegida = readInt();
			if(opcionElegida == 1) {
				System.out.println("Seleccione un terreno para mirar los campesinos que laboran en el");
				System.out.println(Terreno.mostrarTerrenos());
				opcionElegida = readInt() - 1;
				if(Terreno.getTerreno().get(opcionElegida).getCampesinos().size() > 0) {
					System.out.println("Seleccione un campesino para despedir");
					System.out.println(Campesino.mostrarCampesinos(Terreno.getTerreno().get(opcionElegida)));
					opcionElegida2 = readInt() - 1;
					System.out.println("Se ha despedio a: ");
					System.out.println(Terreno.getTerreno().get(opcionElegida).getCampesinos().get(opcionElegida2));
					Terreno.getTerreno().get(opcionElegida).getCampesinos().get(opcionElegida2).renunciar();
				}
				else {
					System.out.println("No hay campesinos vinculados a este terreno");
				}
			}
			else if(opcionElegida == 2) {
				if (Agronomo.getAgronomos().size() > 0) {
					System.out.println("Seleccione un agronomo para despedir");
					System.out.println(Agronomo.mostrarAgronomos());
					opcionElegida = readInt() - 1;
				}
				else {
					System.out.println("No ha contratado agronomos");
				}
			}
		}
		else {
			System.out.println("Debe asignar primero terrenos, para así tener trabajadores y despedirlos.");
		}
		
	}
	public static void produccion() {
		System.out.println("La cantidad de cultivos de cada clase es:");
		System.out.println("Cantidad de papas: " + + "hectareas.");
		System.out.println("Cantidad de sandias: " + + "hectareas.");
		System.out.println("Cantidad de mangos: " + + "hectareas.");
		System.out.println("Cantidad de bananos: " + + "hectareas.");
		System.out.println("Cantidad de fresas: " + + "hectareas.");
	}
	public static void examinarCultivo(){
		if(Cultivo.getCultivos().isEmpty()) {
			System.out.println("Debe cultivar primero");
		}
		else {
			int opcionElegida;
			System.out.println("Seleccione un cultivo:");
			System.out.println(Cultivo.mostrarCultivos());
			opcionElegida = readInt() - 1;
			System.out.println(Cultivo.getCultivos().get(opcionElegida));
			if(!Cultivo.getCultivos().get(opcionElegida).getAmenaza().equals(null)) {
				System.out.print("El cultivo se encuentra bajo una amenaza de: ");
				System.out.println(Cultivo.getCultivos().get(opcionElegida).getAmenaza());
				System.out.println("¿Desea aplicas pesticida para eliminar la amenaza del cultivo?");
				System.out.println("1. Si");
				System.out.println("2. No");
				opcionElegida = readInt();
				if (opcionElegida == 1) {
					
				}
				else {}
			}
		}
	}
	public static void main(String args[]) {
		new Terreno("Cola", 2);
		new Terreno("bola", 2);
		int opcionElegida = 0;
		do {
			System.out.println("Selecciona una funcion");
			System.out.println("1. Contratar");
			System.out.println("2. Despedir");
			System.out.println("3. Produccion total de los cultivos");
			System.out.println("4. Examinar cultivos");
			System.out.println("5. Cultivar");
			System.out.println("6. Agregar terreno");
			System.out.println("7. Fertilizar e irrigar terrenos");
			System.out.println("8. Terminar");
			opcionElegida = readInt();
			switch (opcionElegida) {
				case 1: contratar();break;
				case 2: despedir();break;
				case 3: produccion();
				case 4: examinarCultivo();break;
				case 8: break;
					
			}
		}while(opcionElegida != 8);
	}
}
