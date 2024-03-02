package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;
import EntidadesGraficas.LabelEntidadesDecoracion;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.Vertical_loop_estrellas;
import Visitors.Visitor;
import Visitors.VisitorEntidadesDecoracion;

public class EntidadesDecoracion extends Enemigo{

	public EntidadesDecoracion(Point p, int duracion, boolean enEspera) {
		super(new LabelEntidadesDecoracion(p), duracion, false);
		velocidad = 10;
		visitor = new VisitorEntidadesDecoracion(this);

	}

	public void disminuirVida(int daño) {
		
	}
	
	public void aparecer() {
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new Vertical_loop_estrellas(EntidadesDecoracion.this, Vertical.ABAJO);
				timer.cancel();
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}

	public Proyectil disparar() {
		return null;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void setLabel() {
		entidad_graf = new LabelEntidadesDecoracion(entidad_graf.getLocation());
	}

}
