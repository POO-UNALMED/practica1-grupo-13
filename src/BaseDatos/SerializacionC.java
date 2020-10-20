package BaseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import gestorAplicacion.*;
import gestorAplicacion.empleado.*;
import gestorAplicacion.terreno.*;

public class SerializacionC {
	private static ObjectInputStream entradas;
	static File fichero = new File("");
	static Object Objeto;

	public static void Load() {
		try {

			entradas = new ObjectInputStream(
					new FileInputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Cultivos.txt"));

			Objeto = entradas.readObject();
			try {
				while (Objeto != null) {
					Cultivo.getCultivos().add((Cultivo) Objeto);
					Objeto = entradas.readObject();
				}
			} catch (java.io.EOFException e) {

			}
			entradas.close();
			entradas = new ObjectInputStream(
					new FileInputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Terrenos.txt"));
			Objeto = entradas.readObject();
			try {
				while (Objeto != null) {
					Terreno.getTerreno().add((Terreno) Objeto);
					Objeto = entradas.readObject();
				}
			} catch (java.io.EOFException e) {

			}
			entradas.close();
			entradas = new ObjectInputStream(
					new FileInputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Campesinos.txt"));
			Objeto = entradas.readObject();
			try {
				while (Objeto != null) {
					for (Terreno tempTerreno : Terreno.getTerreno()) {
						LinkedList<Campesino> tempCampesinos = new LinkedList<Campesino>();
						tempCampesinos = tempTerreno.getCampesinos();
						tempCampesinos.add((Campesino) Objeto);
					}
					Objeto = entradas.readObject();
				}
			} catch (java.io.EOFException e) {

			}
			entradas.close();
			entradas = new ObjectInputStream(
					new FileInputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Agronomos.txt"));
			Objeto = entradas.readObject();
			try {
				while (Objeto != null) {
					Agronomo.getAgronomos().add((Agronomo) Objeto);
					Objeto = entradas.readObject();
				}
			} catch (java.io.EOFException e) {

			}
			entradas.close();
			entradas = new ObjectInputStream(
					new FileInputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Amenazas.txt"));
			Objeto = entradas.readObject();
			try {
				while (Objeto != null) {
					for (Cultivo tempCultivo : Cultivo.getCultivos()) {
						tempCultivo.setAmenaza((Amenaza) Objeto);
					}
					Objeto = entradas.readObject();
				}
			} catch (java.io.EOFException e) {

			}
			entradas.close();
		} catch (Exception e) {

			System.out.println(e.toString());

		}
	}
}
