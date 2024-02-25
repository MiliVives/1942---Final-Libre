package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    private Image backgroundImage;

    public ImagePanel(String imagePath) {
        backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calculate the center coordinates
            int centerX = (panelWidth - backgroundImage.getWidth(null)) / 2;
            int centerY = (panelHeight - backgroundImage.getHeight(null)) / 2;

            // Draw the background image centered and scaled to fit the panel
            g.drawImage(backgroundImage, centerX, centerY, backgroundImage.getWidth(null), backgroundImage.getHeight(null), this);
        }
    }
}
//  g.drawImage(backgroundImage, -180, -200, 700, 700, this);