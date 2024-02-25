package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class LabelRaizan extends LabelEnemigo{

	public LabelRaizan(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon((LabelRaizan.class.getResource("/RecursosGraficos_Enemigos/Raizan.png")));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
