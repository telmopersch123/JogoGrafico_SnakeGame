import java.util.Timer;
import java.util.TimerTask;

public class AnimationGameFim {
  private static int vitoriaInterval = 10;
  public static Timer vitoriaTemp;
  public static boolean increaseSizeVen = true;

  public static void AnimationVitoria(Game game) {
    if (vitoriaTemp != null) {
      vitoriaTemp.cancel();
      vitoriaTemp.purge();
    }

    vitoriaTemp = new Timer();
    vitoriaTemp.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (game != null && game.isVisible()) {
          if (increaseSizeVen) {
            if (Game.vitoriaWidth <= 350 || Game.vitoriaHeight <= 180) {
              if (Game.vitoriaWidth < 350) {
                Game.vitoriaWidth += 2;
              }
              if (Game.vitoriaHeight < 200) {
                Game.vitoriaHeight += 1;
              }
              game.resizeImagePanel();
              if (Game.vitoriaWidth == 350 || Game.vitoriaHeight == 180) {
                increaseSizeVen = false;
              }
            }
          } else {
            if (Game.vitoriaWidth > 300 || Game.vitoriaHeight > 150) {
              Game.vitoriaWidth -= 2;
              Game.vitoriaHeight--;
              game.resizeImagePanel();
            }
          }
          game.repaint();
        } else {
          vitoriaTemp.cancel();
          vitoriaTemp.purge();
        }
      }
    }, 0, vitoriaInterval);
  }
}
