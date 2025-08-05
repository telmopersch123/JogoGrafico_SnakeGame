import java.awt.Point;
import java.util.ArrayList;
import java.util.TimerTask;

public class AnimationControlPoison {

  void updateVenomAnimation(Game game) {

    TimerTask timerTask = new TimerTask() {
      @Override
      public void run() {
        game.TimerVerif = true;
      }
    };

    game.timer.scheduleAtFixedRate(timerTask, 5000, 5000);
    long elapsedTime1 = System.currentTimeMillis() - game.lastVenomAnimationTime1;
    long currentTime = System.currentTimeMillis();
    if (Game.VerifiEnergyAnimation) {
      game.TimerVerif = false;
      game.lastVenomAnimationTime1 = System.currentTimeMillis(); 
      currentTime = System.currentTimeMillis();
    }


    if (currentTime - game.lastVenomAnimationTime1 >= 0 && currentTime -
        game.lastVenomAnimationTime1 <= 20) {
      game.venomAnimationPlayed = false;
      Game.poisonFruitWidthVen = 25;
      Game.poisonFruitHeightVen = 50;
    }

    if (elapsedTime1 >= 5000) {
      ArrayList<Point> foodPositions = LocaleUtils.LocateFood(
          game.FrameWidth, game.FrameHeight, game.WIDTH, game.HEIGHT, game.walls_x, game.walls_y, game.nodeSnake);
      if (foodPositions.size() >= 2) {
        Point foodPosition0 = foodPositions.get(0);
        Point foodPosition1 = foodPositions.get(1);
        if (!game.TimerVerif) {
          if (Game.snakeClassica || Game.snakeFire) {
            game.macaPOX = -100;
            game.macaPOY = -100;
          }
          if (Game.snakePoison) {
            game.macaX = -100;
            game.macaY = -100;
          }
        } else if (game.TimerVerif) {
          if (Game.snakeClassica || Game.snakeFire) {
            game.macaPOX = foodPosition1.x;
            game.macaPOY = foodPosition1.y;
          }
          if (Game.snakePoison) {
            game.macaX = foodPosition0.x;
            game.macaY = foodPosition0.y;
          }
        }
      }

      if (!Game.colidionPoiControlTimerAnimation) {
        if (Game.ManterAnimation) {
          AnimationPOison.AnimationFoodVenInic(this);
        }
      }

      game.lastVenomAnimationTime1 = System.currentTimeMillis();
    }
    game.repaint();
  }

}
