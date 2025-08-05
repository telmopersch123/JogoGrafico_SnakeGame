import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;

public class AnimationTextSelection {
  static Timer animacaoSelecionadoTimer;
  static int Transper = 0;
  static String Text = "Selecionado";

  public static void AnimationText() {
    animacaoSelecionadoTimer = new Timer();
    animacaoSelecionadoTimer.scheduleAtFixedRate(new TimerTask() {

      @Override
      public void run() {
        SwingUtilities.invokeLater(() -> {
          if (MapPanel.Position >= -100) {
            MapPanel.backgroundLabel.remove(MapPanel.TextSelection);
            MapPanel.backgroundLabel.remove(MapPanel.DungeonButton);
            MapPanel.backgroundLabel.remove(MapPanel.SwampButton);
            MapPanel.backgroundLabel.remove(MapPanel.FieldButton);
            MapPanel.backgroundLabel.remove(MapPanel.backgroundLabel2);
            if (MapPanel.Position >= -100 && MapPanel.Position <= -70) {
              if (Transper >= 0) {
                Transper -= 10;
              }
              if (MapPanel.Position == -100) {
                Transper = 0;
              }
            } else {
              Transper += 5;
            }
            MapPanel.TextSelection = new TextShadow(
                Text, new Color(255, 255, 255, Transper),
                new Color(255, 255, 255, Transper), MapPanel.selectionFont);
            MapPanel.Position -= 2;
            MapPanel.TextSelection.setBorder(BorderFactory.createEmptyBorder(150, 0,
                MapPanel.Position, 0));
            MapPanel.gbc.gridy = 1;
            MapPanel.backgroundLabel.add(MapPanel.TextSelection, MapPanel.gbc);
            MapPanel.gbc.gridy = 1;
            MapPanel.backgroundLabel.add(MapPanel.DungeonButton, MapPanel.gbc);
            MapPanel.gbc.gridy = 2;
            MapPanel.backgroundLabel.add(MapPanel.SwampButton, MapPanel.gbc);
            MapPanel.gbc.gridy = 3;
            MapPanel.backgroundLabel.add(MapPanel.FieldButton, MapPanel.gbc);
            MapPanel.gbc.gridy = 2;
            MapPanel.backgroundLabel.add(MapPanel.backgroundLabel2, MapPanel.gbc);
         
            MapPanel.backgroundLabel.revalidate();
            MapPanel.backgroundLabel.repaint();
          } else {
            animacaoSelecionadoTimer.cancel();
            animacaoSelecionadoTimer.purge();
          }
        });
      }
    }, 0, 20);
  }


 

  public static void AnimationTextSkin() {
    animacaoSelecionadoTimer = new Timer();
    animacaoSelecionadoTimer.scheduleAtFixedRate(new TimerTask() {

      @Override
      public void run() {
        SwingUtilities.invokeLater(() -> {
          if (MapPanel.Position >= -100) {
            SkinPanel.backgroundLabel.remove(SkinPanel.TextSelection);
            SkinPanel.backgroundLabel.remove(SkinPanel.ClassicSkinButton);
            SkinPanel.backgroundLabel.remove(SkinPanel.PoisonSkinButton);
            SkinPanel.backgroundLabel.remove(SkinPanel.FireSkinButton);
            SkinPanel.backgroundLabel.remove(MapPanel.backgroundLabel2);
            if (MapPanel.Position >= -100 && MapPanel.Position <= -70) {
              if (Transper >= 0) {
                Transper -= 10;
              }
              if (MapPanel.Position == -100) {
                Transper = 0;
              }
            } else {
              Transper += 5;
            }
            SkinPanel.TextSelection = new TextShadow(Text, new Color(255, 255, 255, Transper),
                new Color(255, 255, 255, Transper), SkinPanel.selectionFont);
            MapPanel.Position -= 2;
            SkinPanel.TextSelection.setBorder(BorderFactory.createEmptyBorder(150, 0,
                MapPanel.Position, 0));
              
            SkinPanel.gbc.gridy = 1;
            SkinPanel.backgroundLabel.add(SkinPanel.TextSelection, SkinPanel.gbc);
            SkinPanel.gbc.gridy = 1;
            SkinPanel.backgroundLabel.add(SkinPanel.ClassicSkinButton, SkinPanel.gbc);
            SkinPanel.gbc.gridy = 2;
            SkinPanel.backgroundLabel.add(SkinPanel.PoisonSkinButton, SkinPanel.gbc);
            SkinPanel.gbc.gridy = 3;
            SkinPanel.backgroundLabel.add(SkinPanel.FireSkinButton, SkinPanel.gbc);
            SkinPanel.gbc.gridy = 2;
            SkinPanel.backgroundLabel.add(MapPanel.backgroundLabel2, SkinPanel.gbc);
          
            SkinPanel.backgroundLabel.revalidate();
            SkinPanel.backgroundLabel.repaint();
          } else {
            animacaoSelecionadoTimer.cancel();
            animacaoSelecionadoTimer.purge();
          }
        });
      }
    }, 0, 20);
  }
}
