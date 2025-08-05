import java.awt.Rectangle;
import java.util.ArrayList;

public class checkedColisson {

  public static Rectangle headCollisionAreaDeco;
  private static Rectangle complexasDungeon;
  private static Rectangle complexasSwamp;
  private static Rectangle complexasField;

  public static ResultadoColisao verificarColisao(boolean gameOver, int WIDTH, int HEIGHT, int FrameWidth,
      int FrameHeight,
      ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, Node[] nodeSnake,
      int largerCollisionArea, Rectangle headCollisionArea, boolean poisonDeathAnimationPlaying,
      int borderWidth, int getWidth, int getHeight, boolean DeathfromHunger) {

    if (nodeSnake.length < 30) {
      return new ResultadoColisao(true, true);
    }

    if (DeathfromHunger) {
      MusicPlayer.deathFome();
      return new ResultadoColisao(true, false);
    }

    if (Game.colisianEnergyMorrer) {
      return new ResultadoColisao(true, false);
    }

    if (Game.clickedButtonDifiNormal || Game.clickedButtonDifiDificil) {
      if (colisaoPainel(nodeSnake, borderWidth, getWidth, getHeight)) {
        MusicPlayer.Colisao();
        return new ResultadoColisao(true, false);
      }
    }
    if (nodeSnake.length >= 60) {
      if (colisaoCobra(nodeSnake)) {
        MusicPlayer.Colisao();
        return new ResultadoColisao(true, false);
      }
    }

    if (Game.MapField) {
      if (colisaoDecoField(nodeSnake, largerCollisionArea)) {
        MusicPlayer.Colisao();
        return new ResultadoColisao(true, false);
      }
      if (colisaoParede(nodeSnake, walls_x, walls_y, largerCollisionArea)) {
        MusicPlayer.Colisao();
        return new ResultadoColisao(true, false);
      }
    } else if (Game.MapSwamp) {
      if (colisaoDecoSwamp(nodeSnake, largerCollisionArea)) {
        MusicPlayer.Colisao();
        return new ResultadoColisao(true, false);
      }
    } else if (Game.MapDungeon) {
      if (colisaoDecoDungeon(nodeSnake, largerCollisionArea)) {
        MusicPlayer.Colisao();
        return new ResultadoColisao(true, false);
      }
    }

    return new ResultadoColisao(gameOver, poisonDeathAnimationPlaying);
  }

  private static boolean colisaoPainel(Node[] nodeSnake, int borderWidth, int getWidth, int getHeight) {
    return (nodeSnake[0].y <= borderWidth || nodeSnake[0].y >= getHeight - 30 ||
        nodeSnake[0].x <= borderWidth || nodeSnake[0].x >= getWidth - 30);
  }

  private static boolean colisaoCobra(Node[] nodeSnake) {
    for (int i = 1; i < nodeSnake.length; i++) {
      if (nodeSnake[0].x == nodeSnake[i].x && nodeSnake[0].y == nodeSnake[i].y) {
        return true;
      }
    }
    return false;
  }

  private static boolean colisaoDecoField(Node[] nodeSnake, int largerCollisionArea) {
    headCollisionAreaDeco = new Rectangle(nodeSnake[0].x, nodeSnake[0].y, 15, 15);
    if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
        && Game.DecoComplexoY != null && Game.quantiComplexo != null) {
      for (int i = 0; i < Game.DecoracaoX.length; i++) {
        Rectangle Decoracao = new Rectangle(Game.DecoracaoX[i], Game.DecoracaoY[i],
            30, 30);
        if (headCollisionAreaDeco.intersects(Decoracao)) {
          return true;
        }
      }
      for (int i = 0; i < Game.quantiComplexo.size(); i++) {
        if (Game.quantiComplexo.get(i) > 0) {
          switch (i) {
            case 0:
              if (Game.DecoComplexoX.length > 1 && Game.DecoComplexoY.length > 1) {
                complexasField = new Rectangle(Game.DecoComplexoX[1] + 10,
                    Game.DecoComplexoY[1] + 45, 40, 10);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 1:
              if (Game.DecoComplexoX.length > 2 && Game.DecoComplexoY.length > 2) {
                complexasField = new Rectangle(Game.DecoComplexoX[2] + 10,
                    Game.DecoComplexoY[2] + 45, 40, 10);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 2:
              if (Game.DecoComplexoX.length > 3 && Game.DecoComplexoY.length > 3) {
                complexasField = new Rectangle(Game.DecoComplexoX[3] + 10,
                    Game.DecoComplexoY[3] + 50, 40, 10);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 3:
              if (Game.DecoComplexoX.length > 4 && Game.DecoComplexoY.length > 4) {
                complexasField = new Rectangle(Game.DecoComplexoX[4] + 35,
                    Game.DecoComplexoY[4] + 75, 40, 10);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 4:
              if (Game.DecoComplexoX.length > 5 && Game.DecoComplexoY.length > 5) {
                complexasField = new Rectangle(Game.DecoComplexoX[5] + 22,
                    Game.DecoComplexoY[5] + 50, 10, 10);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 5:
              if (Game.DecoComplexoX.length > 6 && Game.DecoComplexoY.length > 6) {
                complexasField = new Rectangle(Game.DecoComplexoX[6] + 10,
                    Game.DecoComplexoY[6] + 40, 50, 50);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 6:
              if (Game.DecoComplexoX.length > 7 && Game.DecoComplexoY.length > 7) {
                complexasField = new Rectangle(Game.DecoComplexoX[7] + 25,
                    Game.DecoComplexoY[7] + 15, 75, 85);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 7:
              if (Game.DecoComplexoX.length > 8 && Game.DecoComplexoY.length > 8) {
                complexasField = new Rectangle(Game.DecoComplexoX[8],
                    Game.DecoComplexoY[8] + 25, 64, 40);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 8:
              if (Game.DecoComplexoX.length > 9 && Game.DecoComplexoY.length > 9) {
                complexasField = new Rectangle(Game.DecoComplexoX[9] + 10,
                    Game.DecoComplexoY[9] + 15, 100, 90);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 9:
              if (Game.DecoComplexoX.length > 10 && Game.DecoComplexoY.length > 10) {
                complexasField = new Rectangle(Game.DecoComplexoX[10] + 35,
                    Game.DecoComplexoY[10] + 100, 40, 40);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 10:
              if (Game.DecoComplexoX.length > 11 && Game.DecoComplexoY.length > 11) {
                complexasField = new Rectangle(Game.DecoComplexoX[11] + 15,
                    Game.DecoComplexoY[11] + 50, 10, 10);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            case 11:
              if (Game.DecoComplexoX.length > 12 && Game.DecoComplexoY.length > 12) {
                complexasField = new Rectangle(Game.DecoComplexoX[12],
                    Game.DecoComplexoY[12] + 10, 100, 67);
                if (headCollisionAreaDeco.intersects(complexasField)) {
                  return true;
                }
              }
              break;
            default:
              break;
          }
        }
      }
    }
    return false;
  }

  private static boolean colisaoDecoSwamp(Node[] nodeSnake, int largerCollisionArea) {
    headCollisionAreaDeco = new Rectangle(nodeSnake[0].x, nodeSnake[0].y, 15, 15);
    if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
        && Game.DecoComplexoY != null && Game.quantiComplexo != null) {
      for (int i = 0; i < Game.DecoracaoX.length; i++) {
        Rectangle Decoracao = new Rectangle(Game.DecoracaoX[i], Game.DecoracaoY[i],
            30, 30);
        if (headCollisionAreaDeco.intersects(Decoracao)) {
          return true;
        }
      }
    }
    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      if (Game.quantiComplexo.get(i) > 0) {
        switch (i) {
          case 0:
            if (Game.DecoComplexoX.length > 1 && Game.DecoComplexoY.length > 1) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[1] + 10,
                  Game.DecoComplexoY[1] + 20, 28, 29);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 1:
            if (Game.DecoComplexoX.length > 2 && Game.DecoComplexoY.length > 2) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[2] + 7,
                  Game.DecoComplexoY[2] + 10, 40, 35);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 2:
            if (Game.DecoComplexoX.length > 3 && Game.DecoComplexoY.length > 3) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[3] + 10,
                  Game.DecoComplexoY[3] + 20, 35, 45);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 3:
            if (Game.DecoComplexoX.length > 4 && Game.DecoComplexoY.length > 4) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[4],
                  Game.DecoComplexoY[4] + 50, 100, 60);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 4:
            if (Game.DecoComplexoX.length > 5 && Game.DecoComplexoY.length > 5) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[5] + 15,
                  Game.DecoComplexoY[5] + 15, 73, 55);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 5:
            if (Game.DecoComplexoX.length > 6 && Game.DecoComplexoY.length > 6) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[6] + 12,
                  Game.DecoComplexoY[6] + 37, 80, 60);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }

            break;
          case 6:
            if (Game.DecoComplexoX.length > 7 && Game.DecoComplexoY.length > 7) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[7] + 30,
                  Game.DecoComplexoY[7] + 60, 40, 30);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }

            break;
          case 7:
            if (Game.DecoComplexoX.length > 18 && Game.DecoComplexoY.length > 8) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[8] + 5,
                  Game.DecoComplexoY[8] + 30, 45, 30);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }

            break;
          case 8:
            if (Game.DecoComplexoX.length > 9 && Game.DecoComplexoY.length > 9) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[9] + 25,
                  Game.DecoComplexoY[9] + 95, 60, 25);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 9:
            if (Game.DecoComplexoX.length > 10 && Game.DecoComplexoY.length > 10) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[10] + 8,
                  Game.DecoComplexoY[10] + 40, 58, 15);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 10:
            if (Game.DecoComplexoX.length > 11 && Game.DecoComplexoY.length > 11) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[11] + 25,
                  Game.DecoComplexoY[11] + 60, 60, 48);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 11:
            if (Game.DecoComplexoX.length > 12 && Game.DecoComplexoY.length > 12) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[12] + 25,
                  Game.DecoComplexoY[12] + 65, 45, 25);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 12:
            if (Game.DecoComplexoX.length > 13 && Game.DecoComplexoY.length > 13) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[13] + 6,
                  Game.DecoComplexoY[13] + 29, 25, 20);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 13:
            if (Game.DecoComplexoX.length > 14 && Game.DecoComplexoY.length > 14) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[14] + 20,
                  Game.DecoComplexoY[14] + 105, 40, 30);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 14:
            if (Game.DecoComplexoX.length > 15 && Game.DecoComplexoY.length > 15) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[15] + 35,
                  Game.DecoComplexoY[15] + 40, 30, 25);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 15:
            if (Game.DecoComplexoX.length > 16 && Game.DecoComplexoY.length > 16) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[16] + 15,
                  Game.DecoComplexoY[16] + 40, 20, 20);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 16:
            if (Game.DecoComplexoX.length > 17 && Game.DecoComplexoY.length > 17) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[17] + 10,
                  Game.DecoComplexoY[17] + 50, 45, 25);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 17:
            if (Game.DecoComplexoX.length > 18 && Game.DecoComplexoY.length > 18) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[18] + 5,
                  Game.DecoComplexoY[18] + 40, 20, 20);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 18:
            if (Game.DecoComplexoX.length > 19 && Game.DecoComplexoY.length > 19) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[19] + 5,
                  Game.DecoComplexoY[19] + 15, 60, 25);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 19:
            if (Game.DecoComplexoX.length > 20 && Game.DecoComplexoY.length > 20) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[20] + 20,
                  Game.DecoComplexoY[20] + 60, 25, 30);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 20:
            if (Game.DecoComplexoX.length > 21 && Game.DecoComplexoY.length > 21) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[21] + 15,
                  Game.DecoComplexoY[21] + 60, 40, 25);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 21:
            if (Game.DecoComplexoX.length > 22 && Game.DecoComplexoY.length > 22) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[22] + 30,
                  Game.DecoComplexoY[22] + 50, 30, 30);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 22:
            if (Game.DecoComplexoX.length > 23 && Game.DecoComplexoY.length > 23) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[23] + 30,
                  Game.DecoComplexoY[23] + 55, 20, 25);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 23:
            if (Game.DecoComplexoX.length > 24 && Game.DecoComplexoY.length > 24) {

              complexasSwamp = new Rectangle(Game.DecoComplexoX[24] + 25,
                  Game.DecoComplexoY[24] + 45, 15, 20);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 24:
            if (Game.DecoComplexoX.length > 25 && Game.DecoComplexoY.length > 25) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[25] + 10,
                  Game.DecoComplexoY[25] + 70, 45, 30);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 25:
            if (Game.DecoComplexoX.length > 26 && Game.DecoComplexoY.length > 26) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[26] + 5,
                  Game.DecoComplexoY[26] + 45, 40, 25);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 26:
            if (Game.DecoComplexoX.length > 27 && Game.DecoComplexoY.length > 27) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[27] + 5,
                  Game.DecoComplexoY[27] + 65, 50, 35);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 27:
            if (Game.DecoComplexoX.length > 28 && Game.DecoComplexoY.length > 28) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[28] + 5,
                  Game.DecoComplexoY[28] + 100, 40, 30);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 28:
            if (Game.snakeClassica || Game.snakeFire) {
              if (Game.DecoComplexoX.length > 29 && Game.DecoComplexoY.length > 29) {
                complexasSwamp = new Rectangle(Game.DecoComplexoX[29] + 45,
                    Game.DecoComplexoY[29] + 45, 65, 65);
                if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                  return true;
                }
              }
            }
            break;
          case 29:
            if (Game.snakeClassica || Game.snakeFire) {
              if (Game.DecoComplexoX.length > 30 && Game.DecoComplexoY.length > 30) {
                complexasSwamp = new Rectangle(Game.DecoComplexoX[30] + 45,
                    Game.DecoComplexoY[30] + 45, 65, 65);
                if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                  return true;
                }
              }
            }
            break;
          case 30:
            if (Game.snakeClassica || Game.snakeFire) {
              if (Game.DecoComplexoX.length > 30 && Game.DecoComplexoY.length > 30) {
                complexasSwamp = new Rectangle(Game.DecoComplexoX[31] + 45,
                    Game.DecoComplexoY[31] + 45, 65, 65);
                if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                  return true;
                }
              }
            } else {
              if (Game.DecoComplexoX.length > 30 && Game.DecoComplexoY.length > 30) {
                complexasSwamp = new Rectangle(Game.DecoComplexoX[31] + 45,
                    Game.DecoComplexoY[31] + 35, 40, 30);
                if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                  return true;
                }
              }
              if (Game.DecoComplexoX.length > 30 && Game.DecoComplexoY.length > 30) {
                complexasSwamp = new Rectangle(Game.DecoComplexoX[31] + 75,
                    Game.DecoComplexoY[31] + 90, 30, 20);
                if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                  return true;
                }
              }
            }
            break;
          case 31:
            if (Game.DecoComplexoX.length > 32 && Game.DecoComplexoY.length > 32) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[32] + 18,
                  Game.DecoComplexoY[32] + 48, 90, 60);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          case 32:
            if (Game.DecoComplexoX.length > 33 && Game.DecoComplexoY.length > 33) {
              complexasSwamp = new Rectangle(Game.DecoComplexoX[33] + 60,
                  Game.DecoComplexoY[33] + 75, 30, 30);
              if (headCollisionAreaDeco.intersects(complexasSwamp)) {
                return true;
              }
            }
            break;
          default:
            break;
        }
      }
    }
    return false;
  }

  private static boolean colisaoDecoDungeon(Node[] nodeSnake, int largerCollisionArea) {
    headCollisionAreaDeco = new Rectangle(nodeSnake[0].x, nodeSnake[0].y, 15, 15);
    if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
        && Game.DecoComplexoY != null && Game.quantiComplexo != null) {
      for (int i = 0; i < Game.DecoracaoX.length; i++) {
        Rectangle Decoracao = new Rectangle(Game.DecoracaoX[i], Game.DecoracaoY[i],
            30, 30);
        if (Game.snakeFire) {
          for (int f = 0; f < Game.valueFireX.size(); f++) {
            Rectangle DecoracaoFire = new Rectangle(Game.valueFireX.get(f), Game.valueFireY.get(f), 30, 30);
            if (headCollisionAreaDeco.intersects(DecoracaoFire)) {
              return false;
            }
          }

        
          if (i < Game.valueFireX.size()
              && (Game.DecoracaoX[i] != Game.valueFireX.get(i) && Game.DecoracaoY[i] != Game.valueFireY.get(i))) {
            if (headCollisionAreaDeco.intersects(Decoracao)) {
              return true;
            }
          }
        } else {
          if (headCollisionAreaDeco.intersects(Decoracao)) {
            return true;
          }
        }

      }
    }

    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      if (Game.quantiComplexo.get(i) > 0) {
        switch (i) {
          case 0:
            if (Game.DecoComplexoX.length > 1 && Game.DecoComplexoY.length > 1) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[1] + 25,
                  Game.DecoComplexoY[1] + 70, 35, 20);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 1:
            if (Game.DecoComplexoX.length > 2 && Game.DecoComplexoY.length > 2) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[2] + 10,
                  Game.DecoComplexoY[2] + 40, 70, 40);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 2:
            if (Game.DecoComplexoX.length > 3 && Game.DecoComplexoY.length > 3) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[3] + 8,
                  Game.DecoComplexoY[3] + 15, 40, 34);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 3:
            int pos = 4;
            if (Game.DecoComplexoX.length > pos && Game.DecoComplexoY.length > pos) {
              for (int y = 0; y < 4; y++) {
                complexasDungeon = new Rectangle(Game.DecoComplexoX[pos] + 5,
                    Game.DecoComplexoY[pos] + 20, 55, 80);
                if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                  return true;
                }
                pos++;
              }
            }
            break;
          case 4:
            if (Game.DecoComplexoX.length > 8 && Game.DecoComplexoY.length > 8) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[8] + 9,
                  Game.DecoComplexoY[8] + 23, 30, 40);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 5:
            int pos1 = 9;
            for (int y = 0; y < 4; y++) {
              if (Game.DecoComplexoX.length > pos1 && Game.DecoComplexoY.length > pos1) {
                complexasDungeon = new Rectangle(Game.DecoComplexoX[pos1] + 4,
                    Game.DecoComplexoY[pos1] + 25, 65, 60);
                if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                  return true;
                }
              }
              pos1++;
            }
            break;
          case 6:
            if (Game.DecoComplexoX.length > 13 && Game.DecoComplexoY.length > 13) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[13] + 5,
                  Game.DecoComplexoY[13] + 30, 55, 62);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 7:
            if (Game.DecoComplexoX.length > 14 && Game.DecoComplexoY.length > 14) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[14] + 5,
                  Game.DecoComplexoY[14] + 45, 85, 75);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 8:
            if (Game.DecoComplexoX.length > 15 && Game.DecoComplexoY.length > 15) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[15] + 4,
                  Game.DecoComplexoY[15] + 35, 36, 25);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 9:
            if (Game.DecoComplexoX.length > 16 && Game.DecoComplexoY.length > 16) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[16] + 10,
                  Game.DecoComplexoY[16] + 40, 45, 60);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 10:
            if (Game.DecoComplexoX.length > 17 && Game.DecoComplexoY.length > 17) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[17] + 15,
                  Game.DecoComplexoY[17] + 40, 50, 60);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 11:
            if (Game.DecoComplexoX.length > 18 && Game.DecoComplexoY.length > 18) {
              complexasDungeon = new Rectangle(Game.DecoComplexoX[18] + 15,
                  Game.DecoComplexoY[18] + 40, 50, 60);
              if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                return true;
              }
            }
            break;
          case 12:
            if (!Game.snakeFire) {
              int index = 19;
              for (int y = 0; y < 2; y++) {
                if (Game.DecoComplexoX.length > 19 && Game.DecoComplexoY.length > 19) {
                  complexasDungeon = new Rectangle(Game.DecoComplexoX[index] + 20,
                      Game.DecoComplexoY[index] + 20, 115, 60);
                  if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                    return true;
                  }
                }
                index++;
              }
            }
            break;
          case 13:
            if (!Game.snakeFire) {
              if (Game.DecoComplexoX.length > 21 && Game.DecoComplexoY.length > 21) {
                complexasDungeon = new Rectangle(Game.DecoComplexoX[21] + 20,
                    Game.DecoComplexoY[21] + 20, 115, 60);
                if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                  return true;
                }
              }
            } else {
              if (Game.DecoComplexoX.length > 21 && Game.DecoComplexoY.length > 21) {
                complexasDungeon = new Rectangle(Game.DecoComplexoX[21] + 50,
                    Game.DecoComplexoY[21] + 15, 80, 50);
                if (headCollisionAreaDeco.intersects(complexasDungeon)) {
                  return true;
                }
              }
            }
            break;
        }
      }
    }
    return false;
  }

  private static boolean colisaoParede(Node[] nodeSnake, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y,
      int largerCollisionArea) {
    Rectangle headCollisionArea = new Rectangle(nodeSnake[0].x - largerCollisionArea / 2,
        nodeSnake[0].y - largerCollisionArea / 2,
        5 + largerCollisionArea, 5 + largerCollisionArea);

    for (int i = 0; i < walls_x.size(); i++) {
      Rectangle wallArea = new Rectangle(walls_x.get(i), walls_y.get(i), 15, 15);
      if (headCollisionArea.intersects(wallArea)) {
        return true;
      }
    }
    return false;
  }
}
