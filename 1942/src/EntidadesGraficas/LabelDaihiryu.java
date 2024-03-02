package EntidadesGraficas;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelDaihiryu extends LabelEnemigo{

	public LabelDaihiryu(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/Daihiryu.gif"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			label.setSize(165, 165);
			grafico.setImage(grafico.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}
}
