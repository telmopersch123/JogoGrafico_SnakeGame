import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class loadImages {

  public static BufferedImage[] Images(int WIDTH, int HEIGHT) {
    BufferedImage[] images = new BufferedImage[68];
    try {
      String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;

      images[0] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeGreen" + File.separator + "head.png"));
      images[1] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeGreen" + File.separator + "tail.png"));
      images[2] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeGreen" + File.separator + "body.png"));
      images[3] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeGreen" + File.separator + "fold.png"));

      images[4] = ImageIO.read(new File(basePath + "map_field" + File.separator + "mapa" + File.separator + "gram.png"));
      images[5] = ImageIO.read(new File(basePath + "map_field" + File.separator + "mapa" + File.separator + "rock.png"));

      images[6] = ImageIO.read(new File(basePath + "foods" + File.separator + "apple.png"));

      images[7] = ImageIO.read(new File(basePath + "map_field" + File.separator + "decoração" + File.separator + "decoration_Lawn01.png"));
      images[8] = ImageIO.read(new File(basePath + "map_field" + File.separator + "decoração" + File.separator + "decoration_Lawn02.png"));

      images[9] = ImageIO.read(new File(basePath + "foods" + File.separator + "applePoison.png"));

      images[10] = ImageIO.read(new File(basePath + "foods" + File.separator + "appleEnergy.png"));
      images[11] = ImageIO.read(new File(basePath + "animation" + File.separator + "FoodPoison" + File.separator + "PoisonDeathAnimation.png"));
      images[12] = ImageIO.read(new File(basePath + "animation" + File.separator + "snakeColision" + File.separator + "BeatEffect.png"));
      images[13] = ImageIO.read(new File(basePath + "animation" + File.separator + "snakeColision" + File.separator + "spritesheetEnergyPartBody.png"));
      images[14] = ImageIO.read(new File(basePath + "animation" + File.separator + "snakeColision" + File.separator + "spritesheetEnergyPartTail.png"));
      images[15] = ImageIO.read(new File(basePath + "animation" + File.separator + "snakeColision" + File.separator + "spritesheetEnergyFinal.png"));
      images[16] = ImageIO.read(new File(basePath + "animation" + File.separator + "snakeColision" + File.separator + "ColidianEnergy.png"));
      images[17] = ImageIO.read(new File(basePath + "animation" + File.separator + "snakeColision" + File.separator + "ColidianEnergyFood.png"));
      images[18] = ImageIO.read(new File(basePath + "animation" + File.separator + "snakeColision" + File.separator + "ColidianPoisonFood.png"));
      images[19] = ImageIO.read(new File(basePath + "animation" + File.separator + "snakeColision" + File.separator + "colidianClassic.png"));
      images[20] = ImageIO.read(new File(basePath + "map_field" + File.separator + "mapa" + File.separator + "painelRock.png"));

      images[21] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "mapa" + File.separator + "chao-swamp.png"));
      images[22] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "mapa" + File.separator + "rock-swamp.png"));

      images[23] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "mapa" + File.separator + "chao-dungeon.png"));
      images[24] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "mapa" + File.separator + "rock-dungeon.png"));

      images[25] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "small-trunk.png"));
      images[26] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "chao1.png"));
      images[27] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "chao2.png"));
      images[28] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "chao3.png"));

      images[29] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "decoração" + File.separator + "dragon-bone.png"));
      images[30] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "decoração" + File.separator + "skull-bone.png"));
      images[31] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "decoração" + File.separator + "tibia-bone.png"));

      images[32] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "swamp1.png"));
      images[33] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "swamp2.png"));
      images[34] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "swamp3.png"));
      images[35] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "swamp4.png"));
      images[36] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "spriteshetlago1.png"));
      images[37] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "spriteshetlago2.png"));
      images[38] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "spriteshetlago3.png"));
      images[39] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "chao4.png"));
      images[40] = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "decoração" + File.separator + "chao5.png"));
      images[41] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "decoração" + File.separator + "gold1.png"));
      images[42] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "decoração" + File.separator + "gold2.png"));
      images[43] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "decoração" + File.separator + "gold3.png"));
      images[44] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "lava.png"));
      images[45] = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "lavaskull.png"));

      images[46] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakePoison" + File.separator + "tail.png"));
      images[47] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakePoison" + File.separator + "fold.png"));
      images[48] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakePoison" + File.separator + "body.png"));
      images[49] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakePoison" + File.separator + "head.png"));

      images[50] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeFire" + File.separator + "tail.png"));
      images[51] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeFire" + File.separator + "fold.png"));
      images[52] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeFire" + File.separator + "body.png"));
      images[53] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeFire" + File.separator + "head.png"));
      images[54] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeFire" + File.separator + "fogocomplementar.png"));
      images[55] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeFire" + File.separator + "fogofinal.png"));
      images[56] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakePoison" + File.separator + "manchasAmarelas.png"));
      images[57] = ImageIO.read(new File(basePath + "animation" + File.separator + "FoodPoison" + File.separator + "PoisonDeathAnimation20.png"));
      images[58] = ImageIO.read(new File(basePath + "animation" + File.separator + "snakeColision" + File.separator + "explosionDeath.png"));
      images[59] = ImageIO.read(new File(basePath + "animation" + File.separator + "Egg" + File.separator + "animationEgg.png"));
      images[60] = ImageIO.read(new File(basePath + "animation" + File.separator + "Egg" + File.separator + "animationEggBreak.png"));
      images[61] = ImageIO.read(new File(basePath + "numeroColisao.png"));
      images[62] = ImageIO.read(new File(basePath + "RaioIcon.png"));
      images[63] = ImageIO.read(new File(basePath + "PoisonDeathIcon.png"));
      images[64] = ImageIO.read(new File(basePath + "velocidadeIcon.png"));

      images[65] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakePoison" + File.separator + "headDeathPoison.png"));
      images[66] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeFire" + File.separator + "headDeathFire.png"));
      images[67] = ImageIO.read(new File(basePath + "snakes" + File.separator + "snakeGreen" + File.separator + "headDeathClassica.png"));

    } catch (IOException e) {
      e.printStackTrace();
    }
    return images;
  }
}
