package Logica;

import java.awt.Point;
import Entidades.Enemigo;
import Entidades.Fukusuke;

/**
 * clase que se encarga de construir los enemigos tipo Fukuske
 *
 */

public class FactoryFukusuke extends Factory {

	public FactoryFukusuke() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Fukusuke(p, tiempo+5000, enEspera);
		tiempo = tiempo + 3000;
		return ene;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth() - 60), -100); 
	}

	protected void reiniciar() {
		tiempo = 1;
	}

}