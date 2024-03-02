package EntidadesGraficas;

import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelShoryu extends LabelEnemigo{

	public LabelShoryu(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Enemigos/Shoryu.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	/*
	 * método creado para rotar eel grafico cuando hace el recorrido el avion shoryu
	 * 
	 */
	
	public void setDireccion(int d) {
		if(d == 1)
			reDimensionar(this, new ImageIcon(LabelJugador.class.getResource("/RecursosGraficos_Enemigos/ShoryuD.gif")));
		else reDimensionar(this, new ImageIcon(LabelJugador.class.getResource("/RecursosGraficos_Enemigos/ShoryuI.gif")));
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(grafico.getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}
}
