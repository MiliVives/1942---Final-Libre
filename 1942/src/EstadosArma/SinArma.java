package EstadosArma;

import Entidades.Jugador;
import Entidades.Proyectil;

public class SinArma extends EstadoArma {

	public SinArma(Jugador jugador) {
		super(jugador);
	}

	public Proyectil disparar() {
		return null;
	}
}