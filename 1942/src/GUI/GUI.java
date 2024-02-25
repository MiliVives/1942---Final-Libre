package GUI;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Logica.Juego;

import javax.swing.JLabel;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GUI extends JFrame {

	private FondoPanel panelJuego;
	private Juego juego;
	private Thread hiloJuego;
	private JLabel nivelTanda;
	private JLabel[] estados;
	private JLabel fondoJuego;
	
	/**
	 * Crea el mapa de juego
	 * @param dificultad de juego 
	 * -> 0 si es normal
	 * -> 1 si es dificil
	 */
	public GUI() {
		
		this.setResizable(false);
		
		setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/icon.png")).getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 700);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		panelJuego = new FondoPanel();
		panelJuego.setBounds(0, 60, 933, 601);
		panelJuego.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelJuego.setLayout(null);
		contentPane.add(panelJuego);
		
		fondoJuego = new JLabel("New label");
		fondoJuego.setIcon(new ImageIcon(GUI.class.getResource("/RecursosGraficosNiveles/FONDO-LVL01.png")));
		fondoJuego.setBounds(0, 0, 933,601);
		reDimensionar(fondoJuego, (ImageIcon) fondoJuego.getIcon());
		panelJuego.add(fondoJuego);
		panelJuego.moveToBack(fondoJuego);
	
		panelJuego.repaint();
		JPanel barraSuperior = new JPanel();
		barraSuperior.setBounds(0, 0, 933, 60);
		contentPane.add(barraSuperior);
		barraSuperior.setLayout(null);
		barraSuperior.setBackground(Color.BLACK);

		JPanel panelMejoras = new JPanel();

		panelMejoras.setBounds(615, 0, 258, 60);
		panelMejoras.setBackground(Color.BLACK);
		panelMejoras.setLayout(new GridLayout(1, 4));
		panelMejoras.setVisible(true);
		estados = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			estados[i] = new JLabel();
			estados[i].setSize(70, 70); 
			panelMejoras.add(estados[i]);
			estados[i].setEnabled(true);

		}
		estados[1].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/corazon.png")));
		estados[4].setIcon(new ImageIcon(getClass().getResource("/RecursosGraficos_Extras/star.png")));
		
		reDimensionar(estados[1], (ImageIcon) estados[1].getIcon());
		reDimensionar(estados[4], (ImageIcon) estados[4].getIcon());
		
		estados[0].setForeground(Color.WHITE);
		estados[0].setText("");
		estados[2].setForeground(Color.WHITE);
		estados[2].setText("");
		estados[3].setForeground(Color.WHITE);
		estados[3].setText("");
		
		Font font = estados[2].getFont();
		estados[0].setFont(new Font(font.getName(), Font.PLAIN, 20)); // Adjust the size (18 in this example)
		estados[3].setFont(new Font(font.getName(), Font.PLAIN, 20));
		estados[0].setHorizontalAlignment(JLabel.CENTER);
		estados[0].setVerticalAlignment(JLabel.CENTER);
		estados[3].setHorizontalAlignment(JLabel.CENTER);
		estados[3].setVerticalAlignment(JLabel.CENTER);
		

		barraSuperior.add(panelMejoras);

		this.setFocusable(true);

		setContentPane(contentPane);
		setLocationRelativeTo(null);

		juego = Juego.getJuego();
		juego.setGUI(this);

		this.addKeyListener(new OyenteTeclado(juego));

		hiloJuego = new Thread() {
			public void run() {
				juego.run();
				
			}
		};

		
		hiloJuego.start();

		
		this.repaint();
		panelJuego.repaint();
	}
	
	/**
	 * Redimensiona el ImageIcon grafico en base al JLabel label
	 * @param label
	 * @param grafico
	 */
	private void reDimensionar(JLabel label, ImageIcon grafico) {
		Image image = grafico.getImage();
		if (image != null) {
			Image newimg = image.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			grafico.setImage(newimg);
			label.setIcon(grafico);
			label.repaint();
		}
	}

	/**
	 * Se crea abre un nuevo frame donde se muestra que se gano el juego
	 */
	public void gano() {
		
		GameOver_Win win = new GameOver_Win(1);
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
		this.juego = null;
		win.setVisible(true);
		
	}

	/**
	 * Se crea abre un nuevo frame donde se muestra que se perdio el juego
	 */
	public void perdio() {
		this.juego = null;
		hiloJuego = null;
		this.panelJuego = null;
		this.dispose();
		GameOver_Win go = new GameOver_Win(0);
		go.setVisible(true);
		
	}

	/**
	 * retorna el mapa donde se muestra el juego 
	 * @return mapa de tipo Container
	 */
	public Container getMapa() {
		return panelJuego;
	}

	/**
	 * Muestra en el panel de juego la transicion del nivel. Esta transicion muestra el nivel actual
	 * A su vez que cambia el mapa al correspondiente del nivel actual
	 * @param nivel Nivel actual
	 */
	public void cambioNivel(int nivel) {
		this.reDimensionar(fondoJuego, new ImageIcon(GUI.class.getResource("/RecursosGraficosNiveles/FONDO-LVL0"+nivel+".png")));
		panelJuego.moveToBack(fondoJuego);
		panelJuego.pantallaNivel(nivel - 1);
		juego.pausa();
		panelJuego.CambioDeLvl();
		panelJuego.repaint();
	}

	/**
	 * Actualiza los puntos deel jugador
	 */
	public void actualizarPuntos(int puntos) {
		 estados[3].setText(""+puntos+"");
	}
	
	public void actualizarVida(int vida) {
		estados[0].setText(""+vida+"");
	}

	/**
	 * actualiza el label que muestra la tanda y nivel actuales
	 * @param nivel
	 * @param tanda
	 */
	public void actualizarNivelTanda(int nivel, int tanda) {
		ImageIcon im = new ImageIcon(
				getClass().getResource("/RecursosGraficos_Extras/NivelTanda/nivel" + nivel + "tanda" + tanda + ".png"));
		this.nivelTanda.setIcon(im);
	}

	/**
	 * actualiza la barra que muestra los estados de los premios.
	 * Si un premio esta activo entonces se mostrar� con su label activo
	 * en caso contrario se mostrara con su label desactivado
	 * @param mejoras estado de cada premios
	 */
	
	//estados[i].setEnabled(mejoras[i]);

	/**
	 * Activa el sonido de disparo
	 */
	public void sonidoDisparar() {
		try {
			
			Clip disparo = AudioSystem.getClip();
			disparo.open(AudioSystem.getAudioInputStream(getClass().getResource("/RecursosWAV/disparo.wav")));
			disparo.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}
	
	public void musica() {
		try {
			
			Clip disparo = AudioSystem.getClip();
			disparo.open(AudioSystem.getAudioInputStream(getClass().getResource("/RecursosWAV/AcrossTheStars1.wav")));
			disparo.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			e.getMessage();
			System.out.println("error audio");
		}
	}
}