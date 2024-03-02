package EstrategiasMovimiento;

import Entidades.EntidadesDecoracion;
import EntidadesGraficas.EntidadGrafica;


public class Vertical_loop_estrellas extends Vertical {

	public Vertical_loop_estrellas(EntidadesDecoracion entidad, int direccion) {
		super(entidad, direccion);
	}

	public void mover() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();
		if (siguientePosY > limiteY+100) {
			g.setLocation(g.getX(), -300);
		}else
			g.setLocation(g.getX(), siguientePosY);
	}
}