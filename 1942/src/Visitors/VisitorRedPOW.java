package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;

public class VisitorRedPOW extends VisitorPremioEspecial {

	public VisitorRedPOW(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		entidad.eliminar();
		jugador.setPuntos(1000);
	}

}
