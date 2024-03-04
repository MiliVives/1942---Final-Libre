package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;
import Logica.Juego;

/*
 * Visitor del powerUP blackPOW.
 * 
 */

public class VisitorBlackPOW extends VisitorPremioEspecial {

	public VisitorBlackPOW(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
		entidad.eliminar();
		Juego.getJuego().premioAgarrado();
		jugador.incrementarVida();
	}

}
