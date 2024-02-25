package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class LabelShoryu extends LabelEnemigo{

	public LabelShoryu(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/Shoryu.png"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

}
