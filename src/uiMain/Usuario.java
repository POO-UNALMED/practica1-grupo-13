package uiMain;
import java.util.*;
import gestorAplicacion.empleado.*;
import gestorAplicacion.terreno.*;
import gestorAplicacion.*;

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
		System.out.println("Cantidad de papas: " + Cultivo.getPapaProducida() + " hectareas");
		System.out.println("Cantidad de sandias: " + Cultivo.getSandiaProducida() + " hectareas");
		System.out.println("Cantidad de bananos: " + Cultivo.getBananoProducido() + " hectareas");
		System.out.println("Cantidad de mangos: " + Cultivo.getMangoProducido() + " hectareas");
		System.out.println("Cantidad de fresas: " + Cultivo.getFresaProducida() + " hectareas");
	}
	public static void examinarCultivo(){
		if(Cultivo.getCultivos().isEmpty()) {
			System.out.println("Debe cultivar primero");
		}
		else {
			int opcionElegida, opcionElegida2;
			System.out.println("Seleccione un cultivo:");
			System.out.println(Cultivo.mostrarCultivos());
			opcionElegida = readInt() - 1;
			System.out.println(Cultivo.getCultivos().get(opcionElegida));
			if(!Cultivo.getCultivos().get(opcionElegida).getAmenaza().equals(null)) {
				System.out.print("El cultivo se encuentra bajo una amenaza de: ");
				System.out.println(Cultivo.getCultivos().get(opcionElegida).getAmenaza());
				System.out.println("¿Desea aplicar pesticida para eliminar la amenaza del cultivo?");
				System.out.println("1. Si");
				System.out.println("2. No");
				opcionElegida2 = readInt();
				if (opcionElegida2 == 1) {
					Amenaza amenaza = Cultivo.getCultivos().get(opcionElegida).getAmenaza();
					Cultivo cultivo = Cultivo.getCultivos().get(opcionElegida);
					Agronomo.erradicarAmenaza(amenaza, cultivo);
				}
				else {}
			}
		}
	}
	public static void agregarTerreno() {
		System.out.println("Indique el Id que le desea poner: ");
		String id = readLine();
		if(Terreno.buscarTerreno(id) == null) {
			System.out.println("Ahora indique el tamano deseado: ");
			int tamano = readInt();
			Terreno terrenoCreado = new Terreno(id, tamano);
			System.out.println("El terreno ha sido agregado exitosamente");
			System.out.println(terrenoCreado.toString());
			
		}else {
			System.out.println("Lo siento, este terreno ya existe");
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
				case 3: produccion();break;
				case 4: examinarCultivo();break;
				case 6: agregarTerreno();
				case 8: break;
					
			}
		}while(opcionElegida != 8);
	}
}
