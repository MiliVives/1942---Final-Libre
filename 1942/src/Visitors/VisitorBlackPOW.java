package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;

public class VisitorBlackPOW extends VisitorPremioEspecial {

	public VisitorBlackPOW(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		entidad.eliminar();
		jugador.incrementarVida();
	}

}
