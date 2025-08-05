import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class MyKeyBoardListener implements KeyListener {
  private int initialDirection;
  private int currentDirection = 0;
  private boolean initialVerif = false;

  private Timer timer;

  private Timer timerBlock;
  private boolean canPress = true;

  public MyKeyBoardListener(Game game, int direction) {
    this.initialDirection = direction;
    timer = new Timer(10, e -> resetVerif());
    timerBlock = new Timer(100, e -> canPress = true);
    timerBlock.setRepeats(false);

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (Game.PodeIniciarPosLoading || !Game.ManterAnimation) {
      if (key == Game.keyPressedEsquerda) {
        Game.direction = Game.keyPressedEsquerda;
      } else if (key == Game.keyPressedDireita) {
        Game.direction = Game.keyPressedDireita;
      } else if (key == Game.keyPressedSuperior) {
        Game.direction = Game.keyPressedSuperior;
      } else if (key == Game.keyPressedInferior) {
        Game.direction = Game.keyPressedInferior;
      }

      
      if ((key == Game.keyPressedEsquerda || key == Game.keyPressedDireita ||
          key == Game.keyPressedSuperior || key == Game.keyPressedInferior) &&
          Math.abs(key - initialDirection) != 2 && canPress) {

       
        if ((key == Game.keyPressedEsquerda && initialDirection != Game.keyPressedDireita) ||
            (key == Game.keyPressedDireita && initialDirection != Game.keyPressedEsquerda) ||
            (key == Game.keyPressedSuperior && initialDirection != Game.keyPressedInferior) ||
            (key == Game.keyPressedInferior && initialDirection != Game.keyPressedSuperior)) {

          Game.IniciouEgg = false;
          Game.cobraParada = true;
          initialDirection = key;
          canPress = false;
          timerBlock.restart();
        }
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  
    int key = e.getKeyCode();
    if (key != currentDirection) {
      initialVerif = true;
    }
    if ((key == Game.keyPressedEsquerda || key == Game.keyPressedDireita || key == Game.keyPressedSuperior
        || key == Game.keyPressedInferior) && Math.abs(key - initialDirection) != 2) {
      currentDirection = e.getKeyCode();
    }

    timer.restart();
  }

  public int getDirection() {
    return initialDirection;
  }

  public boolean getVerif() {
    return initialVerif;
  }

  private void resetVerif() {
    initialVerif = false;
  }

  public void setDirection(int direction) {
    // Não é necessário implementar este método
  }
}
