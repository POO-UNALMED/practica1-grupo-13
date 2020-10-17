package gestorAplicacion.empleado;
import java.util.*;
import gestorAplicacion.terreno.*;

public class Administrador{
	public static void main(String args[]) {
		int opcionElegida = 0;
		while(opcionElegida != 5) {
			Scanner Sc = new Scanner(System.in);
			
			System.out.println("¿Qué funcionalidad desea usar?");
			System.out.println("1. Contratar");
			System.out.println("2. Despedir");
			System.out.println("3. Crear terreno");
			System.out.println("4. Crear cultivo");
			opcionElegida = Sc.nextInt();
			
		}
		
	}
}