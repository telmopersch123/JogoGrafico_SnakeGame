import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class LoadingSpinner extends JPanel {
  private int angle = 0;
  private final int trailLength = 10;
  private final Point[] trailPoints = new Point[trailLength];
  static Timer timerLoading;
  public LoadingSpinner() {
    setPreferredSize(new Dimension(50, 50));
    setOpaque(false);
     timerLoading = new Timer(10, new ActionListener() { 
      @Override
      public void actionPerformed(ActionEvent e) {
        angle += 10; 
        updateTrailPoints();
        repaint();
      }
    });
     timerLoading.start();
  }

  private void updateTrailPoints() {
    for (int i = trailLength - 1; i > 0; i--) {
      trailPoints[i] = trailPoints[i - 1];
    }
    int radius = Math.min(getWidth(), getHeight()) / 4;
    int x = getWidth() / 2 + (int) (radius * Math.cos(Math.toRadians(angle))) - radius / 2;
    int y = getHeight() / 2 + (int) (radius * Math.sin(Math.toRadians(angle))) - radius / 2;
    trailPoints[0] = new Point(x, y);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    for (int i = 0; i < trailLength; i++) {
      if (trailPoints[i] != null) {
        g2d.setColor(new Color(0, 0, 0, (int) (255 * (1 - (float) i / trailLength))));
        g2d.fillOval(trailPoints[i].x, trailPoints[i].y, 10, 10); 
      }
    }
    g2d.dispose();
  }
}
