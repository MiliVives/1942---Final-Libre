package Logica;

import java.awt.Point;
import Entidades.Daihiryu;
import Entidades.Enemigo;

/**
 * clase que se encarga de construir los enemigos tipo Daihiryu
 *
 */
public class FactoryDaihiryu extends Factory {

	public FactoryDaihiryu() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Daihiryu(p, tiempo, enEspera);
		tiempo = tiempo + 5000;
		return ene;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth() - 60), mapa.getHeight()+100); //CAMBIAR POSICION SPAWN
	}

	protected void reiniciar() {
		tiempo = 1;
	}

}