package Premios;

import java.awt.Point;
import EntidadesGraficas.LabelGrayPOW;
import Visitors.Visitor;
import Visitors.VisitorGrayPOW;

/*
 * Clase que modela al powerUp GrayPOW.
 * Crea los aviones laterales del jugador.
 */

public class GrayPOW extends PremioEspecial{

	public GrayPOW(Point p) {
		super(new LabelGrayPOW(p));
		velocidad = 2;
		visitor = new VisitorGrayPOW(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
}
