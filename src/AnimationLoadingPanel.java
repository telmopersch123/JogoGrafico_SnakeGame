import java.util.Timer;
import java.util.TimerTask;

public class AnimationLoadingPanel {
  static Timer timerLoading;
  static int loadingInterval = 100;

  public static void AnimationLoading(Game game) {
    if (timerLoading != null) {
      timerLoading.cancel();
      timerLoading.purge();
    }
    timerLoading = new Timer();
    timerLoading.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (game != null && game.isVisible()) {
          if (MenuPanel.CorPretaLoading != 0) {
            MenuPanel.CorPretaLoading--;
            MenuPanel.loadingPanel.revalidate();
            MenuPanel.loadingPanel.repaint();
          } else {
            Game.PodeIniciarPosLoading = true;
            Game.aparecerAposLoading = true;
            timerLoading.cancel();
            timerLoading.purge();
          }
        }
      }
    }, 0, loadingInterval);
  }
}
