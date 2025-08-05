import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Game extends JPanel implements Runnable {

  int DISTANCE = 0;
  int WIDTH = 10;
  int HEIGHT = 10;
  int largerCollisionArea = 12;
  public static int ValueFinal;
  public static int ValueDecoNormal;
  public static int ValueDecoComplexo;
  static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  public static int FrameWidth = (int) screenSize.getWidth();
  public static int FrameHeight = (int) screenSize.getHeight();
  static int ALL_DOTS_Width = (int) screenSize.getWidth();
  static int ALL_DOTS_Height = (int) screenSize.getHeight();
  int x[] = new int[ALL_DOTS_Width];
  int y[] = new int[ALL_DOTS_Height];
  Boolean[] Direcoes = new Boolean[4];
  Rectangle headCollisionArea;
  Rectangle headCollisionAreaPO;
  static int quantidadeDeco = 0;
  static int quantidadeDeco2 = 0;
  static int[] randomX2 = new int[4];
  static int[] randomY2 = new int[4];
  static int[] randomX = new int[3];
  static int[] randomY = new int[3];
  int[] randomXS0 = new int[4];
  int[] randomYS0 = new int[4];
 
  private Image snakeHead;
  private Image bodyStraight;
  private Image bodyCorner;
  private Image tailImage;

  private Image snakeHeadPoison;
  private Image bodyStraightPoison;
  private Image bodyCornerPoison;
  private Image tailImagePoison;
  private Image manchasAmarelas;

  private Image fogoComplementar;
  private Image fogoFinal;
  private Image snakeHeadFire;
  private Image bodyStraightFire;
  private Image bodyCornerFire;
  private Image tailImageFire;
  
  private Image gramSprit;
  private Image rockSprit;
  private Image DecoLawn01;
  private Image DecoLawn02;
  private Image painelRock;
 
  private Image appleSprit;
  private Image applePoison;
  private Image appleEnergy;

  private Image eggAnimation;
  private Image eggAnimationBreak;
  public static int poisonFruitWidthVen = 25; 
  public static int poisonFruitHeightVen = 50; 

  public static int poisonFruitWidthErn = 20;
  public static int poisonFruitHeightErn = 20;
  public static int poisonFruitWidthCla = 18;
  public static int poisonFruitHeightCla = 18;


  private Image explosionDeath;
  private Image DeathPoison;
  private Image DeathPoison2;
  private Image BeatEffect;
  Image EnergyAnimationBody;
  Image EnergyAnimationTail;
  Image EnergyAnimationFinal;
  Image ColidianEnergy;
  Image ColidianEnergyFood;
  Image ColidianPoisonFood;
  Image colidianClassic;

  Image chao_swamp;
  Image rock_swamp;
  Image spriteshetlago1;
  Image spriteshetlago2;
  Image spriteshetlago3;
  Image small_trunk;
  Image chao1;
  Image chao2;
  Image chao3;
  Image chao4;
  Image chao5;
  Image swamp1;
  Image swamp2;
  Image swamp3;
  Image swamp4;


  Image chao_dungeon;
  Image rock_dungeon;

  Image dragon_bone;
  Image skull_bone;
  Image tibia_bone;
  Image gold1;
  Image gold2;
  Image gold3;

  Image NumberMais1;


  static BufferedImage Vitoria;
  private boolean VerificDistance = false;
  boolean gameOver = false;
  BufferedImage buffer; 
  public static ArrayList<Integer> walls_x = new ArrayList<>();
  public static ArrayList<Integer> walls_y = new ArrayList<>();
  private MyKeyBoardListener keyListener;
  public static int direction;
  static Node[] ComprimentoCobra = new Node[40];
  public static Node[] nodeSnake = ComprimentoCobra;
  public int score = 0;
  public static int macaX = 0, macaY = 0;
  public int macaENX = 0, macaENY = 0;
  public int macaPOX = 0, macaPOY = 0;
  public int count = 0;


  private static boolean animationFinished = false;
  private boolean poisonDeathAnimationPlaying = false;
  public long lastVenomAnimationTime1 = System.currentTimeMillis();
  public long lastVenomAnimationTimeEnergy = System.currentTimeMillis();
  public long TeleportEnergyVerif = System.currentTimeMillis();
  public long ControlTimerVelocity = System.currentTimeMillis();
  public long ajudantsClaTimer = System.currentTimeMillis();
  public long ControlAPOSSuporte = System.currentTimeMillis();
  public long ControlSpriteSheet = System.currentTimeMillis();
  public long ControlSpriteSheetColidion = System.currentTimeMillis();
  public boolean TimerVerif = false;
  public boolean ColidionEnergyCla = false;
  public boolean ColidionEnergyConfirmed = false;
  public static boolean colisionControlPoison = false;
  public static boolean colisionControlEnergy = false;
  public boolean venomAnimationPlayed = false;
  public boolean ernegyAnimationPlayed = false;
  public Timer timer = new Timer();
  public Timer timerEnergy = new Timer();
  public boolean timerCancelled = false;
  public boolean lit = false;
 
  int segmentsToRemove = 0;
  int segmentsToRemoveTemporary = 0;

  static boolean poisonFruitAnimationRunning = false;
  public boolean Segunds = false;
  public boolean ControlTeleport = false;
  public boolean ControlColisionEnergy = false;
  public static boolean VelocityControl = false;

  public static Timer poisonFruitAnimationTimer;
  public boolean colidionClaControlTimerAnimation = false;
  public static boolean colidionPoiControlTimerAnimation = false;
  public static boolean colidionEneControlTimerAnimation = false;
  public static boolean ColisionEnergy = false;
  public static boolean SpreetSheetInitial = false;
  public static boolean SpreetSheetFinale = false;
  public static boolean ControlAPOSColidionTimer = false;
  public static boolean ControlEnergyColidianBoolean = false;
  public static boolean ControEletriFinal = false;
  public static boolean ControlEnergy = false;
  public static int PosColidianEnergyX = 0;
  public static int PosColidianEnergyY = 0;
  public static int PosColidianPoisonX = 0;
  public static int PosColidianPoisonY = 0;
  public static int PosColidianClassicX = 0;
  public static int PosColidianClassicY = 0;
  public static int currentFrame34 = 0;
  public static int currentFrame33 = 0;
  public static int currentFrame32 = 0;
  public static int currentFrame31 = 0;
  public static int currentFrame30 = 0;
  public static int currentFrame29 = 0;
  public static int currentFrame28 = 0;
  public static int currentFrame27 = 0;
  public static int currentFrame26 = 0;
  public static int currentFrame25 = 0;
  public static int currentFrame24 = 0;
  public static int currentFrame23 = 0;
  public static int currentFrame22 = 0;
  public static int currentFrame21 = 0;
  public static int currentFrame20 = 0;
  public static int currentFrame19 = 0;
  public static int currentFrame18 = 0;
  public static int currentFrame17 = 0;
  public static int currentFrame16 = 0;
  public static int currentFrame15 = 0;
  public static int currentFrame14 = 0;
  public static int currentFrame13 = 0;
  public static int currentFrame12 = 0;
  public static int currentFrame11 = 0;
  public static int currentFrame10 = 0;
  public static int currentFrame9 = 0;
  public static int currentFrame8 = 0;
  public static int currentFrame7 = 0;
  public static int currentFrame6 = 0;
  public static int currentFrame5 = 0;
  public static int currentFrame4 = 0;
  public static int currentFrame3 = 0;
  public static int currentFrame2 = 0;
  public static int currentFrame1 = 0;
  public static boolean VerifiEnergyAnimation = false;
  public static boolean ControlOneAnimation = false;
  public static boolean ControlOneAnimationESPLO = false;
  public static boolean ControlOneAnimationPoison = false;
  public static boolean ControlOneAnimationClassic = false;
  public static boolean ControlOneAnimationClassicAtivar = false;
  public static boolean ControlOneAnimationEgg = false;
  public static Graphics2D painelBordas;
  public static int borderWidth = 20;
  public static int drawX;
  public static int drawY;
  public static int positionX;
  public static int positionY;
  public static Graphics2D g2d;
  public static boolean NewButtonGame;
  public static boolean MapDungeon = false;
  public static boolean MapSwamp = false;
  public static boolean MapField = true;
  public static boolean snakeClassica = true;
  public static boolean snakePoison = false;
  public static boolean snakeFire = false;
  private static int quantidadeDecoSmallTrunk;
  private static int quantidadeDecoChao1;
  private static int quantidadeDecoChao2;
  private static int quantidadeDecoChao3;
  private static int quantidadeDecoChao4;
  private static int quantidadeDecoChao5;
  private static int quantidadeDecoGold1;
  private static int quantidadeDecoGold2;
  private static int quantidadeDecoGold3;
  static int[] randomSX = new int[7];
  static int[] randomSY = new int[7];
  static int[] randomSX1 = new int[2];
  static int[] randomSY1 = new int[2];
  static int[] randomSX2 = new int[3];
  static int[] randomSY2 = new int[3];
  static int[] randomSX3 = new int[1];
  static int[] randomSY3 = new int[1];

  static int[] randomDX = new int[1];
  static int[] randomDY = new int[1];
  static int[] randomDX1 = new int[15];
  static int[] randomDY1 = new int[15];
  static int[] randomDX2 = new int[15];
  static int[] randomDY2 = new int[15];
  static int[] randomSX4 = new int[16];
  static int[] randomSY4 = new int[16];
  static int[] randomSX5 = new int[16];
  static int[] randomSY5 = new int[16];
  static int[] randomSX6 = new int[16];
  static int[] randomSY6 = new int[16];
  static int[] randomSX7 = new int[16];
  static int[] randomSY7 = new int[16];
  static int[] randomSX8 = new int[10];
  static int[] randomSY8 = new int[10];
  static int[] randomSX9 = new int[10];
  static int[] randomSY9 = new int[10];
  static int[] randomDX3 = new int[10];
  static int[] randomDY3 = new int[10];
  static int[] randomDX4 = new int[10];
  static int[] randomDY4 = new int[10];
  static int[] randomDX5 = new int[10];
  static int[] randomDY5 = new int[10];
  public static int[] DecoracaoX = new int[0];
  public static int[] DecoracaoY = new int[0];
  public static int[] DecoComplexoX = new int[0];
  public static int[] DecoComplexoY = new int[0];

  private static int quantidadeDecoDragonBone;
  private static int quantidadeDecoSkullBone;
  private static int quantidadeDecoTibiaBone;
  private static int quantidadeDecoSwamp1;
  private static int quantidadeDecoSwamp2;
  private static int quantidadeDecoSwamp3;
  private static int quantidadeDecoSwamp4;
  JButton newGameButton;
  JButton RevertMenuButton;
  JButton button;
  JPanel meuPainel = this;
  static JPanel meuPainelButtons;
  JLabel messageLabel;
  Font newgameFont;
  Font revertmenuFont;
  ImageIcon buttonImage;
  JLabel label;
  double rotationAngle = 0;
  Image lavaNormal;
  Image lavaSkull;
  private Image RaioIcon;
  private Image PoisonDeathIcon;
  private Image VelocityIcon;
  public static boolean GameFim = false;
  private int TamanhoFinal = 200;
  private boolean VelocityFinal;

  public static boolean checkedEsplo;
  public static boolean colisianEnergySumir = false;
  public static boolean colisianEnergyMorrer = false;
  public static ArrayList<Integer> quanti = new ArrayList<>();
  public static ArrayList<Integer> quantiComplexo = new ArrayList<>();
  public static ArrayList<Integer> valueFireX = new ArrayList<>();
  public static ArrayList<Integer> valueFireY = new ArrayList<>();
  public static boolean cobraParada = false;
  public static boolean cobraParadaFinal = false;

  public static int PosicaoX;
  public static int PosicaoY;
  public static boolean IniciouEgg = true;

  static int posicaoXNumber = 0;
  static int posicaoYNumber = 0;
  static int NovaPosicao0 = 0;
  static int widhtNumberW = 0;
  static int widhtNumberH = 0;
  static float TransparentNumber = 0.1f;
  static boolean possibilitiNumberFinal = false;
  static boolean colidianClassico = false;

  static int posicaoXDeath = 0;
  static int posicaoYDeath = 0;
  static int NovaPosicaoDeath0 = 0;
  static int widhtDeathW = 0;
  static int widhtDeathH = 0;
  static float TransparentDeath = 0.1f;
  static boolean colidianDeath = false;
  static boolean possibilitiDeathFinal = false;
  static Timer DeathElevacao;

  static int posicaoXEnergy = 0;
  static int posicaoYEnergy = 0;
  static int NovaPosicaoEnergy0 = 0;
  static int widhtEnergyW = 0;
  static int widhtEnergyH = 0;
  static float TransparentEnergy = 0.1f;
  static boolean colidianEnergy = false;
  static boolean possibilitiEnergyFinal = false;
  static Timer EnergyElevacao;


  static int posicaoXVelocity = 0;
  static int posicaoYVelocity = 0;
  static int NovaPosicaoVelocity0 = 0;
  static int widhtVelocityW = 0;
  static int widhtVelocityH = 0;
  static float TransparentVelocity = 0.1f;
  static boolean colidianVelocity = false;
  static boolean possibilitiVelocityFinal = false;
  static int SubindoNivel = 0;
  public static int ControlVelocity = 1200;
  public static int ControlVelocityFinal = 1200;
  static int vitoriaWidth = 1;
  static int vitoriaHeight = 1;
  static ImagePanel imagePanel;
  static ImagePanel2 animationPanel;
  private TextShadow textShadowLabel;
  static TextShadow DificultytextShadowLabel;
  static TextShadow DificultytextShadowLabel2;
  static TextShadow TempotextShadowLabel;

  static TextShadow TempotextShadowLabel2;
  static TextShadow PonttextShadowLabel;
  static TextShadow PonttextShadowLabel2;
  private GridBagConstraints gbc;
  static BufferedImage animatiomVictory;
  static boolean AparecerVitoriaPainel = false;
  static boolean AnimationVitoria = false;
  static int Transper = 0;
  static String dificulty = "Normal";
  static int Minutos = 0;
  static int Segundos = 0;
  static Timer timerPartida;
  static int Pontuacao = 0;
  static String timeText;
  static boolean colidindoPontuacao = false;
  static int delay = 1000; // 1 segundo
  static JLabel tempoLabel;
  static JPanel GridTimer;
  static TextShadow textTimer;
  static JLabel pontLabel;
  static TextShadow textpont;
  int seconds = 0;
  public static boolean componentesTimerPontAdicionado = false; 
  private Timer timerTempo;
  static KeyEvent escolha;
  int QuantiTempoGameFim = 0;

  private TextShadow youLose;
  private TextShadow textPontGameOver;
  private TextShadow textPontGameOver1;
  private Image headDeathPoison;
  private Image headDeathFire;
  private Image headDeathClassica;
  public static JLabel DificuldadeLabel;
  static int sizeDificult = 32;
  static Font fontesGameWins;
  static Font Fonts;
  static Font customFont;
  static GridBagConstraints GridGameWins;
  static Color CorDificulty = Color.YELLOW;
  static Timer timerLabelsGameWins;
  static int DesblockedPontuation = 3;

  public static boolean ZerouMapaField;
  public static boolean ZerouMapaDungeon;
  public static boolean ZerouMapaSwamp;
  static String MapLiberation;
  static String SnakeLiberation;
  static boolean NotificationGameDesblocked;
  static boolean DeathfromHunger = false;

  private Image originalSnakeHeadClassica;
  private Image originalSnakeHeadPoison;
  private Image originalSnakeHeadFire;
  static LifeEnergyPanel lifeEnergyPanel;
  private BufferedImage RaioInicial;
  private InicialRaio InicialRaioPanel;
  private int delay1;
  private int delay2;
  private int delay0;
  private int colorTransparente;
  private Font fontesGameWinsButton;
  private boolean tocando = true;
  static boolean aparecerAposLoading;
  static boolean ControlTamanho = false;
  static boolean PodeIniciarPosLoading = false;
  static int keyPressedSuperior = KeyEvent.VK_UP;
  static int keyPressedInferior = KeyEvent.VK_DOWN;
  static int keyPressedEsquerda = KeyEvent.VK_LEFT;
  static int keyPressedDireita = KeyEvent.VK_RIGHT;
  static boolean RemoverAnimation = false;
  static boolean ManterAnimation = true;
  static boolean clickedButtonDifiNormal = true;
  static boolean clickedButtonDifiDificil = false;
  static boolean clickedButtonDifiFacil = false;
  public static Queue<File> musicQueue = new LinkedList<>();
  public static Queue<File> originalQueue = new LinkedList<>();
  public static Queue<File> limperQueue = new LinkedList<>();
  static boolean userInteracted = true;
  static JFrame frame;

  private void initializeKeyListener() {
    if (!gameOver && !GameFim) {
      keyListener = new MyKeyBoardListener(this, direction);
      this.addKeyListener(keyListener);
    }

  }

  public Game() {

    Image[] imagens = loadImages.Images(WIDTH, HEIGHT);
    snakeHead = imagens[0];
    tailImage = imagens[1];
    bodyStraight = imagens[2];
    bodyCorner = imagens[3];
    gramSprit = imagens[4];
    rockSprit = imagens[5];
    appleSprit = imagens[6];
    DecoLawn01 = imagens[7];
    DecoLawn02 = imagens[8];
    applePoison = imagens[9];
    appleEnergy = imagens[10];
    DeathPoison = imagens[11];
    BeatEffect = imagens[12];
    EnergyAnimationBody = imagens[13];
    EnergyAnimationTail = imagens[14];
    EnergyAnimationFinal = imagens[15];
    ColidianEnergy = imagens[16];
    ColidianEnergyFood = imagens[17];
    ColidianPoisonFood = imagens[18];
    colidianClassic = imagens[19];
    painelRock = imagens[20];
    chao_swamp = imagens[21];
    rock_swamp = imagens[22];
    chao_dungeon = imagens[23];
    rock_dungeon = imagens[24];
    small_trunk = imagens[25];
    chao1 = imagens[26];
    chao2 = imagens[27];
    chao3 = imagens[28];
    dragon_bone = imagens[29];
    skull_bone = imagens[30];
    tibia_bone = imagens[31];
    swamp1 = imagens[32];
    swamp2 = imagens[33];
    swamp3 = imagens[34];
    swamp4 = imagens[35];
    spriteshetlago1 = imagens[36];
    spriteshetlago2 = imagens[37];
    spriteshetlago3 = imagens[38];
    chao4 = imagens[39];
    chao5 = imagens[40];
    gold1 = imagens[41];
    gold2 = imagens[42];
    gold3 = imagens[43];
    lavaNormal = imagens[44];
    lavaSkull = imagens[45];
    tailImagePoison = imagens[46];
    bodyCornerPoison = imagens[47];
    bodyStraightPoison = imagens[48];
    snakeHeadPoison = imagens[49];
    tailImageFire = imagens[50];
    bodyCornerFire = imagens[51];
    bodyStraightFire = imagens[52];
    snakeHeadFire = imagens[53];
    fogoComplementar = imagens[54];
    fogoFinal = imagens[55];
    manchasAmarelas = imagens[56];
    DeathPoison2 = imagens[57];
    explosionDeath = imagens[58];
    eggAnimation = imagens[59];
    eggAnimationBreak = imagens[60];
    NumberMais1 = imagens[61];
    RaioIcon = imagens[62];
    PoisonDeathIcon = imagens[63];
    VelocityIcon = imagens[64];
    headDeathPoison = imagens[65];
    headDeathFire = imagens[66];
    headDeathClassica = imagens[67];
    originalSnakeHeadClassica = snakeHead;
    originalSnakeHeadPoison = snakeHeadPoison;
    originalSnakeHeadFire = snakeHeadFire;

    initializeKeyListener();
    this.setPreferredSize(new Dimension(ALL_DOTS_Width, ALL_DOTS_Height));
    this.setFocusable(true);
    buffer = new BufferedImage(ALL_DOTS_Width, ALL_DOTS_Height, BufferedImage.TYPE_INT_ARGB); 
    
    if (MapField) {
      ArrayList<ArrayList<Integer>> walls = LocaleUtils.LocateWall(FrameWidth,
          FrameHeight, WIDTH, HEIGHT, 20);
      walls_x = walls.get(0);
      walls_y = walls.get(1);
    }
 
    Location_deco();
 
    StartSnake();
    PosicaoX = nodeSnake[0].x;
    PosicaoY = nodeSnake[0].y;

    headCollisionArea = new Rectangle(nodeSnake[0].x - largerCollisionArea / 2,
        nodeSnake[0].y - largerCollisionArea / 2,
        WIDTH + largerCollisionArea, HEIGHT + largerCollisionArea);

  

    ArrayList<Point> foodPositions = LocaleUtils.LocateFood(FrameWidth, FrameHeight, WIDTH, HEIGHT, walls_x, walls_y,
        nodeSnake);
    if (foodPositions.size() >= 2) {
      Point foodPosition0 = foodPositions.get(0);
      Point foodPosition1 = foodPositions.get(1);
      if (snakePoison) {
        macaX = -100;
        macaY = -100;
      } else {
        macaX = foodPosition0.x;
        macaY = foodPosition0.y;
      }
      if (snakePoison) {
        macaPOX = foodPosition1.x;
        macaPOY = foodPosition1.y;
      }

      macaENX = -100;
      macaENY = -100;
      if (!TimerVerif) {
        if (snakePoison) {
          macaX = -100;
          macaY = -100;
        }
        if (Game.snakeClassica || Game.snakeFire) {
          macaPOX = -100;
          macaPOY = -100;
        }
      } else if (TimerVerif) {
        if (snakePoison) {
          macaX = foodPosition0.x;
          macaY = foodPosition0.y;

        }
        if (Game.snakeClassica || Game.snakeFire) {
          macaPOX = foodPosition1.x;
          macaPOY = foodPosition1.y;
        }
      }
    }
  }

  public static void Location_deco() {
    Random random = new Random();
  
    if (MapField) {

      quantidadeDeco = (int) (Math.random() * 3 + 1);
      quantidadeDeco2 = (int) (Math.random() * 4 + 1);
      for (int i = 0; i < quantidadeDeco; i++) {
        randomX[i] = random.nextInt(ALL_DOTS_Width);
        randomY[i] = random.nextInt(ALL_DOTS_Height);
      }
      
      for (int i = 0; i < quantidadeDeco2; i++) {
        randomX2[i] = random.nextInt(ALL_DOTS_Width);
        randomY2[i] = random.nextInt(ALL_DOTS_Height);
      }
    }
    if (MapSwamp) {

      quantidadeDecoSmallTrunk = (int) (Math.random() * 6 + 2);
      quantidadeDecoChao1 = (int) (Math.random() * 2 + 1);
      quantidadeDecoChao2 = (int) (Math.random() * 3 + 1);
      quantidadeDecoChao3 = (int) (Math.random() * 1 + 1);
      quantidadeDecoChao4 = (int) (Math.random() * 6 + 3);
      quantidadeDecoChao5 = (int) (Math.random() * 6 + 3);
      quantidadeDecoSwamp1 = (int) (Math.random() * 10 + 5);
      quantidadeDecoSwamp2 = (int) (Math.random() * 10 + 5);
      quantidadeDecoSwamp3 = (int) (Math.random() * 10 + 5);
      quantidadeDecoSwamp4 = (int) (Math.random() * 10 + 5);

      for (int i = 0; i < quantidadeDecoSmallTrunk; i++) {
        randomSX[i] = random.nextInt(ALL_DOTS_Width);
        randomSY[i] = random.nextInt(ALL_DOTS_Height);
      }
    
      for (int i = 0; i < quantidadeDecoChao1; i++) {
        randomSX1[i] = random.nextInt(ALL_DOTS_Width);
        randomSY1[i] = random.nextInt(ALL_DOTS_Height);
      }
     
      for (int i = 0; i < quantidadeDecoChao2; i++) {
        randomSX2[i] = random.nextInt(ALL_DOTS_Width);
        randomSY2[i] = random.nextInt(ALL_DOTS_Height);
      }
     
      for (int i = 0; i < quantidadeDecoChao3; i++) {
        randomSX3[i] = random.nextInt(ALL_DOTS_Width);
        randomSY3[i] = random.nextInt(ALL_DOTS_Height);
      }
      
      for (int i = 0; i < quantidadeDecoChao4; i++) {
        randomSX8[i] = random.nextInt(ALL_DOTS_Width);
        randomSY8[i] = random.nextInt(ALL_DOTS_Height);
      }
      
      for (int i = 0; i < quantidadeDecoChao5; i++) {
        randomSX9[i] = random.nextInt(ALL_DOTS_Width);
        randomSY9[i] = random.nextInt(ALL_DOTS_Height);
      }
      
      for (int i = 0; i < quantidadeDecoSwamp1; i++) {
        randomSX4[i] = random.nextInt(ALL_DOTS_Width);
        randomSY4[i] = random.nextInt(ALL_DOTS_Height);
      }
      
      for (int i = 0; i < quantidadeDecoSwamp2; i++) {
        randomSX5[i] = random.nextInt(ALL_DOTS_Width);
        randomSY5[i] = random.nextInt(ALL_DOTS_Height);
      }
      
      for (int i = 0; i < quantidadeDecoSwamp3; i++) {
        randomSX6[i] = random.nextInt(ALL_DOTS_Width);
        randomSY6[i] = random.nextInt(ALL_DOTS_Height);
      }
     
      for (int i = 0; i < quantidadeDecoSwamp4; i++) {
        randomSX7[i] = random.nextInt(ALL_DOTS_Width);
        randomSY7[i] = random.nextInt(ALL_DOTS_Height);
      }
     
    }
    if (MapDungeon) {

     
      quantidadeDecoDragonBone = (int) (Math.random() * 1 + 1);
      quantidadeDecoSkullBone = (int) (Math.random() * 10 + 5);
      quantidadeDecoTibiaBone = (int) (Math.random() * 10 + 5);
      quantidadeDecoGold1 = (int) (Math.random() * 6 + 3);
      quantidadeDecoGold2 = (int) (Math.random() * 6 + 3);
      quantidadeDecoGold3 = (int) (Math.random() * 6 + 3);
      for (int i = 0; i < quantidadeDecoDragonBone; i++) {
        randomDX[i] = random.nextInt(ALL_DOTS_Width);
        randomDY[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoSkullBone; i++) {
        randomDX1[i] = random.nextInt(ALL_DOTS_Width);
        randomDY1[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoTibiaBone; i++) {
        randomDX2[i] = random.nextInt(ALL_DOTS_Width);
        randomDY2[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoGold1; i++) {
        randomDX3[i] = random.nextInt(ALL_DOTS_Width);
        randomDY3[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoGold2; i++) {
        randomDX4[i] = random.nextInt(ALL_DOTS_Width);
        randomDY4[i] = random.nextInt(ALL_DOTS_Height);
      }
      for (int i = 0; i < quantidadeDecoGold3; i++) {
        randomDX5[i] = random.nextInt(ALL_DOTS_Width);
        randomDY5[i] = random.nextInt(ALL_DOTS_Height);
      }
    }
  }


  public static void main(String args[]) {
    Game game = new Game();
    frame = new JFrame("Snake Game");
    frame.add(game);
    frame.setResizable(false);
    frame.setUndecorated(true);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    // cheia
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    MenuPanel menuPanel = new MenuPanel();
    frame.add(menuPanel);
    frame.setVisible(true);
    MusicPlayer.audioClips = new ArrayList<>();
    MusicPlayer.effectsClips = new ArrayList<>();
    MusicPlayer.musicMenu();
    ConfPanel.valueEf = 80;
    ConfPanel.value = 80;

  }

  public void drawCollisionAnimation(Graphics g, double rotationAngle) {
    if (nodeSnake.length > 0) { 
      positionX = nodeSnake[0].x; 
      positionY = nodeSnake[0].y; 
     
      drawX = positionX - BeatEffect.getWidth(null) / 40 + 26; 
      drawY = positionY - BeatEffect.getHeight(null) / 40 / 40 + 5; 
      Animation.AnimationColidion(buffer, BeatEffect, drawX, drawY, rotationAngle);
    }
  }

  

  @Override
  public void run() {
    while (!gameOver && !GameFim) {
      if (VerificDistance) {
        VerificDistance = false;
      }

      tick();
      if (clickedButtonDifiFacil) {
        Ultrapassagem.UltrapassagemPainel(nodeSnake, FrameWidth, FrameHeight);
      }
      ResultadoColisao resultadoColisao = checkedColisson.verificarColisao(gameOver, WIDTH, HEIGHT, FrameWidth,
          FrameHeight,
          walls_x, walls_y, nodeSnake, largerCollisionArea, headCollisionArea,
          poisonDeathAnimationPlaying,
          borderWidth, FrameWidth, FrameHeight, DeathfromHunger);
      gameOver = resultadoColisao.gameOver;
      poisonDeathAnimationPlaying = resultadoColisao.animacaoMorteVenenoAtiva;

      try {
        Thread.sleep(ControlVelocityFinal / 60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  
    while (gameOver && !poisonDeathAnimationPlaying && !checkedEsplo && !DeathfromHunger) {
      rotationAngle += 1;
      rotationAngle %= 360;
      if (keyListener != null) {
        this.removeKeyListener(keyListener);
      }
      drawCollisionAnimation(buffer.getGraphics(), rotationAngle);
      try {
        Thread.sleep(10); 
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void Animation() {
    if (!animationFinished && snakePoison) {
      if (!ControlOneAnimationPoison) {

        Animation.AnimationColidianPoisonFood(buffer, ColidianPoisonFood, nodeSnake,
            PosColidianPoisonX,
            PosColidianPoisonY);
      }
    }

    if (!animationFinished && poisonDeathAnimationPlaying) {
      int positionX = 0;
      int positionY = 0;
      for (int i = 0; i < nodeSnake.length; i++) {
        positionX = nodeSnake[0].x;
        positionY = nodeSnake[0].y;
      }

      if (snakeClassica || snakeFire) {
        if (!ControlOneAnimationPoison) {
          posicaoXDeath = PosColidianPoisonX;
          posicaoYDeath = PosColidianPoisonY;
          NovaPosicaoDeath0 = Game.posicaoYDeath - 40;
          widhtDeathW = 0;
          widhtDeathH = 0;
          Game.TransparentDeath = 0.1f;
          NumberAnimation.restartAnimationDeath(this);
          colidianDeath = true;
          Animation.AnimationColidianPoisonFood(buffer, ColidianPoisonFood, nodeSnake, PosColidianPoisonX,
              PosColidianPoisonY);
        }
      }
      animationFinished = Animation.AnimationPoisonDeath(buffer, DeathPoison, DeathPoison2, animationFinished,
          positionX,
          positionY, keyListener);
    }
    if (ControlEnergyColidianBoolean) {
      if (!ControlOneAnimation) {
        Animation.AnimationColidianEnergyFood(buffer, ColidianEnergyFood, nodeSnake, PosColidianEnergyX,
            PosColidianEnergyY);
      }
      Animation.AnimationColisionEnergy(this, buffer,
          ColidianEnergy,
          nodeSnake, PosColidianEnergyX, PosColidianEnergyY);
    }
    if (ControlOneAnimationClassicAtivar) {
      if (!ControlOneAnimationClassic) {
        Animation.AnimationColidianClassicFood(buffer, colidianClassic, nodeSnake,
            PosColidianClassicX, PosColidianClassicY);
      }
    }
    if (gameOver) {
      if (keyListener != null) {
        this.removeKeyListener(keyListener);
      }
      repaint();
    } else if (GameFim) {

      if (keyListener != null) {
        this.removeKeyListener(keyListener);
      }
      repaint();
    }

  }

 
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (buffer == null) {
      return;
    }

   

    if (MapField) {
      map.mapField(buffer, ALL_DOTS_Width, ALL_DOTS_Height, gramSprit, DecoLawn01, DecoLawn02, randomX, randomY,
          quantidadeDeco, randomX2,
          randomY2, quantidadeDeco2);
    }
    if (MapSwamp) {
      map.mapSwamp(buffer, ALL_DOTS_Width, ALL_DOTS_Height, chao_swamp, small_trunk, chao1, chao2, chao3, chao4, chao5,
          swamp1, swamp2, swamp3, swamp4,
          quantidadeDecoSmallTrunk, quantidadeDecoChao1, quantidadeDecoChao2, quantidadeDecoChao3, quantidadeDecoChao4,
          quantidadeDecoChao5, randomSX, randomSY,
          randomSX1, randomSY1, randomSX2, randomSY2, randomSX3, randomSY3, randomSX4, randomSY4, randomSX5, randomSY5,
          randomSX6, randomSY6, randomSX7, randomSY7, randomSX8, randomSY8, randomSX9, randomSY9, quantidadeDecoSwamp1,
          quantidadeDecoSwamp2,
          quantidadeDecoSwamp3, quantidadeDecoSwamp4);
      decoracaoComplexaAcima.AcimaSwamp(buffer, spriteshetlago1, spriteshetlago2, spriteshetlago3);
    }
    if (MapDungeon) {
      map.mapDungeon(buffer, ALL_DOTS_Width, ALL_DOTS_Height, chao_dungeon, dragon_bone, skull_bone, tibia_bone, gold1,
          gold2, gold3,
          quantidadeDecoDragonBone, quantidadeDecoSkullBone, quantidadeDecoTibiaBone,
          quantidadeDecoGold1, quantidadeDecoGold2, quantidadeDecoGold3, randomDX, randomDY, randomDX1,
          randomDY1, randomDX2, randomDY2, randomDX3, randomDY3, randomDX4, randomDY4, randomDX5, randomDY5);
      decoracaoComplexaAcima.AcimaDungeon(buffer, lavaNormal, lavaSkull);
    }

    if (tocando) {
      if (!gameOver && !GameFim) {
        MusicPlayer.MusicasFields();
        MusicPlayer.MusicsField();
        MusicPlayer.audioClips.add(MusicPlayer.clipField);
        if (ConfPanel.slider != null) {
          AbaixarOuAumentarMusica.setVolumeForAllClips(ConfPanel.slider.getValue());
        }
        tocando = false;
      }
    }
    if (gameOver || GameFim) {
      MusicPlayer.stopMusicField();
    }
   
    if (snakeClassica && keyListener != null) {
      if (DeathfromHunger) {
        snakeHead = headDeathClassica;
      }
      snake.snakePaint(nodeSnake, buffer, WIDTH, HEIGHT, bodyStraight, bodyCorner, tailImage, snakeHead, keyListener,
          null, null, null);
    }
    if (snakePoison) {
      if (DeathfromHunger) {
        snakeHeadPoison = headDeathPoison;
      }
      snake.snakePaint(nodeSnake, buffer, WIDTH, HEIGHT, bodyStraightPoison, bodyCornerPoison, tailImagePoison,
          snakeHeadPoison, keyListener, manchasAmarelas, null, null);
    }
    if (!colisianEnergySumir) {
      if (snakeFire) {
        if (DeathfromHunger) {
          snakeHeadFire = headDeathFire;
        }
        snake.snakePaint(nodeSnake, buffer, WIDTH, HEIGHT, bodyStraightFire, bodyCornerFire, tailImageFire,
            snakeHeadFire,
            keyListener, null, fogoComplementar, fogoFinal);
      }
    }
   
    if (IniciouEgg) {
      Eggs.EggStart(buffer, PosicaoX, PosicaoY, eggAnimation);
    } else {
      if (Game.RemoverAnimation) {
        Game.ControlOneAnimationEgg = true;
        Game.cobraParadaFinal = true;
      }
      if (!ControlOneAnimationEgg) {
        Eggs.EggBreak(buffer, PosicaoX, PosicaoY, eggAnimationBreak);

      }
    }
    if (Game.ManterAnimation) {
      if (SpreetSheetInitial) {
        Animation.AnimationEnergyTemporary(this, buffer,
            EnergyAnimationBody,
            EnergyAnimationTail, nodeSnake);
      } else if (!SpreetSheetInitial && SpreetSheetFinale) {
        Animation.AnimationEnergyTemporaryFinal(buffer, EnergyAnimationFinal, nodeSnake);
      }
      if (colidianClassico) {
        NumberAnimation.AnimationNumberInitial(this);
        if (possibilitiNumberFinal) {
          NumberAnimation.AnimationNumberFinal(this);
        }
      }
      if (colidianDeath) {
        NumberAnimation.AnimationDeathInitial(this);
        if (possibilitiDeathFinal) {
          NumberAnimation.AnimationDeathFinal(this);
        }
      }
      if (colidianVelocity) {
        NumberAnimation.AnimationVelocityInitial(this);
        if (possibilitiVelocityFinal) {
          NumberAnimation.AnimationVelocityFinal(this);
        }
      }
    }
   
    food.classicFood(g, buffer, macaX, macaY, appleSprit, poisonFruitWidthCla,
        poisonFruitHeightCla);
    food.PoisonFood(g, buffer, macaPOX, macaPOY, applePoison,
        poisonFruitWidthVen, poisonFruitHeightVen);
    food.EnergyFood(this, g, buffer, macaENX, macaENY, appleEnergy,
        poisonFruitWidthErn, poisonFruitHeightErn);

    if (MapField) {
     
      walls.lawnWalls(buffer.getGraphics(), walls_x, walls_y, rockSprit);
      decoracao.decoracaoField(buffer);
    }
    if (MapSwamp) {
      decoracao.decoracaoSwamp(buffer);
    }
    if (MapDungeon) {
      decoracao.decoracaoDungeon(buffer);
    }
    if (Game.ManterAnimation) {
      NumberAnimation.NumberAnimationMais(buffer, NumberMais1, posicaoXNumber, posicaoYNumber, widhtNumberW,
          widhtNumberH, TransparentNumber);
      NumberAnimation.NumberAnimationDeath(buffer, PoisonDeathIcon, posicaoXDeath, posicaoYDeath, widhtDeathW,
          widhtDeathH, TransparentDeath);
      NumberAnimation.NumberAnimationEnergy(buffer, RaioIcon, posicaoXEnergy, posicaoYEnergy, widhtEnergyW,
          widhtEnergyH, TransparentEnergy);
      NumberAnimation.NumberAnimationVelocity(buffer,
          VelocityIcon, posicaoXVelocity, posicaoYVelocity, widhtVelocityW,
          widhtVelocityH, TransparentVelocity);
    }
    if (clickedButtonDifiDificil || clickedButtonDifiNormal) {
      Colidian(rock_swamp, rock_dungeon);
    }

   
    if (Game.ManterAnimation) {
      Animation();
    }
    if (clickedButtonDifiDificil) {
      LifesTimers.LifeSnake(this, buffer, gameOver);
    }

   

    g.drawImage(buffer, 0, 0, null);

   
    if (gameOver) {
      if (!poisonDeathAnimationPlaying && !checkedEsplo && !DeathfromHunger) {
        drawCollisionAnimation(buffer.getGraphics(), rotationAngle);
      }
      g.drawImage(buffer, 0, 0, null);

      GameOver(g);
    }

    if (!gameOver) {
      if (aparecerAposLoading) {
        ComponentesTimerPont(this, g);
        atualizarPontuacao();
      }

     
      if (GameFim) {
        if (ManterAnimation) {
          AnimationFundoVitoria.AnimationVitoria(this, g, getWidth(), getHeight());
        } else {
          Transper = 50;
        }
        GameWinsButtons(g);
      }

    }
    if (Game.ManterAnimation) {
      LoadingApos(g);
    }
  }

  public void LoadingApos(Graphics g) {
    g.setColor(new Color(0, 0, 0, MenuPanel.CorPretaLoading));
    g.fillRect(0, 0, getWidth(), getHeight());
  }

  public void ComponentesTimerPont(Game game, Graphics g) {
    if (GameFim) {
    
      if (GridTimer != null) {
        GridTimer.remove(textpont);
        GridTimer.remove(textTimer);
        GridTimer.remove(lifeEnergyPanel);
        if (InicialRaioPanel != null) {
          GridTimer.remove(InicialRaioPanel);
        }
        GridTimer.revalidate();
        GridTimer.repaint();
      }
      if (timerTempo != null) {
        timerTempo.cancel();
        timerTempo = null;
      }
      return;
    }
    if (!componentesTimerPontAdicionado && !GameFim) {
      Font TimerFont = loadFont.loadFont("resources/fontes/fontGeral.ttf", 16);
      GridTimer = game;
      GridTimer.setLayout(new GridBagLayout());
      gbc = new GridBagConstraints();
     
      pontLabel = new JLabel("Pontuação: " + Pontuacao);
      pontLabel.setFont(TimerFont);
      textpont = new TextShadow("Pontuação: " + Pontuacao, Color.WHITE, Color.DARK_GRAY, TimerFont);
      gbc.gridx = 0;
      gbc.gridy = 0; 
      gbc.anchor = GridBagConstraints.NORTHWEST; 
      gbc.insets = new Insets(5, 5, 0, 0);
      gbc.weightx = 1.0;
      gbc.weighty = 1.0; 
      GridTimer.add(textpont, gbc);
     
      tempoLabel = new JLabel("00:00");
      tempoLabel.setFont(TimerFont);
      textTimer = new TextShadow("00:00", Color.WHITE, Color.DARK_GRAY, TimerFont);
      gbc.anchor = GridBagConstraints.NORTH;
      gbc.insets = new Insets(5, 0, 0, 0);
      gbc.weightx = 0.0;
      gbc.weighty = 1.0; 
      GridTimer.add(textTimer, gbc);
      TimerRelogio();
    
        try {
          String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
          LifeEnergyPanel.ImageLifeEnergy = ImageIO.read(new File(basePath + "snakes" + File.separator + "timerEnergySnake.png"));
          RaioInicial = ImageIO.read(new File(basePath + "snakes" + File.separator + "InicialRaio.png"));
      } catch (IOException ex) {
          ex.printStackTrace();
      }
  
      if (Game.ManterAnimation) {
        BufferedImage InitialRaio = RaioInicial;
        int numFramesXInicial = 1;
        int numFramesYInicial = 7;
        InicialRaioPanel = new InicialRaio(InitialRaio, numFramesXInicial, numFramesYInicial);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        GridTimer.add(InicialRaioPanel, gbc);
      }
    
      BufferedImage lifeEnergyImage = LifeEnergyPanel.ImageLifeEnergy;
      int numFramesX = 2;
      int numFramesY = 11;
      lifeEnergyPanel = new LifeEnergyPanel(g, lifeEnergyImage, numFramesX, numFramesY);
      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.anchor = GridBagConstraints.SOUTH;
      gbc.fill = GridBagConstraints.NONE;
      gbc.insets = new Insets(10, 0, 0, 0);
      gbc.weightx = 1.0; 
      gbc.weighty = 0.0; 
      GridTimer.add(lifeEnergyPanel, gbc);

      if (!GameFim) {
        GridTimer.revalidate();
        GridTimer.repaint();
      }
      componentesTimerPontAdicionado = true; 
    }
  }

  public void TimerRelogio() {
    if (timerTempo != null || gameOver) {
      timerTempo.cancel();
      timerTempo.purge();
    }
    timerTempo = new Timer();
    timerTempo.scheduleAtFixedRate(new TimerTask() {
      DecimalFormat df = new DecimalFormat("00");

      @Override
      public void run() {
        if (!IniciouEgg) {
          seconds++;
          Minutos = seconds / 60;
          Segundos = seconds % 60;
        }

        timeText = df.format(Minutos) + ":" + df.format(Segundos);
        SwingUtilities.invokeLater(() -> tempoLabel.setText(timeText));
        SwingUtilities.invokeLater(() -> textTimer.setText(timeText));
      }
    }, 0, 1000); 
  }

  public void atualizarPontuacao() {
    if (colidindoPontuacao) {
      Pontuacao++;
      textpont.setText("Pontuação: " + Pontuacao);
      GridTimer.repaint();
      colidindoPontuacao = false;
    }
  }

  private void addCenteredComponent(Container container, Component component, int gridy) {
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx = 0;
    constraints.gridy = gridy;
    constraints.anchor = GridBagConstraints.CENTER;
    constraints.insets = new Insets(10, 0, 10, 0);
    container.add(component, constraints);
  }

  private ImageIcon makeTransparent(String imagePath, float Transper) {
    ImageIcon icon = new ImageIcon(imagePath);
    Image image = icon.getImage();

 
    BufferedImage transparentImage = new BufferedImage(300, 100,
        BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = transparentImage.createGraphics();
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Transper));
    g2d.drawImage(image, 0 + 50, 0 + 25, 220, 50, null);
    g2d.dispose();

    return new ImageIcon(transparentImage);
  }

  public static void SystemLiberationMap() {
    if (MapField && !ZerouMapaField) {
      ZerouMapaField = true;
      MapLiberation = "Pântano";
      Game.NotificationGameDesblocked = true;
      DesblockedPontuation--;
    }
    if (MapSwamp && !ZerouMapaSwamp) {
      ZerouMapaSwamp = true;
      MapLiberation = "Masmorra";
      SnakeLiberation = "Venenosa";
      Game.NotificationGameDesblocked = true;
      DesblockedPontuation--;
    }
    if (MapDungeon && DesblockedPontuation == 1) {
      ZerouMapaDungeon = true;
      MapLiberation = "";
      SnakeLiberation = "Boitata";
      Game.NotificationGameDesblocked = true;
      DesblockedPontuation--;
    }
  }

  public void GameWinsButtons(Graphics g) {
    

    meuPainelButtons = this;
    g.setColor(new Color(128, 255, 125, Transper));
    g.fillRect(0, 0, getWidth(), getHeight());
  
    boolean newGameButtonExists = false;
    for (int i = 0; i < meuPainelButtons.getComponentCount(); i++) {
      Component comp = meuPainelButtons.getComponent(i);
      if (comp instanceof JButton && ((JButton) comp).getText().equals("Inicio")) {
        newGameButtonExists = true;
        break;
      }
    }

    if (!newGameButtonExists) {
      MusicPlayer.AudioGameWins();

      MusicPlayer.stopEnergytime();
      meuPainelButtons.setLayout(new GridBagLayout());
      try {
          String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
          Vitoria = ImageIO.read(new File(basePath + "fontes" + File.separator + "vitoria.png"));
          animatiomVictory = ImageIO.read(new File(basePath + "animationVictory.png"));
      } catch (IOException e) {
          e.printStackTrace();
      }
      GridGameWins = new GridBagConstraints();
      GridGameWins.gridx = 0;
      GridGameWins.gridy = 0;
      GridGameWins.insets = new Insets(0, 0, 0, 0); 
      GridGameWins.anchor = GridBagConstraints.CENTER;
     
      customFont = loadFont.loadFont("resources/fontes/fontGeral.ttf", 32);
      textShadowLabel = new TextShadow("Região Dominada!", 
          new Color(255, 255, 255, 0), new Color(0, 0, 0, 0), customFont);
      GridGameWins.gridy = 0;
      meuPainelButtons.add(textShadowLabel, GridGameWins);
     
      if (ManterAnimation) {
        delay2 = 3000;
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
          @Override
          public void run() {
            SwingUtilities.invokeLater(() -> {
              if (Vitoria != null) {
                GridGameWins.gridy = 1;
                imagePanel = new ImagePanel(Vitoria, vitoriaHeight, vitoriaWidth);
                meuPainelButtons.add(imagePanel, GridGameWins);
              }
            });
          }
        }, delay2);
      } else {
        GridGameWins.gridy = 1;
        vitoriaHeight = 149;
        vitoriaWidth = 299;
        imagePanel = new ImagePanel(Vitoria, vitoriaHeight, vitoriaWidth);
        resizeImagePanel();
        meuPainelButtons.add(imagePanel, GridGameWins);
      }
     
      if (ManterAnimation) {
        delay1 = 5000;
        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
          @Override
          public void run() {
            SwingUtilities.invokeLater(() -> {
              if (animatiomVictory != null) {
                MusicPlayer.explosao();
                GridGameWins.gridy = 1;
                animationPanel = new ImagePanel2(animatiomVictory, animatiomVictory.getWidth() / 3,
                    animatiomVictory.getHeight() / 5, 100);
                meuPainelButtons.add(animationPanel, GridGameWins);
              }
            });
          }
        }, delay1);
      }
      GridGameWins.gridy = 2;
    
      if (ManterAnimation) {
        sizeDificult = 32;
        colorTransparente = 0;
      } else {
        sizeDificult = 12;
        colorTransparente = 255;
      }
      Fonts = loadFont.loadFont("resources/fontes/fontGeral.ttf", sizeDificult);
      fontesGameWins = Fonts.deriveFont((float) sizeDificult);
      fontesGameWinsButton = Fonts.deriveFont((float) 26);
     
      DificuldadeLabel = new JLabel("Dificuldade");
      DificuldadeLabel.setFont(Fonts);
      DificultytextShadowLabel = new TextShadow("Dificuldade", new Color(255, 255,
          255,
          colorTransparente),
          new Color(0, 0, 0,
              colorTransparente),
          fontesGameWins);
      meuPainelButtons.add(DificultytextShadowLabel, GridGameWins);
     
      GridGameWins.gridy = 3;
      JLabel dificulting = new JLabel(dificulty);
      dificulting.setFont(Fonts);
      if (dificulty == "Normal") {
        CorDificulty = Color.YELLOW;
      } else if (dificulty == "Fácil") {
        CorDificulty = Color.GREEN;
      }
      if (dificulty == "Difícil") {
        CorDificulty = Color.RED;
      }
      if (ManterAnimation) {
        DificultytextShadowLabel2 = new TextShadow(dificulty,
            new Color(0, 0, 0,
                0),
            new Color(0, 0, 0, 0),
            fontesGameWins);
      } else {
        DificultytextShadowLabel2 = new TextShadow(dificulty,
            CorDificulty, new Color(0, 0, 0, colorTransparente),
            fontesGameWins);
      }

      GridGameWins.insets = new Insets(0, 0, 5, 0);
      meuPainelButtons.add(DificultytextShadowLabel2, GridGameWins);
      
      GridGameWins.gridy = 4;
      JLabel TempoLabel = new JLabel("Tempo de Partida");
      TempoLabel.setFont(fontesGameWins);
      TempotextShadowLabel = new TextShadow("Tempo de Partida", new Color(255, 255, 255,
          colorTransparente),
          new Color(0, 0, 0,
              colorTransparente),
          fontesGameWins);
      GridGameWins.insets = new Insets(0, 0, 0, 0);
      meuPainelButtons.add(TempotextShadowLabel, GridGameWins);
     
      GridGameWins.gridy = 5;
      JLabel TempoLabel2 = new JLabel(timeText);
      TempoLabel2.setFont(fontesGameWins);
      TempotextShadowLabel2 = new TextShadow(timeText, new Color(0, 255, 255,
          colorTransparente), new Color(0, 0, 0, colorTransparente), fontesGameWins);
      GridGameWins.insets = new Insets(0, 0, 5, 0);
      meuPainelButtons.add(TempotextShadowLabel2, GridGameWins);
    
      GridGameWins.gridy = 6;
      JLabel PontLabel = new JLabel("Pontuação");
      PontLabel.setFont(fontesGameWins);
      PonttextShadowLabel = new TextShadow("Pontuação", new Color(255, 255, 255,
          colorTransparente), new Color(0, 0, 0, colorTransparente), fontesGameWins);
      GridGameWins.insets = new Insets(0, 0, 0, 0);
      meuPainelButtons.add(PonttextShadowLabel, GridGameWins);
     
      GridGameWins.gridy = 7;
      JLabel PontLabel2 = new JLabel("" + Game.Pontuacao);
      PontLabel2.setFont(fontesGameWins);
      PonttextShadowLabel2 = new TextShadow("" + Game.Pontuacao, new Color(192, 192, 192,
          colorTransparente),
          new Color(0, 0, 0,
              colorTransparente),
          fontesGameWins);
      GridGameWins.insets = new Insets(0, 0, 10, 0);
      meuPainelButtons.add(PonttextShadowLabel2, GridGameWins);
    
      GridGameWins.gridy = 8;
      float initialTransparency = 0.0f;
      ImageIcon buttonImage = makeTransparent("resources/Menu/buttonRock.png", initialTransparency);
      JButton RevertMenuButton = new JButton("Inicio", buttonImage);
      Font revertmenuFont = fontesGameWinsButton;
      MenuPanel.addShadow(RevertMenuButton, "Inicio", revertmenuFont, 220, 50, false);
      RevertMenuButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          MusicPlayer.musicMenu();
          if (ConfPanel.slider != null) {
            AbaixarOuAumentarMusica.setVolumeForAllClips(ConfPanel.slider.getValue());
          }

          JFrame GameSnake = (JFrame) SwingUtilities.getWindowAncestor(Game.this);
          GameSnake.getContentPane().removeAll();
         
          Game.PodeIniciarPosLoading = false;
          Game.aparecerAposLoading = false;
          MenuPanel.CorPretaLoading = 255;
          if (AnimationLoadingPanel.timerLoading != null) {
            AnimationLoadingPanel.timerLoading.cancel();
            AnimationLoadingPanel.timerLoading.purge();
          }
          AnimationLoadingPanel.timerLoading = new Timer();
          Transper = 0;
          vitoriaWidth = 0;
          vitoriaHeight = 0;
          AnimationGameFim.increaseSizeVen = true;
          if (AnimationGameFim.vitoriaTemp != null) {
            AnimationGameFim.vitoriaTemp.cancel();
            AnimationGameFim.vitoriaTemp.purge();
          }
          AnimationGameFim.vitoriaTemp = new Timer();
          restartGame();
          SystemLiberationMap();
          if (DesblockedPontuation >= 1) {
            NotificationDesblocked.SumirFundo = false;
          }
          GameSnake.add(new MenuPanel());
          GameSnake.revalidate();
          GameSnake.repaint();

        }
      });
      meuPainelButtons.add(RevertMenuButton, GridGameWins);
      meuPainelButtons.revalidate(); 
      meuPainelButtons.repaint(); 

     
      if (ManterAnimation) {
        delay0 = 1000;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
          @Override
          public void run() {
            SwingUtilities.invokeLater(() -> {
              QuantiTempoGameFim++;
              if (QuantiTempoGameFim == 6) {
                SelectionText();
                meuPainelButtons.add(textShadowLabel, 0);
                meuPainelButtons.revalidate();
                meuPainelButtons.repaint();
              }

              if (QuantiTempoGameFim == 12) {
                MenuPanel.addShadow(RevertMenuButton, "Inicio", revertmenuFont, 220, 50, true);
                float finalTransparency = 1.0f;
                ImageIcon buttonImage = makeTransparent("resources/Menu/buttonRock.png", finalTransparency);
                RevertMenuButton.setIcon(buttonImage);
                meuPainelButtons.revalidate();
                meuPainelButtons.repaint();
              }
            });
          }
        }, 0, delay0);
      } else if (RemoverAnimation) {
        SelectionText();
        meuPainelButtons.add(textShadowLabel, 0);
        meuPainelButtons.revalidate();
        meuPainelButtons.repaint();
        MenuPanel.addShadow(RevertMenuButton, "Inicio", revertmenuFont, 220, 50, true);
        float finalTransparency = 1.0f;
        ImageIcon buttonImage2 = makeTransparent("resources/Menu/buttonRock.png", finalTransparency);
        RevertMenuButton.setIcon(buttonImage2);
        meuPainelButtons.revalidate();
        meuPainelButtons.repaint();
      }
    }
  }

  public void SelectionText() {
    if (MapField) {
      if (ZerouMapaField) {
        textShadowLabel = new TextShadow("Região Mantida!", 
            Color.WHITE, Color.BLACK, customFont);
      } else if (!ZerouMapaField) {
        textShadowLabel = new TextShadow("Região Dominada!", 
            Color.WHITE, Color.BLACK, customFont);
      }
    } else if (MapSwamp) {
      if (ZerouMapaSwamp) {
        textShadowLabel = new TextShadow("Região Mantida!", 
            Color.WHITE, Color.BLACK, customFont);
      } else if (!ZerouMapaSwamp) {
        textShadowLabel = new TextShadow("Região Dominada!", 
            Color.WHITE, Color.BLACK, customFont);
      }
    } else if (MapDungeon) {
      if (ZerouMapaDungeon) {
        textShadowLabel = new TextShadow("Região Mantida!",
            Color.WHITE, Color.BLACK, customFont);
      } else if (!ZerouMapaDungeon) {
        textShadowLabel = new TextShadow("Região Dominada!", 
            Color.WHITE, Color.BLACK, customFont);
      }
    }
  }

  public void resizeImagePanel() {
    if (imagePanel != null) {
      imagePanel.updateImageSize(vitoriaWidth, vitoriaHeight);
    }
  }

  public void GameOver(Graphics g) {

    meuPainel.setLayout(new GridBagLayout());
 
    Game game = this;
  
    g.setColor(new Color(0, 0, 0, 127));
    g.fillRect(0, 0, getWidth(), getHeight());
    
    boolean newGameButtonExists = false;
    for (int i = 0; i < this.getComponentCount(); i++) {
      if (this.getComponent(i) instanceof JButton) {
        button = (JButton) this.getComponent(i);
        if (button.getText().equals("Reiniciar")) {
          newGameButtonExists = true;
          break;
        }
      }
    }
    if (!newGameButtonExists) {
      MusicPlayer.AudioGameOver();
      MusicPlayer.stopEnergytime();
      Font customFontGameOver = loadFont.loadFont("resources/fontes/fontGeral.ttf", 16);
      Font derivateFont = customFontGameOver.deriveFont((float) 22);
     
      meuPainel.removeAll();
      youLose = new TextShadow("Você Morreu!", 
          Color.WHITE, Color.BLACK, derivateFont);
      meuPainel.add(youLose);

      buttonImage = new StretchIcon("resources/Menu/buttonRock.png");
      newGameButton = new JButton("Reiniciar", buttonImage);
      newgameFont = derivateFont;

      newGameButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          meuPainel.remove(RevertMenuButton);
          meuPainel.remove(newGameButton);
          meuPainel.remove(youLose);
          meuPainel.remove(textPontGameOver);
          meuPainel.remove(textPontGameOver1);
          restartGame();
          new Thread(game).start();
        }
      });
      meuPainel.add(newGameButton); 
      MenuPanel.addShadow(newGameButton, "Reiniciar", newgameFont, 150, 50, false);
      addCenteredComponent(meuPainel, newGameButton, 1);

      RevertMenuButton = new JButton("Inicio", buttonImage);
      revertmenuFont = derivateFont;
      MenuPanel.addShadow(RevertMenuButton, "Inicio", revertmenuFont, 150, 50, false);
      RevertMenuButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          MusicPlayer.musicMenu();
          if (ConfPanel.slider != null) {
            AbaixarOuAumentarMusica.setVolumeForAllClips(ConfPanel.slider.getValue());
          }

          Game.aparecerAposLoading = false;
          Game.PodeIniciarPosLoading = false;
          MenuPanel.CorPretaLoading = 255;
          if (AnimationLoadingPanel.timerLoading != null) {
            AnimationLoadingPanel.timerLoading.cancel();
            AnimationLoadingPanel.timerLoading.purge();
          }
          AnimationLoadingPanel.timerLoading = new Timer();
          JFrame GameSnake = (JFrame) SwingUtilities.getWindowAncestor(Game.this);
          meuPainel.remove(RevertMenuButton);
          restartGame();
          GameSnake.getContentPane().removeAll();
          GameSnake.add(new MenuPanel());
          GameSnake.revalidate();
          GameSnake.repaint();
        }
      });
      meuPainel.add(RevertMenuButton); 
      addCenteredComponent(meuPainel, RevertMenuButton, 2);
      //
      textPontGameOver = new TextShadow("Pontuação: " + Pontuacao, 
          Color.WHITE, Color.BLACK, customFontGameOver);
      meuPainel.add(textPontGameOver);
      addCenteredComponent(meuPainel, textPontGameOver, 3);
      //
      textPontGameOver1 = new TextShadow("Tempo de Partida: " + timeText,
          Color.WHITE, Color.BLACK, customFontGameOver);
      meuPainel.add(textPontGameOver1);
      addCenteredComponent(meuPainel, textPontGameOver1, 4);
      meuPainel.revalidate(); 
      meuPainel.repaint(); 
    }
  }

  public void Colidian(Image rock_swamp, Image rock_dungeon) {
    g2d = buffer.createGraphics();
    if (MapField) {
      for (int x = 0; x < FrameWidth; x += borderWidth) {
        g2d.drawImage(painelRock, x, 0, borderWidth, borderWidth, null); 
        g2d.drawImage(painelRock, x, FrameHeight - borderWidth, borderWidth, borderWidth, null);
      }
      for (int y = 0; y < FrameHeight; y += borderWidth) {
        g2d.drawImage(painelRock, 0, y, borderWidth, borderWidth, null);
        g2d.drawImage(painelRock, FrameWidth - borderWidth, y, borderWidth, borderWidth, null);
      }
    }
    if (MapSwamp) {
      for (int x = 0; x < FrameWidth; x += borderWidth) {
        g2d.drawImage(rock_swamp, x, 0, borderWidth, borderWidth, null); 
        g2d.drawImage(rock_swamp, x, FrameHeight - borderWidth, borderWidth, borderWidth, null); 
      }
      for (int y = 0; y < FrameHeight; y += borderWidth) {
        g2d.drawImage(rock_swamp, 0, y, borderWidth, borderWidth, null);
        g2d.drawImage(rock_swamp, FrameWidth - borderWidth, y, borderWidth, borderWidth, null); 
      }
    }
    if (MapDungeon) {
      for (int x = 0; x < FrameWidth; x += borderWidth) {
        g2d.drawImage(rock_dungeon, x, 0, borderWidth, borderWidth, null); 
        g2d.drawImage(rock_dungeon, x, FrameHeight - borderWidth, borderWidth, borderWidth, null); 
      }
      for (int y = 0; y < FrameHeight; y += borderWidth) {
        g2d.drawImage(rock_dungeon, 0, y, borderWidth, borderWidth, null); 
        g2d.drawImage(rock_dungeon, FrameWidth - borderWidth, y, borderWidth, borderWidth, null); 
      }
    }
  }

 
  public void tick() {
    VerificDistance = keyListener.getVerif();
    for (int z = 0; z < nodeSnake.length; z++) {
      int currX = nodeSnake[z].x;
      int currY = nodeSnake[z].y;
      int prevX = z > 0 ? nodeSnake[z - 1].x : currX;
      int prevY = z > 0 ? nodeSnake[z - 1].y : currY;
      int nextX = z < nodeSnake.length - 1 ? nodeSnake[z + 1].x : currX;
      int nextY = z < nodeSnake.length - 1 ? nodeSnake[z + 1].y : currY;
      boolean isCorner = (prevX != nextX) && (prevY != nextY);

      if (VerificDistance && isCorner) {
        DISTANCE = 5;
      } else {
        DISTANCE = 1;
      }
    }

    if (nodeSnake.length >= TamanhoFinal) {
      GameFim = true;
    }
    if (ControlVelocityFinal == 350) {
      VelocityFinal = true;
    }
    if (VelocityControl) {
      if (snakeFire) {
        ControlVelocityFinal = (ControlVelocity - 100);
      } else {
        ControlVelocityFinal = (ControlVelocity - 300);
      }
    } else {
      if (snakeFire) {
        ControlVelocityFinal = ControlVelocity - 100;
      } else {
        ControlVelocityFinal = ControlVelocity;
      }
    }
    if (SubindoNivel == 3) {
      posicaoXVelocity = nodeSnake[0].x;
      posicaoYVelocity = nodeSnake[0].y;
      NovaPosicaoVelocity0 = Game.posicaoYVelocity - 40;
      widhtVelocityW = 0;
      widhtVelocityH = 0;
      Game.TransparentVelocity = 0.1f;
      NumberAnimation.restartAnimationVelocity(this);
      colidianVelocity = true;
      if (!VelocityFinal) {
        ControlVelocity -= 25;
      }
      SubindoNivel = 0;

      MusicPlayer.aumentovelocity3x();
    }

   
    if (cobraParada) {
      if (cobraParadaFinal) {
        move.SnakeMove(nodeSnake, keyListener.getDirection(), DISTANCE);
      }
    }
    headCollisionArea = new Rectangle(nodeSnake[0].x - largerCollisionArea / 2,
        nodeSnake[0].y - largerCollisionArea / 2, 8 + largerCollisionArea, 8 + largerCollisionArea);

    headCollisionAreaPO = new Rectangle(nodeSnake[0].x - 12 / 2, nodeSnake[0].y - 60 / 2, 10, 15);

    ArrayList<Point> foodPositions = LocaleUtils.LocateFood(FrameWidth, FrameHeight, WIDTH, HEIGHT, walls_x, walls_y,
        nodeSnake);

    Rectangle fruitArea = new Rectangle(macaX, macaY, WIDTH, HEIGHT);
    Rectangle fruitPOArea = new Rectangle(macaPOX, macaPOY, 20, 20);
    ////////////
    if (headCollisionArea.intersects(fruitArea)) {
      ControlOneAnimationClassicAtivar = true;
      PosColidianClassicX = macaX;
      PosColidianClassicY = macaY;

      if (snakeClassica || snakeFire) {
        colidindoPontuacao = true;
        SubindoNivel++;
        posicaoXNumber = PosColidianClassicX;
        posicaoYNumber = PosColidianClassicY;
        NovaPosicao0 = Game.posicaoYNumber - 40;
        widhtNumberW = 0;
        widhtNumberH = 0;
        Game.TransparentNumber = 0.1f;
        NumberAnimation.restartAnimation(this);
        colidianClassico = true;
        MusicPlayer.HeatFood();
      }
      if (snakePoison) {
        posicaoXDeath = PosColidianClassicX;
        posicaoYDeath = PosColidianClassicY;
        NovaPosicaoDeath0 = Game.posicaoYDeath - 40;
        widhtDeathW = 0;
        widhtDeathH = 0;
        Game.TransparentDeath = 0.1f;
        NumberAnimation.restartAnimationDeath(this);
        colidianDeath = true;

        MusicPlayer.colisianpoisonfood();
      }
      if (foodPositions.size() >= 2) {
        Point foodPosition0 = foodPositions.get(0);
        macaX = foodPosition0.x;
        macaY = foodPosition0.y;
        ControlOneAnimationClassic = false;
      }
      if (snakeClassica || snakeFire) {
        if (!colidionClaControlTimerAnimation) {
          if (ManterAnimation) {
            Animation.AnimationFoodCla(this);
          }
        }
      }

      if (!ColidionEnergyConfirmed) {
        ColidionEnergyCla = true;
      }
      if (Game.snakePoison) {
        ControlOneAnimationPoison = true;
        animationFinished = false;
        poisonDeathAnimationPlaying = true;
        venomAnimationPlayed = true;
        if (!gameOver) {
          AnimationSnakeDeath.AnimationSnake(this, foodPositions);
        }
        lastVenomAnimationTime1 = System.currentTimeMillis();
      }

      if (Game.snakeClassica || Game.snakeFire) {
        for (int i = 0; i < 10; i++) {
         
          int lastIndex = nodeSnake.length - 1;
          Node newTailNode = new Node(nodeSnake[lastIndex].x, nodeSnake[lastIndex].y);

       
          int dx = nodeSnake[lastIndex].x - nodeSnake[lastIndex - 1].x;
          int dy = nodeSnake[lastIndex].y - nodeSnake[lastIndex - 1].y;

         
          newTailNode.x += dx;
          newTailNode.y += dy;

        
          nodeSnake = Arrays.copyOf(nodeSnake, nodeSnake.length + 1);
          nodeSnake[lastIndex + 1] = newTailNode;
        }
      }
    }
   
    if (headCollisionAreaPO.intersects(fruitPOArea)) {
      PosColidianPoisonX = macaPOX;
      PosColidianPoisonY = macaPOY;
      if (snakePoison) {
        colidindoPontuacao = true;
        SubindoNivel++;
        posicaoXNumber = PosColidianPoisonX;
        posicaoYNumber = PosColidianPoisonY + 30;
        NovaPosicao0 = Game.posicaoYNumber - 40;
        widhtNumberW = 0;
        widhtNumberH = 0;
        Game.TransparentNumber = 0.1f;
        NumberAnimation.restartAnimation(this);
        colidianClassico = true;
        MusicPlayer.HeatFood();
      }
      if (snakeClassica || snakeFire) {
        posicaoXDeath = PosColidianPoisonX;
        posicaoYDeath = PosColidianPoisonY;
        NovaPosicaoDeath0 = Game.posicaoYDeath - 40;
        widhtDeathW = 0;
        widhtDeathH = 0;
        Game.TransparentDeath = 0.1f;
        NumberAnimation.restartAnimationDeath(this);
        colidianDeath = true;
        MusicPlayer.colisianpoisonfood();
      }
    }
    if (!colisionControlPoison) {
      if (headCollisionAreaPO.intersects(fruitPOArea)) {

        if (foodPositions.size() >= 2) {
          Point foodPosition1 = foodPositions.get(1);

          macaPOX = foodPosition1.x;
          macaPOY = foodPosition1.y;
          ControlOneAnimationPoison = false;
        }
        if (snakePoison) {
          for (int i = 0; i < 10; i++) {
         
            int lastIndex = nodeSnake.length - 1;
            Node newTailNode = new Node(nodeSnake[lastIndex].x, nodeSnake[lastIndex].y);

          
            int dx = nodeSnake[lastIndex].x - nodeSnake[lastIndex - 1].x;
            int dy = nodeSnake[lastIndex].y - nodeSnake[lastIndex - 1].y;

           
            newTailNode.x += dx;
            newTailNode.y += dy;

         
            nodeSnake = Arrays.copyOf(nodeSnake, nodeSnake.length + 1);
            nodeSnake[lastIndex + 1] = newTailNode;
          }
          if (!ColidionEnergyConfirmed) {
            ColidionEnergyCla = true;
          }
        }

        animationFinished = false;
        venomAnimationPlayed = false;
        if (snakePoison) {
          if (!colidionPoiControlTimerAnimation) {
            AnimationPOison.AnimationFoodClaInicColision(this);
          }
        }

        if (snakeClassica || snakeFire) {
          poisonDeathAnimationPlaying = true;
          if (!colidionPoiControlTimerAnimation) {
            AnimationPOison.AnimationFoodVenInicColision(this);
          }
          lastVenomAnimationTime1 = System.currentTimeMillis();
          if (snakeClassica) {
            if (!gameOver) {
              AnimationSnakeDeath.AnimationSnake(this, foodPositions);
            }
          }
        } else {
          poisonDeathAnimationPlaying = false;
        }

      }
    }

    AnimationControlPoison animationControlPoison = new AnimationControlPoison();
    animationControlPoison.updateVenomAnimation(this);

    AnimationEnergyControl animationEnergyControl = new AnimationEnergyControl();
    animationEnergyControl.updateEnergyAnimation(this, buffer, explosionDeath);

    Game gaming = this;
    if (GameFim) {
      if (ManterAnimation) {
        int delay2 = 4000;
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
          @Override
          public void run() {
            AnimationGameFim.AnimationVitoria(gaming);
          }
        }, delay2);
        //

        int delay3 = 1000;
        timerLabelsGameWins = new Timer();
        timerLabelsGameWins.scheduleAtFixedRate(new TimerTask() {
          int Contador = 0;

          @Override
          public void run() {
            Contador++;
            if (Contador == 8) {
              AnimationFontGameFim.AnimationFontDificulty(gaming);
              MusicPlayer.DetailsGameWins();
            }
            if (Contador == 9) {
              AnimationFontGameFim.AnimationFontTempo(gaming);
              MusicPlayer.DetailsGameWins();
            }
            if (Contador == 10) {
              AnimationFontGameFim.AnimationFontPontuacao(gaming);
              MusicPlayer.DetailsGameWins();
            }
            if (Contador == 11) {
              timerLabelsGameWins.cancel();
            }
          }
        }, 0, delay3);
      }
    }
    if (ManterAnimation) {
      AnimationLoadingPanel.AnimationLoading(this);
    }
  }

  public void StartSnake() {

  
    int snakeX, snakeY; 
    boolean tooCloseToWallSnake; 

    do {
   
      snakeX = new Random().nextInt(FrameWidth - WIDTH);
      snakeY = new Random().nextInt(FrameWidth - WIDTH);

      tooCloseToWallSnake = false; 

    
      for (int i = 0; i < walls_x.size(); i++) {
        Rectangle wallRect = new Rectangle(walls_x.get(i), walls_y.get(i), WIDTH, HEIGHT);
        Rectangle snakeRect = new Rectangle(snakeX, snakeY, WIDTH, HEIGHT);

        if (wallRect.contains(snakeRect)) {
          tooCloseToWallSnake = true; 
          break; 
        }
      }

    } while (tooCloseToWallSnake
        || CollisionUtils.ThisNearBorder(snakeX, snakeY, FrameWidth, FrameHeight, WIDTH, HEIGHT)
        || CollisionUtils.ThisNearWalls(snakeX, snakeY, walls_x, walls_y, WIDTH, HEIGHT) || CollisionUtils
            .ThisDecoration(snakeX, snakeY, DecoracaoX, DecoracaoY, DecoComplexoY, DecoComplexoX, WIDTH, HEIGHT));

  
    nodeSnake[0] = new Node(snakeX, snakeY);
 
    for (int i = 1; i < nodeSnake.length; i++) {
      nodeSnake[i] = new Node(snakeX, snakeY);
    }

  }

  public void restartGame() {

    DeathfromHunger = false;
    GameFim = false;
    direction = 0;
    TimerVerif = false;
    gameOver = false;
    cobraParada = false;
    cobraParadaFinal = false;
    score = 0;
    if (MapField) {
      walls_x.clear();
      walls_y.clear();
      ArrayList<ArrayList<Integer>> walls = LocaleUtils.LocateWall(FrameWidth,
          FrameHeight, WIDTH, HEIGHT, 20);
      walls_x = walls.get(0);
      walls_y = walls.get(1);
    }
    Game.nodeSnake = Game.ComprimentoCobra;
    initializeKeyListener();
    snakeHead = originalSnakeHeadClassica;
    snakeHeadPoison = originalSnakeHeadPoison;
    snakeHeadFire = originalSnakeHeadFire;
    StartSnake();

    PosicaoX = nodeSnake[0].x;
    PosicaoY = nodeSnake[0].y;
    IniciouEgg = true;
    ArrayList<Point> foodPositions = LocaleUtils.LocateFood(FrameWidth, FrameHeight, WIDTH, HEIGHT, walls_x, walls_y,
        nodeSnake);
    if (foodPositions.size() >= 2) {
      Point foodPosition0 = foodPositions.get(0);
      Point foodPosition1 = foodPositions.get(1);
      if (snakePoison) {
        macaX = -100;
        macaY = -100;
      } else {
        macaX = foodPosition0.x;
        macaY = foodPosition0.y;
      }
      if (snakeClassica || snakeFire) {
        macaPOX = -100;
        macaPOY = -100;
      } else {
        macaPOX = foodPosition1.x;
        macaPOY = foodPosition1.y;
      }
      macaENX = -100;
      macaENY = -100;
    }
    tocando = true;
    Location_deco();
    ControlTamanho = false;
    ValueFinal = 0;
    ValueDecoComplexo = 0;
    ValueDecoNormal = 0;
    quanti.clear();
    quantiComplexo.clear();
    valueFireX.clear();
    valueFireY.clear();
    Game.DecoracaoX = new int[0];
    Game.DecoracaoY = new int[0];
    Game.DecoComplexoX = new int[0];
    Game.DecoComplexoY = new int[0];
    decoracao.posicoesDeco(FrameWidth, FrameHeight, ALL_DOTS_Width, ALL_DOTS_Height, walls_x, walls_y);
    checkedEsplo = false;
    ControlVelocityFinal = 0;
    SubindoNivel = 0;
    animationFinished = true;
    poisonDeathAnimationPlaying = false;
    venomAnimationPlayed = false;
    ernegyAnimationPlayed = false;
    lastVenomAnimationTime1 = System.currentTimeMillis(); 
    TeleportEnergyVerif = System.currentTimeMillis();
    lastVenomAnimationTimeEnergy = System.currentTimeMillis();
    ControlTimerVelocity = System.currentTimeMillis();
    ControlAPOSSuporte = System.currentTimeMillis();
    ControlSpriteSheet = System.currentTimeMillis();
    ControlSpriteSheetColidion = System.currentTimeMillis();
    TimerVerif = false;
    count = 0;
    VelocityControl = false;
    ColidionEnergyCla = false;
    ColidionEnergyConfirmed = false;
    ControlTeleport = false;
    Segunds = false;
    ControlColisionEnergy = false;
    ColisionEnergy = false;
    SpreetSheetInitial = false;
    SpreetSheetFinale = false;
    ControlAPOSColidionTimer = false;
    ControlEnergyColidianBoolean = false;
    ControlOneAnimationClassicAtivar = false;
    ControlOneAnimationEgg = false;
    colisianEnergyMorrer = false;
    colisianEnergySumir = false;
    ControlOneAnimationESPLO = true;
   
    NovaPosicao0 = 0;
    posicaoXNumber = 0;
    posicaoYNumber = 0;
    widhtNumberW = 0;
    widhtNumberH = 0;
    TransparentNumber = 0.1f;
    possibilitiNumberFinal = false;
    colidianClassico = false;
   
    NovaPosicaoDeath0 = 0;
    posicaoXDeath = 0;
    posicaoYDeath = 0;
    widhtDeathW = 0;
    widhtDeathH = 0;
    TransparentDeath = 0.1f;
    possibilitiDeathFinal = false;
    colidianDeath = false;
    
    NovaPosicaoEnergy0 = 0;
    posicaoXEnergy = 0;
    posicaoYEnergy = 0;
    widhtEnergyW = 0;
    widhtEnergyH = 0;
    TransparentEnergy = 0.1f;
    possibilitiEnergyFinal = false;
    colidianEnergy = false;
   
    NumberAnimation.restartAnimation(this);
    NumberAnimation.restartAnimationDeath(this);
    NumberAnimation.restartAnimationEnergy(this);
    NumberAnimation.restartAnimationVelocity(this);
   
    NovaPosicaoVelocity0 = 0;
    posicaoXVelocity = 0;
    posicaoYVelocity = 0;
    widhtVelocityW = 0;
    widhtVelocityH = 0;
    TransparentVelocity = 0.1f;
    possibilitiVelocityFinal = false;
   
    ControlVelocity = 1200;
    ControlVelocityFinal = 1200;
    if (clickedButtonDifiDificil) {
      ControlVelocity = 500;
      ControlVelocityFinal = 500;
    }
    VelocityFinal = false;

    currentFrame1 = 0;
    currentFrame4 = 0;
    currentFrame3 = 0;
    currentFrame2 = 0;
    currentFrame5 = 0;
    currentFrame6 = 0;
    currentFrame7 = 0;
    currentFrame8 = 0;
    currentFrame9 = 0;
    currentFrame10 = 0;
    currentFrame11 = 0;
    currentFrame12 = 0;
    currentFrame13 = 0;
    currentFrame14 = 0;
    currentFrame15 = 0;
    currentFrame16 = 0;
    currentFrame17 = 0;
    currentFrame18 = 0;
    currentFrame19 = 0;
    currentFrame20 = 0;
    currentFrame21 = 0;
    currentFrame22 = 0;
    currentFrame23 = 0;
    currentFrame24 = 0;
    currentFrame25 = 0;
    currentFrame26 = 0;
    currentFrame27 = 0;
    currentFrame28 = 0;
    currentFrame29 = 0;
    currentFrame30 = 0;
    currentFrame31 = 0;
    currentFrame32 = 0;
    currentFrame33 = 0;
    currentFrame34 = 0;
    seconds = 0;
    Minutos = 0;
    Segundos = 0;
    Pontuacao = 0;
    if (textpont != null) {
      textpont.setText("Pontuação: " + Pontuacao);
    }
    colidindoPontuacao = false;
    componentesTimerPontAdicionado = false;
    if (timerTempo != null) {
      timerTempo.cancel();
      timerTempo.purge();
    }
    timerTempo = new Timer();
    if (AnimationFundoVitoria.fundoTemp != null) {
      AnimationFundoVitoria.fundoTemp.cancel();
      AnimationFundoVitoria.fundoTemp.purge();
    }
    AnimationFundoVitoria.fundoTemp = new Timer();
    if (timer != null) {
      timer.cancel();
      timer.purge();
    }
    timer = new Timer();
    if (timerEnergy != null) {
      timerEnergy.cancel();
      timerEnergy.purge();
    }
    timerEnergy = new Timer();

  }

}
