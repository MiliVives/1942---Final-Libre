package EstrategiasMovimiento;

import Entidades.Entidad;

public class EliminarTotal extends EstrategiaMovimiento {


	public EliminarTotal(Entidad entidad, int direccion) {
		super(entidad, direccion);
	}

	@Override
	public void mover() {
		entidad.eliminar();

	}
}