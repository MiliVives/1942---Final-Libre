package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class LabelDaihiryu extends LabelEnemigo{

	public LabelDaihiryu(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/Daihiryu.png"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
