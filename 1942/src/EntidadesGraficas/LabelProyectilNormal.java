package EntidadesGraficas;

import java.awt.Point;
import javax.swing.ImageIcon;

public class LabelProyectilNormal extends LabelProyectilJugador {

	public LabelProyectilNormal(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(LabelProyectilNormal.class.getResource("/RecursosGraficos_Jugador/disparo.gif"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
}