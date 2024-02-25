package EntidadesGraficas;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public abstract class LabelEnemigo extends EntidadGrafica {

	private String explotado = "/RecursosGraficos_Enemigos/explosion.gif";

	public LabelEnemigo(Point p) {
		super();
		this.setSize(60, 100);
		this.setLocation(p);
	}

	public void seMato() {
		ImageIcon imagen = null;
		Random rand = new Random();
		int i = rand.nextInt(7);

		imagen = new ImageIcon(this.getClass().getResource(explotado));

		this.setIcon(imagen);
		this.setBounds(getX(), getY(), 100, 75);
		this.repaint();
		

	}

}