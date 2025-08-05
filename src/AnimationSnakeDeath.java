import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class AnimationSnakeDeath {
  private static Timer removeSegmentTimer;

  private static int REMOVE_SEGMENT_INTERVAL = 20;

  public static void AnimationSnake(Game game, ArrayList<Point> foodPositions) {

    if (foodPositions.size() >= 2) {
      if (Game.snakeClassica || Game.snakeFire) {
        Point foodPosition1 = foodPositions.get(1);
        game.macaPOX = foodPosition1.x;
        game.macaPOY = foodPosition1.y;
      } else {
        Point foodPosition0 = foodPositions.get(0);
        game.macaX = foodPosition0.x;
        game.macaY = foodPosition0.y;
      }
    }

    game.segmentsToRemove = game.nodeSnake.length / 2;
    Game.ControlVelocity += game.nodeSnake.length / 2;

    if (game.nodeSnake.length >= 2000) {
      REMOVE_SEGMENT_INTERVAL = 2;
    } else if (game.nodeSnake.length >= 1500) {
      REMOVE_SEGMENT_INTERVAL = 5;
    } else if (game.nodeSnake.length >= 1000) {
      REMOVE_SEGMENT_INTERVAL = 10;
    } else if (game.nodeSnake.length >= 500) {
      REMOVE_SEGMENT_INTERVAL = 15;
    } else {
      REMOVE_SEGMENT_INTERVAL = 20;
    }

    removeSegmentTimer = new Timer();
    removeSegmentTimer.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (game.gameOver) {
          removeSegmentTimer.cancel();
          removeSegmentTimer.purge();
          return;
        }
        if (game.segmentsToRemove > 0) {
      
          game.nodeSnake = Arrays.copyOf(game.nodeSnake, game.nodeSnake.length - 1);
          game.segmentsToRemove--;
          Game.ControlVelocity = Math.max(1, Game.ControlVelocity - 1);

        } else {
          removeSegmentTimer.cancel();
          removeSegmentTimer.purge();

        }
      }
    }, 0, REMOVE_SEGMENT_INTERVAL);
  }
}
