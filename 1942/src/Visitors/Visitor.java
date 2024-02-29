package Visitors;

import Entidades.Bala;
import Entidades.Daihiryu;
import Entidades.Entidad;
import Entidades.EntidadesDecoracion;
import Entidades.Fukusuke;
import Entidades.Jugador;
import Entidades.ProyectilMortal;
import Entidades.ProyectilNormal;
import Entidades.ProyectilNormalLateral;
import Entidades.Qing;
import Entidades.Raizan;
import Entidades.Shoryu;
import Entidades.Zero;
import Premios.BlackPOW;
import Premios.GrayPOW;
import Premios.GreenPOW;
import Premios.OrangePOW;
import Premios.RedPOW;

public abstract class Visitor {
	protected Entidad entidad;

	public Visitor(Entidad entidad) {
		this.entidad = entidad;
	}

	public void visit(Jugador jugador) {
	
	}

	public void visit(Qing qing) {
	
	}
	
	public void visit(Bala bala) {
		
	}

	public void visit(Raizan raizan) {
		
	}

	public void visit(ProyectilNormal proyectilNormal) {
		
	}

	public void visit(Daihiryu daihiryu) {
		
	}

	public void visit(Shoryu shoryu) {

	}

	public void visit(RedPOW redPOW) {
		
	}

	public void visit(BlackPOW blackPOW) {
		
	}

	public void visit(GreenPOW greenPOW) {
		
	}

	public void visit(GrayPOW grayPOW) {
		
	}

	public void visit(OrangePOW orangePOW) {
		
	}

	public void visit(Fukusuke fukusuke) {

	}

	public void visit(Zero zero) {
		
	}

	public void visit(ProyectilMortal proyectilMortal) {
		
	}

	public void visit(EntidadesDecoracion entidadesDecoracion) {
		
	}

	public void visit(ProyectilNormalLateral proyectilNormalLateral) {
		
	}
}