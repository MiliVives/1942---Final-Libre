package Premios;

import java.awt.Point;
import EntidadesGraficas.LabelOrangePOW;
import Visitors.Visitor;
import Visitors.VisitorOrangePOW;

/**
 * Clase que modela al powerUp OrangePOW.
 * Da inmunidad por 3 segundos.
 */

public class OrangePOW extends PremioTemporal{

	public OrangePOW(Point p) {
		super(new LabelOrangePOW(p));
		velocidad = 2;
		duracion = 3000;
		visitor = new VisitorOrangePOW(this);		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);	
	}
}
