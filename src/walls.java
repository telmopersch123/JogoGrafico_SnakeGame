import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class walls {
  public static void lawnWalls(Graphics g, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, Image rockSprit) {
    for (int i = 0; i < walls_x.size(); i++) {
      g.drawImage(rockSprit, walls_x.get(i), walls_y.get(i), 18, 18, null);
    }
  }
}
