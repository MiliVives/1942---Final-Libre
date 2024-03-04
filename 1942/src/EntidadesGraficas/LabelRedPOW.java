package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelRedPOW extends LabelPremioEspecial{

	public LabelRedPOW(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/RedPOW.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}	
}
