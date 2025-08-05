import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

class ImagePanel2 extends JPanel {
  private BufferedImage spriteSheet;
  private int frameWidth;
  private int frameHeight;
  private int currentFrame;
  private int totalFrames;
  private Timer timer;

  public ImagePanel2(BufferedImage spriteSheet, int frameWidth, int frameHeight, int frameDelay) {
    this.spriteSheet = spriteSheet;
    this.frameWidth = frameWidth;
    this.frameHeight = frameHeight;
    this.totalFrames = (spriteSheet.getWidth() / frameWidth) * (spriteSheet.getHeight() / frameHeight);
    this.currentFrame = 0;

   
    this.setPreferredSize(new Dimension(frameWidth + 210, frameHeight + 190));
    this.setOpaque(false);

    timer = new Timer(frameDelay, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        currentFrame+=2;
        if (currentFrame >= totalFrames) {
        timer.stop(); 
        }
        repaint();
      }
    });
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int cols = spriteSheet.getWidth() / frameWidth;
    int x = (currentFrame % cols) * frameWidth;
    int y = (currentFrame / cols) * frameHeight ;

   
    g.drawImage(spriteSheet, 0, 0, frameWidth + 200, frameHeight + 200, x, y, x + frameWidth, y + frameHeight, this);
  }
}
