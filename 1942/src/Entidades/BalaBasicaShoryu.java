package Entidades;

import java.awt.Point;

import Entidades.BalaBasica;
import EntidadesGraficas.LabelBalaBasica;
import EntidadesGraficas.LabelBalaShoryu;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;

/*
 * Implementacion auxiliar de las balas enemigas utilizadas para Shoryu y Fukusuke porque aparecen por el norte del mapa
 * 
 */

public class BalaBasicaShoryu extends Bala {

	public BalaBasicaShoryu(Point posicion, int pos) {
		super(new LabelBalaShoryu(posicion));
		velocidad = 6;
		damage = 5;
		rango = 400;
		movimiento = new VerticalRemove(this, pos);
	}

}