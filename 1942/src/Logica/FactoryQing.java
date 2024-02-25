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

	@Override
	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Qing(p, tiempo, enEspera);
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