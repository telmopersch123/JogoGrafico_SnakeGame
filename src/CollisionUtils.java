import java.awt.Rectangle;
import java.util.ArrayList;

public class CollisionUtils {
  static Rectangle imageRect;
  static Rectangle imageRectComplexa;

  public static boolean ThisNearBorder(int x, int y, int FrameWidth, int FrameHeight, int WIDTH, int HEIGHT) {
    return x < 50 || x > FrameWidth - 50 || y < 50 || y > FrameHeight - 50;
  }

  public static boolean ThisNearWalls(int x, int y, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, int WIDTH,
      int HEIGHT) {
    for (int i = 0; i < walls_x.size(); i++) {
      double distance = Math.sqrt(Math.pow(x - walls_x.get(i), 2) + Math.pow(y - walls_y.get(i), 2));
      if (distance < 50) {
        return true;
      }
    }
    return false;
  }

  public static boolean ThisDecoration(int x, int y, int[] DecoracaoX, int[] DecoracaoY, int[] DecoComplexoY,
      int[] DecoComplexoX, int WIDTH, int HEIGHT) {
    if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
        && Game.DecoComplexoY != null && Game.quantiComplexo != null) {
      Rectangle snakeRect = new Rectangle(x, y, WIDTH, HEIGHT);
      for (int i = 0; i < Game.ValueFinal; i++) {
        if (i < Game.ValueDecoNormal) {
          imageRect = new Rectangle(DecoracaoX[i], DecoracaoY[i], 70, 70);
        }
        imageRectComplexa = new Rectangle(DecoComplexoX[i], DecoComplexoY[i], 132, 132);
        if (imageRect.intersects(snakeRect) || imageRectComplexa.intersects(snakeRect)) {
          return true;
        }
      }
    }
    return false;
  }
}
