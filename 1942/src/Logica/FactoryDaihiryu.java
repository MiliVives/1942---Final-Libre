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

	@Override
	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Daihiryu(p, tiempo, enEspera);
		tiempo = tiempo + 5000;// cada enemigo aparecera con una diferencia de 5 segundos
		return ene;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth() - 60), -100); //CAMBIAR POSICION SPAWN
	}

	@Override
	protected void reiniciar() {
		tiempo = 1;
	}

}