package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;

public class VisitorEntidadesDecoracion extends VisitorEnemigo{

	public VisitorEntidadesDecoracion(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador j) {
		
	}
}