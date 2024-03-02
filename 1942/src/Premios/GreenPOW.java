package Premios;

import java.awt.Point;
import EntidadesGraficas.LabelGreenPOW;
import Visitors.Visitor;
import Visitors.VisitorGreenPOW;

public class GreenPOW extends PremioEspecial{

	public GreenPOW(Point p) {
		super(new LabelGreenPOW(p));
		velocidad = 2;
		visitor = new VisitorGreenPOW(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);	
	}
}
