package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelFukusuke extends LabelEnemigo{

	public LabelFukusuke(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/Fukusuke.gif"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
