package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;
import Entidades.Proyectil;

public class VisitorBala extends Visitor{

	public VisitorBala(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador j) {
		Proyectil p = (Proyectil) entidad;
		p.eliminar();
		j.decrementarVidas();
	}

}
