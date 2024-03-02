package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;

public class VisitorGreenPOW extends VisitorPremioEspecial {

	public VisitorGreenPOW(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		//ver de hacer nueva entidad para disparar que de puntos
		entidad.eliminar();
	}
}
