package BaseDatos;

import gestorAplicacion.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import gestorAplicacion.empleado.*;
import gestorAplicacion.terreno.*;

public class SerializacionC {
	private static ObjectInputStream entradas;
	static File fichero = new File("");
	static Object Objeto;

	public static void Load() {
		
		try {
			entradas = new ObjectInputStream(new FileInputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Cultivos.txt"));
			Objeto = entradas.readObject();
			while (Objeto != null) {
			Cultivo.getCultivos().add((Cultivo) Objeto);
			Objeto = entradas.readObject();
			}
			entradas.close();

		} catch (java.io.IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		} 
		
		try {
			entradas = new ObjectInputStream(new FileInputStream(fichero.getAbsolutePath() + "\\src\\BaseDatos\\temp\\Terrenos.txt"));
			Objeto = entradas.readObject();
			while (Objeto != null) {
				Terreno.getTerreno().add((Terreno) Objeto);
				Terreno tempTerreno = (Terreno) Objeto;
				if (tempTerreno.getAgronomo()!=null) {
					Agronomo.getAgronomos().add(tempTerreno.getAgronomo());
				}
				
				Objeto = entradas.readObject();
			}						
			entradas.close();
			
		} catch (java.io.IOException e) {

		} catch (ClassNotFoundException e) {

		}
				
	}
}
