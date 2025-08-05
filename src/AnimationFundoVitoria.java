import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class AnimationFundoVitoria {
  private static int vitoriaInterval = 100;
  public static Timer fundoTemp;

  public static void AnimationVitoria(Game game, Graphics g, int getWidth, int getHeight) {
    if (fundoTemp != null) {
      fundoTemp.cancel();
      fundoTemp.purge();
    }

    fundoTemp = new Timer();
    fundoTemp.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {

        if (Game.Transper <= 50) {
          Game.Transper++;
        } else {
          fundoTemp.cancel();
          fundoTemp.purge();
        }

        game.repaint();
      }
    }, 0, vitoriaInterval);
  }
}
