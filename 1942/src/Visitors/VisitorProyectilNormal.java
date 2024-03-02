package Visitors;

import Entidades.Bala;
import Entidades.Daihiryu;
import Entidades.Entidad;
import Entidades.Fukusuke;
import Entidades.ProyectilNormal;
import Entidades.Qing;
import Entidades.Raizan;
import Entidades.Shoryu;
import Entidades.Zero;

public class VisitorProyectilNormal extends Visitor{

	public VisitorProyectilNormal(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Qing i) {
		ProyectilNormal e = (ProyectilNormal) entidad;
		e.eliminar();
		i.disminuirVida(e.getDamage());		
	}

	public void visit(Raizan i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Daihiryu i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Shoryu i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Fukusuke i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}
	
	public void visit(Zero i) {
		ProyectilNormal e = (ProyectilNormal) entidad;		
		e.eliminar();     
		i.disminuirVida(e.getDamage());		
	}

}
