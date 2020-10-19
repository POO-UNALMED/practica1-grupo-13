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
		if(((opcionElegida == 1) || (opcionElegida == 2)) && (Terreno.getTerreno().size() > 0)) {
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
				System.out.println("Se ha contratado un campesino.");
				System.out.println(campe);
			}
			else if(opcionElegida == 2) {
				if(Terreno.getTerreno().get(terreno).getAgronomo() == (null)) {
					Agronomo agro = new Agronomo(nombre, sueldo, cedula, Terreno.getTerreno().get(terreno));
					System.out.println("Se ha contratado un agronomo.");
					System.out.println(agro);
					
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
					Terreno.getTerreno().get(opcionElegida).getCampesinos().get(opcionElegida2).renunciar(opcionElegida, opcionElegida2);
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
					Agronomo.getAgronomos().get(opcionElegida).renunciar(opcionElegida);
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
		System.out.println("Cantidad producida de cada tipo de cultivo");
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
			if(Cultivo.getCultivos().get(opcionElegida).getAmenaza() != (null)) {
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
	public static void ferrigar() {
		if(Terreno.getTerreno().size() > 0) {
			System.out.println("Escoja el terreno que desea fertilizar e irrigar: "+"\n");
			System.out.println(Terreno.mostrarTerrenos());
			int id = readInt() - 1;
			if(Terreno.getTerreno().get(id).getCampesinos().size() > 0) {
				int trabajador = (int) Math.random()*(Terreno.getTerreno().get(id).getCampesinos().size()-1);
				Campesino campesinoFertiliza = Terreno.getTerreno().get(id).getCampesinos().get(trabajador);
				campesinoFertiliza.fertilizar(Terreno.getTerreno().get(id));
				Terreno.getTerreno().get(id).getCultivoPermitido();
				System.out.println("Terreno fertilizado ");
		        System.out.println(Terreno.getTerreno().get(id).cultivosPermitidos());
			}else {
				System.out.println("No ha contratado campesinos para este terreno.\nDebe contartar al menos uno para realizar este trabajo");
			}
		}else {
			System.out.println("No dispone de terrenos, por favor cree uno");
		}
		
		
	}
	public static void cultivoyCosecha() {
		System.out.println("Escoja la funcion a realizar:\nPara crear un cultivo ingrese 1\nPara recolectar un cultivo ingrese 2");
		int opcion = readInt();
		if (opcion == 1) {
			if (Terreno.getTerreno().size() !=0 ) {
				System.out.println("Escoja la opcion del terreno en el que quiere sembrar: ");
				System.out.println(Terreno.mostrarTerrenos());
				int entrada = readInt();
				Terreno terreno = Terreno.getTerreno().get(entrada - 1);
				if(terreno.getCampesinos().size() != 0) {
					terreno.getCultivoPermitido();     //Funcion que actualiza los tipos disponibles
				if (terreno.getCultivoPermitido().size() != 0) {
					System.out.println(terreno.cultivosPermitidos());
					System.out.println("Escriba el tipo que quiere sembrar: ");
					String tipo = readLine();
					System.out.println("Escriba el tamaño que desea que tenga el cultivo: ");
					int tamaño = readInt();
					if (tamaño <= terreno.getTamanoDisponible()) {
						System.out.println(Cultivo.crearCultivo(tipo, tamaño, terreno));
					}else {
						System.out.println("Se ha cancelado la operacion, el tamaño del cultivo no concuerda con el del terreno");
						}
					}else {
						System.out.println("No dispone con los requerimientos suficientes para sembrar en este terreno, por favor irrigue o fertilice");
					}
				}else {
					System.out.println("Debe contratar al menos un campesino para el terreno");
				}
			}else {
				System.out.println("No dispone de terrenos, por favor cree uno");
			}
		}else if (opcion == 2) {
			if (Terreno.getTerreno().size() != 0 ) {
				System.out.println("Escoja la opcion del terreno en el que quiere recolectar: ");
				System.out.println(Terreno.mostrarTerrenos());
				int entrada = readInt();
				Terreno terreno = Terreno.getTerreno().get(entrada - 1);
				if (terreno.getCampesinos().isEmpty() == false) {
					if (terreno.getCultivos().isEmpty() == false) {
						System.out.println("Ingrese la opcion que corresponde al tipo ");
						System.out.println(terreno.mostrarCultivos());
						int eleccion = readInt();
						Cultivo cultivo = terreno.getCultivos().get(eleccion - 1);
						if(cultivo.getAmenaza() == null) {
							Campesino campesino = terreno.getCampesinos().peek();
							System.out.println("Se ha recolectado del cultivo de tipo " + cultivo.getTipoCultivo() + " "
									+ cultivo.getTamano() + " hectareas.");
							campesino.recolectar(cultivo);
						}
						else {
							System.out.println("El terreno se encuentra bajo una amenaza, por favor, exterminela para cosechar el cultivo");
						}
						
						
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
	public static void renunciaAleatoria() {
		new Campesino().renunciar();
		new Agronomo().renunciar();
	}
	public static void main(String args[]) {
		int opcionElegida;
		do {
			Amenaza.Amenazar();
			renunciaAleatoria();
			System.out.println("\n"+"Selecciona una funcion");
			System.out.println("1. Contratar");
			System.out.println("2. Despedir");
			System.out.println("3. Produccion total de los cultivos");
			System.out.println("4. Examinar cultivos");
			System.out.println("5. Cultivar y cosechar");
			System.out.println("6. Agregar terreno");
			System.out.println("7. Fertilizar e irrigar terrenos");
			System.out.println("8. Terminar" + "\n");
			opcionElegida = readInt();
			switch (opcionElegida) {
				case 1: contratar();break;
				case 2: despedir();break;
				case 3: produccion();break;
				case 4: examinarCultivo();break;
				case 5: cultivoyCosecha();break;
				case 6: agregarTerreno();break;
				case 7: ferrigar();break;
				case 8: break;
					
			}
		}while(opcionElegida != 8);
	}
}
