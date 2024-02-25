package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;

public class VisitorGreenPOW extends VisitorPremioEspecial {

	public VisitorGreenPOW(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		entidad.eliminar();
		//incrementarle daño al arma
		//ver si hacer un proyectil nuevo o arma
	}

}
