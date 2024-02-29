package Visitors;

import Entidades.AvionLateral;
import Entidades.Entidad;
import Entidades.Jugador;
import EntidadesGraficas.LabelJugador;

public class VisitorGrayPOW extends VisitorPremioEspecial {

	public VisitorGrayPOW(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		jugador.CrearNavesLaterales();
		entidad.eliminar();
	}

}
