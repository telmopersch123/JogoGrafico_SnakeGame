import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class InicialRaio extends JPanel {
  private int numFramesX;
  private int numFramesY;
  private BufferedImage RaioInicial;
  private int frameIndex;
  private boolean gameOver;
  private long lastFrameTime = 0;
  private long frameInterval = 150;
  private int totalFrames;
  static boolean SumirInicialRaio = true;

  public InicialRaio(BufferedImage inicialRaio, int numFramesXInicial, int numFramesYInicial) {
    this.RaioInicial = inicialRaio;
    this.numFramesX = numFramesXInicial;
    this.numFramesY = numFramesYInicial;
    this.totalFrames = numFramesX * numFramesY;
    this.frameIndex = 0;
    this.gameOver = false;
    setPreferredSize(new Dimension(250, 60));
    setMinimumSize(new Dimension(250, 60));
    setMaximumSize(new Dimension(250, 60));
    setOpaque(false);
  }

  public void setFrameIndex(int frameIndex) {
    this.frameIndex = frameIndex;
    repaint();
  }

  public void setGameOver(boolean gameOver) {
    this.gameOver = gameOver;
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    if (RaioInicial != null && !gameOver && !SumirInicialRaio) {
      int frameWidth = RaioInicial.getWidth() / numFramesX;
      int frameHeight = RaioInicial.getHeight() / numFramesY;
      int sx1 = (frameIndex % numFramesX) * frameWidth;
      int sy1 = (frameIndex / numFramesX) * frameHeight;
      BufferedImage currentFrame = RaioInicial.getSubimage(sx1, sy1, frameWidth, frameHeight);

      Graphics2D g2d = (Graphics2D) g;
      AffineTransform at = new AffineTransform();
      at.scale((double) getWidth() / frameWidth, (double) getHeight() / frameHeight);
      AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
      BufferedImage scaledImage = op.filter(currentFrame, null);
      g2d.drawImage(scaledImage, 0, 0, 250, 60, null);
      updateFrame();
    }
  }

  public void updateFrame() {
    if (!gameOver) {
      long currentTime = System.currentTimeMillis();
      
      if (currentTime - lastFrameTime >= frameInterval) {
        lastFrameTime = currentTime - (currentTime % frameInterval);
        frameIndex = (frameIndex + 1) % (numFramesX * numFramesY);
        Game.currentFrame33 = (Game.currentFrame33 + 1) % totalFrames;
        if (Game.currentFrame33 == totalFrames - 1) {
          SumirInicialRaio = true;
        }
        repaint();
      }
    }
  }
}
