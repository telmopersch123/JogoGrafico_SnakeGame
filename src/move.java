public class move {
  public static Node[] SnakeMove(Node[] nodeSnake, int newDirection, int DISTANCE) {
    for (int i = nodeSnake.length - 1; i > 0; i--) {
      nodeSnake[i].x = nodeSnake[i - 1].x;
      nodeSnake[i].y = nodeSnake[i - 1].y;

    }

    if (newDirection == Game.keyPressedDireita) {
      nodeSnake[0].x += DISTANCE;
    } else if (newDirection == Game.keyPressedEsquerda) {
      nodeSnake[0].x -= DISTANCE;
    } else if (newDirection == Game.keyPressedSuperior) {
      nodeSnake[0].y -= DISTANCE;
    } else if (newDirection == Game.keyPressedInferior) {
      nodeSnake[0].y += DISTANCE;
    }

    return nodeSnake;
  }

}
