package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOver_Win extends JFrame {

	private JPanel contentPane;
	private int pantalla;
	
	/**
	 * Create the frame.
	 */
	public GameOver_Win( int p ) {// si es 1 entonces gano, 0 caso contrario :)
		
		this.pantalla = p;
		
		setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/icon.png")).getImage());
		
		this.setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 647);
		contentPane = new JPanel();
		setAlwaysOnTop(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		

		JButton tryAgain = new JButton("");
		tryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frame = new Menu();
				frame.setVisible(true);
				dispose();
			}
		});
		tryAgain.setBackground(Color.BLACK);
		tryAgain.setBorder(new LineBorder(Color.BLACK));
		tryAgain.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/start.png")));
		tryAgain.setBounds(459, 527, 198, 49);
		reDimensionar(tryAgain, (ImageIcon) tryAgain.getIcon());
		contentPane.add(tryAgain);
		
		JButton salir = new JButton("");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		salir.setBackground(Color.BLACK);
		salir.setBorder(new LineBorder(Color.BLACK));
		salir.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/exit.png")));
		salir.setBounds(669, 527, 184, 49);
		salir.setBorder(new EmptyBorder(0, 0, 0, 0)); 
		contentPane.add(salir);
		
		JLabel gameOver = new JLabel("");
		gameOver.setIcon(new ImageIcon(GameOver_Win.class.getResource("/RecursosGraficos_Extras/endpage1.gif")));
		gameOver.setOpaque(false);
		gameOver.setBounds(0, 0, 921, 643);
		gameOver.setBorder(new EmptyBorder(0, 0, 0, 0)); 
		contentPane.add(gameOver);
		
	}
	
	private void reDimensionar(JButton boton, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newimg = image.getScaledInstance(boton.getWidth(), boton.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			boton.setIcon(grafico);
			boton.repaint();
		}
	}
}