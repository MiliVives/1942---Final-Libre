package Premios;

import java.awt.Point;
import EntidadesGraficas.LabelRedPOW;
import Visitors.Visitor;
import Visitors.VisitorRedPOW;

public class RedPOW extends PremioEspecial{

	public RedPOW(Point p) {
		super(new LabelRedPOW(p));
		velocidad = 2;
		visitor = new VisitorRedPOW(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
