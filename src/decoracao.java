import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class decoracao {
  public static Graphics2D g2d;

  public static List<Imagem> imagens = new ArrayList<>();
  private static BufferedImage Bush_blue_flowers;
  private static BufferedImage Bush_orange_flowers1;
  private static BufferedImage Bush_simple1_1;
  private static BufferedImage Bush_simple2_1;
  private static BufferedImage Fruit_tree3;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art2;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art3;
  private static BufferedImage Rock1_grass_shadow1;
  private static BufferedImage Rock1_grass_shadow3;
  private static BufferedImage Christmas_tree2;
  private static BufferedImage Tree2;
  private static BufferedImage Glade_Objects_OTop_ODown_OPixel_OArt3_O1;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art3_2;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art66;
  private static BufferedImage Glade_Objects_Top_Down_Pixel_Art44;
  private static BufferedImage dragao_rock;
  private static BufferedImage Brown_gray_ruins3;
  private static BufferedImage Brown_gray_ruins1;
  private static BufferedImage sprite_sheet_moinho;
  private static BufferedImage sprite_sheet_placa;
  private static BufferedImage casadamonga;
  //
  private static BufferedImage Broken_tree_shadow2_3 = null;
  private static BufferedImage Broken_tree_shadow2_4 = null;
  private static BufferedImage Orange_mushrooms1_grass_shadow = null;
  private static BufferedImage Oval_leaf_tree33 = null;
  private static BufferedImage Rock4_grass_shadow34 = null;
  private static BufferedImage aglomerado_cogubranco = null;
  private static BufferedImage aglomerado_coguroxo = null;
  private static BufferedImage Blue_green_balls_tree1 = null;
  private static BufferedImage Brown_ruins1 = null;
  private static BufferedImage cemiterio = null;
  private static BufferedImage Luminous_tree1 = null;
  private static BufferedImage Luminous_tree2 = null;
  private static BufferedImage Luminous_tree3 = null;
  private static BufferedImage Mega_tree2 = null;
  private static BufferedImage Rock_statue_deer_ground_shadow = null;
  private static BufferedImage SwampObjectsTopDownPixelArt3 = null;
  private static BufferedImage SwampObjectsTopDownPixelArt4 = null;
  private static BufferedImage SwamppObjectsTopDownPixelArt2 = null;
  private static BufferedImage SwampTopDownTilesetPixelArt3 = null;
  private static BufferedImage SwampTopDownTilesetPixelArt31 = null;
  private static BufferedImage SwampTopDownTilesetPixelArt32 = null;
  private static BufferedImage SwampTopDownTilesetPixelArt33 = null;
  private static BufferedImage SwampTopDownTilesetPixelArt34 = null;
  private static BufferedImage SwampTopDownTilesetPixelArt35 = null;
  private static BufferedImage SwampTopDownTilesetPixelArt36 = null;
  private static BufferedImage SwampTopDownTilesetPixelArt42 = null;
  private static BufferedImage Willow1 = null;
  private static BufferedImage Willow2 = null;
  private static BufferedImage Willow3 = null;
  private static BufferedImage Yellow_ruins1 = null;
  private static BufferedImage spritesheetarvore1 = null;
  private static BufferedImage spritesheetarvore3 = null;
  private static BufferedImage spritesheetarvore2 = null;
  private static BufferedImage spritsheethomemcristal = null;
  //
  private static BufferedImage Black_crystal1 = null;
  private static BufferedImage Blue_crystal1 = null;
  private static BufferedImage Green_crystal1 = null;
  private static BufferedImage Pink_crystal1 = null;
  private static BufferedImage Red_crystal1 = null;
  private static BufferedImage Violet_crystal1 = null;
  private static BufferedImage White_crystal2 = null;
  private static BufferedImage Yellow_green_crystal1 = null;
  private static BufferedImage skeleton = null;
  private static BufferedImage skullcabra = null;
  private static BufferedImage skullsheads = null;
  private static BufferedImage skullsbirdy = null;
  private static BufferedImage caixao1 = null;
  private static BufferedImage caixao2 = null;
  private static BufferedImage spritedungeonnormal = null;
  private static BufferedImage firedungeon = null;
  private static BufferedImage arvoreskull = null;
  private static BufferedImage craniodino = null;
  private static BufferedImage espinhal = null;
  private static BufferedImage picodungeon = null;
  private static BufferedImage picomedio = null;
  private static BufferedImage pilardungeon = null;
  private static BufferedImage skullcostela = null;
  private static BufferedImage swordskeleton = null;
  private static BufferedImage templedungeon = null;
  private static BufferedImage spritesheetskull1 = null;
  private static BufferedImage spritesheetskull2 = null;
  private static BufferedImage spritesheetskull3 = null;

  private static BufferedImage arvoreLago;
  static {
    try {
    String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;

    Bush_blue_flowers = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_normal" + File.separator + "Bush_blue_flowers2.png"));
    Bush_orange_flowers1 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_normal" + File.separator + "Bush_orange_flowers1.png"));
    Bush_simple1_1 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_normal" + File.separator + "Bush_simple1_1.png"));
    Bush_simple2_1 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_normal" + File.separator + "Bush_simple2_1.png"));
    Fruit_tree3 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_normal" + File.separator + "Fruit_tree3.png"));
    Glade_Objects_Top_Down_Pixel_Art2 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_normal" + File.separator + "Glade_Objects_Top_Down_Pixel_Art2.png"));
    Glade_Objects_Top_Down_Pixel_Art3 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_normal" + File.separator + "Glade_Objects_Top_Down_Pixe_Art3.png"));
    Rock1_grass_shadow1 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_normal" + File.separator + "Rock1_grass_shadow1.png"));
    Rock1_grass_shadow3 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_normal" + File.separator + "Rock1_grass_shadow3.png"));

    Christmas_tree2 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "Christmas_tree2.png"));
    Glade_Objects_Top_Down_Pixel_Art66 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "Glade_Objects_Top_Down_Pixel_Art66.png"));
    Tree2 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "Tree2.png"));
    Glade_Objects_Top_Down_Pixel_Art3_2 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "Glade_Objects_Top_Down_Pixel_Art3_2.png"));
    Glade_Objects_OTop_ODown_OPixel_OArt3_O1 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "Glade_Objects_OTop_ODown_OPixel_OArt3_O1.png"));
    Glade_Objects_Top_Down_Pixel_Art44 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "Glade_Objects_Top_Down_Pixel_Art44.png"));
    Brown_gray_ruins3 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "Brown_gray_ruins3.png"));
    Brown_gray_ruins1 = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "Brown_gray_ruins1.png"));
    dragao_rock = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "dragao_rock.png"));
    sprite_sheet_moinho = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "sprite_sheet_moinho.png"));
    sprite_sheet_placa = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "sprite_sheet_placa.png"));
    casadamonga = ImageIO.read(new File(basePath + "map_field" + File.separator + "obstaculos_complexos" + File.separator + "casadamonga.png"));

    Broken_tree_shadow2_3 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_normal" + File.separator + "Broken_tree_shadow2_3.png"));
    Broken_tree_shadow2_4 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_normal" + File.separator + "Broken_tree_shadow2_4.png"));
    Orange_mushrooms1_grass_shadow = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_normal" + File.separator + "Orange_mushrooms1_grass_shadow.png"));
    Oval_leaf_tree33 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_normal" + File.separator + "Oval_leaf_tree33.png"));
    Rock4_grass_shadow34 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_normal" + File.separator + "Rock4_grass_shadow34.png"));

    aglomerado_cogubranco = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "aglomerado_cogubranco.png"));
    aglomerado_coguroxo = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "aglomerado_coguroxo.png"));
    Blue_green_balls_tree1 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Blue_green_balls_tree1.png"));
    Brown_ruins1 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Brown_ruins1.png"));
    cemiterio = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "cemiterio.png"));
    Luminous_tree1 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Luminous_tree1.png"));
    Luminous_tree2 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Luminous_tree2.png"));
    Luminous_tree3 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Luminous_tree3.png"));
    Mega_tree2 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Mega_tree2.png"));
    Rock_statue_deer_ground_shadow = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Rock_statue_deer_ground_shadow.png"));
    SwampObjectsTopDownPixelArt3 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampObjectsTopDownPixelArt3.png"));
    SwampObjectsTopDownPixelArt4 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampObjectsTopDownPixelArt4.png"));
    SwamppObjectsTopDownPixelArt2 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwamppObjectsTopDownPixelArt2.png"));
    SwampTopDownTilesetPixelArt3 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampTopDownTilesetPixelArt3.png"));
    SwampTopDownTilesetPixelArt31 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampTopDownTilesetPixelArt31.png"));
    SwampTopDownTilesetPixelArt32 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampTopDownTilesetPixelArt32.png"));
    SwampTopDownTilesetPixelArt33 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampTopDownTilesetPixelArt33.png"));
    SwampTopDownTilesetPixelArt34 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampTopDownTilesetPixelArt34.png"));
    SwampTopDownTilesetPixelArt35 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampTopDownTilesetPixelArt35.png"));
    SwampTopDownTilesetPixelArt36 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampTopDownTilesetPixelArt36.png"));
    SwampTopDownTilesetPixelArt42 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "SwampTopDownTilesetPixelArt42.png"));
    Willow1 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Willow1.png"));
    Willow2 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Willow2.png"));
    Willow3 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Willow3.png"));
    Yellow_ruins1 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "Yellow_ruins1.png"));
    spritesheetarvore1 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "spritesheetarvore1.png"));
    spritesheetarvore2 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "spritesheetarvore2.png"));
    spritesheetarvore3 = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "spritesheetarvore3.png"));
    spritsheethomemcristal = ImageIO.read(new File(basePath + "map_swamp" + File.separator + "obstaculos_complexos" + File.separator + "spritsheethomemcristal.png"));
    arvoreLago = ImageIO.read(new File(basePath + "map_Swamp" + File.separator + "obstaculos_complexos" + File.separator + "arvoreLago.png"));

    Black_crystal1 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "Black_crystal1.png"));
    Blue_crystal1 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "Blue_crystal1.png"));
    Green_crystal1 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "Green_crystal1.png"));
    Pink_crystal1 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "Pink_crystal1.png"));
    Red_crystal1 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "Red_crystal1.png"));
    Violet_crystal1 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "Violet_crystal1.png"));
    White_crystal2 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "White_crystal2.png"));
    Yellow_green_crystal1 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "Yellow_green_crystal1.png"));
    skeleton = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "skeleton.png"));
    skullcabra = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "skullcabra.png"));
    skullsbirdy = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "skullsbirdy.png"));
    skullsheads = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "skullsheads.png"));
    caixao1 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "caixao1.png"));
    caixao2 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "caixao2.png"));
    spritedungeonnormal = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "spritedungeonnormal.png"));
    firedungeon = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_normal" + File.separator + "firedungeon.png"));

    arvoreskull = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "arvoreskull.png"));
    craniodino = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "craniodino.png"));
    espinhal = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "espinhal.png"));
    picodungeon = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "picodungeon.png"));
    picomedio = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "picomedio.png"));
    pilardungeon = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "pilardungeon.png"));
    skullcostela = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "skullcostela.png"));
    swordskeleton = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "swordskeleton.png"));
    templedungeon = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "templedungeon.png"));
    spritesheetskull1 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "spritesheetskull1.png"));
    spritesheetskull2 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "spritesheetskull2.png"));
    spritesheetskull3 = ImageIO.read(new File(basePath + "map_dungeon" + File.separator + "obstaculos_complexos" + File.separator + "spritesheetskull3.png"));

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void posicoesDeco(int FrameWidth, int FrameHeight, int ALL_DOTS_Width, int ALL_DOTS_Height,
      ArrayList<Integer> walls_x,
      ArrayList<Integer> walls_y) {
    int PorcentagemX = (10 * FrameWidth) / 100;
    int PorcentagemY = (10 * FrameHeight) / 100;
    int PorcentagemCOMX = (7 * FrameWidth) / 100;
    int PorcentagemCOMY = (15 * FrameHeight) / 100;
    ///
    int valueDecoSimples = 0;
    int valueDecoComplexo = 0;
    
    if (Game.MapField) {
      if (Game.clickedButtonDifiDificil) {
        valueDecoSimples = 9;
        valueDecoComplexo = 12;
      } else if (Game.clickedButtonDifiNormal) {
        valueDecoSimples = 6;
        valueDecoComplexo = 8;
      } else if (Game.clickedButtonDifiFacil) {
        valueDecoSimples = 3;
        valueDecoComplexo = 4;
      }
    } else if (Game.MapSwamp) {
      if (Game.clickedButtonDifiDificil) {
        valueDecoSimples = 5;
        valueDecoComplexo = 34;
      } else if (Game.clickedButtonDifiNormal) {
        valueDecoSimples = 3;
        valueDecoComplexo = 22;
      } else if (Game.clickedButtonDifiFacil) {
        valueDecoSimples = 1;
        valueDecoComplexo = 10;
      }
    } else if (Game.MapDungeon) {
      if (Game.clickedButtonDifiDificil) {
        valueDecoSimples = 17;
        valueDecoComplexo = 14;
      } else if (Game.clickedButtonDifiNormal) {
        valueDecoSimples = 11;
        valueDecoComplexo = 8;
      } else if (Game.clickedButtonDifiFacil) {
        valueDecoSimples = 5;
        valueDecoComplexo = 4;
      }
    }

    for (int i = 0; i < valueDecoSimples; i++) {
      if (Game.MapField) {
        Game.quanti.add((int) (Math.random() * 3) + 2);
      } else if (Game.MapSwamp) {
        Game.quanti.add((int) (Math.random() * 3) + 1);
      } else if (Game.MapDungeon) {
        Game.quanti.add((int) (Math.random() * 3) + 1);
      }
    }

    for (int i = 0; i < Game.quanti.size(); i++) {
      Game.ValueFinal += Game.quanti.get(i);
      Game.ValueDecoNormal += Game.quanti.get(i);
    }

   
    for (int i = 0; i < valueDecoComplexo; i++) {
      Game.quantiComplexo.add(1);
    }

    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      Game.ValueFinal += Game.quantiComplexo.get(i);
    }
    if (Game.DecoracaoX != null && Game.DecoracaoY != null && Game.DecoComplexoX != null
        && Game.DecoComplexoY != null) {
      Game.DecoracaoX = new int[Game.ValueDecoNormal];
      Game.DecoracaoY = new int[Game.ValueDecoNormal];
      Game.DecoComplexoX = new int[Game.ValueFinal];
      Game.DecoComplexoY = new int[Game.ValueFinal];

      for (int i = 0; i < Game.ValueFinal; i++) {
        int x, y;
        int x1, y1;
        do {
          x = (int) (Math.random() * (FrameWidth - PorcentagemX)) + 50;
          y = (int) (Math.random() * (FrameHeight - PorcentagemY)) + 50;
          x1 = (int) (Math.random() * (FrameWidth - PorcentagemCOMX)) + 70;
          y1 = (int) (Math.random() * (FrameHeight - PorcentagemCOMY)) + 70;
        } while (isWallPosition(x, y, walls_x, walls_y, x1, y1) || containsPosition(x, y, Game.DecoracaoX,
            Game.DecoracaoY, x1, y1, Game.DecoComplexoX, Game.DecoComplexoY) || isSnake(x, y, x1, y1)
            || isFood(x, y, x1, y1));
        if (i < Game.ValueDecoNormal) {
          Game.DecoracaoX[i] = x;
          Game.DecoracaoY[i] = y;
        }
        Game.DecoComplexoX[i] = x1;
        Game.DecoComplexoY[i] = y1;
        if (Game.DecoComplexoX.length > 33 && Game.DecoComplexoY.length > 33) {
          Game.DecoComplexoX[33] = Game.DecoComplexoX[30];
          Game.DecoComplexoY[33] = Game.DecoComplexoY[30];
        }
      }
    }

  }

  private static boolean isWallPosition(int x, int y, ArrayList<Integer> walls_x, ArrayList<Integer> walls_y, int x1,
      int y1) {
    Rectangle imageRect = new Rectangle(x, y, 50, 50); 
    Rectangle imageRectComplexa = new Rectangle(x1, y1, 150, 150);
    for (int i = 0; i < walls_x.size(); i++) {
      Rectangle wallRect = new Rectangle(walls_x.get(i), walls_y.get(i), 10, 10);
      if (imageRect.intersects(wallRect) || imageRectComplexa.intersects(wallRect)) {
        return true;
      }
    }
    return false;
  }

  static Rectangle otherRect;
  static Rectangle otherRectComplexa;

  private static boolean isSnake(int x, int y, int x1,
      int y1) {
    Rectangle imageRect = new Rectangle(x, y, 50, 50);
    Rectangle imageRectComplexa = new Rectangle(x1, y1, 150, 150);
    Rectangle Snake = new Rectangle(Game.nodeSnake[0].x, Game.nodeSnake[0].y, 15, 15);
    if (imageRect.intersects(Snake) || imageRectComplexa.intersects(Snake)) {
      return true;
    } else {
      return false;
    }

  }

  private static boolean isFood(int x, int y, int x1, int y1) {
    Rectangle imageRect = new Rectangle(x, y, 50, 50);
    Rectangle imageRectComplexa = new Rectangle(x1, y1, 150, 150);
    Rectangle Food = new Rectangle(Game.macaX, Game.macaY, 15, 15);
    if (imageRect.intersects(Food) || imageRectComplexa.intersects(Food)) {
      return true;
    } else {
      return false;
    }
  }

  private static boolean containsPosition(int x, int y, int[] DecoracaoX, int[] DecoracaoY, int x1,
      int y1, int[] DecoComplexoX, int[] DecoComplexoY) {
    Rectangle imageRect = new Rectangle(x, y, 30, 30); 
    Rectangle imageRectComplexa = new Rectangle(x1, y1, 120, 120);
    for (int i = 0; i < Game.ValueFinal; i++) {
      if (i < DecoComplexoY.length && i < DecoComplexoY.length) {
        if (i < Game.ValueDecoNormal) {
          otherRect = new Rectangle(DecoracaoX[i], DecoracaoY[i], 30, 30);
        }

        otherRectComplexa = new Rectangle(DecoComplexoX[i], DecoComplexoY[i], 120, 120);
      }
      if (imageRect.intersects(otherRect)) {
        return true;
      } else if (imageRect.intersects(otherRectComplexa)) {
        return true;
      } else if (imageRectComplexa.intersects(otherRectComplexa)) {
        return true;
      } else if (imageRectComplexa.intersects(otherRect)) {
        return true;
      }
    }
    return false;
  }

  public static int numFramesXMo = 6; 
  public static int numFramesYMo = 1; 
  private static int frameIntervalMo = 1000;
  public static int totalFramesMo = numFramesXMo * numFramesYMo;
  public static long currentTimeMoinho = System.currentTimeMillis();
  private static long lastFrameTimeMo = 0;
  public static Graphics2D ImagemMoinho;
  
  public static int numFramesXBan = 6; 
  public static int numFramesYBan = 1; 
  private static int frameIntervalBan = 1000;
  public static int totalFramesBan = numFramesXBan * numFramesYBan;
  public static long currentTimeBandeira = System.currentTimeMillis();
  private static long lastFrameTimeBan = 0;
  public static Graphics2D ImagemBandeira;
 
  public static Graphics2D ImagemArvore1;
  public static Graphics2D ImagemArvore2;
  public static Graphics2D ImagemArvore3;
  public static Graphics2D ImagemCris;
  public static Graphics2D fireFogo;
  public static Graphics2D fireFogo1;
  public static Graphics2D vulcanfire;
  public static Graphics2D temple1;
  public static Graphics2D temple2;
  public static Graphics2D temple3;

  public static int numFramesXArv = 6;
  public static int numFramesYArv = 1; 
  public static int numFramesXCris = 3;
  public static int numFramesYCris = 9;
  public static int numFramesXfire = 7;
  public static int numFramesYfire = 7;
  public static int numFramesXvulcan = 6;
  public static int numFramesYvulcan = 2;
  public static int numFramesXtemple = 6;
  public static int numFramesYtemple = 3;

  private static int frameIntervalArv = 100;
  private static int frameIntervalArv1 = 100;
  private static int frameIntervalArv2 = 100;
  private static int frameIntervalcris = 100;
  private static int frameIntervalfire = 50;
  private static int frameIntervalfire1 = 50;
  private static int frameIntervalvulcan = 50;
  private static int frameIntervaltemple = 100;
  private static int frameIntervaltemple1 = 100;
  private static int frameIntervaltemple2 = 100;

  public static int totalFramesArv = numFramesXArv * numFramesYArv;
  public static int totalFramescris = numFramesXCris * numFramesYCris;
  public static int totalFramesfire = numFramesXfire * numFramesYfire;
  public static int totalFramesfire1 = numFramesXfire * numFramesYfire;
  public static int totalFramesvulcan = numFramesXvulcan * numFramesYvulcan;
  public static int totalFramestemple = numFramesXtemple * numFramesYtemple;
  public static int totalFramestemple1 = numFramesXtemple * numFramesYtemple;
  public static int totalFramestemple2 = numFramesXtemple * numFramesYtemple;

  public static long currentTimeArv = System.currentTimeMillis();
  public static long currentTimeArv1 = System.currentTimeMillis();
  public static long currentTimeArv2 = System.currentTimeMillis();
  public static long currentTimecris = System.currentTimeMillis();
  public static long currentTimefire = System.currentTimeMillis();
  public static long currentTimefire1 = System.currentTimeMillis();
  public static long currentTimevulcan = System.currentTimeMillis();
  public static long currentTimetemple1 = System.currentTimeMillis();
  public static long currentTimetemple2 = System.currentTimeMillis();
  public static long currentTimetemple3 = System.currentTimeMillis();

  private static long lastFrameTimeArv = 0;
  private static long lastFrameTimeArv1 = 0;
  private static long lastFrameTimeArv2 = 0;
  private static long lastFrameTimecris = 0;
  private static long lastFrameTimefire = 0;
  private static long lastFrameTimefire1 = 0;
  private static long lastFrameTimevulcan = 0;
  private static long lastFrameTimetemple = 0;
  private static long lastFrameTimetemple1 = 0;
  private static long lastFrameTimetemple2 = 0;

  private static Graphics2D fireFogo2;

  public static void decoracaoField(BufferedImage buffer) {
    g2d = buffer.createGraphics();
    imagens.clear(); 
    int index = 0;

   
    try {
      for (int i = 0; i < Game.quanti.get(0); i++) {
        imagens.add(new Imagem(Bush_blue_flowers, Game.DecoracaoX[index], Game.DecoracaoY[index], 28, 28));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(1); i++) {
        imagens.add(new Imagem(Bush_orange_flowers1, Game.DecoracaoX[index], Game.DecoracaoY[index], 35, 37));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(2); i++) {
        imagens.add(new Imagem(Bush_simple1_1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(3); i++) {
        imagens.add(new Imagem(Bush_simple2_1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(4); i++) {
        imagens.add(new Imagem(Fruit_tree3,
            Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(5); i++) {
        imagens.add(new Imagem(Glade_Objects_Top_Down_Pixel_Art2,
            Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(6); i++) {
        imagens.add(new Imagem(Glade_Objects_Top_Down_Pixel_Art3,
            Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(7); i++) {
        imagens.add(new Imagem(Rock1_grass_shadow1,
            Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(8); i++) {
        imagens.add(new Imagem(Rock1_grass_shadow3,
            Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
    } catch (IndexOutOfBoundsException e) {

    }

  

    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      if (Game.quantiComplexo.get(i) > 0) {
        switch (i) {
          case 0:
            imagens.add(new Imagem(Christmas_tree2, Game.DecoComplexoX[1], Game.DecoComplexoY[1], 60, 60));
            break;
          case 1:
            imagens.add(new Imagem(Tree2, Game.DecoComplexoX[2], Game.DecoComplexoY[2], 60, 60));
            break;
          case 2:
            imagens.add(new Imagem(Glade_Objects_OTop_ODown_OPixel_OArt3_O1, Game.DecoComplexoX[3],
                Game.DecoComplexoY[3], 51, 73));
            break;
          case 3:
            imagens.add(
                new Imagem(Glade_Objects_Top_Down_Pixel_Art3_2, Game.DecoComplexoX[4], Game.DecoComplexoY[4], 92, 93));
            break;
          case 4:
            imagens.add(
                new Imagem(Glade_Objects_Top_Down_Pixel_Art66, Game.DecoComplexoX[5], Game.DecoComplexoY[5], 57, 60));
            break;
          case 5:
            imagens.add(
                new Imagem(Glade_Objects_Top_Down_Pixel_Art44, Game.DecoComplexoX[6], Game.DecoComplexoY[6], 74, 90));
            break;
          case 6:
            imagens.add(new Imagem(dragao_rock, Game.DecoComplexoX[7], Game.DecoComplexoY[7], 147, 111));
            break;
          case 7:
            imagens.add(new Imagem(Brown_gray_ruins3, Game.DecoComplexoX[8], Game.DecoComplexoY[8], 64, 64));
            break;
          case 8:
            imagens.add(new Imagem(Brown_gray_ruins1, Game.DecoComplexoX[9], Game.DecoComplexoY[9], 112, 112));
            break;
          case 9:
            BufferedImage Moinho = (BufferedImage) sprite_sheet_moinho;
            int sx = (Game.currentFrame10 % numFramesXMo) * (Moinho.getWidth() /
                numFramesXMo);
            int sy = (Game.currentFrame10 / numFramesXMo) * (Moinho.getHeight() /
                numFramesYMo);
            int sw = Moinho.getWidth() / numFramesXMo;
            int sh = Moinho.getHeight() / numFramesYMo;
            ImagemMoinho = buffer.createGraphics();
            AffineTransform at = new AffineTransform();
            at.scale((double) (100 + 2) / sw, (double) (134 + 2) / sh);
          
            AffineTransformOp op = new AffineTransformOp(at,
                AffineTransformOp.TYPE_BILINEAR);
          
            BufferedImage scaledImage = op.filter(Moinho.getSubimage(sx, sy, sw, sh),
                null);
            ImagemMoinho.drawImage(scaledImage, Game.DecoComplexoX[10],
                Game.DecoComplexoY[10], null);
            long currentTimeMoinho = System.currentTimeMillis();
            if (Game.ManterAnimation) {
              Game.currentFrame10 = (Game.currentFrame10 + 1) % totalFramesMo;
              if (currentTimeMoinho - lastFrameTimeMo >= frameIntervalMo) {
                lastFrameTimeMo = currentTimeMoinho - (currentTimeMoinho % frameIntervalMo);
                Game.currentFrame10 = (Game.currentFrame10 + 1) % totalFramesMo;
              }
            }
            break;
          case 10:
            BufferedImage bandeira = (BufferedImage) sprite_sheet_placa;
            int sx1 = (Game.currentFrame11 % numFramesXBan) * (bandeira.getWidth() /
                numFramesXBan);
            int sy1 = (Game.currentFrame11 / numFramesXBan) * (bandeira.getHeight() /
                numFramesYBan);
            int sw1 = bandeira.getWidth() / numFramesXBan;
            int sh1 = bandeira.getHeight() / numFramesYBan;
            ImagemBandeira = buffer.createGraphics();
            AffineTransform at1 = new AffineTransform();
            at1.scale((double) (30 + 2) / sw1, (double) (54 + 2) / sh1);
          
            AffineTransformOp op1 = new AffineTransformOp(at1,
                AffineTransformOp.TYPE_BILINEAR);
          
            BufferedImage scaledImage1 = op1.filter(bandeira.getSubimage(sx1, sy1, sw1,
                sh1),
                null);
            ImagemBandeira.drawImage(scaledImage1, Game.DecoComplexoX[11],
                Game.DecoComplexoY[11], null);
            long currentTimeBandeira = System.currentTimeMillis();
            if (Game.ManterAnimation) {
              Game.currentFrame11 = (Game.currentFrame11 + 1) % totalFramesBan;
              if (currentTimeBandeira - lastFrameTimeBan >= frameIntervalBan) {
                lastFrameTimeBan = currentTimeBandeira - (currentTimeBandeira %
                    frameIntervalBan);
                Game.currentFrame11 = (Game.currentFrame11 + 1) % totalFramesBan;
              }
            }
            break;
          case 11:
            imagens.add(new Imagem(casadamonga, Game.DecoComplexoX[12], Game.DecoComplexoY[12], 101, 77));
            break;
          default:
            break;
        }
      }

    }

    ///////////////////////
    for (Imagem imagem : imagens) {
      g2d.drawImage(imagem.getImagem(), imagem.getX(), imagem.getY(), imagem.getWidth(), imagem.getHeight(), null);
    }
    g2d.dispose();
  }

  public static void decoracaoSwamp(BufferedImage buffer) {
    g2d = buffer.createGraphics();
    imagens.clear();

    int index = 0;
  
    try{
    for (int i = 0; i < Game.quanti.get(0); i++) {
      imagens.add(new Imagem(Broken_tree_shadow2_3, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(1); i++) {
      imagens.add(new Imagem(Broken_tree_shadow2_4, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(2); i++) {
      imagens.add(new Imagem(Orange_mushrooms1_grass_shadow, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(3); i++) {
      imagens.add(new Imagem(Oval_leaf_tree33, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
    for (int i = 0; i < Game.quanti.get(4); i++) {
      imagens.add(new Imagem(Rock4_grass_shadow34, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
      index++;
    }
  } catch (IndexOutOfBoundsException e) {
  }
 
    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      if (Game.quantiComplexo.get(i) > 0) {
        switch (i) {
          case 0:
            if (Game.DecoComplexoX.length > 1 && Game.DecoComplexoY.length > 1) {

              imagens.add(new Imagem(aglomerado_cogubranco, Game.DecoComplexoX[1],
                  Game.DecoComplexoY[1], 38, 49));
            }
            break;
          case 1:
            if (Game.DecoComplexoX.length > 2 && Game.DecoComplexoY.length > 2) {

              imagens.add(new Imagem(aglomerado_coguroxo, Game.DecoComplexoX[2],
                  Game.DecoComplexoY[2], 47, 45));
            }
            break;
          case 2:
            if (Game.DecoComplexoX.length > 3 && Game.DecoComplexoY.length > 3) {

              imagens.add(new Imagem(Blue_green_balls_tree1, Game.DecoComplexoX[3],
                  Game.DecoComplexoY[3], 50, 64));
            }
            break;
          case 3:
            if (Game.DecoComplexoX.length > 4 && Game.DecoComplexoY.length > 4) {

              imagens.add(
                  new Imagem(Brown_ruins1, Game.DecoComplexoX[4], Game.DecoComplexoY[4], 112,
                      112));
            }
            break;
          case 4:
            if (Game.DecoComplexoX.length > 5 && Game.DecoComplexoY.length > 5) {

              imagens.add(
                  new Imagem(cemiterio, Game.DecoComplexoX[5], Game.DecoComplexoY[5], 99, 83));
            }
            break;
          case 5:
            if (Game.DecoComplexoX.length > 6 && Game.DecoComplexoY.length > 6) {

              imagens.add(new Imagem(Yellow_ruins1,
                  Game.DecoComplexoX[6],
                  Game.DecoComplexoY[6], 112, 112));
            }

            break;
          case 6:
            if (Game.DecoComplexoX.length > 7 && Game.DecoComplexoY.length > 7) {
              imagens.add(
                  new Imagem(Rock_statue_deer_ground_shadow,
                      Game.DecoComplexoX[7],
                      Game.DecoComplexoY[7], 94, 94));
            }
            break;
          case 7:
            if (Game.DecoComplexoX.length > 8 && Game.DecoComplexoY.length > 8) {
              imagens
                  .add(new Imagem(SwamppObjectsTopDownPixelArt2,
                      Game.DecoComplexoX[8],
                      Game.DecoComplexoY[8], 50,
                      60));
            }
            break;
          case 8:
            if (Game.DecoComplexoX.length > 9 && Game.DecoComplexoY.length > 9) {

              imagens
                  .add(new Imagem(SwampObjectsTopDownPixelArt3,
                      Game.DecoComplexoX[9],
                      Game.DecoComplexoY[9], 98, 123));
            }
            break;
          case 9:
            if (Game.DecoComplexoX.length > 10 && Game.DecoComplexoY.length > 10) {

              imagens
                  .add(new Imagem(SwampObjectsTopDownPixelArt4,
                      Game.DecoComplexoX[10],
                      Game.DecoComplexoY[10], 63, 52));
            }
            break;
          case 10:
            if (Game.DecoComplexoX.length > 11 && Game.DecoComplexoY.length > 11) {

              imagens.add(new Imagem(Mega_tree2,
                  Game.DecoComplexoX[11],
                  Game.DecoComplexoY[11], 123, 123));
            }

            break;
          case 11:
            if (Game.DecoComplexoX.length > 12 && Game.DecoComplexoY.length > 12) {
            }
            imagens
                .add(
                    new Imagem(SwampTopDownTilesetPixelArt3,
                        Game.DecoComplexoX[12],
                        Game.DecoComplexoY[12], 81, 91));
            break;
          case 12:
            if (Game.DecoComplexoX.length > 13 && Game.DecoComplexoY.length > 13) {
            }
            imagens.add(
                new Imagem(SwampTopDownTilesetPixelArt31,
                    Game.DecoComplexoX[13],
                    Game.DecoComplexoY[13], 32, 49));
            break;
          case 13:
            if (Game.DecoComplexoX.length > 14 && Game.DecoComplexoY.length > 14) {
              imagens.add(
                  new Imagem(SwampTopDownTilesetPixelArt32,
                      Game.DecoComplexoX[14],
                      Game.DecoComplexoY[14], 81, 131));
            }

            break;
          case 14:
            if (Game.DecoComplexoX.length > 15 && Game.DecoComplexoY.length > 5) {
            }
            imagens.add(
                new Imagem(SwampTopDownTilesetPixelArt33,
                    Game.DecoComplexoX[15],
                    Game.DecoComplexoY[15], 68, 67));
            break;
          case 15:
            if (Game.DecoComplexoX.length > 16 && Game.DecoComplexoY.length > 16) {
            }
            imagens
                .add(new Imagem(SwampTopDownTilesetPixelArt34,
                    Game.DecoComplexoX[16],
                    Game.DecoComplexoY[16], 49,
                    60));
            break;
          case 16:
            if (Game.DecoComplexoX.length > 17 && Game.DecoComplexoY.length > 17) {
              imagens
                  .add(new Imagem(SwampTopDownTilesetPixelArt35,
                      Game.DecoComplexoX[17],
                      Game.DecoComplexoY[17], 62,
                      81));
            }
            break;
          case 17:
            if (Game.DecoComplexoX.length > 18 && Game.DecoComplexoY.length > 18) {
              imagens
                  .add(new Imagem(SwampTopDownTilesetPixelArt36, Game.DecoComplexoX[18],
                      Game.DecoComplexoY[18], 32,
                      56));
            }
            break;
          case 18:
            if (Game.DecoComplexoX.length > 19 && Game.DecoComplexoY.length > 19) {
              imagens
                  .add(new Imagem(SwampTopDownTilesetPixelArt42,
                      Game.DecoComplexoX[19],
                      Game.DecoComplexoY[19], 77,
                      44));
            }
            break;
          case 19:
            if (Game.DecoComplexoX.length > 20 && Game.DecoComplexoY.length > 20) {
              imagens.add(new Imagem(Luminous_tree3,
                  Game.DecoComplexoX[20],
                  Game.DecoComplexoY[20], 63, 85));
            }
            break;
          case 20:
            if (Game.DecoComplexoX.length > 21 && Game.DecoComplexoY.length > 21) {

              imagens.add(new Imagem(Luminous_tree2,
                  Game.DecoComplexoX[21],
                  Game.DecoComplexoY[21], 64, 83));
            }

            break;
          case 21:
            if (Game.DecoComplexoX.length > 22 && Game.DecoComplexoY.length > 22) {
              imagens.add(new Imagem(Willow1,
                  Game.DecoComplexoX[22],
                  Game.DecoComplexoY[22], 79, 81));
            }
            break;
          case 22:
            if (Game.DecoComplexoX.length > 23 && Game.DecoComplexoY.length > 23) {
              imagens.add(new Imagem(Willow2, Game.DecoComplexoX[23],
                  Game.DecoComplexoY[23], 67, 75));
            }
            break;
          case 23:
            if (Game.DecoComplexoX.length > 24 && Game.DecoComplexoY.length > 24) {
              imagens.add(new Imagem(Willow3, Game.DecoComplexoX[24],
                  Game.DecoComplexoY[24], 63, 64));
            }
            break;
          case 24:
            if (Game.DecoComplexoX.length > 25 && Game.DecoComplexoY.length > 25) {

              imagens.add(
                  new Imagem(Luminous_tree1, Game.DecoComplexoX[25], Game.DecoComplexoY[25],
                      70,
                      93));
            }
            break;
          case 25:
            if (Game.DecoComplexoX.length > 26 && Game.DecoComplexoY.length > 26) {
              BufferedImage arvore1 = (BufferedImage) spritesheetarvore1;
              int sx1 = (Game.currentFrame11 % numFramesXArv) * (arvore1.getWidth() /
                  numFramesXArv);
              int sy1 = (Game.currentFrame11 / numFramesXArv) * (arvore1.getHeight() /
                  numFramesYArv);
              int sw1 = arvore1.getWidth() / numFramesXArv;
              int sh1 = arvore1.getHeight() / numFramesYArv;
              ImagemArvore1 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (66 + 2) / sw1, (double) (65 + 2) / sh1);
             
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
           
              BufferedImage scaledImage1 = op1.filter(arvore1.getSubimage(sx1, sy1, sw1,
                  sh1),
                  null);
              ImagemArvore1.drawImage(scaledImage1, Game.DecoComplexoX[26],
                  Game.DecoComplexoY[26], null);
              long currentTimeArv = System.currentTimeMillis();
              if (Game.ManterAnimation) {
                if (currentTimeArv - lastFrameTimeArv >= frameIntervalArv) {
                  lastFrameTimeArv = currentTimeArv - (currentTimeArv %
                      frameIntervalArv);
                  Game.currentFrame11 = (Game.currentFrame11 + 1) % totalFramesArv;
                }
              }
            }
            break;
          case 26:
            if (Game.DecoComplexoX.length > 27 && Game.DecoComplexoY.length > 27) {
              BufferedImage arvore1 = (BufferedImage) spritesheetarvore2;
              int sx1 = (Game.currentFrame12 % numFramesXArv) * (arvore1.getWidth() /
                  numFramesXArv);
              int sy1 = (Game.currentFrame12 / numFramesXArv) * (arvore1.getHeight() /
                  numFramesYArv);
              int sw1 = arvore1.getWidth() / numFramesXArv;
              int sh1 = arvore1.getHeight() / numFramesYArv;
              ImagemArvore2 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (80 + 2) / sw1, (double) (96 + 2) / sh1);
             
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
             
              BufferedImage scaledImage1 = op1.filter(arvore1.getSubimage(sx1, sy1, sw1,
                  sh1),
                  null);
              ImagemArvore2.drawImage(scaledImage1,
                  Game.DecoComplexoX[27],
                  Game.DecoComplexoY[27], null);
              long currentTimeArv1 = System.currentTimeMillis();
              if (Game.ManterAnimation) {
                if (currentTimeArv1 - lastFrameTimeArv1 >= frameIntervalArv1) {
                  lastFrameTimeArv1 = currentTimeArv1 - (currentTimeArv1 %
                      frameIntervalArv1);
                  Game.currentFrame12 = (Game.currentFrame12 + 1) % totalFramesArv;
                }
              }
            }
            break;
          case 27:
            if (Game.DecoComplexoX.length > 28 && Game.DecoComplexoY.length > 28) {
              BufferedImage arvore2 = (BufferedImage) spritesheetarvore3;
              int sx1 = (Game.currentFrame13 % numFramesXArv) * (arvore2.getWidth() /
                  numFramesXArv);
              int sy1 = (Game.currentFrame13 / numFramesXArv) * (arvore2.getHeight() /
                  numFramesYArv);
              int sw1 = arvore2.getWidth() / numFramesXArv;
              int sh1 = arvore2.getHeight() / numFramesYArv;
              ImagemArvore3 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (92 + 2) / sw1, (double) (128 + 2) / sh1);
            
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
            
              BufferedImage scaledImage1 = op1.filter(arvore2.getSubimage(sx1, sy1, sw1,
                  sh1),
                  null);
              ImagemArvore3.drawImage(scaledImage1,
                  Game.DecoComplexoX[28],
                  Game.DecoComplexoY[28], null);
              long currentTimeArv2 = System.currentTimeMillis();
              if (Game.ManterAnimation) {
                if (currentTimeArv2 - lastFrameTimeArv2 >= frameIntervalArv2) {
                  lastFrameTimeArv2 = currentTimeArv2 - (currentTimeArv2 %
                      frameIntervalArv2);
                  Game.currentFrame13 = (Game.currentFrame13 + 1) % totalFramesArv;
                }
              }
            }
            break;
          case 28:
            //////
            break;
          case 29:
            //////
            break;
          case 30:
            //////
            break;
          case 31:
            if (Game.DecoComplexoX.length > 32 && Game.DecoComplexoY.length > 32) {
              BufferedImage homemcristal = (BufferedImage) spritsheethomemcristal;
              int sxc = (Game.currentFrame17 % numFramesXCris) * (homemcristal.getWidth() /
                  numFramesXCris);
              int syc = (Game.currentFrame17 / numFramesXCris) * (homemcristal.getHeight() /
                  numFramesYCris);
              int swc = homemcristal.getWidth() / numFramesXCris;
              int shc = homemcristal.getHeight() / numFramesYCris;
              ImagemCris = buffer.createGraphics();
              AffineTransform atc = new AffineTransform();
              atc.scale((double) (128 + 2) / swc, (double) (128 + 2) / shc);
            
              AffineTransformOp opc = new AffineTransformOp(atc,
                  AffineTransformOp.TYPE_BILINEAR);
             
              BufferedImage scaledImagecris = opc.filter(homemcristal.getSubimage(sxc, syc, swc,
                  shc),
                  null);
              ImagemCris.drawImage(scaledImagecris,
                  Game.DecoComplexoX[32],
                  Game.DecoComplexoY[32], null);
              long currentTimecris = System.currentTimeMillis();
              if (Game.ManterAnimation) {
                if (currentTimecris - lastFrameTimecris >= frameIntervalcris) {
                  lastFrameTimecris = currentTimecris - (currentTimecris %
                      frameIntervalcris);
                  Game.currentFrame17 = (Game.currentFrame17 + 1) % totalFramescris;
                }
              }
            }
          case 32:
            if (Game.DecoComplexoX.length > 33 && Game.DecoComplexoY.length > 33) {
            }
            imagens.add(
                new Imagem(
                    arvoreLago,
                    Game.DecoComplexoX[33] + 48,
                    Game.DecoComplexoY[33] + 30, 57, 69));
            break;
          default:
            break;
        }
      }
    }
    for (Imagem imagem : imagens) {
      g2d.drawImage(imagem.getImagem(), imagem.getX(), imagem.getY(), imagem.getWidth(), imagem.getHeight(), null);
    }
    g2d.dispose();
  }

  public static void decoracaoDungeon(BufferedImage buffer) {
    g2d = buffer.createGraphics();
    imagens.clear();

    int index = 0;

    try {
      for (int i = 0; i < Game.quanti.get(0); i++) {
        imagens.add(new Imagem(Black_crystal1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(1); i++) {
        imagens.add(new Imagem(Blue_crystal1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(2); i++) {
        imagens.add(new Imagem(Green_crystal1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(3); i++) {
        imagens.add(new Imagem(Pink_crystal1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(4); i++) {
        imagens.add(new Imagem(Red_crystal1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(5); i++) {
        imagens.add(new Imagem(Violet_crystal1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(6); i++) {
        imagens.add(new Imagem(White_crystal2, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(7); i++) {
        imagens.add(new Imagem(Yellow_green_crystal1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(8); i++) {
        imagens.add(new Imagem(skeleton, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(9); i++) {
        imagens.add(new Imagem(skullcabra, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(10); i++) {
        imagens.add(new Imagem(skullsbirdy, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(11); i++) {
        imagens.add(new Imagem(skullsheads, Game.DecoracaoX[index], Game.DecoracaoY[index], 35, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(12); i++) {
        imagens.add(new Imagem(caixao1, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(13); i++) {
        imagens.add(new Imagem(caixao2, Game.DecoracaoX[index], Game.DecoracaoY[index], 32, 32));
        index++;
      }
      for (int i = 0; i < Game.quanti.get(14); i++) {
        BufferedImage fire = (BufferedImage) firedungeon;
        int sx1 = (Game.currentFrame18 % numFramesXfire) * (fire.getWidth() /
            numFramesXfire);
        int sy1 = (Game.currentFrame18 / numFramesXfire) * (fire.getHeight() /
            numFramesYfire);
        int sw1 = fire.getWidth() / numFramesXfire;
        int sh1 = fire.getHeight() / numFramesYfire;
        fireFogo = buffer.createGraphics();
        AffineTransform at1 = new AffineTransform();
        at1.scale((double) (35 + 2) / sw1, (double) (35 + 2) / sh1);
       
        AffineTransformOp op1 = new AffineTransformOp(at1,
            AffineTransformOp.TYPE_BILINEAR);
      
        BufferedImage scaledImage1 = op1.filter(fire.getSubimage(sx1, sy1, sw1,
            sh1),
            null);
        fireFogo.drawImage(scaledImage1, Game.DecoracaoX[index],
            Game.DecoracaoY[index], null);

        if (Game.snakeFire) {
          Game.valueFireX.add(Game.DecoracaoX[index]);
          Game.valueFireY.add(Game.DecoracaoY[index]);
        }

        long currentTimefire = System.currentTimeMillis();
        if (Game.ManterAnimation) {
          if (currentTimefire - lastFrameTimefire >= frameIntervalfire) {
            lastFrameTimefire = currentTimefire - (currentTimefire %
                frameIntervalfire);
            Game.currentFrame18 = (Game.currentFrame18 + 1) % totalFramesfire;
          }
        }
        index++;
      }

      for (int i = 0; i < Game.quanti.get(15); i++) {
        BufferedImage vulcan = (BufferedImage) spritedungeonnormal;
        int sx1 = (Game.currentFrame19 % numFramesXvulcan) * (vulcan.getWidth() /
            numFramesXvulcan);
        int sy1 = (Game.currentFrame19 / numFramesXvulcan) * (vulcan.getHeight() /
            numFramesYvulcan);
        int sw1 = vulcan.getWidth() / numFramesXvulcan;
        int sh1 = vulcan.getHeight() / numFramesYvulcan;
        vulcanfire = buffer.createGraphics();
        AffineTransform at1 = new AffineTransform();
        at1.scale((double) (35 + 2) / sw1, (double) (35 + 2) / sh1);
       
        AffineTransformOp op1 = new AffineTransformOp(at1,
            AffineTransformOp.TYPE_BILINEAR);
       
        BufferedImage scaledImage1 = op1.filter(vulcan.getSubimage(sx1, sy1, sw1,
            sh1),
            null);
        vulcanfire.drawImage(scaledImage1, Game.DecoracaoX[index],
            Game.DecoracaoY[index], null);

        long currentTimevulcan = System.currentTimeMillis();
        if (Game.ManterAnimation) {
          if (currentTimevulcan - lastFrameTimevulcan >= frameIntervalvulcan) {
            lastFrameTimevulcan = currentTimevulcan - (currentTimevulcan %
                frameIntervalvulcan);
            Game.currentFrame19 = (Game.currentFrame19 + 1) % totalFramesvulcan;
          }
        }
        index++;
      }
      for (int i = 0; i < Game.quanti.get(16); i++) {
        BufferedImage fire = (BufferedImage) firedungeon;
        int sx1 = (Game.currentFrame28 % numFramesXfire) * (fire.getWidth() /
            numFramesXfire);
        int sy1 = (Game.currentFrame28 / numFramesXfire) * (fire.getHeight() /
            numFramesYfire);
        int sw1 = fire.getWidth() / numFramesXfire;
        int sh1 = fire.getHeight() / numFramesYfire;
        fireFogo2 = buffer.createGraphics();
        AffineTransform at1 = new AffineTransform();
        at1.scale((double) (35 + 2) / sw1, (double) (35 + 2) / sh1);

        AffineTransformOp op1 = new AffineTransformOp(at1,
            AffineTransformOp.TYPE_BILINEAR);
       
        BufferedImage scaledImage1 = op1.filter(fire.getSubimage(sx1, sy1, sw1,
            sh1),
            null);
        fireFogo2.drawImage(scaledImage1, Game.DecoracaoX[index],
            Game.DecoracaoY[index], null);
        if (Game.snakeFire) {
          Game.valueFireX.add(Game.DecoracaoX[index]);
          Game.valueFireY.add(Game.DecoracaoY[index]);
        }
        long currentTimefire1 = System.currentTimeMillis();
        if (Game.ManterAnimation) {
          if (currentTimefire1 - lastFrameTimefire1 >= frameIntervalfire1) {
            lastFrameTimefire1 = currentTimefire1 - (currentTimefire1 %
                frameIntervalfire1);
            Game.currentFrame28 = (Game.currentFrame28 + 1) % totalFramesfire1;
          }
        }
        index++;
      }
    } catch (IndexOutOfBoundsException e) {
  }

    for (int i = 0; i < Game.quantiComplexo.size(); i++) {
      if (Game.quantiComplexo.get(i) > 0) {
        switch (i) {
          case 0:
            if (Game.DecoComplexoX.length > 1 && Game.DecoComplexoY.length > 1) {

              imagens.add(new Imagem(
                  arvoreskull,
                  Game.DecoComplexoX[1],
                  Game.DecoComplexoY[1], 64, 92));
            }
            break;
          case 1:
            if (Game.DecoComplexoX.length > 2 && Game.DecoComplexoY.length > 2) {

              imagens.add(new Imagem(
                  craniodino,
                  Game.DecoComplexoX[2],
                  Game.DecoComplexoY[2], 100, 92));
            }
            break;
          case 2:
            if (Game.DecoComplexoX.length > 3 && Game.DecoComplexoY.length > 3) {

              imagens.add(new Imagem(
                  espinhal,
                  Game.DecoComplexoX[3],
                  Game.DecoComplexoY[3], 48, 49));
            }
            break;
          case 3:
            int pos = 4;
            if (Game.DecoComplexoX.length > pos && Game.DecoComplexoY.length > pos) {
              for (int y = 0; y < 4; y++) {
                imagens.add(new Imagem(
                    picodungeon,
                    Game.DecoComplexoX[pos],
                    Game.DecoComplexoY[pos], 60, 100));
                pos++;
              }
            }
            break;
          case 4:
            if (Game.DecoComplexoX.length > 8 && Game.DecoComplexoY.length > 8) {

              imagens.add(new Imagem(
                  picomedio,
                  Game.DecoComplexoX[8],
                  Game.DecoComplexoY[8], 39, 63));
            }
            break;
          case 5:
            int pos1 = 9;
            if (Game.DecoComplexoX.length > pos1 && Game.DecoComplexoY.length > pos1) {
              for (int y = 0; y < 4; y++) {
                imagens.add(new Imagem(
                    pilardungeon,
                    Game.DecoComplexoX[pos1],
                    Game.DecoComplexoY[pos1], 75, 90));
                pos1++;
              }
            }
            break;
          case 6:
            if (Game.DecoComplexoX.length > 13 && Game.DecoComplexoY.length > 13) {

              imagens.add(new Imagem(
                  skullcostela,
                  Game.DecoComplexoX[13],
                  Game.DecoComplexoY[13], 60, 92));
            }
            break;
          case 7:
            if (Game.DecoComplexoX.length > 14 && Game.DecoComplexoY.length > 14) {

              imagens.add(new Imagem(
                  templedungeon,
                  Game.DecoComplexoX[14],
                  Game.DecoComplexoY[14], 90, 115));
            }
            break;
          case 8:
            if (Game.DecoComplexoX.length > 15 && Game.DecoComplexoY.length > 15) {

              imagens.add(new Imagem(
                  swordskeleton,
                  Game.DecoComplexoX[15],
                  Game.DecoComplexoY[15], 40, 60));
            }
            break;
          case 9:
            if (Game.DecoComplexoX.length > 16 && Game.DecoComplexoY.length > 16) {
              BufferedImage skullTemple1 = (BufferedImage) spritesheetskull1;
              int sx1 = (Game.currentFrame20 % numFramesXtemple) * (skullTemple1.getWidth()
                  /
                  numFramesXtemple);
              int sy1 = (Game.currentFrame20 / numFramesXtemple) *
                  (skullTemple1.getHeight() /
                      numFramesYtemple);
              int sw1 = skullTemple1.getWidth() / numFramesXtemple;
              int sh1 = skullTemple1.getHeight() / numFramesYtemple;
              temple1 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (60 + 2) / sw1, (double) (100 + 2) / sh1);
            
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
           
              BufferedImage scaledImage1 = op1.filter(skullTemple1.getSubimage(sx1, sy1,
                  sw1,
                  sh1),
                  null);
              temple1.drawImage(scaledImage1,
                  Game.DecoComplexoX[16],
                  Game.DecoComplexoY[16], null);
              long currentTimeTemple1 = System.currentTimeMillis();
              if (Game.ManterAnimation) {
                if (currentTimeTemple1 - lastFrameTimetemple >= frameIntervaltemple) {
                  lastFrameTimetemple = currentTimeTemple1 - (currentTimeTemple1 %
                      frameIntervaltemple);
                  Game.currentFrame20 = (Game.currentFrame20 + 1) % totalFramestemple;
                }
              }
            }
            break;
          case 10:
            if (Game.DecoComplexoX.length > 17 && Game.DecoComplexoY.length > 17) {
              BufferedImage skullTemple2 = (BufferedImage) spritesheetskull2;
              int sx1 = (Game.currentFrame21 % numFramesXtemple) * (skullTemple2.getWidth()
                  /
                  numFramesXtemple);
              int sy1 = (Game.currentFrame21 / numFramesXtemple) *
                  (skullTemple2.getHeight() /
                      numFramesYtemple);
              int sw1 = skullTemple2.getWidth() / numFramesXtemple;
              int sh1 = skullTemple2.getHeight() / numFramesYtemple;
              temple2 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (70 + 2) / sw1, (double) (100 + 2) / sh1);
             
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
             
              BufferedImage scaledImage1 = op1.filter(skullTemple2.getSubimage(sx1, sy1,
                  sw1,
                  sh1),
                  null);
              temple2.drawImage(scaledImage1, Game.DecoComplexoX[17],
                  Game.DecoComplexoY[17], null);
              long currentTimeTemple2 = System.currentTimeMillis();
              if (Game.ManterAnimation) {
                if (currentTimeTemple2 - lastFrameTimetemple1 >= frameIntervaltemple1) {
                  lastFrameTimetemple1 = currentTimeTemple2 - (currentTimeTemple2 %
                      frameIntervaltemple1);
                  Game.currentFrame21 = (Game.currentFrame21 + 1) % totalFramestemple1;
                }
              }
            }
            break;
          case 11:
            if (Game.DecoComplexoX.length > 18 && Game.DecoComplexoY.length > 18) {
              BufferedImage skullTemple3 = (BufferedImage) spritesheetskull3;
              int sx1 = (Game.currentFrame22 % numFramesXtemple) * (skullTemple3.getWidth()
                  /
                  numFramesXtemple);
              int sy1 = (Game.currentFrame22 / numFramesXtemple) *
                  (skullTemple3.getHeight() /
                      numFramesYtemple);
              int sw1 = skullTemple3.getWidth() / numFramesXtemple;
              int sh1 = skullTemple3.getHeight() / numFramesYtemple;
              temple3 = buffer.createGraphics();
              AffineTransform at1 = new AffineTransform();
              at1.scale((double) (70 + 2) / sw1, (double) (100 + 2) / sh1);
            
              AffineTransformOp op1 = new AffineTransformOp(at1,
                  AffineTransformOp.TYPE_BILINEAR);
            
              BufferedImage scaledImage1 = op1.filter(skullTemple3.getSubimage(sx1, sy1,
                  sw1,
                  sh1),
                  null);
              temple3.drawImage(scaledImage1,
                  Game.DecoComplexoX[18],
                  Game.DecoComplexoY[18], null);
              long currentTimeTemple3 = System.currentTimeMillis();
              if (Game.ManterAnimation) {
                if (currentTimeTemple3 - lastFrameTimetemple2 >= frameIntervaltemple2) {
                  lastFrameTimetemple2 = currentTimeTemple3 - (currentTimeTemple3 %
                      frameIntervaltemple2);
                  Game.currentFrame22 = (Game.currentFrame22 + 1) % totalFramestemple2;
                }
              }
            }
            break;
          case 12:
            ////
            break;
          case 13:
            ////
            break;
          default:
            break;
        }
      }
    }
    for (Imagem imagem : imagens) {
      g2d.drawImage(imagem.getImagem(), imagem.getX(), imagem.getY(), imagem.getWidth(), imagem.getHeight(), null);
    }
    g2d.dispose();
  }
}

class Imagem {
  private Image imagem;
  private int x;
  private int y;
  private int width;
  private int height;

  public Imagem(Image imagem, int x, int y, int width, int height) {
    this.imagem = imagem;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public Image getImagem() {
    return imagem;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
