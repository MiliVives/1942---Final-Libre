package Logica;

import java.awt.Point;
import java.util.Random;

import Premios.BlackPOW;
import Premios.GrayPOW;
import Premios.GreenPOW;
import Premios.OrangePOW;
import Premios.RedPOW;

/**
 * clase que se encarga de crear los premios de forma aleatoria 
 */
public class GeneradorDePremio {

	
	private static final int cantidadPremiosTemporales=1;
	private static final int cantidadPremios=5;
	
	/**
	 * metodo que crea un premio, es llamado de forma estatica
	 */
	public static void generar(Point p) {
		Random r= new Random();
		int indice=r.nextInt(cantidadPremios);
		Juego juego=Juego.getJuego();
		while(indice<cantidadPremiosTemporales && juego.getEstadoPremio()) {
			//se chequea que no se cree un premio temporal que ya este activado
			indice=r.nextInt(cantidadPremios);
		}
		switch(2) {
			case 0: new GreenPOW(p);
				break;
			case 1: new RedPOW(p);
				break;
			case 2: new GrayPOW(p);
				break;
			case 3: new OrangePOW(p);
				break;
			case 4: new BlackPOW(p);
				break;
		}
	}
}