package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;

public class VerticalRemove extends Vertical {


	public VerticalRemove(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		if(direccion == Vertical.ABAJO)
			moverAbajo();
		else moverArriba();
	}
	
	private void moverAbajo() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY+100) {
			entidad.eliminar();
		}else 
			g.setLocation(g.getX(), siguientePosY);
	}
	
	private void moverArriba() {
		EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

		if (siguientePosY < 0) {
				entidad.eliminar();
		}else
				g.setLocation(g.getX(), siguientePosY);
		
	
	}
}