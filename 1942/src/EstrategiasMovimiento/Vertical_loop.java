package EstrategiasMovimiento;

import Entidades.Planeta;
import EntidadesGraficas.EntidadGrafica;
import EntidadesGraficas.LabelPlaneta;


public class Vertical_loop extends Vertical {

	public Vertical_loop(Planeta entidad, int direccion) {
		super(entidad, direccion);
	}

	public void mover() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();
		if (siguientePosY > limiteY+100) {
			LabelPlaneta lP = (LabelPlaneta)entidad.getGrafico();
			lP.cambiarGrafico();
			g.setLocation(g.getX(), -300);
		}else
			g.setLocation(g.getX(), siguientePosY);
	}
}