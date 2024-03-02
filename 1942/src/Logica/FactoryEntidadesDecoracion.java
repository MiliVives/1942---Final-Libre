package Logica;

import java.awt.Point;
import Entidades.Enemigo;
import Entidades.EntidadesDecoracion;

/**
 * clase que se encarga de construir las entidades de decoracion (estrellas)
 *
 */

public class FactoryEntidadesDecoracion extends Factory {

	public FactoryEntidadesDecoracion() {
		super();
	}

	@Override
	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new EntidadesDecoracion(p, tiempo, enEspera);
		tiempo = tiempo + 250;
		return ene;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth() - 60), -100); //CAMBIAR POSICION SPAWN
	} 

	protected void reiniciar() {
		tiempo = 1;
	}

}