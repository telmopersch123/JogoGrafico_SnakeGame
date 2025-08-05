import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LifesTimers {
  static Graphics2D GraficosLifeSnake;
  static int numFramesX = 2;
  static int numFramesY = 11;
  static long lastFrameLifeSnake = 0;
  static int frameIntervalLifeSnake = 1000;
  static int totalFramesLife = numFramesX * numFramesY;
  static BufferedImage ImageLifeSnake;

  static {
    try {
      String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
      ImageLifeSnake = ImageIO.read(new File(basePath + "snakes" + File.separator + "lifeSnakeHard.png"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void LifeSnake(Game game, BufferedImage buffer, boolean gameOver) {
    BufferedImage lifesnake = (BufferedImage) ImageLifeSnake;
    int sx1 = (Game.currentFrame31 % numFramesX) * (lifesnake.getWidth() /
        numFramesX);
    int sy1 = (Game.currentFrame31 / numFramesX) * (lifesnake.getHeight() /
        numFramesY);
    int sw1 = lifesnake.getWidth() / numFramesX;
    int sh1 = lifesnake.getHeight() / numFramesY;
    GraficosLifeSnake = buffer.createGraphics();
    AffineTransform at1 = new AffineTransform();
    at1.scale((double) (80) / sw1, (double) (20) / sh1);
 
    AffineTransformOp op1 = new AffineTransformOp(at1,
        AffineTransformOp.TYPE_BILINEAR);
   
    BufferedImage scaledImage1 = op1.filter(lifesnake.getSubimage(sx1, sy1, sw1,
        sh1),
        null);
    GraficosLifeSnake.drawImage(scaledImage1, Game.nodeSnake[0].x - 35, Game.nodeSnake[0].y - 20, null);
    long currentTime = System.currentTimeMillis();
    if (Game.colidianClassico) {
      Game.currentFrame31 = 0;
      lastFrameLifeSnake = System.currentTimeMillis();
    }
    if (!gameOver && !Game.IniciouEgg) {
      if (currentTime - lastFrameLifeSnake >= frameIntervalLifeSnake) {
        lastFrameLifeSnake = currentTime - (currentTime %
            frameIntervalLifeSnake);
        Game.currentFrame31 = (Game.currentFrame31 + 1) % totalFramesLife;
      }
      if (Game.currentFrame31 == totalFramesLife - 1) {
        Game.posicaoXDeath = Game.nodeSnake[0].x;
        Game.posicaoYDeath = Game.nodeSnake[0].y;
        Game.NovaPosicaoDeath0 = Game.posicaoYDeath - 40;
        Game.widhtDeathW = 0;
        Game.widhtDeathH = 0;
        Game.TransparentDeath = 0.1f;
        NumberAnimation.restartAnimationDeath(game);
        Game.colidianDeath = true;
        Game.DeathfromHunger = true;
      }
    }
  }
}
