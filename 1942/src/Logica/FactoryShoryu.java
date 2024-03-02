package Logica;

import java.awt.Point;
import Entidades.Enemigo;
import Entidades.Shoryu;

/**
 * clase que se encarga de construir los enemigos tipo Shoryu
 *
 */

public class FactoryShoryu extends Factory {

	public FactoryShoryu() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Shoryu(p, tiempo, enEspera);
		tiempo = tiempo + 5000;
		return ene;
	}

	private Point posicion() {
		return new Point(360, -100);
	}

	protected void reiniciar() {
		tiempo = 1;
	}
}