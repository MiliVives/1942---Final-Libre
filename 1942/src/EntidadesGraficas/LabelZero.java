package EntidadesGraficas;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelZero extends LabelEnemigo{

	public LabelZero(Point p) {
		super(p);
		muerto = false;
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/Zero.gif"));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	public void setDerecha() {
		if(muerto == false)
			reDimensionar(this, new ImageIcon(LabelJugador.class.getResource("/RecursosGraficos_Enemigos/ZeroH.gif")));
	}
	
	public void setAbajo() {
		if(muerto == false)
			reDimensionar(this, new ImageIcon(LabelJugador.class.getResource("/RecursosGraficos_Enemigos/ZeroD.gif")));
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(grafico.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}
}
