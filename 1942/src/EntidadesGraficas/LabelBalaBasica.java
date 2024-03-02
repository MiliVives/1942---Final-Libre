package EntidadesGraficas;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelBalaBasica extends LabelBala {

	public LabelBalaBasica(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/BalaBasica.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(grafico.getImage().getScaledInstance(label.getWidth()-10, label.getHeight()-10, Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}
}