package EntidadesGraficas;

import java.awt.Image;
import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelEntidadesDecoracion extends LabelEnemigo {

	private String[] rutasImagen = {"/RecursosGraficos_Enemigos/estrella0.gif",
			"/RecursosGraficos_Enemigos/estrella1.gif", "/RecursosGraficos_Enemigos/estrella2.gif"};
	
	
	public LabelEntidadesDecoracion(Point p) {
		super(p);
		Random r = new Random();
		ImageIcon imagen = new ImageIcon((LabelEntidadesDecoracion.class.getResource(rutasImagen[r.nextInt(3)])));//
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

	public void seMato() {
		
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(grafico.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	}
}