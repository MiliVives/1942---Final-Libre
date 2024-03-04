package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;
import Logica.Juego;

/*
 * Visitor del powerUP GrayPOW.
 * 
 */

public class VisitorGrayPOW extends VisitorPremioEspecial {

	public VisitorGrayPOW(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		jugador.CrearNavesLaterales();
		entidad.eliminar();
		Juego.getJuego().premioAgarrado();
	}

}
