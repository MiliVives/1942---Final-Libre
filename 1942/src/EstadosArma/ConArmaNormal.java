package EstadosArma;

import java.awt.Point;
import Entidades.Jugador;
import Entidades.Proyectil;
import Entidades.ProyectilNormal;
import EntidadesGraficas.EntidadGrafica;

public class ConArmaNormal extends EstadoArma {

	public ConArmaNormal(Jugador jugador) {
		super(jugador);
	}

	@Override
	public Proyectil disparar() {
		EntidadGrafica g = this.jugador.getGrafico();
		return new ProyectilNormal(new Point(g.getX(), g.getY() - 30));
	}
}