package Entidades;

import EntidadesGraficas.LabelJugador;
import EstadosArma.ConArmaNormal;
import EstadosArma.EstadoArma;
import EstadosJugador.EstadoInicial;
import EstadosJugador.EstadoJugador;
import EstrategiasMovimiento.Horizontal;
import EstrategiasMovimiento.Vertical;
import Visitors.Visitor;

public class Jugador extends Entidad {
	protected EstadoArma estado_arma;
	protected EstadoJugador estado_jugador;
	protected int vidas, tiros, puntos;

	public Jugador() {
		super(new LabelJugador());
		movimiento = new Horizontal(this, Horizontal.DERECHA);
		estado_arma = new ConArmaNormal(this);
		estado_jugador = new EstadoInicial(this);
		vidas = 20;
		tiros = 0;
		puntos = 0;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void sumarPuntos(int points) {
		puntos+=points;
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
		estado_jugador.decrementarVidaJugador();

		if (vidas <= 0) {
			juego.eliminarEntidad(this);
			juego.perdio();
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
		puntos+=p;
	}
	
	public int getPuntos() {
		return puntos;
	}
}