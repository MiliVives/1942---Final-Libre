package EstadosArma;


import Entidades.Jugador;
import Entidades.Proyectil;

public class SinArma extends EstadoArma {

	public SinArma(Jugador jugador) {
		super(jugador);
	}

	@Override
	public Proyectil disparar() {
		return null;
	}
}