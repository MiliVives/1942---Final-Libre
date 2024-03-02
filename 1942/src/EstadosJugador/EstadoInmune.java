package EstadosJugador;

import Entidades.Jugador;

public class EstadoInmune extends EstadoJugador {

	public EstadoInmune(Jugador jugador) {
		super(jugador);
		velocidad = jugador.getVelocidad();
	}

	public void decrementarVidaJugador() {
		//no hace nada porque es inmune 
	}
}