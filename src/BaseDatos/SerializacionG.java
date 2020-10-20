package BaseDatos;

import gestorAplicacion.*;
import gestorAplicacion.empleado.*;
import gestorAplicacion.terreno.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class SerializacionG {
	static File fichero = new File("");
	static ObjectOutputStream entradas;

	public static void Save() {
		try {
			entradas = new ObjectOutputStream(
					new FileOutputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Cultivos.txt"));
			for (int i = 0; i < Cultivo.getCultivos().size(); i++) {
				entradas.writeObject(Cultivo.getCultivos().get(i));
			}
			entradas.close();
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage() + "  " + e.toString());
		}
		try {
			entradas = new ObjectOutputStream(
					new FileOutputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Terrenos.txt"));
			for (int i = 0; i < Terreno.getTerreno().size(); i++) {
				entradas.writeObject(Terreno.getTerreno().get(i));
				System.out.println("Write");
			}
			entradas.close();
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage() + "  " + e.toString());
		}
		try {
			entradas = new ObjectOutputStream(
					new FileOutputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Campesinos.txt"));
			for (Terreno tempTerreno : Terreno.getTerreno()) {
				LinkedList<Campesino> tempCampesinos = new LinkedList<Campesino>();
				tempCampesinos = tempTerreno.getCampesinos();
				for (Campesino tempCultivo : tempCampesinos) {
					entradas.writeObject(tempCultivo);
				}

			}
			entradas.close();
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage() + "  " + e.toString());
		}
		try {
			entradas = new ObjectOutputStream(
					new FileOutputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Agronomos.txt"));
			for (int i = 0; i < Agronomo.getAgronomos().size(); i++) {
				entradas.writeObject(Agronomo.getAgronomos().get(i));
			}
			entradas.close();
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage() + "  " + e.toString());
		}
		try {
			entradas = new ObjectOutputStream(
					new FileOutputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Amenazas.txt"));
			for (Cultivo temp : Cultivo.getCultivos()) {
				entradas.writeObject(temp.getAmenaza());
			}
			entradas.close();
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage() + "  " + e.toString());
		}
	}
}
