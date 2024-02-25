package Entidades;

import java.awt.Point;
import EntidadesGraficas.LabelQing;
import Visitors.Visitor;

public class Qing extends Enemigo{

	public Qing(Point p, int duracion, boolean enEspera) {
		super(new LabelQing(p), duracion, enEspera);
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
