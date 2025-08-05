import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class snake {
  public static int angle = 0;
  public static Graphics2D snakeBody;
  public static Graphics2D rotated;
  public static Graphics2D rotated2;
  public static Graphics2D rotated3;
  public static Graphics2D Corner;
  public static Graphics2D tail;
  public static Graphics2D head;
  public static int currX;
  public static int currY;
  public static int prevX;
  public static int prevY;
  public static int nextX;
  public static int nextY;
  public static boolean isCorner;
  public static boolean isHorizontal;
  public static int shadowSize;
  public static Color shadowColor;
  public static int centerX;
  public static int centerY;
  public static RadialGradientPaint gradientPaint;
 
  public static boolean isHorizontal1;
  public static AffineTransform rotation;
  public static AffineTransform rotationfire;
 
  public static boolean horizontal;
  public static boolean vertical;
  public static boolean rightTurn;
  public static boolean leftTurn;
  public static int width = 14;

  public static int imageWidth;
  public static int imageHeight;
  public static int centerX2;
  public static int centerY2;
  public static int xPos;
  public static int yPos;

  public static long currentTimefire = System.currentTimeMillis();
  public static long currentTimefire1 = System.currentTimeMillis();
  private static long lastFrameTimefire = 0;
  private static long lastFrameTimefire1 = 0;
  private static int frameIntervalfire = 100;
  private static int frameIntervalfire1 = 100;
  public static int numFramesXfire = 6;
  public static int numFramesXfire1 = 6;
  public static int numFramesYfire = 1;
  public static int numFramesYfire1 = 1;
  public static int totalFramesfire = numFramesXfire * numFramesYfire;
  public static int totalFramesfire1 = numFramesXfire1 * numFramesYfire1;
  private static Graphics2D rotated0;
  private static AffineTransform rotationpoison;

  public static void snakePaint(Node[] nodeSnake, BufferedImage buffer, int WIDTH, int HEIGHT, Image bodyStraight,
      Image bodyCorner, Image tailImage, Image snakeHead,
      MyKeyBoardListener keyListener, Image manchasAmarelas, Image fogoComplementar, Image fogoFinal) {

    snakeBody = buffer.createGraphics();
    Graphics2D g2d = buffer.createGraphics();
    angle = 0;

  
    for (int z = 1; z < nodeSnake.length; z++) {

      currX = nodeSnake[z].x;
      currY = nodeSnake[z].y;
      prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      isHorizontal1 = currY == prevY;
      if (isHorizontal1) {
    
        rotation = AffineTransform.getQuadrantRotateInstance(1, currX + 14 / 2, currY + 14 / 2);
        rotated = (Graphics2D) snakeBody.create();
        rotated.transform(rotation);
        rotated.drawImage(bodyStraight, currX, currY, WIDTH + 4, HEIGHT + 4, null);

        rotated.dispose();
      } else {
  

        rotation = AffineTransform.getQuadrantRotateInstance(0, currX + 14 / 2, currY + 14 / 2);
        rotated = (Graphics2D) snakeBody.create();
        rotated.transform(rotation);
        rotated.drawImage(bodyStraight, currX, currY, WIDTH + 4, HEIGHT + 4, null);

        rotated.dispose();
      }
    }

   
    for (int z = 0; z < nodeSnake.length; z++) {
      Corner = buffer.createGraphics();
      currX = nodeSnake[z].x;
      currY = nodeSnake[z].y;
      prevX = z > 0 ? nodeSnake[z - 1].x : currX;
      prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
      nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
      isCorner = (prevX != nextX) && (prevY != nextY);
      horizontal = prevX != nextX;
      vertical = prevY != nextY;
      rightTurn = (prevX < currX && nextY > currY) || (prevY > currY && nextX < currX);
      leftTurn = (prevX > currX && nextY < currY) || (prevY < currY && nextX > currX);
      if (isCorner) {
        if (vertical && rightTurn) {
          angle = 90;
        } else if (vertical && leftTurn) {
          angle = -90;
        } else if (horizontal && rightTurn) {
          angle = 0;
        } else if (horizontal && leftTurn) {
          angle = 180;
        } else if (horizontal && nextY < currY) {
          angle = 180;
        } else if (horizontal && nextY > currY) {
          angle = 0;
        } else if (vertical && nextX < currX) {
          angle = 180;
        } else if (vertical && nextX > currX) {
          angle = 0;
        }

        Corner.rotate(Math.toRadians(angle), nodeSnake[z].x + 15 / 2, nodeSnake[z].y + 15 / 2);
        Corner.drawImage(bodyCorner, currX, currY, WIDTH + 6, HEIGHT + 6, null);
        Corner.dispose();
      }
    }
   
    for (int z = 0; z < nodeSnake.length; z++) {
      currX = nodeSnake[z].x;
      currY = nodeSnake[z].y;
      prevX = z > 0 ? nodeSnake[z - 1].x : currX;
      prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
      nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
      horizontal = prevX != nextX;
      vertical = prevY != nextY;
      tail = (Graphics2D) buffer.createGraphics();

      if (z == nodeSnake.length - 1) {
        if (horizontal && prevX < currX) {
          // direita
          tail.rotate(Math.toRadians(180), nodeSnake[z].x + width / 2, nodeSnake[z].y + width / 2);
        } else if (horizontal && prevX > currX) {
          // esquerda
          tail.rotate(Math.toRadians(0), nodeSnake[z].x + width / 2, nodeSnake[z].y + width / 2);
        } else if (vertical && prevY < currY) {
          // baixo
          tail.rotate(Math.toRadians(-90), nodeSnake[z].x + width / 2, nodeSnake[z].y + width / 2);
        } else if (vertical && prevY > currY) {
          // cima
          tail.rotate(Math.toRadians(90), nodeSnake[z].x + width / 2, nodeSnake[z].y + width / 2);
        }
        tail.drawImage(tailImage, nodeSnake[z].x - 3, nodeSnake[z].y, 14, 14, null);
        tail.dispose();
      }
    }
  
    head = buffer.createGraphics();
  
    if (keyListener.getDirection() == Game.keyPressedEsquerda) {
      angle = 180;
    } else if (keyListener.getDirection() == Game.keyPressedDireita) {
      angle = 0;
    } else if (keyListener.getDirection() == Game.keyPressedSuperior) {
      angle = -90;
    } else if (keyListener.getDirection() == Game.keyPressedInferior) {
      angle = 90;
    }
    imageWidth = (int) (12 * 1.7); 
    imageHeight = (int) (12 * 1.5); 
    centerX = nodeSnake[0].x + 15 / 2;
    centerY = nodeSnake[0].y + 15 / 2;

   
    xPos = centerX - imageWidth / 2;
    yPos = centerY - imageHeight / 2;
  
    head.rotate(Math.toRadians(angle), xPos + imageWidth / 2, yPos + imageHeight / 2); 
    head.drawImage(snakeHead, xPos + 3, yPos, imageWidth, imageHeight, null); 

  
    if (Game.snakePoison) {
      for (int f = 10; f < nodeSnake.length; f += 10) {
        currX = nodeSnake[f].x;
        currY = nodeSnake[f].y;
        prevY = f > 0 ? nodeSnake[f - 1].y : currY;
        isHorizontal1 = currY == prevY;
        if (isHorizontal1) {
          rotationpoison = AffineTransform.getQuadrantRotateInstance(1, currX + 18 / 2, currY + 22 / 2);
          rotated0 = (Graphics2D) g2d.create();
          rotated0.transform(rotationpoison);
          rotated0.drawImage(manchasAmarelas, currX, currY + 7, WIDTH, HEIGHT, null);
          rotated0.dispose();
        } else {
          rotationpoison = AffineTransform.getQuadrantRotateInstance(0, currX + 18 / 2, currY + 27 / 2);
          rotated0 = (Graphics2D) g2d.create();
          rotated0.transform(rotationpoison);
          rotated0.drawImage(manchasAmarelas, currX + 2, currY + 2, WIDTH, HEIGHT, null);
          rotated0.dispose();
        }
      }
    }
    if (Game.ManterAnimation) {
    
      if (Game.snakeFire) {
        for (int f = 10; f < nodeSnake.length; f += 10) {
          currX = nodeSnake[f].x;
          currY = nodeSnake[f].y;
          prevY = f > 0 ? nodeSnake[f - 1].y : currY;
          isHorizontal1 = currY == prevY;
          if (isHorizontal1) {
            rotationfire = AffineTransform.getRotateInstance(Math.toRadians(180), currX + 18 / 2, currY + 27 / 2);
            rotated2 = (Graphics2D) g2d.create();
            rotated2.transform(rotationfire);
            BufferedImage fogosnake = (BufferedImage) fogoComplementar;
            int sx = (Game.currentFrame25 % numFramesXfire) * (fogosnake.getWidth() / numFramesXfire);
            int sy = (Game.currentFrame25 / numFramesXfire) * (fogosnake.getHeight() / numFramesYfire);
            int sw = fogosnake.getWidth() / numFramesXfire;
            int sh = fogosnake.getHeight() / numFramesYfire;
            AffineTransform at = new AffineTransform();
            at.scale((double) (20) / sw, (double) (40) / sh);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            BufferedImage scaledImage = op.filter(fogosnake.getSubimage(sx, sy, sw, sh), null);
            rotated2.drawImage(scaledImage, currX, currY, null);
            long currentTimefire = System.currentTimeMillis();
            if (currentTimefire - lastFrameTimefire >= frameIntervalfire) {
              lastFrameTimefire = currentTimefire;
              Game.currentFrame25 = (Game.currentFrame25 + 1) % totalFramesfire;
            }
            rotated2.dispose();
          } else {
            rotationfire = AffineTransform.getRotateInstance(Math.toRadians(90), currX + 28 / 2, currY + 27 / 2);
            rotated2 = (Graphics2D) g2d.create();
            rotated2.transform(rotationfire);
            BufferedImage fogosnake = (BufferedImage) fogoComplementar;
            int sx = (Game.currentFrame25 % numFramesXfire) * (fogosnake.getWidth() / numFramesXfire);
            int sy = (Game.currentFrame25 / numFramesXfire) * (fogosnake.getHeight() / numFramesYfire);
            int sw = fogosnake.getWidth() / numFramesXfire;
            int sh = fogosnake.getHeight() / numFramesYfire;
            AffineTransform at = new AffineTransform();
            at.scale((double) (20) / sw, (double) (40) / sh);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            BufferedImage scaledImage = op.filter(fogosnake.getSubimage(sx, sy, sw, sh), null);
            rotated2.drawImage(scaledImage, currX, currY, null);
            long currentTimefire = System.currentTimeMillis();
            if (currentTimefire - lastFrameTimefire >= frameIntervalfire) {
              lastFrameTimefire = currentTimefire;
              Game.currentFrame25 = (Game.currentFrame25 + 1) % totalFramesfire;
            }
            rotated2.dispose();
          }
        }
        for (int z = 0; z < nodeSnake.length; z++) {
          currX = nodeSnake[z].x;
          currY = nodeSnake[z].y;
          prevX = z > 0 ? nodeSnake[z - 1].x : currX;
          prevY = z > 0 ? nodeSnake[z - 1].y : currY;
          nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
          nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
          horizontal = prevX != nextX;
          vertical = prevY != nextY;
          rotated3 = (Graphics2D) g2d.create();
          if (z == nodeSnake.length - 1) {
            if (horizontal && prevX > currX) {
              // direita
              rotated3.rotate(Math.toRadians(0), nodeSnake[z].x + 18 / 2, nodeSnake[z].y + 27 / 2);
            } else if (horizontal && prevX < currX) {
              // esquerda
              rotated3.rotate(Math.toRadians(180), nodeSnake[z].x + 17 / 2, nodeSnake[z].y + 13 / 2);
            } else if (vertical && prevY < currY) {
              // cima
              rotated3.rotate(Math.toRadians(-90), nodeSnake[z].x + 15 / 2, nodeSnake[z].y + 13 / 2);
            } else if (vertical && prevY > currY) {
              // baixo
              rotated3.rotate(Math.toRadians(90), nodeSnake[z].x + 10 / 2, nodeSnake[z].y + 15 / 2);
            }
            BufferedImage fogosnake = (BufferedImage) fogoFinal;
            int sx = (Game.currentFrame26 % numFramesXfire1) * (fogosnake.getWidth() / numFramesXfire1);
            int sy = (Game.currentFrame26 / numFramesXfire1) * (fogosnake.getHeight() / numFramesYfire1);
            int sw = fogosnake.getWidth() / numFramesXfire1;
            int sh = fogosnake.getHeight() / numFramesYfire1;
            AffineTransform at = new AffineTransform();
            at.scale((double) (30) / sw, (double) (30) / sh);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            BufferedImage scaledImage = op.filter(fogosnake.getSubimage(sx, sy, sw, sh), null);
            rotated3.drawImage(scaledImage, currX - 18, currY - 9, null);
            long currentTimefire1 = System.currentTimeMillis();
            if (currentTimefire1 - lastFrameTimefire1 >= frameIntervalfire1) {
              lastFrameTimefire1 = currentTimefire1;
              Game.currentFrame26 = (Game.currentFrame26 + 1) % totalFramesfire1;
            }
            rotated3.dispose();
          }
        }
      }
    }
  }
}
