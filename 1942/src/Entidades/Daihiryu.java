package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;
import EntidadesGraficas.LabelDaihiryu;
import EntidadesGraficas.LabelZero;
import EstrategiasMovimiento.EliminarTotal;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import EstrategiasMovimiento.VerticalRemoveEnemigo;
import Logica.GeneradorDePremio;
import Visitors.Visitor;

public class Daihiryu extends Enemigo{

	public Daihiryu(Point p, int duracion, boolean enEspera) {
		super(new LabelDaihiryu(p), duracion, enEspera);
		vida = 40;
		velocidad = 3;
	}

	
	public void desaparecer() {
		LabelDaihiryu li = (LabelDaihiryu) this.getGrafico();
		li.seMato();
		if (suelta_premio) {
			GeneradorDePremio.generar(entidad_graf.getLocation());
		}
		if(muerto == false) {
			juego.sumarPuntos(puntos);
			muerto = true;
		}
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				movimiento = new EliminarTotal(Daihiryu.this,1);
				timer.cancel();
			}

		}, 1 * 1000);

	}
	
	public void aparecer() {
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new VerticalRemoveEnemigo(Daihiryu.this, Vertical.ARRIBA);
				timer.cancel();
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}
	
	public void disminuirVida(int daño) {
		vida = vida-daño;
		if(vida < 0)
			desaparecer();
		
	}

	public Proyectil disparar() {
		return new BalaBasica(new Point(entidad_graf.getX()+60, entidad_graf.getY() - entidad_graf.getHeight()/2), Vertical.ARRIBA);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
