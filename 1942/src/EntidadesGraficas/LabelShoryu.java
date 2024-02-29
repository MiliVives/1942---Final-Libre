package EntidadesGraficas;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelShoryu extends LabelEnemigo{

	public LabelShoryu(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/Shoryu.png"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	public void setDireccion(int d) {
		if(d == 1)
			reDimensionar(this, new ImageIcon(LabelJugador.class.getResource("/RecursosGraficos_Enemigos/ShoryuD.png")));
		else reDimensionar(this, new ImageIcon(LabelJugador.class.getResource("/RecursosGraficos_Enemigos/ShoryuI.png")));
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(grafico.getImage().getScaledInstance(58, 58, Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}
}
