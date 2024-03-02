package Logica;

import java.awt.Point;
import Entidades.Enemigo;
import Entidades.Qing;

/**
 * clase que se encarga de construir los enemigos tipo Qing
 *
 */

public class FactoryQing extends Factory {

	public FactoryQing() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Qing(p, tiempo, enEspera);
		tiempo = tiempo + 1000;
		return ene;
	}

	private Point posicion() {
		return new Point(150, mapa.getHeight()+100); //CAMBIAR POSICION SPAWN
	}

	protected void reiniciar() {
		tiempo = 1;
	}
}