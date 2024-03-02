package EntidadesGraficas;

import java.awt.Image;
import java.awt.Point;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelPlaneta extends LabelEntidadesDecoracion {
	
	Random r;
	private String[] rutasImagen = {"/RecursosGraficos_Enemigos/Jupiter.png", "/RecursosGraficos_Enemigos/Mars.png", 
			"/RecursosGraficos_Enemigos/Mercury.png", "/RecursosGraficos_Enemigos/Uranus.png", "/RecursosGraficos_Enemigos/Earth.png",
			"/RecursosGraficos_Enemigos/Sun.png"};
	
	
	public LabelPlaneta(Point p) {
		super(p);
		r = new Random();
		ImageIcon imagen = new ImageIcon((LabelPlaneta.class.getResource(rutasImagen[r.nextInt(6)])));//
		this.setSize(277, 279);
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
	/*
	 * método realizado para cambiar el gráfico del planeta cada vez que vuelve a hacer el loop vertical
	 * 
	 * 
	 */
	
	public void cambiarGrafico() {
		ImageIcon imagen = new ImageIcon((LabelPlaneta.class.getResource(rutasImagen[r.nextInt(6)])));//
		this.setSize(277, 279);
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}

	public void seMato() {
		
	}
	
	public void reDimensionar(JLabel label, ImageIcon grafico) {
		if (grafico.getImage() != null) {
			grafico.setImage(grafico.getImage().getScaledInstance(277, 279, Image.SCALE_DEFAULT));
			label.setIcon(grafico);
			label.repaint();
		}	
	} 
}