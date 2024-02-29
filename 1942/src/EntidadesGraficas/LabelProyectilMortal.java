package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

import Entidades.Jugador;

public class LabelProyectilMortal extends LabelProyectilJugador {

	public LabelProyectilMortal(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(LabelProyectilMortal.class.getResource("/RecursosGraficos_Jugador/BalaBasica.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}