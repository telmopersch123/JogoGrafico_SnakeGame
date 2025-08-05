import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class map {
  public static Graphics2D g2d;
  public static BufferedImage bufferedImage;
  public static int backgroundImageWidth;
  public static int backgroundImageHeight;
  public static double scale = 0.8;
  public static int scaledBackgroundImageWidth;
  public static int scaledBackgroundImageHeight;

  public static void mapField(BufferedImage buffer, int ALL_DOTS_Width, int ALL_DOTS_Height, Image gramSprit,
      Image DecoLawn01, Image DecoLawn02,
      int[] randomX, int[] randomY, int quantidadeDeco, int[] randomX2, int[] randomY2, int quantidadeDeco2) {
    g2d = buffer.createGraphics();
    try {
      bufferedImage = (BufferedImage) gramSprit;
      backgroundImageWidth = bufferedImage.getWidth();
      backgroundImageHeight = bufferedImage.getHeight();
      scaledBackgroundImageWidth = (int) (backgroundImageWidth * scale);
      scaledBackgroundImageHeight = (int) (backgroundImageHeight * scale);
   
      for (int y = 0; y < ALL_DOTS_Height; y += scaledBackgroundImageHeight) {
        for (int x = 0; x < ALL_DOTS_Width; x += scaledBackgroundImageWidth) {
          g2d.drawImage(gramSprit, x, y, scaledBackgroundImageWidth, scaledBackgroundImageHeight, null);
        }
      }
      for (int i = 0; i < quantidadeDeco2; i++) {
        g2d.drawImage(DecoLawn02, randomX2[i], randomY2[i], 100, 100, null);
      }
      for (int i = 0; i < quantidadeDeco; i++) {
        g2d.drawImage(DecoLawn01, randomX[i], randomY[i], 150, 150, null);
      }
    } finally {
      g2d.dispose();
    }
  }

  public static void mapSwamp(BufferedImage buffer, int ALL_DOTS_Width, int ALL_DOTS_Height, Image chao_swamp,
      Image small_trunk, Image chao1, Image chao2, Image chao3, Image chao4, Image chao5, Image swamp1, Image swamp2,
      Image swamp3,
      Image swamp4, int quantidadeDecoSmallTrunk, int quantidadeDecoChao1,
      int quantidadeDecoChao2, int quantidadeDecoChao3,
      int quantidadeDecoChao4, int quantidadeDecoChao5, int[] randomSX, int[] randomSY,
      int[] randomSX1, int[] randomSY1, int[] randomSX2, int[] randomSY2, int[] randomSX3, int[] randomSY3,
      int[] randomSX4, int[] randomSY4, int[] randomSX5, int[] randomSY5, int[] randomSX6, int[] randomSY6,
      int[] randomSX7, int[] randomSY7, int[] randomSX8, int[] randomSY8, int[] randomSX9, int[] randomSY9,
      int quantidadeDecoSwamp1,
      int quantidadeDecoSwamp2, int quantidadeDecoSwamp3, int quantidadeDecoSwamp4) {
    g2d = buffer.createGraphics();
    try {
      bufferedImage = (BufferedImage) chao_swamp;
      backgroundImageWidth = bufferedImage.getWidth();
      backgroundImageHeight = bufferedImage.getHeight();
      scaledBackgroundImageWidth = (int) (backgroundImageWidth * scale);
      scaledBackgroundImageHeight = (int) (backgroundImageHeight * scale);
      // Desenha as imagens de fundo
      for (int y = 0; y < ALL_DOTS_Height; y += scaledBackgroundImageHeight) {
        for (int x = 0; x < ALL_DOTS_Width; x += scaledBackgroundImageWidth) {
          g2d.drawImage(chao_swamp, x, y, scaledBackgroundImageWidth, scaledBackgroundImageHeight, null);
        }
      }

      for (int i = 0; i < quantidadeDecoChao1; i++) {
        g2d.drawImage(chao1, randomSX1[i], randomSY1[i], 1000, 700, null);
      }
      for (int i = 0; i < quantidadeDecoChao2; i++) {
        g2d.drawImage(chao2, randomSX2[i], randomSY2[i], 40, 44, null);
      }
      for (int i = 0; i < quantidadeDecoChao3; i++) {
        g2d.drawImage(chao3, randomSX3[i], randomSY3[i], 900, 520, null);
      }
      for (int i = 0; i < quantidadeDecoChao4; i++) {
        g2d.drawImage(chao4, randomSX8[i], randomSY8[i], 200, 180, null);
      }
      for (int i = 0; i < quantidadeDecoChao5; i++) {
        g2d.drawImage(chao5, randomSX9[i], randomSY9[i], 200, 180, null);
      }
      for (int i = 0; i < quantidadeDecoSmallTrunk; i++) {
        g2d.drawImage(small_trunk, randomSX[i], randomSY[i], 41, 24, null);
      }
      for (int i = 0; i < quantidadeDecoSwamp1; i++) {
        g2d.drawImage(swamp1, randomSX4[i], randomSY4[i], 18, 22, null);
      }
      for (int i = 0; i < quantidadeDecoSwamp2; i++) {
        g2d.drawImage(swamp2, randomSX5[i], randomSY5[i], 24, 21, null);
      }
      for (int i = 0; i < quantidadeDecoSwamp3; i++) {
        g2d.drawImage(swamp3, randomSX6[i], randomSY6[i], 26, 30, null);
      }
      for (int i = 0; i < quantidadeDecoSwamp4; i++) {
        g2d.drawImage(swamp4, randomSX7[i], randomSY7[i], 32, 33, null);
      }
    } finally {
      g2d.dispose();
    }
  }

  public static void mapDungeon(BufferedImage buffer, int ALL_DOTS_Width, int ALL_DOTS_Height, Image chao_dungeon,
      Image dragon_bone, Image skull_bone, Image tibia_bone, Image gold1, Image gold2, Image gold3,
      int quantidadeDecoDragonBone, int quantidadeDecoSkullBone,
      int quantidadeDecoTibiaBone, int quantidadeDecoGold1, int quantidadeDecoGold2, int quantidadeDecoGold3,
      int[] randomDX, int[] randomDY, int[] randomDX1, int[] randomDY1, int[] randomDX2,
      int[] randomDY2, int[] randomDX3, int[] randomDY3, int[] randomDX4, int[] randomDY4, int[] randomDX5,
      int[] randomDY5) {
    g2d = buffer.createGraphics();
    try {
      bufferedImage = (BufferedImage) chao_dungeon;
      backgroundImageWidth = bufferedImage.getWidth();
      backgroundImageHeight = bufferedImage.getHeight();
      scaledBackgroundImageWidth = (int) (backgroundImageWidth * scale);
      scaledBackgroundImageHeight = (int) (backgroundImageHeight * scale);
      // Desenha as imagens de fundo
      for (int y = 0; y < ALL_DOTS_Height; y += scaledBackgroundImageHeight) {
        for (int x = 0; x < ALL_DOTS_Width; x += scaledBackgroundImageWidth) {
          g2d.drawImage(chao_dungeon, x, y, scaledBackgroundImageWidth, scaledBackgroundImageHeight, null);
        }
      }
      for (int i = 0; i < quantidadeDecoTibiaBone; i++) {
        g2d.drawImage(tibia_bone, randomDX2[i], randomDY2[i], 30, 30, null);
      }
      for (int i = 0; i < quantidadeDecoSkullBone; i++) {
        g2d.drawImage(skull_bone, randomDX1[i], randomDY1[i], 20, 20, null);
      }
      for (int i = 0; i < quantidadeDecoDragonBone; i++) {
        g2d.drawImage(dragon_bone, randomDX[i], randomDY[i], 212, 176, null);
      }
      for (int i = 0; i < quantidadeDecoGold1; i++) {
        g2d.drawImage(gold1, randomDX3[i], randomDY3[i], 72, 34, null);
      }
      for (int i = 0; i < quantidadeDecoGold2; i++) {
        g2d.drawImage(gold2, randomDX4[i], randomDY4[i], 55, 33, null);
      }
      for (int i = 0; i < quantidadeDecoGold3; i++) {
        g2d.drawImage(gold3, randomDX5[i], randomDY5[i], 40, 32, null);
      }
    } finally {
      g2d.dispose();
    }
  }
}
