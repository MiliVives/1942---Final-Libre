package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelEntidadesDecoracion;
import EntidadesGraficas.LabelPlaneta;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import EstrategiasMovimiento.Vertical_loop;
import Visitors.Visitor;
import Visitors.VisitorEntidadesDecoracion;

/*
 * Clase que modela un tipo de entidad decorativa.
 * 
 */

public class Planeta extends EntidadesDecoracion{

	public Planeta(Point p, int duracion, boolean enEspera) {
		super(p, duracion, false);
		entidad_graf = new LabelPlaneta(p);
		velocidad = 1;
		visitor = new VisitorEntidadesDecoracion(this);
		super.tiempoEspera = duracion;
	}

	@Override
	public void disminuirVida(int daño) {
		
	}
	
	public void aparecer() {
		Enemigo inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new Vertical_loop(Planeta.this, Vertical.ABAJO);
				timer.cancel();
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}
	
	public Proyectil disparar() {
		return null;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
