import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class food {
  private static long lastFrameTime1 = System.currentTimeMillis();
  private static long lastFrameTime = System.currentTimeMillis();
  public static int lastRenderedFrame = -1;

  public static void classicFood(Graphics g, BufferedImage buffer, int macaX, int macaY, Image appleSprit, int width,
      int height) {
    Graphics2D food = buffer.createGraphics();
    food.drawImage(appleSprit, macaX, macaY, width, height, null);
    food.dispose();
    g.drawImage(buffer, 0, 0, null);
  }

  public static int numFramesX1 = 13;
  public static int numFramesY1 = 1; 
  public static int frameWidth1 = 500; 
  public static int frameHeight1 = 500; 
  public static int totalFrames1 = numFramesX1 * numFramesY1;
  public static int frameInterval1 = 250; 
  public static long currentTime1 = System.currentTimeMillis();
  public static Graphics2D food1;
  public static AffineTransform transform1 = new AffineTransform();

  public static void PoisonFood(Graphics g, BufferedImage buffer, int macaPOX, int macaPOY, Image applePoison,
      int width, int height) {
    BufferedImage EnergyAnimationFoodPoison = (BufferedImage) applePoison;
    //
    int sx = (Game.currentFrame6 % numFramesX1) * (EnergyAnimationFoodPoison.getWidth() / numFramesX1);
    int sy = (Game.currentFrame6 / numFramesX1) * (EnergyAnimationFoodPoison.getHeight() / numFramesY1);
    int sw = EnergyAnimationFoodPoison.getWidth() / numFramesX1;
    int sh = EnergyAnimationFoodPoison.getHeight() / numFramesY1;
    food1 = buffer.createGraphics();
    AffineTransform atPoison = new AffineTransform();
    if (height == 0) {
      height = 20;
    }
    atPoison.scale((double) (width + 2) / sw, (double) (height + 2) / sh);
    AffineTransformOp op = new AffineTransformOp(atPoison, AffineTransformOp.TYPE_BILINEAR);
    BufferedImage scaledImage = op.filter(EnergyAnimationFoodPoison.getSubimage(sx, sy, sw, sh), null);
    food1.drawImage(scaledImage, macaPOX, macaPOY, null);
   
    if (Game.ManterAnimation) {
      Game.currentFrame6 = (Game.currentFrame6 + 1) % totalFrames1;
      totalFrames1 = numFramesX1 * numFramesY1;
      if (currentTime1 - lastFrameTime1 > frameInterval1) {
        Game.currentFrame6 = (Game.currentFrame6 + 1) % totalFrames1;
        lastFrameTime1 = currentTime1;
      }
    }
  }

  public static int numFramesX = 6;
  public static int numFramesY = 1; 
  public static int frameWidth = 500; 
  public static int frameHeight = 500; 
  private static final int frameInterval = 120;
  public static int totalFrames = numFramesX * numFramesY;
  public static long currentTime = System.currentTimeMillis();
  public static Graphics2D food;
  public static AffineTransform transform = new AffineTransform();

  public static void EnergyFood(Game game, Graphics g, BufferedImage buffer, int macaX, int macaY, Image appleEnergy,
      int width,
      int height) {
    BufferedImage EnergyAnimationFoodEnergy = (BufferedImage) appleEnergy;
    int sx = (Game.currentFrame5 % numFramesX) * (EnergyAnimationFoodEnergy.getWidth() / numFramesX);
    int sy = (Game.currentFrame5 / numFramesX) * (EnergyAnimationFoodEnergy.getHeight() / numFramesY);
    int sw = EnergyAnimationFoodEnergy.getWidth() / numFramesX;
    int sh = EnergyAnimationFoodEnergy.getHeight() / numFramesY;
    food = buffer.createGraphics();
   
    AffineTransform at = new AffineTransform();
    if (Game.RemoverAnimation) {
      width = 40;
      height = 40;
    }
    at.scale((double) (width + 2) / sw, (double) (height + 2) / sh);
   
    AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
  
    BufferedImage scaledImage = op.filter(EnergyAnimationFoodEnergy.getSubimage(sx, sy, sw, sh), null);

    food.drawImage(scaledImage, macaX, macaY, null);
    if (Game.ManterAnimation) {
      Game.currentFrame5 = (Game.currentFrame5 + 1) % totalFrames;
      totalFrames = numFramesX * numFramesY;
      if (currentTime - lastFrameTime > frameInterval) {
        lastFrameTime = currentTime;
      }
    }
  }

}
