import java.util.Timer;
import java.util.TimerTask;

public class AnimationEnergyFim {
  private static int poisonFruitAnimationInterval1 = 5;
  private static Timer poisonFruitAnimationTimerFim;

  public static void AnimationFoodErnFim() {
    poisonFruitAnimationTimerFim = new Timer();
    poisonFruitAnimationTimerFim.scheduleAtFixedRate(new TimerTask() {

      @Override
      public void run() {
        if (Game.poisonFruitWidthErn > 0 || Game.poisonFruitHeightErn > 0) {
          Game.poisonFruitWidthErn--;
          Game.poisonFruitHeightErn--;
          Game.colisionControlEnergy = true;
        } else {
          poisonFruitAnimationTimerFim.cancel();
          poisonFruitAnimationTimerFim.purge();
        }

      }

    }, 0, poisonFruitAnimationInterval1);
  }
}
