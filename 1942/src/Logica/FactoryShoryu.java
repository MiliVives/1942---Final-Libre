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

	@Override
	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Shoryu(p, tiempo, enEspera);
		tiempo = tiempo + 5000;// cada enemigo aparecera con una diferencia de 5 segundos
		return ene;
	}

	private Point posicion() {
		return new Point(360, -100); //CAMBIAR POSICION SPAWN
	}//r.nextInt(mapa.getWidth() - 60

	@Override
	protected void reiniciar() {
		tiempo = 1;
	}

}