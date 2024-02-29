package Entidades;

import java.util.Timer;
import java.util.TimerTask;

import EntidadesGraficas.LabelAvionLateral;
import EstadosArma.ConArmaNormalLateral;
import EstadosArma.EstadoArma;
import EstadosArma.SinArma;
import EstadosJugador.EstadoInicial;
import EstadosJugador.EstadoInmune;
import EstadosJugador.EstadoJugador;
import EstrategiasMovimiento.Horizontal;
import EstrategiasMovimiento.Vertical;
import Visitors.Visitor;

public class AvionLateral extends Jugador {
	protected EstadoArma estado_arma;
	protected EstadoJugador estado_avion;
	protected int vidas, tiros;
	protected Jugador jugadorPadre;

	public AvionLateral(Jugador j, int i) {
		super();  
		jugadorPadre = j;
		entidad_graf = new LabelAvionLateral();
		int desplazamientoI = 0;
		if(i == -1)
			desplazamientoI = -30;
		else desplazamientoI = 50;
		entidad_graf.setBounds(j.getGrafico().getX()+desplazamientoI, j.getGrafico().getY(), entidad_graf.getWidth(), entidad_graf.getHeight());
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_arma = new ConArmaNormalLateral(this);
		estado_avion = new EstadoInicial(this);
		vidas = 20;
		tiros = 0;
		puntos = 0;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public int getVidas() {
		return vidas;
	}
	
	public void restarVida() {
		vidas--;
	}
	
	public void incrementarVida() {
		vidas++;
	}

	public void decrementarVidas() {
		estado_avion.decrementarVidaJugador();

		if (vidas <= 0) {
			juego.eliminarEntidad(this);
		}
	}

	public void accionar() {
		if (juego.moviendoDerecha()) {
			setMovimiento(new Horizontal(this, Horizontal.DERECHA));
			this.movimiento.mover();
		}

		if (juego.moviendoIzquierda()) {
			setMovimiento(new Horizontal(this,Horizontal.IZQUIERDA));
			this.movimiento.mover();
		}
		
		if (juego.moviendoArriba()) {
			setMovimiento(new Vertical(this, Vertical.ARRIBA));
			this.movimiento.mover();
		}
		
		if (juego.moviendoAbajo()) {
			setMovimiento(new Vertical(this, Vertical.ABAJO));
			this.movimiento.mover();
		}

		if (juego.disparando()) {
			tiros++;
			if (tiros == 8) {
				this.estado_arma.disparar();
				tiros = 0;
				juego.seDisparo();
			}
		}
		
		if(juego.getDiveo()) {
			setEstadoJugador(new EstadoInmune(this));
			System.out.println("SOY INMUNE LOCOO");
			setEstadoArma(new SinArma(this));
//			((LabelJugador) entidad_graf).setDiveo(true);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					setEstadoJugador(new EstadoInicial(AvionLateral.this));
					setEstadoArma(new ConArmaNormalLateral(AvionLateral.this));
					timer.cancel();
				}

			}, 3 * 1000);

		}
	}
	
	public void CrearNavesLaterales() {
		
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public Proyectil disparar() {
		return estado_arma.disparar();
	}

	public void setEstadoJugador(EstadoJugador estado_jugador) {
		this.estado_jugador = estado_jugador;
	}

	public void setEstadoArma(EstadoArma estado_arma) {
		this.estado_arma = estado_arma;
	}

	public EstadoArma getEstadoArma() {
		return estado_arma;
	}

	public EstadoJugador getEstadoJugador() {
		return estado_jugador;
	}

	@Override
	public int getVelocidad() {
		return estado_jugador.getVelocidad();
	}

	public void setPuntos(int p) {
		jugadorPadre.setPuntos(p);
	}
	
	public int getPuntos() {
		return puntos;
	}
}