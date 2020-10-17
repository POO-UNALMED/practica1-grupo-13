package uiMain;
import java.util.Scanner;
import gestorAplicacion.terreno.*;

public class Usuario {
	static Scanner Sc = new Scanner(System.in);
	static int readInt() {
		return Sc.nextInt();
	}
	static String readLine() {
		return Sc.next();
	}
	public static void contratar(int opcionElegida) {
		String nombre; int sueldo; int cedula; int terreno;
		System.out.println("Ingrese el nombre:");
		nombre = readLine();
		System.out.println("Ingrese el sueldo:");
		sueldo = readInt();
		System.out.println("Ingrese el numero de cedula");
		cedula = readInt();
		System.out.println("Seleccione un terreno para vincular al trabajador");
		Terreno.mostrarTerrenos();
		terreno = readInt();
		if(opcionElegida == 1) {
			System.out.println("bobo hijueputa");
		}
		else if (opcionElegida == 2) {
			System.out.println("no sos bobo");
		}
		else {
		}
	}
	public static void main(String args[]) {
		
		int opcionElegida = 0;
		do {
			System.out.println("Selecciona una funcion");
			System.out.println("1. Contratar");
			System.out.println("2. Despedir");
			System.out.println("3. Produccion por terreno");
			System.out.println("4. Examinar cultivos");
			System.out.println("5. Cultivar");
			System.out.println("6. Agregar terreno");
			System.out.println("7. Fertilizar e irrigar terrenos");
			System.out.println("8. Terminar");
			opcionElegida = Sc.nextInt();
			switch (opcionElegida) {
				case 1: System.out.println("¿Qué trabajador desea contratar?");
						System.out.println("1. Campesino");
						System.out.println("2. Agronomo");
						System.out.println("3. Volver");
						opcionElegida = Sc.nextInt();
						contratar(opcionElegida);break;
					
			}
		}while(opcionElegida != 5);
	}
}
