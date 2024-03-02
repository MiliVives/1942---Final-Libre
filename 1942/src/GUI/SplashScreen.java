package GUI;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {
	private int duration;

	public SplashScreen(int d) {
		duration = d;
		setBounds(100, 100, 500, 375);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true); 
		Image img = Toolkit.getDefaultToolkit().getImage(SplashScreen.class.getResource("/RecursosGraficos_Extras/intro.gif"));
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("");
		ImageIcon ii = new ImageIcon();
		ii.setImage(img);
		lblNewLabel.setIcon(ii);
		add(lblNewLabel);
		repaint();
	}

	public void showSplash() {
		this.setVisible(true);
		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dispose();
	}
}