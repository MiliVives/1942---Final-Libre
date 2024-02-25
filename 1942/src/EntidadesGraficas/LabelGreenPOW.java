package EntidadesGraficas;

import java.awt.Point;

import javax.swing.ImageIcon;

public class LabelGreenPOW extends LabelPremioEspecial{

	public LabelGreenPOW(Point p) {
		super(p);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/RecursosGraficos_Premios/GreenPOW.png"));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
	}
	
}
