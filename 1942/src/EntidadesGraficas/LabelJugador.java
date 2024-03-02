package EntidadesGraficas;

import javax.swing.ImageIcon;

public class LabelJugador extends EntidadGrafica {
	
	private String[] rutasImagen = { "/RecursosGraficos_Jugador/avionInicial.gif", "/RecursosGraficos_Jugador/diveo1.gif"};

	public LabelJugador() {
		super();
		this.setSize(70, 70);
		ImageIcon imagen = new ImageIcon(getClass().getResource(rutasImagen[0]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(430, 520);
		this.setVisible(true);
	}

	/*
	 * método para cambiar el gráfico del jugador por el gif de maniobra
	 * 
	 * 
	 */
	
	public void setDiveo(boolean diveo) {
		if(diveo == true) {
			super.reDimensionar(this, new ImageIcon(LabelJugador.class.getResource(rutasImagen[1])));
		}else super.reDimensionar(this, new ImageIcon(LabelJugador.class.getResource(rutasImagen[0])));
	}
}