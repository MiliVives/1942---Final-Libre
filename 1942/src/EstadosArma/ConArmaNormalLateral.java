package EstadosArma;

import java.awt.Point;

import Entidades.AvionLateral;
import Entidades.Proyectil;
import Entidades.ProyectilNormalLateral;
import EntidadesGraficas.EntidadGrafica;

public class ConArmaNormalLateral extends EstadoArma {

	public ConArmaNormalLateral(AvionLateral jugador) {
		super(jugador);
	}

	@Override
	public Proyectil disparar() {
		EntidadGrafica g = this.jugador.getGrafico();
		return new ProyectilNormalLateral(new Point(g.getX(), g.getY() - 30));
	}
}