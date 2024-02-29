package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;

public class HorizontalJugadorLimiteIzquierda extends EstrategiaMovimiento {
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;
	private int limiteXIzq = 30;

	public HorizontalJugadorLimiteIzquierda(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		EntidadGrafica g = this.entidad.getGrafico();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();
		if (siguientePosX > limiteX)
			g.setLocation(limiteX, g.getY());
		else {
			if (siguientePosX < limiteXIzq)
				g.setLocation(limiteXIzq, g.getY());
			else
				g.setLocation(siguientePosX, g.getY());
		}

	}
}