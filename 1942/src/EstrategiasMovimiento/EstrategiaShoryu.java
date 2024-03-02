package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;
import EntidadesGraficas.LabelShoryu;

public class EstrategiaShoryu extends EstrategiaMovimiento {
	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;

    public EstrategiaShoryu(Entidad entidad, int direccion) {
        super(entidad, direccion); 
    	LabelShoryu lS = (LabelShoryu) entidad.getGrafico();
    	lS.setDireccion(direccion);
    }

    public void mover() {
    	if(direccion == DERECHA)
    		moverD();
    	else moverI();
    }
    
    private void moverI() {
    	EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() - this.direccion * entidad.getVelocidad();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY+100 || siguientePosX < 0) {
			entidad.eliminar();
		}else 
			g.setLocation(siguientePosX, siguientePosY);
    }

	private void moverD() {
    	EntidadGrafica g = entidad.getGrafico();
		int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();
		int siguientePosX = g.getX() + this.direccion * entidad.getVelocidad();

		if (siguientePosY > limiteY+100 || siguientePosX > limiteX+100) {
			entidad.eliminar();
		}else 
			g.setLocation(siguientePosX, siguientePosY);
	}
}
