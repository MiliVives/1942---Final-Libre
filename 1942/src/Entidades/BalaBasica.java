package Entidades;

import java.awt.Point;

import EntidadesGraficas.LabelBalaBasica;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;

public class BalaBasica extends Bala {

	public BalaBasica(Point posicion) {
		super(new LabelBalaBasica(posicion));
		velocidad = 6;
		damage = 5;
		rango = 400;
		movimiento = new VerticalRemove(this, Vertical.ARRIBA);
	}

}