package Entidades;

import java.awt.Point;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelDaihiryu;
import EntidadesGraficas.LabelShoryu;
import EstrategiasMovimiento.EliminarTotal;
import EstrategiasMovimiento.EstrategiaShoryu;
import EstrategiasMovimiento.Vertical;
import Logica.GeneradorDePremio;
import Visitors.Visitor;

public class Shoryu extends Enemigo{

	public Shoryu(Point p, int duracion, boolean enEspera) {
		super(new LabelShoryu(p), duracion, enEspera);
	}

	public void disminuirVida(int daño) {
		vida = vida-daño;
		if(vida < 0)
			desaparecer();
		
	}
	
	public void desaparecer() {
		LabelShoryu li = (LabelShoryu) this.getGrafico();
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
				movimiento = new EliminarTotal(Shoryu.this,1);
				timer.cancel();
			}

		}, 1 * 1000);

	}
	
	public void aparecer() {
		Random r = new Random();
		int[] doI = new int[2];
		doI[0] = -1;
		doI[1] = 1;
		Enemigo inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new EstrategiaShoryu(Shoryu.this, doI[r.nextInt(2)]);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}

	public Proyectil disparar() {
		return new BalaBasicaShoryu(new Point(entidad_graf.getX()+10, entidad_graf.getY() + 40), Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
