package Premios;

import java.awt.Point;
import EntidadesGraficas.LabelOrangePOW;
import Visitors.Visitor;
import Visitors.VisitorOrangePOW;

public class OrangePOW extends PremioTemporal{

	public OrangePOW(Point p) {
		super(new LabelOrangePOW(p));
		velocidad = 2;
		visitor = new VisitorOrangePOW(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
