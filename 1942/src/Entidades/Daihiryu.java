package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelDaihiryu;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import Visitors.Visitor;

public class Daihiryu extends Enemigo{

	public Daihiryu(Point p, int duracion, boolean enEspera) {
		super(new LabelDaihiryu(p), duracion, enEspera);
		vida = 50;
	}

	
	public void aparecer() {
		Enemigo inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new VerticalRemove(Daihiryu.this, Vertical.ARRIBA);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}
	
	public void disminuirVida(int daño) {
		vida = vida-daño;
		if(vida < 0)
			super.desaparecer();
		
	}

	public Proyectil disparar() {
		return new BalaBasica(new Point(entidad_graf.getX(), entidad_graf.getY() + 40), Vertical.ARRIBA);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
