package Logica;

import java.awt.Point;
import java.util.Random;
import Premios.BlackPOW;
import Premios.GrayPOW;
import Premios.OrangePOW;
import Premios.RedPOW;

/**
 * clase que se encarga de crear los premios de forma aleatoria 
 */

public class GeneradorDePremio {

	private static final int cantidadPremiosTemporales=1;
	private static final int cantidadPremios=4;
	
	public static void generar(Point p) {
		Random r= new Random();
		int indice=r.nextInt(cantidadPremios);
		Juego juego=Juego.getJuego();
		while(indice<cantidadPremiosTemporales && juego.getEstadoPremio()) {
			indice=r.nextInt(cantidadPremios);
		}
		switch(indice) {
			case 0: new RedPOW(p);
				break;
			case 1: new GrayPOW(p);
				break;
			case 2: new OrangePOW(p);
				break;
			case 3: new BlackPOW(p);
				break;
		}
	}
}