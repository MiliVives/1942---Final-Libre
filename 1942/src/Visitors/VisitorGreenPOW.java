package Visitors;

import Entidades.Entidad;
import Entidades.Jugador;
import EstadosArma.ConArmaMortal;

public class VisitorGreenPOW extends VisitorPremioEspecial {

	public VisitorGreenPOW(Entidad entidad) {
		super(entidad);
	}
	
	public void visit(Jugador jugador) {
	//	jugador.setEstadoArma(new ConArmaMortal(jugador));
		entidad.eliminar();
	}

}
