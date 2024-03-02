package Visitors;

import Entidades.Bala;
import Entidades.Daihiryu;
import Entidades.Entidad;
import Entidades.Fukusuke;
import Entidades.ProyectilNormal;
import Entidades.ProyectilNormalLateral;
import Entidades.Qing;
import Entidades.Raizan;
import Entidades.Shoryu;
import Entidades.Zero;

public class VisitorProyectilNormalLateral extends Visitor{

	public VisitorProyectilNormalLateral(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Qing i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;
		e.eliminar();
		i.disminuirVida(e.getDamage());		
	}

	public void visit(Raizan i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Daihiryu i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Shoryu i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Fukusuke i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Zero i) {
		ProyectilNormalLateral e = (ProyectilNormalLateral) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}

}
