package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Enemigo;

/**
 * clase que modela una tanda de enemigos
 *
 */
public class Tanda {
	private List<Enemigo> aviones;

	public Tanda() {
		aviones = new LinkedList<Enemigo>();
	}

	public boolean vacia() {
		return aviones.isEmpty();
	}

	public void agregarEnemigo(Enemigo avion) {
		aviones.add(avion);
	}

	public void eliminarEnemigo(Enemigo ene) {
		aviones.remove(ene);
	}

	public void aparecer() {
		for (Enemigo i : aviones) {
			i.aparecer();
		}
	}

	public List<Enemigo> getEnemigos() {
		return aviones;
	}
}