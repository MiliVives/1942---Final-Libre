package EntidadesGraficas;

import java.awt.Point;

public abstract class LabelProyectilJugador extends LabelProyectil {

	public LabelProyectilJugador(Point p) {
		super(p);
//		this.setSize(50, 50);
		this.setBounds(this.getX()+10, this.getY(), 50, 50);
	}

}