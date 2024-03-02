package Logica;

import java.util.LinkedList;
import java.util.List;
import Entidades.Enemigo;

/**
 * clase que modela un nivel, almacena los enemigos en cada tanda
 *
 */

public class Nivel {

	private int valor; // num de nivel, para el fondo
	private int tandaActual;
	private Juego juego;

	private List<Tanda> tandas;

	public Nivel(int valor) {
		tandas = new LinkedList<Tanda>();
		tandaActual = 0;
		this.valor = valor;
		juego = Juego.getJuego();
	}

	/**
	 * metodo que se llama durante la construccion del nivel
	 */
	
	public void agregarTanda(Tanda t) {
		tandas.add(t);
	}

	public void setValor(int nivel) {
		this.valor = nivel;
	}

	public void eliminarEnemigo(Enemigo e) {
		Tanda tanda = tandas.get(tandaActual);
		tanda.eliminarEnemigo(e);
		if (tanda.vacia()) { 						// ya se elimino todos los enemigos de la tanda
			if (tandaActual + 1 < tandas.size()) { 	// quedan tandas en el nivel
				tandaActual++;
				tandas.get(tandaActual).aparecer();
			} else {
				juego.nivelCompleto(); 				// si ya no quedan tandas se le notifica al juego que el nivel fue completa
			}
		}
	}

	public int getValor() {
		return this.valor;
	}

	public int getNumeroTanda() {
		return this.tandaActual;
	}

	public Tanda getTanda() {
		return tandas.get(tandaActual);
	}
}