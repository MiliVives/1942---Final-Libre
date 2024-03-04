package Visitors;

import Entidades.AvionLateral;
import Entidades.Entidad;
import Entidades.Jugador;

/*
 * Visitor de estrellas y planetas.
 * 
 */

public class VisitorEntidadesDecoracion extends VisitorEnemigo{

	public VisitorEntidadesDecoracion(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador j) {
		
	}
	
	public void visit(AvionLateral j) {
		
	}
}