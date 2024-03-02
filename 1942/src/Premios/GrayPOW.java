package Premios;

import java.awt.Point;
import EntidadesGraficas.LabelGrayPOW;
import Visitors.Visitor;
import Visitors.VisitorGrayPOW;

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
