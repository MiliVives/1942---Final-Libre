package Visitors;

import Entidades.Bala;
import Entidades.Daihiryu;
import Entidades.Entidad;
import Entidades.ProyectilJugador;
import Entidades.Qing;
import Entidades.Raizan;
import Entidades.Shoryu;

public class VisitorProyectilJugador extends Visitor{

	public VisitorProyectilJugador(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Qing i) {
		ProyectilJugador e = (ProyectilJugador) entidad;
		e.eliminar();
		i.disminuirVida(e.getDamage());		
	}

	public void visit(Raizan i) {
		ProyectilJugador e = (ProyectilJugador) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Daihiryu i) {
		ProyectilJugador e = (ProyectilJugador) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Shoryu i) {
		ProyectilJugador e = (ProyectilJugador) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}

}
