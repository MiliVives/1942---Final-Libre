package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelQing;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import Visitors.Visitor;

public class Qing extends Enemigo{

	public Qing(Point p, int duracion, boolean enEspera) {
		super(new LabelQing(p), duracion, enEspera);
		velocidad = 3;
	}

	public void disminuirVida(int daño) {
		vida = vida-daño;
		if(!muerto && vida < 0)
			super.desaparecer();
		
	}
	
	public void aparecer() {
		Enemigo inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new VerticalRemove(inf, Vertical.ARRIBA);
				timer.cancel();
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}

	public Proyectil disparar() {
		return new BalaBasica(new Point(entidad_graf.getX(), entidad_graf.getY() + 40), Vertical.ARRIBA);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
