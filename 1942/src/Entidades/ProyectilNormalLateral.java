package Entidades;

import java.awt.Point;

import EntidadesGraficas.LabelProyectilMortal;
import Visitors.Visitor;

public class ProyectilNormalLateral extends ProyectilJugador {

	public ProyectilNormalLateral(Point posicion) {
		super(new LabelProyectilMortal(posicion));
		velocidad = 6;
		damage = 5;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}