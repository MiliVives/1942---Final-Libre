package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelGrayPOW extends LabelPremioEspecial{

	public LabelGrayPOW(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/GrayPOW.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}
