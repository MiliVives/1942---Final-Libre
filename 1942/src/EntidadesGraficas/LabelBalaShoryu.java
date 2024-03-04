package EntidadesGraficas;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelBalaShoryu extends LabelBala {

	public LabelBalaShoryu(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/BalaBasica1.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(grafico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}
}