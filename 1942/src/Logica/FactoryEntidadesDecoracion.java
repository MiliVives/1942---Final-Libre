package Logica;

import java.awt.Point;

import Entidades.Enemigo;
import Entidades.EntidadesDecoracion;
/**
 * clase que se encarga de construir los enemigos tipo Qing
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
		tiempo = tiempo + 5000;// cada enemigo aparecera con una diferencia de 5 segundos
		return ene;
	}

	private Point posicion() {
		int xRan[] = new int[2];
		xRan[0] = 150;
		xRan[1] = 500;
		return new Point(xRan[r.nextInt(2)], -100); 
	}

	@Override
	protected void reiniciar() {
		tiempo = 1;
	}

}