package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelBlackPOW extends LabelPremioEspecial{

	public LabelBlackPOW(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/BlackPOW.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
}
