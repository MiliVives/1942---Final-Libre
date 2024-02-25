package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;

public class VerticalRemove extends Vertical {


	public VerticalRemove(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY+100) {
			entidad.eliminar();
		}else 
			g.setLocation(g.getX(), siguientePosY);
	}
}