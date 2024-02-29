package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;

public class HorizontalAvionLateralIzquierdo extends EstrategiaMovimiento{
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;
	private int limiteAvionX = limiteX-120;

	public HorizontalAvionLateralIzquierdo(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		EntidadGrafica g = this.entidad.getGrafico();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();
		if (siguientePosX > limiteAvionX) {
			System.out.println(siguientePosX);
			g.setLocation(limiteAvionX, g.getY());
		}else {
			if (siguientePosX < 0)
				g.setLocation(0, g.getY());
			else
				g.setLocation(siguientePosX, g.getY());
		}

	}
}