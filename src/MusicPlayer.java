
import java.io.File;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class MusicPlayer {
  static int musicCount;
  static List<Clip> audioClips;
  static List<Clip> effectsClips;
  static Clip clipField;
  static Clip energyClip;
  static Clip clipMusicMenu;
  static Clip colisianenergyClip;
  static Clip RaioCaindoClip;
  private static boolean isEnergyPlaying = false;
  private static boolean isEnergyPlayingColisian = false;
  private static boolean isPlaying = false;
  private static boolean isMusicPlaying = false;
  private static boolean isEnergyPlayingRaioCaindo = false;
  private static Clip clipovoBreak;
  private static Clip clipaumentovelocity3x;
  private static Clip clipdeathFome;
  private static Clip clipColisao;
  private static Clip clipcolisianpoisonfood;
  private static Clip clipHeatFood;
  private static Clip clipexplosao;
  private static Clip clipnotification;
  private static Clip clipDetailsGameWins;
  private static Clip clipGameWins;
  private static Clip clipGameOver;
  private static Clip clipHover;
  private static Clip clipClick;
  private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

  public static void AudioClick() {
    try {
      File soundFile = new File("resources/audios/clicksound.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipClick = AudioSystem.getClip();
      clipClick.open(audioInputStream);
      clipClick.start();
      effectsClips.add(clipClick);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void AudioHover() {
    try {
      File soundFile = new File("resources/audios/hoversound.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipHover = AudioSystem.getClip();
      clipHover.open(audioInputStream);
      clipHover.start();
      effectsClips.add(clipHover);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void AudioGameOver() {
    try {
      File soundFile = new File("resources/audios/Jogo/gameover.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipGameOver = AudioSystem.getClip();
      clipGameOver.open(audioInputStream);
      clipGameOver.start();
      effectsClips.add(clipGameOver);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void AudioGameWins() {
    try {
      File soundFile = new File("resources/audios/Jogo/musicwins.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipGameWins = AudioSystem.getClip();
      clipGameWins.open(audioInputStream);
      clipGameWins.start();
      effectsClips.add(clipGameWins);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void DetailsGameWins() {
    try {
      File soundFile = new File("resources/audios/Jogo/DetailsGameWins.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipDetailsGameWins = AudioSystem.getClip();
      clipDetailsGameWins.open(audioInputStream);
      clipDetailsGameWins.start();
      effectsClips.add(clipDetailsGameWins);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void notification() {
    try {
      File soundFile = new File("resources/audios/Jogo/musicaNotification.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipnotification = AudioSystem.getClip();
      clipnotification.open(audioInputStream);
      clipnotification.start();
      effectsClips.add(clipnotification);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void explosao() {
    try {
      File soundFile = new File("resources/audios/Jogo/explosaodeath.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipexplosao = AudioSystem.getClip();
      clipexplosao.open(audioInputStream);
      clipexplosao.start();
      effectsClips.add(clipexplosao);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void HeatFood() {
    try {
      File soundFile = new File("resources/audios/Jogo/heatfood.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipHeatFood = AudioSystem.getClip();
      clipHeatFood.open(audioInputStream);
      clipHeatFood.start();
      effectsClips.add(clipHeatFood);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void colisianpoisonfood() {
    try {
      File soundFile = new File("resources/audios/Jogo/colisianpoisonfood.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipcolisianpoisonfood = AudioSystem.getClip();
      clipcolisianpoisonfood.open(audioInputStream);
      clipcolisianpoisonfood.start();
      effectsClips.add(clipcolisianpoisonfood);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void Colisao() {
    try {
      File soundFile = new File("resources/audios/Jogo/deathcolisian.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipColisao = AudioSystem.getClip();
      clipColisao.open(audioInputStream);
      clipColisao.start();
      effectsClips.add(clipColisao);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void deathFome() {
    try {
      File soundFile = new File("resources/audios/Jogo/deathfome.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipdeathFome = AudioSystem.getClip();
      clipdeathFome.open(audioInputStream);
      clipdeathFome.start();
      effectsClips.add(clipdeathFome);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void aumentovelocity3x() {
    try {
      File soundFile = new File("resources/audios/Jogo/aumentovelocity3x.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipaumentovelocity3x = AudioSystem.getClip();
      clipaumentovelocity3x.open(audioInputStream);
      clipaumentovelocity3x.start();
      effectsClips.add(clipaumentovelocity3x);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void ovoBreak() {
    try {
      File soundFile = new File("resources/audios/Jogo/ovoBreak.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipovoBreak = AudioSystem.getClip();
      clipovoBreak.open(audioInputStream);
      clipovoBreak.start();
      effectsClips.add(clipovoBreak);
      AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void colisianenergyfood() {
    try {
      if (colisianenergyClip == null) {
        File soundFile = new File("resources/audios/Jogo/colisianfoodeletric.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        colisianenergyClip = AudioSystem.getClip();
        colisianenergyClip.open(audioInputStream);
      }
      if (!isEnergyPlayingColisian) {
        colisianenergyClip.loop(Clip.LOOP_CONTINUOUSLY);
        isEnergyPlayingColisian = true;
        effectsClips.add(colisianenergyClip);
        AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void stopEnergytimeColisian() {
    if (colisianenergyClip != null && isEnergyPlayingColisian) {
      colisianenergyClip.stop();
      isEnergyPlayingColisian = false;
    }
  }

  public static void RaioCaindo() {
    try {
      if (RaioCaindoClip == null) {
        File soundFile = new File("resources/audios/Jogo/RaioCaindo.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        RaioCaindoClip = AudioSystem.getClip();
        RaioCaindoClip.open(audioInputStream);

       
        RaioCaindoClip.addLineListener(new LineListener() {
          @Override
          public void update(LineEvent event) {
            if (event.getType() == LineEvent.Type.STOP) {
              RaioCaindoClip.stop();
              RaioCaindoClip.setFramePosition(0);
              AnimationEnergyControl.CaiuRaio = false; 
              isEnergyPlayingRaioCaindo = false;
            }
          }
        });
      }
      if (!isEnergyPlayingRaioCaindo) {
        RaioCaindoClip.start();
        isEnergyPlayingRaioCaindo = true;
        effectsClips.add(RaioCaindoClip);
        AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void stopEnergytimeRaioCaindo() {
    if (RaioCaindoClip != null && isEnergyPlayingRaioCaindo) {
      RaioCaindoClip.stop();
      isEnergyPlayingRaioCaindo = false;
    }
  }

  public static void energytime() {
    try {
      if (energyClip == null) {
        File soundFile = new File("resources/audios/Jogo/energytime.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        energyClip = AudioSystem.getClip();
        energyClip.open(audioInputStream);
      }
      if (!isEnergyPlaying) {
        energyClip.loop(Clip.LOOP_CONTINUOUSLY);
        isEnergyPlaying = true;
        effectsClips.add(energyClip);
        AbaixarOuAumentarMusica.setVolumeEffectsForAllClips(ConfPanel.valueEf);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void stopEnergytime() {
    if (energyClip != null && isEnergyPlaying) {
      energyClip.stop();
      isEnergyPlaying = false;
    }
  }

  

  public static void MusicasFields() {
    if (Game.MapField) {
      if (Game.clickedButtonDifiFacil || Game.clickedButtonDifiNormal) {
        Game.musicQueue.add(new File("resources/audios/Planicie/facilNormal_musicaPlanicie1.wav"));
        Game.musicQueue.add(new File("resources/audios/Planicie/facilNormal_musicaPlanicie2.wav"));
        Game.musicQueue.add(new File("resources/audios/Planicie/facilNormal_musicaPlanicie3.wav"));
      } else if (Game.clickedButtonDifiDificil) {
        Game.musicQueue.add(new File("resources/audios/Planicie/Dificil_musicaPlanicie1.wav"));
        Game.musicQueue.add(new File("resources/audios/Planicie/Dificil_musicaPlanicie2.wav"));
        Game.musicQueue.add(new File("resources/audios/Planicie/Dificil_musicaPlanicie3.wav"));
      }
      musicCount = Game.musicQueue.size();
    } else if (Game.MapSwamp) {
      if (Game.clickedButtonDifiFacil || Game.clickedButtonDifiNormal) {
        Game.musicQueue.add(new File("resources/audios/Swamp/FacilNormal_musicaSwamp1.wav"));
        Game.musicQueue.add(new File("resources/audios/Swampe/FacilNormal_musicaSwamp2.wav"));
        Game.musicQueue.add(new File("resources/audios/Swamp/FacilNormal_musicaSwamp3.wav"));
      } else if (Game.clickedButtonDifiDificil) {
        Game.musicQueue.add(new File("resources/audios/Swamp/Dificil_musicaSwamp1.wav"));
        Game.musicQueue.add(new File("resources/audios/Swamp/Dificil_musicaSwamp2.wav"));
        Game.musicQueue.add(new File("resources/audios/Swamp/Dificil_musicaSwamp3.wav"));
        Game.musicQueue.add(new File("resources/audios/Swamp/Dificil_musicaSwamp4.wav"));
      }
    } else if (Game.MapDungeon) {
      if (Game.clickedButtonDifiFacil || Game.clickedButtonDifiNormal) {
        Game.musicQueue.add(new File("resources/audios/Dungeon/FacilNormal_musicaDungeon1.wav"));
        Game.musicQueue.add(new File("resources/audios/Dungeon/FacilNormal_musicaDungeon2.wav"));
        Game.musicQueue.add(new File("resources/audios/Dungeon/FacilNormal_musicaDungeon3.wav"));
      } else if (Game.clickedButtonDifiDificil) {
        Game.musicQueue.add(new File("resources/audios/Dungeon/Dificil_musicaDungeon1.wav"));
        Game.musicQueue.add(new File("resources/audios/Dungeon/Dificil_musicaDungeon2.wav"));
        Game.musicQueue.add(new File("resources/audios/Dungeon/Dificil_musicaDungeon3.wav"));
        Game.musicQueue.add(new File("resources/audios/Dungeon/Dificil_musicaDungeon4.wav"));
      }
    }
  }

  public static void MusicsField() {
    if (!isMusicPlaying) {
      File soundFile = Game.musicQueue.poll();
      if (soundFile != null) {
        try {
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
          clipField = AudioSystem.getClip();
          clipField.open(audioInputStream);
          audioClips.add(clipField);
          AbaixarOuAumentarMusica.setVolumeForAllClips(ConfPanel.value);
          clipField.start();

          isMusicPlaying = true;
          clipField.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
              clipField.close();
              musicCount--;
              isMusicPlaying = false;
              if (musicCount == 0) {
                MusicasFields();
              }
              scheduler.schedule(() -> MusicsField(), 2, TimeUnit.SECONDS);
            }
          });

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void stopMusicField() {
    clipField.stop();
    clipField.close();
    isMusicPlaying = false;
    Game.musicQueue.clear();
    Game.musicQueue.addAll(Game.originalQueue);
  }

  public static void musicMenu() {
    try {
      File soundFile = new File("resources/audios/Jogo/musicamenu-unica.wav");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
      clipMusicMenu = AudioSystem.getClip();
      clipMusicMenu.open(audioInputStream);

      
      clipMusicMenu.addLineListener(new LineListener() {
        @Override
        public void update(LineEvent event) {
          if (event.getType() == LineEvent.Type.STOP) {

            new Thread(() -> {
              try {
                Thread.sleep(10000);
                clipMusicMenu.setFramePosition(0);
                clipMusicMenu.start();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }).start();
          }
        }

      });

      if (!isPlaying) {
        clipMusicMenu.start();
        isPlaying = true;
        audioClips.add(clipMusicMenu);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void stopMusicMenu() {
    if (clipMusicMenu != null && clipMusicMenu.isRunning()) {
      clipMusicMenu.stop();
      clipMusicMenu.close();
      isPlaying = false;
    }
  }
}
