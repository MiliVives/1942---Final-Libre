package Entidades;

import java.awt.Point;

import EntidadesGraficas.LabelProyectilNormal;
import Visitors.Visitor;

public class ProyectilMortal extends ProyectilJugador {

	public ProyectilMortal(Point posicion) {
		super(new LabelProyectilNormal(posicion));
		velocidad = 6;
		damage = 6;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}