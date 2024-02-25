package Entidades;

import java.awt.Point;

import EntidadesGraficas.LabelProyectilNormal;
import Visitors.Visitor;

public class ProyectilNormal extends ProyectilJugador {

	public ProyectilNormal(Point posicion) {
		super(new LabelProyectilNormal(posicion));
		velocidad = 6;
		damage = 5;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}