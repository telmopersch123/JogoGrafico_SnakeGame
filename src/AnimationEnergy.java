import java.util.Timer;
import java.util.TimerTask;

public class AnimationEnergy {
  private static int poisonFruitAnimationInterval0 = 7;
  private static Timer poisonFruitAnimationTimer;

  private static boolean increaseSizeVen = true;

  public static void AnimationFoodErnInic(AnimationEnergyControl AnimationEnergyControl) {
    poisonFruitAnimationTimer = new Timer();
    poisonFruitAnimationTimer.scheduleAtFixedRate(new TimerTask() {

      @Override
      public void run() {
        if (increaseSizeVen) {
          if (Game.poisonFruitWidthErn < 44 || Game.poisonFruitHeightErn < 44) {
            Game.poisonFruitWidthErn++;
            Game.poisonFruitHeightErn++;
            Game.colidionEneControlTimerAnimation = true;
          } else {
            increaseSizeVen = false;
          }
        } else {
          if (Game.poisonFruitWidthErn > 40 || Game.poisonFruitHeightErn > 40) {
            Game.poisonFruitWidthErn--;
            Game.poisonFruitHeightErn--;
            Game.colidionEneControlTimerAnimation = true;
          } else {
            Game.colidionEneControlTimerAnimation = false;
            Game.colisionControlEnergy = false;
            poisonFruitAnimationTimer.cancel();
            poisonFruitAnimationTimer.purge();
            increaseSizeVen = true;
          }
        }
      }
    }, 0, poisonFruitAnimationInterval0);
  }
}
