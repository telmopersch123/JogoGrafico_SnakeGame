public class Ultrapassagem {

  public static void UltrapassagemPainel(Node[] nodeSnake, int FrameWidth, int FrameHeight) {
    if (nodeSnake[0].x >= FrameWidth) {
      nodeSnake[0].x = 0;
      nodeSnake[0].x -= 5;
    } else if (nodeSnake[0].x < -5) {
      nodeSnake[0].x = FrameWidth;
    }

    if (nodeSnake[0].y >= FrameHeight) {
      nodeSnake[0].y = 0;
      nodeSnake[0].y -= 5;
    } else if (nodeSnake[0].y < -5) {
      nodeSnake[0].y = FrameHeight;
    }
  }
}
