package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;
import EntidadesGraficas.LabelZero;
import EstrategiasMovimiento.EstrategiaZero;
import EstrategiasMovimiento.Vertical;
import Visitors.Visitor;

public class Zero extends Enemigo{

	public Zero(Point p, int duracion, boolean enEspera) {
		super(new LabelZero(p), duracion, enEspera);
		velocidad = 5;
	}

	public void disminuirVida(int daño) {
		vida = vida-daño;
		if(vida < 0)
			super.desaparecer();
	}
	
	public void aparecer() {
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new EstrategiaZero(Zero.this, Vertical.ARRIBA);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}

	public Proyectil disparar() {
		return new BalaBasica(new Point(entidad_graf.getX(), entidad_graf.getY() + 40), Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
