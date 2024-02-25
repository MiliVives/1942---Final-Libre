package Entidades;

import java.awt.Point;
import EntidadesGraficas.LabelZero;
import Visitors.Visitor;

public class Zero extends Enemigo{

	public Zero(Point p, int duracion, boolean enEspera) {
		super(new LabelZero(p), duracion, enEspera);
	}

	@Override
	public void disminuirVida(int daño) {
		vida = vida-daño;
		if(vida < 0)
			super.desaparecer();
	}

	public Proyectil disparar() {
		return new BalaBasica(new Point(entidad_graf.getX(), entidad_graf.getY() + 40));
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
