package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;

public class VisitorGrayPOW extends VisitorPremioEspecial {

	public VisitorGrayPOW(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		entidad.eliminar();
		//buffar jugador con compañero de ataque
	}

}
