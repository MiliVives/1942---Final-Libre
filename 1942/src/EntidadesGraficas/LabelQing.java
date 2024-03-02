package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelQing extends LabelEnemigo{

	public LabelQing(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon((LabelQing.class.getResource("/RecursosGraficos_Enemigos/Qing.gif")));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
