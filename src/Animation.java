import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Animation {
  private static int poisonFruitAnimationInterval = 20; 

  private static boolean increaseSizeCla = true;
  private static long lastFrameTime = System.currentTimeMillis();
  private static long lastFrameTime1 = System.currentTimeMillis();
  private static long lastFrameTime2 = System.currentTimeMillis();
  private static long lastFrameTime3 = System.currentTimeMillis();
  private static long lastFrameTime4 = System.currentTimeMillis();
  private static long lastFrameTime5 = System.currentTimeMillis();
  private static long lastFrameTime6 = System.currentTimeMillis();
  private static final int frameInterval = 100;
  private static final int frameInterval1 = 100;
  private static final int frameInterval2 = 100;
  private static int frameInterval3 = 80;
  private static int frameInterval4 = 80;
  private static int frameInterval5 = 80;
  private static int frameInterval6 = 80;
  public static BufferedImage bufferedSpriteSheet;

  public static void AnimationFoodCla(Game game) {
    Game.poisonFruitAnimationTimer = new Timer();
    Game.poisonFruitAnimationTimer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (increaseSizeCla) {
          if (Game.poisonFruitWidthCla < 25 || Game.poisonFruitHeightCla < 25) {
            Game.poisonFruitWidthCla++;
            Game.poisonFruitHeightCla++;
            game.colidionClaControlTimerAnimation = true;
          } else {

            increaseSizeCla = false;
          }
        } else {
          if (Game.poisonFruitWidthCla > 18 || Game.poisonFruitHeightCla > 18) {
            Game.poisonFruitWidthCla--;
            Game.poisonFruitHeightCla--;
            game.colidionClaControlTimerAnimation = true;
          } else {
            Game.poisonFruitAnimationTimer.cancel();
            Game.poisonFruitAnimationTimer.purge();
            game.colidionClaControlTimerAnimation = false;
            increaseSizeCla = true;
          }
        }

        game.repaint();
      }
    }, 0, poisonFruitAnimationInterval);
  }

  public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
    BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = resizedImage.createGraphics();
    AffineTransform transform = AffineTransform.getScaleInstance((double) targetWidth / originalImage.getWidth(),
        (double) targetHeight / originalImage.getHeight());
    AffineTransformOp scaleOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
    scaleOp.filter(originalImage, resizedImage);
    g2d.drawImage(resizedImage, 0, 0, null);
    g2d.dispose();
    return resizedImage;
  }

  public static boolean AnimationPoisonDeath(BufferedImage buffer, Image spriteSheet, Image spriteSheet2,
      boolean animationFinished, int x, int y, MyKeyBoardListener keyListener) {
    Graphics2D g2d = buffer.createGraphics();

   
    if (Game.snakePoison) {
      bufferedSpriteSheet = (BufferedImage) spriteSheet2;
    } else {
      bufferedSpriteSheet = (BufferedImage) spriteSheet;
    }

  
    int angle = 0;
    int valueX = 0;
    int valueY = 0;

    
    int numFramesX = 10; 
    int numFramesY = 1; 

   
    int frameWidth = 20;
    int frameHeight = 50;

    
    int totalFrames = numFramesX * numFramesY;

   
    int sx = (Game.currentFrame1 % numFramesX) * (bufferedSpriteSheet.getWidth() / numFramesX);
    int sy = (Game.currentFrame1 / numFramesX) * (bufferedSpriteSheet.getHeight() / numFramesY);
    int sw = bufferedSpriteSheet.getWidth() / numFramesX;
    int sh = bufferedSpriteSheet.getHeight() / numFramesY;

   
    BufferedImage resizedImage = resizeImage(bufferedSpriteSheet.getSubimage(sx, sy, sw, sh), frameWidth, frameHeight);

  
    if (keyListener.getDirection() == KeyEvent.VK_LEFT) {
      angle = -90;
      valueX = 18;
      valueY = 50;
    } else if (keyListener.getDirection() == KeyEvent.VK_RIGHT) {
      angle = 90;
      valueX = 5;
      valueY = 65;
    } else if (keyListener.getDirection() == KeyEvent.VK_UP) {
      angle = 0;
      valueY = 50;
      valueX = 5;
    } else if (keyListener.getDirection() == KeyEvent.VK_DOWN) {
      angle = 180;
      valueY = 65;
      valueX = 20;
    }

   
    g2d.rotate(Math.toRadians(angle), x, y);
    g2d.drawImage(resizedImage, x - valueX, y - valueY, null);

    
    long currentTime = System.currentTimeMillis();
    if (currentTime - lastFrameTime > frameInterval) { 
      Game.currentFrame1 = (Game.currentFrame1 + 1) % totalFrames; 
      lastFrameTime = currentTime; 

      if (Game.currentFrame1 == totalFrames - 1) {
        animationFinished = true;
      }

    }

    return animationFinished;
  }

  public static int drawX;
  public static int drawY;
  public static int imageCenterX;
  public static int imageCenterY;
  public static Graphics2D g2d;

  public static void AnimationColidion(BufferedImage buffer, Image BeatEffect, int x,
      int y, double rotationAngle) {

    g2d = buffer.createGraphics();
   
    imageCenterX = x; 
    imageCenterY = y; 
    if (Game.ManterAnimation) {
      g2d.rotate(Math.toRadians(rotationAngle), imageCenterX, imageCenterY); 
    }
    
      drawX = x - BeatEffect.getWidth(null) / 50; 
      drawY = y - BeatEffect.getHeight(null) / 50; 
    
    g2d.drawImage(BeatEffect, drawX, drawY, 30, 30, null);
  
    
    if (Game.ManterAnimation) {
      g2d.rotate(-Math.toRadians(rotationAngle), imageCenterX, imageCenterY);
    }
    g2d.dispose();
  }

  public static void AnimationEnergyTemporary(Game game, BufferedImage buffer,
      Image EnergyAnimationBody, Image EnergyAnimationTail,
      Node[] nodeSnake) {

    BufferedImage bufferedSpriteSheetHead = (BufferedImage) EnergyAnimationBody;
    BufferedImage bufferedSpriteSheetTail = (BufferedImage) EnergyAnimationTail;
    int numFramesX = 16; 
    int numFramesY = 1;
    int frameWidth = 40; 
    int frameHeight = 100;
    int totalFrames = numFramesX * numFramesY;

    
    int sxB = (Game.currentFrame2 % numFramesX) * (bufferedSpriteSheetHead.getWidth() / numFramesX);
    int syB = (Game.currentFrame2 / numFramesX) * (bufferedSpriteSheetHead.getHeight() / numFramesX);
    int swB = bufferedSpriteSheetHead.getWidth() / numFramesX;
    int shB = bufferedSpriteSheetHead.getHeight() / numFramesY;
    BufferedImage resizedImageBody = resizeImage(bufferedSpriteSheetHead.getSubimage(sxB, syB, swB, shB), frameWidth,
        frameHeight);
   
    int sxT = (Game.currentFrame2 % numFramesX) * (bufferedSpriteSheetTail.getWidth() / numFramesX);
    int syT = (Game.currentFrame2 / numFramesX) * (bufferedSpriteSheetTail.getHeight() / numFramesX);
    int swT = bufferedSpriteSheetTail.getWidth() / numFramesX;
    int shT = bufferedSpriteSheetTail.getHeight() / numFramesY;
    BufferedImage resizedImageTail = resizeImage(bufferedSpriteSheetTail.getSubimage(sxT, syT, swT, shT), frameWidth,
        frameHeight);
   

    for (int i = 1; i < nodeSnake.length; i += 19) {
      int xPos = nodeSnake[i].x;
      int yPos = nodeSnake[i].y;

      // int currX = nodeSnake[i].x;
      int currY = nodeSnake[i].y;
      int prevY = i > 0 ? nodeSnake[i - 1].y : currY;

      boolean isHorizontal = currY == prevY;
      if (isHorizontal) {
        Graphics2D g2d = buffer.createGraphics();
        AffineTransform oldTransform = g2d.getTransform(); 
        g2d.rotate(Math.toRadians(90), xPos, yPos);

        g2d.drawImage(resizedImageBody, xPos - 9, yPos - 22, 30, 30, null);
        g2d.setTransform(oldTransform); 
        g2d.dispose();
      } else {
        Graphics2D g2d = buffer.createGraphics();
        AffineTransform oldTransform = g2d.getTransform();
        g2d.rotate(Math.toRadians(0), xPos, yPos);

        g2d.drawImage(resizedImageBody, xPos - 9, yPos - 10, 30, 30, null);
        g2d.setTransform(oldTransform); 
        g2d.dispose();
      }
      
    }
    for (int i = 1; i < nodeSnake.length; i++) {
      int xPos = nodeSnake[i].x;
      int yPos = nodeSnake[i].y;

      // int currX = nodeSnake[i].x;
      int currY = nodeSnake[i].y;
      int prevY = i > 0 ? nodeSnake[i - 1].y : currY;
      boolean isHorizontal = currY == prevY;
      int valueY = 0;
      if (i == nodeSnake.length - 1) {
        if (isHorizontal) {

          Graphics2D g2d = buffer.createGraphics();
          AffineTransform oldTransform = g2d.getTransform(); 
          g2d.rotate(Math.toRadians(90), xPos, yPos);

          g2d.drawImage(resizedImageTail, xPos - 9, yPos - 22, 30, 30, null);
          g2d.setTransform(oldTransform); 
          g2d.dispose();
        } else {
          Graphics2D g2d = buffer.createGraphics();
          AffineTransform oldTransform = g2d.getTransform(); 
          g2d.rotate(Math.toRadians(0), xPos, yPos - valueY);

          g2d.drawImage(resizedImageTail, xPos - 8, yPos - 7, 30, 30, null);
          g2d.setTransform(oldTransform); 
          g2d.dispose();
        }
      }
    }
    long currentTime = System.currentTimeMillis();
    if (currentTime - lastFrameTime1 > frameInterval1) {
      Game.currentFrame2 = (Game.currentFrame2 + 1) % totalFrames;
      lastFrameTime1 = currentTime;
    }
  }

  public static void AnimationEnergyTemporaryFinal(BufferedImage buffer, Image EnergyAnimationFinale,
      Node[] nodeSnake) {
    BufferedImage EnergyAnimationFinal = (BufferedImage) EnergyAnimationFinale;
    int numFramesX = 11;
    int numFramesY = 1; 
    int frameWidth = 40; 
    int frameHeight = 100; 
    int totalFrames = numFramesX * numFramesY;

    
    int sx = (Game.currentFrame4 % numFramesX) * (EnergyAnimationFinal.getWidth() / numFramesX);
    int sy = (Game.currentFrame4 / numFramesX) * (EnergyAnimationFinal.getHeight() / numFramesX);
    int sw = EnergyAnimationFinal.getWidth() / numFramesX;
    int sh = EnergyAnimationFinal.getHeight() / numFramesY;
    BufferedImage resizedImageFinal = resizeImage(EnergyAnimationFinal.getSubimage(sx, sy, sw, sh), frameWidth,
        frameHeight);
    for (int i = 1; i < nodeSnake.length; i += 19) {
      int xPos = nodeSnake[i].x;
      int yPos = nodeSnake[i].y;

      int currY = nodeSnake[i].y;
      int prevY = i > 0 ? nodeSnake[i - 1].y : currY;

      boolean isHorizontal = currY == prevY;
      if (isHorizontal) {
        Graphics2D g2d = buffer.createGraphics();
        AffineTransform oldTransform = g2d.getTransform(); 
        g2d.rotate(Math.toRadians(90), xPos, yPos);

        g2d.drawImage(resizedImageFinal, xPos - 9, yPos - 22, 30, 30, null);
        g2d.setTransform(oldTransform); 
        g2d.dispose();
      } else {
        Graphics2D g2d = buffer.createGraphics();
        AffineTransform oldTransform = g2d.getTransform(); 
        g2d.rotate(Math.toRadians(0), xPos, yPos);

        g2d.drawImage(resizedImageFinal, xPos - 9, yPos - 10, 30, 30, null);
        g2d.setTransform(oldTransform); 
        g2d.dispose();
      }
    }
    for (int i = 1; i < nodeSnake.length; i++) {
      int xPos = nodeSnake[i].x;
      int yPos = nodeSnake[i].y;

      int currY = nodeSnake[i].y;
      int prevY = i > 0 ? nodeSnake[i - 1].y : currY;
      boolean isHorizontal = currY == prevY;
      int valueY = 0;
      if (i == nodeSnake.length - 1) {
        if (isHorizontal) {

          Graphics2D g2d = buffer.createGraphics();
          AffineTransform oldTransform = g2d.getTransform(); 
          g2d.rotate(Math.toRadians(90), xPos, yPos);

          g2d.drawImage(resizedImageFinal, xPos - 9, yPos - 25, 30, 30, null);
          g2d.setTransform(oldTransform); 
          g2d.dispose();
        } else {
          Graphics2D g2d = buffer.createGraphics();
          AffineTransform oldTransform = g2d.getTransform(); 
          g2d.rotate(Math.toRadians(0), xPos, yPos - valueY);

          g2d.drawImage(resizedImageFinal, xPos - 8, yPos - 13, 30, 30, null);
          g2d.setTransform(oldTransform); 
          g2d.dispose();
        }
      }
    }
    long currentTime = System.currentTimeMillis();
    if (currentTime - lastFrameTime2 > frameInterval2) {
      Game.currentFrame4 = (Game.currentFrame4 + 1) % totalFrames;
      lastFrameTime2 = currentTime;
      if (Game.currentFrame4 == totalFrames - 1) {
        Game.SpreetSheetFinale = false;
      }
    }

  }

  public static void AnimationColisionEnergy(Game game, BufferedImage buffer, Image EnergyAnimationInitial,
      Node[] nodeSnake,
      int x, int y) {
    BufferedImage EnergyAnimationColisionInitial = (BufferedImage) EnergyAnimationInitial;
    Graphics2D g2d = buffer.createGraphics();
    int numFramesX = 23; 
    int numFramesY = 1; 
    int frameWidth = 500; 
    int frameHeight = 500; 
    int totalFrames = numFramesX * numFramesY;

    long currentTime = System.currentTimeMillis();
    if (lastFrameTime3 == 0) {
      lastFrameTime3 = currentTime;
    }
    int sx = (Game.currentFrame3 % numFramesX) * (EnergyAnimationColisionInitial.getWidth() / numFramesX);
    int sy = (Game.currentFrame3 / numFramesX) * (EnergyAnimationColisionInitial.getWidth() / numFramesX);
    int sw = EnergyAnimationColisionInitial.getWidth() / numFramesX;
    int sh = EnergyAnimationColisionInitial.getHeight() / numFramesY;

    BufferedImage resizedImageInitialColision = resizeImage(
        EnergyAnimationColisionInitial.getSubimage(sx, sy, sw, sh),
        frameWidth,
        frameHeight);

    for (int i = 0; i < nodeSnake.length; i++) {
      if (i == 0) {
        g2d.drawImage(resizedImageInitialColision, x - 25, y - 90, 90, 120, null);
      }
    }
    if (currentTime - lastFrameTime3 > frameInterval3) {
      Game.currentFrame3 = (Game.currentFrame3 + 1) % totalFrames;
      lastFrameTime3 = currentTime;
      if (Game.currentFrame3 == totalFrames - 1) {
        Game.ControlEnergyColidianBoolean = false;
      }
    }
  }

  public static void AnimationColidianEnergyFood(BufferedImage buffer, Image ColidianEnergyFood, Node[] nodeSnake,
      int x, int y) {
    BufferedImage EnergyAnimationColision = (BufferedImage) ColidianEnergyFood;
    Graphics2D g2d = buffer.createGraphics();
    int numFramesX = 8; 
    int numFramesY = 1; 
    int frameWidth = 500; 
    int frameHeight = 500; 
    int totalFrames = numFramesX * numFramesY;
    long currentTime = System.currentTimeMillis();

    int sx = (Game.currentFrame7 % numFramesX) * (EnergyAnimationColision.getWidth() / numFramesX);
    int sy = (Game.currentFrame7 / numFramesX) * (EnergyAnimationColision.getWidth() / numFramesX);
    int sw = EnergyAnimationColision.getWidth() / numFramesX;
    int sh = EnergyAnimationColision.getHeight() / numFramesY;
    BufferedImage resizedImageColision = resizeImage(
        EnergyAnimationColision.getSubimage(sx, sy, sw, sh),
        frameWidth,
        frameHeight);
    for (int i = 0; i < nodeSnake.length; i++) {
      if (i == 0) {
        g2d.drawImage(resizedImageColision, x, y, 45, 45, null);
      }
    }
    if (currentTime - lastFrameTime4 > frameInterval4) {
      Game.currentFrame7 = (Game.currentFrame7 + 1) % totalFrames;
      lastFrameTime4 = currentTime;
      if (Game.currentFrame7 == totalFrames - 1) {
        Game.ControlOneAnimation = true;
      }
    }
  }

  public static void AnimationColidianPoisonFood(BufferedImage buffer, Image ColidianPoisonFood, Node[] nodeSnake,
      int x, int y) {
    BufferedImage PoisonAnimationColision = (BufferedImage) ColidianPoisonFood;
    Graphics2D g2d = buffer.createGraphics();
    int numFramesX1 = 7; 
    int numFramesY1 = 1; 
    int frameWidth1 = 200; 
    int frameHeight1 = 200; 
    int totalFrames1 = numFramesX1 * numFramesY1;

    int sx1 = (Game.currentFrame8 % numFramesX1) * (PoisonAnimationColision.getWidth() / numFramesX1);
    int sy1 = (Game.currentFrame8 / numFramesX1) * (PoisonAnimationColision.getWidth() / numFramesX1);
    int sw1 = PoisonAnimationColision.getWidth() / numFramesX1;
    int sh1 = PoisonAnimationColision.getHeight() / numFramesY1;
    BufferedImage resizedImageColision = resizeImage(
        PoisonAnimationColision.getSubimage(sx1, sy1, sw1, sh1),
        frameWidth1,
        frameHeight1);
    for (int i = 0; i < nodeSnake.length; i++) {
      if (i == 0) {
        g2d.drawImage(resizedImageColision, x - 10, y + 12, 50, 50, null);
      }
    }
    long currentTime1 = System.currentTimeMillis();
    if (currentTime1 - lastFrameTime5 > frameInterval5) {
      Game.currentFrame8 = (Game.currentFrame8 + 1) % totalFrames1;
      lastFrameTime5 = currentTime1;
      if (Game.currentFrame8 == totalFrames1 - 1) {
        Game.ControlOneAnimationPoison = true;
      }
    }
  }

  public static void AnimationColidianClassicFood(BufferedImage buffer, Image ColidianClassicFood, Node[] nodeSnake,
      int x, int y) {
    BufferedImage ClassicAnimationColision = (BufferedImage) ColidianClassicFood;
    Graphics2D g2d = buffer.createGraphics();
    int numFramesX = 7;
    int numFramesY = 1; 
    int frameWidth = 500; 
    int frameHeight = 500;
    int totalFrames = numFramesX * numFramesY;
    long currentTime = System.currentTimeMillis();

    int sx = (Game.currentFrame9 % numFramesX) * (ClassicAnimationColision.getWidth() / numFramesX);
    int sy = (Game.currentFrame9 / numFramesX) * (ClassicAnimationColision.getWidth() / numFramesX);
    int sw = ClassicAnimationColision.getWidth() / numFramesX;
    int sh = ClassicAnimationColision.getHeight() / numFramesY;
    BufferedImage resizedImageColision = resizeImage(
        ClassicAnimationColision.getSubimage(sx, sy, sw, sh),
        frameWidth,
        frameHeight);
    for (int i = 0; i < nodeSnake.length; i++) {
      if (i == 0) {
        g2d.drawImage(resizedImageColision, x - 5, y - 5, 35, 35, null);
      }
    }
    if (currentTime - lastFrameTime6 > frameInterval6) {
      Game.currentFrame9 = (Game.currentFrame9 + 1) % totalFrames;
      lastFrameTime6 = currentTime;
      if (Game.currentFrame9 == totalFrames - 1) {
        Game.ControlOneAnimationClassic = true;
      }
    }
  }
}
