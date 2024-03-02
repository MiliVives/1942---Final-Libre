package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Component;

class FondoPanel extends JLayeredPane {


	private String[] nivelesTransicion = new String[] { "/RecursosGraficosNiveles/LVL01.gif",
			"/RecursosGraficosNiveles/LVL02.gif", "/RecursosGraficosNiveles/LVL03.gif" };
	private JLabel nivelTransicionLabel;

	public FondoPanel() {

		setLayout(null);
		nivelTransicionLabel = new JLabel();
		this.add(nivelTransicionLabel);
		this.repaint();
	}

	public Component add(Component p) {
		Component comp = super.add(p);
		this.moveToFront(p);
		return comp;
	}

	public void CambioDeLvl() {
		this.nivelTransicionLabel.setVisible(false);
		this.repaint(); 
	}

	public void pantallaNivel(int nivel) {// 1, 2, .... , n 		
		this.nivelTransicionLabel.setIcon(new ImageIcon(getClass().getResource(this.nivelesTransicion[nivel])));
		this.nivelTransicionLabel.setVisible(true);
		this.nivelTransicionLabel.repaint();
		this.nivelTransicionLabel.setBounds(this.getX(), (this.getY() + this.getHeight() - 165) / 2, this.getWidth(),165);
	}
}

