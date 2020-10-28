package BaseDatos;

import gestorAplicacion.*;
import gestorAplicacion.empleado.*;
import gestorAplicacion.terreno.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.io.FileNotFoundException;

public class SerializacionG {
	static File fichero = new File("");
	static ObjectOutputStream entradas;

	public static void Save() {
		try {
			entradas = new ObjectOutputStream(new FileOutputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Cultivos.txt"));
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
			for (int i = 0; i < Terreno.getTerrenos().size(); i++) {
				Terreno terreno = Terreno.getTerrenos().get(i);
				entradas.writeObject(terreno);
			}
			entradas.close();
		} catch (IOException e) {
			System.out.println("ERROR" + e.getMessage() + "  " + e.toString());
		}
	}
}
