package Entidades;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelDaihiryu;
import EntidadesGraficas.LabelFukusuke;
import EstrategiasMovimiento.EliminarTotal;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemoveEnemigo;
import Logica.GeneradorDePremio;
import Visitors.Visitor;

public class Fukusuke extends Enemigo{

	public Fukusuke(Point p, int duracion, boolean enEspera) {
		super(new LabelFukusuke(p), duracion, enEspera);
		velocidad = 2;
	}

	
	public void desaparecer() {
		LabelFukusuke li = (LabelFukusuke) this.getGrafico();
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
				movimiento = new EliminarTotal(Fukusuke.this,1);
				timer.cancel();
			}

		}, 1 * 1000);

	}
	
	public void disminuirVida(int daño) {
		vida = vida-daño;
		if(vida < 0)
			super.desaparecer();
	}

	public Proyectil disparar() {
		return new BalaBasicaShoryu(new Point(entidad_graf.getX()+15, entidad_graf.getY() + 40), Vertical.ABAJO);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
