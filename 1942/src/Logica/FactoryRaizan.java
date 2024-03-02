package Logica;

import java.awt.Point;
import Entidades.Enemigo;
import Entidades.Raizan;
/**
 * clase que se encarga de construir los enemigos tipo Raizan
 *
 */
public class FactoryRaizan extends Factory {

	public FactoryRaizan() {
		super();
	}

	public Enemigo crearEnemigo(boolean enEspera) {
		Point p = posicion();
		Enemigo ene = new Raizan(p, tiempo, enEspera);
		tiempo = tiempo + 1000;// cada enemigo aparecera con una diferencia de 5 segundos
		return ene;
	}

	private Point posicion() {
		return new Point(r.nextInt(mapa.getWidth() - 60), mapa.getHeight()+100); //CAMBIAR POSICION SPAWN
	}

	protected void reiniciar() {
		tiempo = 1;
	}
}