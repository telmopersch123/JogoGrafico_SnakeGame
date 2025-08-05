import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

class ImagePanel extends JPanel {
  private BufferedImage image;
  private int imageWidth;
  private int imageHeight;

  public ImagePanel(BufferedImage image, int vitoriaHeight, int vitoriaWidth) {
    this.image = image;
    this.imageWidth = imageWidth;
    this.imageHeight = imageHeight;
    this.setPreferredSize(new Dimension(imageWidth, imageHeight));
    this.setOpaque(false);
  }

  public void updateImageSize(int newWidth, int newHeight) {
    this.imageWidth = newWidth;
    this.imageHeight = newHeight;
    this.setPreferredSize(new Dimension(newWidth, newHeight));
    this.revalidate();
    this.repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int x = (getWidth() - imageWidth) / 2;
    int y = (getHeight() - imageHeight) / 2;
    g.drawImage(image, x, y, imageWidth, imageHeight, this);
  }
}
