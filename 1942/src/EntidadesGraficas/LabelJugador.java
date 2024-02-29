package EntidadesGraficas;

import javax.swing.ImageIcon;

public class LabelJugador extends EntidadGrafica {
	
	private String[] rutasImagen = { "/RecursosGraficos_Jugador/avionInicial.png", "/RecursosGraficos_Jugador/diveo1.gif"};

	public LabelJugador() {
		super();
		this.setSize(70, 55);
		ImageIcon imagen = new ImageIcon(getClass().getResource(rutasImagen[0]));
		this.setIcon(imagen);
		reDimensionar(this, imagen);
		this.setLocation(430, 520);
		this.setVisible(true);
	}

	/**
	 * metodo utilizado para cambiar la imagen del jugador cuando posee alguna
	 * mejora.
	 * 
	 * @param mejoras Arreglo de booleans que representan las mejoras que recibi� el
	 *                jugador. No se tiene en cuenta los primeros elementos del
	 *                arreglo ya que seran los que no afectan directamente al jugador
	 */
	
	public void setDiveo(boolean diveo) {
		if(diveo == true) {
			super.reDimensionar(this, new ImageIcon(LabelJugador.class.getResource(rutasImagen[1])));
		}else super.reDimensionar(this, new ImageIcon(LabelJugador.class.getResource(rutasImagen[0])));
	}
}