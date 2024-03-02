package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelOrangePOW extends LabelPremioTemporal {

	public LabelOrangePOW(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/OrangePOW.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}