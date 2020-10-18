package gestorAplicacion;

import java.util.*;
import gestorAplicacion.terreno.*;

public class Amenaza {
	private String tipoAmenaza;
	private LinkedList<Cultivo> cultivos = new LinkedList<Cultivo>(); //Se guardaran los Cultivos
	//Lo hicimos de otra forma, por eso no colocamos pesticida
	private double cantidad;//Cantidad del cultivo afectada en porcentaje
	
	public Amenaza(String tipoAmenaza, Cultivo cultivo) {
		this.tipoAmenaza = tipoAmenaza; this.cultivos.add(cultivo);
	}	
	public static void atacarCultivo(Amenaza amenaza,Cultivo cultivo) {
		cultivo.setAmenaza(amenaza);
	}
	public String getTipo() {
		return this.tipoAmenaza;
	}
	public static void Amenazar() {
		double Random_Para_AMENAZAR=Math.random();
		if(Random_Para_AMENAZAR>=0 && Random_Para_AMENAZAR<=0.4){
			double Random_Para_TipoPeste=Math.random();
			LinkedList<Cultivo>cultivatrones=Cultivo.getCultivos();
			String TipoPeste;
			int cantidad_de_cultivos=cultivatrones.size();
			if(cantidad_de_cultivos!=0) {
				int Random_Para_Sacar_Cultivo=(int)Random_Para_TipoPeste*cantidad_de_cultivos;
				if(cultivatrones.get(Random_Para_Sacar_Cultivo).getAmenaza()==null && cultivatrones.get(Random_Para_Sacar_Cultivo).getCantSembrada()>0) {
					if(Random_Para_TipoPeste>=0 && Random_Para_TipoPeste<=0.3) {
						TipoPeste="Plaga";
						Amenaza amenaza=new Amenaza(TipoPeste,cultivatrones.get(Random_Para_Sacar_Cultivo));
						atacarCultivo(amenaza,cultivatrones.get(Random_Para_Sacar_Cultivo));
					}
					else if(Random_Para_TipoPeste>0.3 && Random_Para_TipoPeste<0.6) {
						TipoPeste="Maleza";
						Amenaza amenaza=new Amenaza(TipoPeste,cultivatrones.get(Random_Para_Sacar_Cultivo));
						atacarCultivo(amenaza,cultivatrones.get(Random_Para_Sacar_Cultivo));
					}
					else {
						TipoPeste="Hongo";
						Amenaza amenaza=new Amenaza(TipoPeste,cultivatrones.get(Random_Para_Sacar_Cultivo));
						atacarCultivo(amenaza,cultivatrones.get(Random_Para_Sacar_Cultivo));
					}
				}
			}
		}
	}
}
