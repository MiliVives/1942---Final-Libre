package EstrategiasMovimiento;

import Entidades.Entidad;
import EntidadesGraficas.EntidadGrafica;
import EntidadesGraficas.LabelZero;

public class EstrategiaZero extends EstrategiaMovimiento {

    private int targetY = 100;
    private int targetX = 400;
    private boolean objetivoAlcanzado = false;
    		
    public EstrategiaZero(Entidad entidad, int direccion) {
        super(entidad, direccion);
    }

    public void mover() {
    	
    	if(objetivoAlcanzado == false) {
    	
	        if (entidad.getGrafico().getY() > targetY) {
	            moverArriba();
	        } else if (entidad.getGrafico().getX() < targetX) {
	            moverDerecha();
	        }
	        
    	}else moverAbajo();
        
    }

    private void moverDerecha() { 
        EntidadGrafica g = entidad.getGrafico();
        LabelZero lz = (LabelZero)g;
        lz.setDerecha();
        int siguientePosX = g.getX() - this.direccion * entidad.getVelocidad();

        if (siguientePosX >= targetX) {
            objetivoAlcanzado = true;
            siguientePosX = targetX;
        }

        g.setLocation(siguientePosX, g.getY());
    }

    private void moverArriba() {
        EntidadGrafica g = entidad.getGrafico();
        int siguientePosY = g.getY() + this.direccion * entidad.getVelocidad();

        if (siguientePosY > targetY) {
            g.setLocation(g.getX(), siguientePosY);
        } else {
            g.setLocation(g.getX(), targetY);
        }
    }

    private void moverAbajo() { 	
        EntidadGrafica g = entidad.getGrafico();
        LabelZero lz = (LabelZero)g;
        lz.setAbajo();
        int siguientePosY = g.getY() - this.direccion * entidad.getVelocidad();

        if (siguientePosY > limiteY+100) {
            entidad.eliminar();
        } else {
            g.setLocation(g.getX(), siguientePosY);
        }
    }
}
