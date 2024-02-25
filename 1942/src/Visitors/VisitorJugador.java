package Visitors;

import Entidades.Bala;
import Entidades.Daihiryu;
import Entidades.Jugador;
import Entidades.Qing;
import Entidades.Raizan;
import Entidades.Shoryu;

public class VisitorJugador extends Visitor{

	public VisitorJugador(Jugador entidad) {
		super(entidad);
	}
}
