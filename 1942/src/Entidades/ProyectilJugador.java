package Entidades;

import EntidadesGraficas.EntidadGrafica;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import Visitors.VisitorProyectilJugador;

public abstract class ProyectilJugador extends Proyectil {

	public ProyectilJugador(EntidadGrafica entidad_graf) {
		super(entidad_graf);
		movimiento = new VerticalRemove(this, Vertical.ARRIBA);
		visitor = new VisitorProyectilJugador(this);
	}

}