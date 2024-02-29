package EstadosArma;

import java.awt.Point;
import Entidades.Jugador;
import Entidades.Proyectil;
import Entidades.ProyectilMortal;
import EntidadesGraficas.EntidadGrafica;

public class ConArmaMortal extends EstadoArma {

	public ConArmaMortal(Jugador jugador) {
		super(jugador);
	}

	@Override
	public Proyectil disparar() {
		EntidadGrafica g = this.jugador.getGrafico();
		return new ProyectilMortal(new Point(g.getX(), g.getY() - 30));
	}
}