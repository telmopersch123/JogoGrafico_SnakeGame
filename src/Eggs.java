import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Eggs {
  static long lastFrameTimeegg = System.currentTimeMillis();
  static int frameIntervalegg = 100;
  static long lastFrameTimeeggB = System.currentTimeMillis();
  static int frameIntervaleggB = 100;
  static Graphics2D egg;
  static Graphics2D eggBreak;

  public static void EggStart(BufferedImage buffer, int PosicaoX, int PosicaoY, Image EggAnimation) {
    BufferedImage eggAnimation = (BufferedImage) EggAnimation;
    egg = buffer.createGraphics();

    int numFramesX = 8; 
    int numFramesY = 1; 
    int frameWidth = 500; 
    int frameHeight = 500; 
    int totalFramesegg = numFramesX * numFramesY;
    int sx = (Game.currentFrame29 % numFramesX) * (eggAnimation.getWidth() / numFramesX);
    int sy = (Game.currentFrame29 / numFramesX) * (eggAnimation.getWidth() / numFramesX);
    int sw = eggAnimation.getWidth() / numFramesX;
    int sh = eggAnimation.getHeight() / numFramesY;
    BufferedImage resizedImageColision = Animation.resizeImage(eggAnimation.getSubimage(sx, sy, sw, sh),
        frameWidth,
        frameHeight);
    egg.drawImage(resizedImageColision, PosicaoX - 32, PosicaoY - 25, 70, 60, null);
    long currentTimeegg = System.currentTimeMillis();
    if (Game.ManterAnimation) {
      if (currentTimeegg - lastFrameTimeegg > frameIntervalegg) {
        Game.currentFrame29 = (Game.currentFrame29 + 1) % totalFramesegg;
        lastFrameTimeegg = currentTimeegg;
      }
    }
  }

  public static void EggBreak(BufferedImage buffer, int PosicaoX, int PosicaoY, Image EggAnimationBreak) {
    BufferedImage eggAnimation = (BufferedImage) EggAnimationBreak;
    eggBreak = buffer.createGraphics();

    int numFramesX = 10;
    int numFramesY = 1; 
    int frameWidth = 500; 
    int frameHeight = 500; 
    int totalFrameseggB = numFramesX * numFramesY;
    int sx = (Game.currentFrame30 % numFramesX) * (eggAnimation.getWidth() / numFramesX);
    int sy = (Game.currentFrame30 / numFramesX) * (eggAnimation.getWidth() / numFramesX);
    int sw = eggAnimation.getWidth() / numFramesX;
    int sh = eggAnimation.getHeight() / numFramesY;
    BufferedImage resizedImageColision = Animation.resizeImage(eggAnimation.getSubimage(sx, sy, sw, sh),
        frameWidth,
        frameHeight);
    eggBreak.drawImage(resizedImageColision, PosicaoX - 32, PosicaoY - 25, 70, 60, null);
    long currentTimeeggB = System.currentTimeMillis();
    if (Game.ManterAnimation) {
      if (Game.currentFrame30 == 0) { 
        MusicPlayer.ovoBreak();
      }
      if (currentTimeeggB - lastFrameTimeeggB > frameIntervaleggB) {
        Game.currentFrame30 = (Game.currentFrame30 + 1) % totalFrameseggB;
        lastFrameTimeeggB = currentTimeeggB;
     
        if (Game.currentFrame30 == totalFrameseggB - 1) {
          Game.ControlOneAnimationEgg = true;
          Game.cobraParadaFinal = true;
        }
      }
    }
  }
}
