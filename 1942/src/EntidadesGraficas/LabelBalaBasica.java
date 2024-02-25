package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class LabelBalaBasica extends LabelBala {

	public LabelBalaBasica(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/BalaBasica.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}