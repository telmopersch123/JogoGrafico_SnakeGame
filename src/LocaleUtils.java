import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class LocaleUtils {
  static boolean teste = false;
  static Rectangle Decoracao;
  static Rectangle DecoracaoCom;

  public static ArrayList<Point> LocateFood(int FrameWidth, int FrameHeight, int WIDTH, int HEIGHT,
      ArrayList<Integer> walls_x,
      ArrayList<Integer> walls_y, Node[] nodeSnake) {
    ArrayList<Point> foodPositions = new ArrayList<>();
   
    int[] foodX = new int[3];
    int[] foodY = new int[3];
    WIDTH = 18;
    HEIGHT = 18;
    ArrayList<Integer> snake_x = new ArrayList<>();
    ArrayList<Integer> snake_y = new ArrayList<>();
    for (int i = 0; i < nodeSnake.length; i++) {
      snake_x.add(nodeSnake[i].x);
      snake_y.add(nodeSnake[i].y);
    }
  
    boolean tooCloseToWall;

    do {
      tooCloseToWall = false; 
    
      foodX[0] = (int) (Math.random() * (FrameWidth - 100)) + 25;
      foodX[1] = (int) (Math.random() * (FrameWidth - 100)) + 25;
      foodX[2] = (int) (Math.random() * (FrameWidth - 100)) + 25;

      foodY[0] = (int) (Math.random() * (FrameHeight - 100)) + 25;
      foodY[1] = (int) (Math.random() * (FrameHeight - 100)) + 25;
      foodY[2] = (int) (Math.random() * (FrameHeight - 100)) + 25;
      for (int i = 0; i < nodeSnake.length; i++) {
        Rectangle SnakeRect = new Rectangle(snake_x.get(i), snake_y.get(i), WIDTH, HEIGHT);
        Rectangle foodRect1 = new Rectangle(foodX[0], foodY[0], WIDTH, HEIGHT);
        Rectangle foodRect2 = new Rectangle(foodX[1], foodY[1], 25, 25);
        Rectangle foodRect3 = new Rectangle(foodX[2], foodY[2], 25, 25);

        if (foodRect1.intersects(SnakeRect) || foodRect2.intersects(SnakeRect)
            || foodRect3.intersects(SnakeRect)) {
          tooCloseToWall = true;
          break;
        }
      }
 
      if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
          && Game.DecoComplexoY != null && Game.quantiComplexo != null) {
        for (int i = 0; i < Game.ValueFinal; i++) {
          if (i < Game.ValueDecoNormal) {
            if (i < Game.DecoracaoX.length && i < Game.DecoracaoY.length) {
              Decoracao = new Rectangle(Game.DecoracaoX[i],
                  Game.DecoracaoY[i], 30, 30);
            }
          }
          if (i < Game.DecoComplexoX.length && i < Game.DecoComplexoY.length) {
            DecoracaoCom = new Rectangle(Game.DecoComplexoX[i],
                Game.DecoComplexoY[i], 152, 152);
          }
          Rectangle foodRect1 = new Rectangle(foodX[0], foodY[0], 15, 15);
          Rectangle foodRect2 = new Rectangle(foodX[1], foodY[1], 30, 50);
          Rectangle foodRect3 = new Rectangle(foodX[2], foodY[2], 30, 30);
          if (Decoracao.intersects(foodRect1) || Decoracao.contains(foodRect1) ||
              Decoracao.intersects(foodRect2) || Decoracao.contains(foodRect2) ||
              Decoracao.intersects(foodRect3) || Decoracao.contains(foodRect3)) {
            tooCloseToWall = true;
            break; 
          }
          if (DecoracaoCom.intersects(foodRect1) || DecoracaoCom.contains(foodRect1) ||
              DecoracaoCom.intersects(foodRect2) || DecoracaoCom.contains(foodRect2) ||
              DecoracaoCom.intersects(foodRect3) || DecoracaoCom.contains(foodRect3)) {
            tooCloseToWall = true;
            break;
          }
        }
      }
   
    
      for (int i = 0; i < walls_x.size(); i++) {
      
        Rectangle wallRect = new Rectangle(walls_x.get(i), walls_y.get(i), WIDTH, HEIGHT);
        Rectangle foodRect1 = new Rectangle(foodX[0], foodY[0], WIDTH, HEIGHT);
        Rectangle foodRect2 = new Rectangle(foodX[1], foodY[1], 30, 50);
        Rectangle foodRect3 = new Rectangle(foodX[2], foodY[2], 30, 30);
        if (foodRect1.intersects(wallRect) || foodRect1.contains(wallRect) ||
            foodRect2.intersects(wallRect) || foodRect2.contains(wallRect) ||
            foodRect3.intersects(wallRect) || foodRect3.contains(wallRect)) {
          tooCloseToWall = true;
          break; 
        }
      }
      if (!tooCloseToWall) {
        foodPositions.add(new Point(foodX[0], foodY[0]));
        foodPositions.add(new Point(foodX[1], foodY[1]));
        foodPositions.add(new Point(foodX[2], foodY[2]));
      }
     
    } while (tooCloseToWall);
    return foodPositions;
    
  }

  public static ArrayList<ArrayList<Integer>> LocateWall(int FrameWidth, int FrameHeight, int WIDTH, int HEIGHT,
      int numWalls) {
    ArrayList<Integer> walls_x = new ArrayList<>();
    ArrayList<Integer> walls_y = new ArrayList<>();

    for (int k = 0; k < numWalls; k++) {
    
      int valueWidth = 0;
      int valueHeight = 0;
      if (Game.clickedButtonDifiDificil) {
        valueWidth = 4;
        valueHeight = 2;
      } else if (Game.clickedButtonDifiNormal) {
        valueWidth = 3;
        valueHeight = 1;
      } else if (Game.clickedButtonDifiFacil) {
        valueWidth = 2;
        valueHeight = 1;
      }
      int wallWidth = (int) (Math.random() * valueWidth) + 1; 
      int wallHeight = (int) (Math.random() * valueHeight) + 1; 

    
      int startX = (int) (Math.random() * (FrameWidth - wallWidth * WIDTH));
      int startY = (int) (Math.random() * (FrameHeight - wallHeight * HEIGHT));

    
      for (int i = startX; i < startX + wallWidth * WIDTH; i += WIDTH) {
        for (int j = startY; j < startY + wallHeight * HEIGHT; j += HEIGHT) {
          walls_x.add(i);
          walls_y.add(j);
        }
      }

    
      for (int i = 0; i < 20 * (wallWidth + wallHeight); i++) {
        int randomX = startX - valueWidth * WIDTH + (int) (Math.random() * (wallWidth * WIDTH + valueWidth * WIDTH));
        int randomY = startY - valueHeight * HEIGHT + (int) (Math.random() * (wallHeight * HEIGHT + valueHeight * HEIGHT));
        walls_x.add(randomX);
        walls_y.add(randomY);
      }
    }

    ArrayList<ArrayList<Integer>> walls = new ArrayList<>();
    walls.add(walls_x);
    walls.add(walls_y);

    return walls;
  }
}
