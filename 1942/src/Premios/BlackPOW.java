package Premios;

import java.awt.Point;
import EntidadesGraficas.LabelBlackPOW;
import Visitors.Visitor;
import Visitors.VisitorBlackPOW;

public class BlackPOW extends PremioEspecial{

	public BlackPOW(Point p) {
		super(new LabelBlackPOW(p));
		velocidad = 2;
		visitor = new VisitorBlackPOW(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}
}
