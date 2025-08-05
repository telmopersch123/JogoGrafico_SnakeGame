import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

public class AnimationFontGameFim {
  static Timer animacaoFonteTimer;
  static Timer animacaoFonteDificulty;
  static Timer animacaoFontePontuacao;

  public static void AnimationFontDificulty(Game game) {
    animacaoFonteDificulty = new Timer();
    animacaoFonteDificulty.scheduleAtFixedRate(new TimerTask() {
      int ValueColorDificulty;
      int FontSize = Game.sizeDificult;

      @Override
      public void run() {
        SwingUtilities.invokeLater(() -> {
          if (FontSize >= 16) {
            Game.meuPainelButtons.remove(Game.DificultytextShadowLabel);
            Game.meuPainelButtons.remove(Game.DificultytextShadowLabel2);
            FontSize--;
            if (ValueColorDificulty <= 255) {
              if (ValueColorDificulty < 1) {
                ValueColorDificulty = 0;
              }
              ValueColorDificulty += 15;
            }
            Font NovoTamanho = Game.Fonts.deriveFont((float) FontSize);
           
            Game.DificultytextShadowLabel = new TextShadow("Dificuldade", new Color(255, 255, 255,
                ValueColorDificulty), new Color(0, 0, 0, ValueColorDificulty), NovoTamanho);
            Game.GridGameWins.gridy = 2;
            Game.meuPainelButtons.add(Game.DificultytextShadowLabel, Game.GridGameWins);
           
            Color originalColor = Game.CorDificulty;
            int alpha = ValueColorDificulty;
            Color transparentColor = new Color(originalColor.getRed(), originalColor.getGreen(),
                originalColor.getBlue(), alpha);
            Game.DificultytextShadowLabel2 = new TextShadow(Game.dificulty, transparentColor, new Color(0, 0, 0,
                ValueColorDificulty),
                NovoTamanho);
            Game.GridGameWins.gridy = 3;
            Game.GridGameWins.insets = new Insets(0, 0, 5, 0);
            Game.meuPainelButtons.add(Game.DificultytextShadowLabel2, Game.GridGameWins);
         
            Game.meuPainelButtons.revalidate();
            Game.meuPainelButtons.repaint();
          } else {
            animacaoFonteDificulty.cancel();
            animacaoFonteDificulty.purge();
          }

        });
      }
    }, 0, 70);
  }

  public static void AnimationFontTempo(Game game) {

    animacaoFonteTimer = new Timer();
    animacaoFonteTimer.scheduleAtFixedRate(new TimerTask() {
      int ValueColorTempo;
      int FontSize = Game.sizeDificult;

      @Override
      public void run() {
        SwingUtilities.invokeLater(() -> {
          if (FontSize >= 16) {
            Game.meuPainelButtons.remove(Game.TempotextShadowLabel);
            Game.meuPainelButtons.remove(Game.TempotextShadowLabel2);
            FontSize--;
            if (ValueColorTempo <= 255) {
              if (ValueColorTempo < 1) {
                ValueColorTempo = 0;
              }
              ValueColorTempo += 15;
            }
            Font TamanhoNovo = Game.Fonts.deriveFont((float) FontSize);
           
            Game.TempotextShadowLabel = new TextShadow("Tempo de Partida", new Color(255, 255, 255,
                ValueColorTempo), new Color(0, 0, 0, ValueColorTempo), TamanhoNovo);
            Game.GridGameWins.gridy = 4;
            Game.GridGameWins.insets = new Insets(0, 0, 0, 0);
            Game.meuPainelButtons.add(Game.TempotextShadowLabel, Game.GridGameWins);
           
            Game.TempotextShadowLabel2 = new TextShadow(Game.timeText, new Color(0, 255, 255,
                ValueColorTempo),
                new Color(0, 0, 0, ValueColorTempo), TamanhoNovo);
            Game.GridGameWins.gridy = 5;
            Game.GridGameWins.insets = new Insets(0, 0, 5, 0);
            Game.meuPainelButtons.add(Game.TempotextShadowLabel2, Game.GridGameWins);
          
            Game.meuPainelButtons.revalidate();
            Game.meuPainelButtons.repaint();
          } else {
            animacaoFonteTimer.cancel();
            animacaoFonteTimer.purge();
          }
        });
      }
    }, 0, 70);
  }

  public static void AnimationFontPontuacao(Game game) {

    animacaoFontePontuacao = new Timer();
    animacaoFontePontuacao.scheduleAtFixedRate(new TimerTask() {
      int ValueColorPontuacao;
      int FontSize = Game.sizeDificult;

      @Override
      public void run() {
        SwingUtilities.invokeLater(() -> {
          if (FontSize >= 16) {
            Game.meuPainelButtons.remove(Game.PonttextShadowLabel);
            Game.meuPainelButtons.remove(Game.PonttextShadowLabel2);
            FontSize--;
            if (ValueColorPontuacao <= 255) {
              if (ValueColorPontuacao < 1) {
                ValueColorPontuacao = 0;
              }
              ValueColorPontuacao += 15;
            }
            Font TamanhoNovo = Game.Fonts.deriveFont((float) FontSize);
           
            Game.PonttextShadowLabel = new TextShadow("Pontuação", new Color(255, 255, 255,
                ValueColorPontuacao), new Color(0, 0, 0, ValueColorPontuacao), TamanhoNovo);
            Game.GridGameWins.gridy = 6;
            Game.GridGameWins.insets = new Insets(0, 0, 0, 0);
            Game.meuPainelButtons.add(Game.PonttextShadowLabel, Game.GridGameWins);
           
            Game.PonttextShadowLabel2 = new TextShadow("" + Game.Pontuacao, new Color(192, 192,
                192, ValueColorPontuacao),
                new Color(0, 0, 0, ValueColorPontuacao), TamanhoNovo);
            Game.GridGameWins.gridy = 7;
            Game.GridGameWins.insets = new Insets(0, 0, 10, 0);
            Game.meuPainelButtons.add(Game.PonttextShadowLabel2, Game.GridGameWins);
           
            Game.meuPainelButtons.revalidate();
            Game.meuPainelButtons.repaint();
          } else {
            animacaoFontePontuacao.cancel();
            animacaoFontePontuacao.purge();
          }
        });
      }
    }, 0, 70);
  }
}
