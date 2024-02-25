package Entidades;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.EntidadGrafica;
import EntidadesGraficas.LabelEnemigo;
import EstrategiasMovimiento.Vertical;
import EstrategiasMovimiento.VerticalRemove;
import Logica.GeneradorDePremio;
import Visitors.VisitorEnemigo;

public abstract class Enemigo extends Entidad {
	protected int vida;
	protected boolean suelta_premio;
	protected boolean muerto;
	protected int tiempoEspera;
	protected int damage, puntos;
	protected boolean quieto;

	protected Random random;

	/**
	 * Crea un infectado
	 * 
	 * @param entidad_graf entidad grafica de la entidad
	 * @param duracion     tiempo que permanecer� quieto el enemigo, en
	 *                     milisegundos desde que empieza su tanda
	 * @param enEspera     parametro necesario para saber si el infectado que se
	 *                     crea pertene a la primer tanda(en ese caso no estara en
	 *                     espera) o y si deberia quedarse quieto hasta que se
	 *                     notifique(cuando se llegue a su tanda)
	 */
	public Enemigo(EntidadGrafica entidad_graf, int duracion, boolean enEspera) {
		super(entidad_graf);
		velocidad = 1;
		movimiento = null;// en principio no se moveran hasta que se indique que aparezca por pantalla
		random = new Random();
		suelta_premio = random.nextInt(5) == 1;
		vida = 5;
		damage = 1;
		muerto = false;
		quieto = false;
		puntos = 100;

		tiempoEspera = duracion;
		if (!enEspera)
			aparecer();

		visitor = new VisitorEnemigo(this);
	}

	/**
	 * cuando se llama a este m�todo empieza a contar el tiempo de espera del
	 * infectado para luego aparecer en pantalla
	 */
	public void aparecer() {
		Enemigo inf = this;
		Timer timer = new Timer();
		TimerTask timer_task = new TimerTask() {
			@Override
			public void run() {
				if (juego.jugando())
					movimiento = new VerticalRemove(inf, Vertical.ABAJO);
				timer.cancel();// se ejecuta una vez el run y se cancela el timer
			};
		};

		timer.schedule(timer_task, tiempoEspera, 1);
	}

	public abstract void disminuirVida(int daño);

	public abstract Proyectil disparar();

	public int getVida() {
		return vida;
	}

	public void eliminar() {
		juego.eliminarEnemigo(this);
	}

	public void accionar() {
		if (!quieto || muerto) {
			if (movimiento != null)
				movimiento.mover();

			if (!muerto && random.nextInt(100) == 1) {// para que no dispare demasiado se considera solo una de
															// cada 100 veces que se llame al accionar (en promedio)
				disparar();
			}
		}
	}

	/**
	 * Es invocado cuando el enemigo tiene vida 0
	 */
	public void desaparecer() {
		LabelEnemigo li = (LabelEnemigo) this.getGrafico();
		li.seMato();
		if (suelta_premio) {
			GeneradorDePremio.generar(entidad_graf.getLocation());
		}
		if(muerto == false) {
			juego.sumarPuntos(puntos);
			muerto = true;
		}
		eliminar();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				eliminar();
				timer.cancel();
			}

		}, 1 * 1000);
	}

	public int getDamage() {
		return damage;
	}

	public void setQuieto(boolean estado) {
		quieto = estado;
	}
	
	public int getPuntos() {
		return puntos;
	}

}