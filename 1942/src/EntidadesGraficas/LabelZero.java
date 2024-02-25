package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class LabelZero extends LabelEnemigo{

	public LabelZero(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/Zero.png"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
