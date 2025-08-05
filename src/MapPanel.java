import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MapPanel extends JPanel {
  private JButton ReturnButton;
  static JButton DungeonButton;
  static JButton SwampButton;
  static JButton FieldButton;
  static JLabel backgroundLabel;
  public static Image Bordas;
  static Color Transper = new Color(0, 0, 0, 0);
  static JLabel backgroundLabel2;
  static Image backgroundImageMenu;
  static List<JButton> buttons;
  static JLabel TextSelection;
  static int Position = 0;
  static GridBagConstraints gbc;
  static Font selectionFont;
  static JLayeredPane layeredPane;
  static JLabel mapLabel;

  public MapPanel(ImageIcon buttonReturn) {
    setLayout(new BorderLayout());
    buttons = new ArrayList<>();
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    try {
      String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
      Font Fonts = loadFont.loadFont(basePath + "fontes" + File.separator + "fontGeral.ttf", 16);
      Font FontsTitulo = loadFont.loadFont(basePath + "fontes" + File.separator + "fontGeral.ttf", 34);
      selectionFont = loadFont.loadFont(basePath + "fontes" + File.separator + "fontGeral.ttf", 64);
      ImageIcon buttonDungeonINCBack = new StretchIcon(basePath + "Menu" + File.separator + "buttonInactive-Dungeon.png");
      ImageIcon buttonFieldINCBack = new StretchIcon(basePath + "Menu" + File.separator + "buttonInactive-field.png");
      ImageIcon buttonSwampINCBack = new StretchIcon(basePath + "Menu" + File.separator + "buttonInactive-swamp.png");
      ImageIcon buttonSwampBack = new StretchIcon(basePath + "Menu" + File.separator + "button-swamp.png");
      ImageIcon buttonFieldBack = new StretchIcon(basePath + "Menu" + File.separator + "button-field.png");
      ImageIcon buttonDungeonBack = new StretchIcon(basePath + "Menu" + File.separator + "button-dungeon.png");
      ImageIcon buttonBlockedSwamp = new StretchIcon(basePath + "Menu" + File.separator + "BlockedSwamp.png");
      ImageIcon buttonBlockedDungeon = new StretchIcon(basePath + "Menu" + File.separator + "BlockedDungeon.png");
      Image backgroundImage = ImageIO.read(new File(basePath + "Menu" + File.separator + "backgroundMenu.png"));
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      backgroundImage = backgroundImage.getScaledInstance((int) screenSize.getWidth(), (int) screenSize.getHeight(),
          Image.SCALE_SMOOTH);
      backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
      backgroundLabel.setSize(screenSize);
      backgroundLabel.setLayout(new GridBagLayout());
      backgroundLabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          resetButtonSizes();
        }
      });
      layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

      ReturnButton = new JButton("", buttonReturn);
      ReturnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MapPanel.this);
          MenuPanel menuPanel = new MenuPanel();
          topFrame.getContentPane().removeAll();
          topFrame.getContentPane().add(menuPanel);
          topFrame.revalidate();
          topFrame.repaint();
        }
      });
      ReturnButton.setBounds(10, 10, 100, 80);
      ReturnButtonImage(ReturnButton, 100, 80, Fonts);
      layeredPane.add(ReturnButton, JLayeredPane.PALETTE_LAYER);
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.CENTER;
   
      mapLabel = new JLabel("Cenários de Fuga");
      mapLabel.setFont(FontsTitulo);
      mapLabel.setForeground(Color.WHITE);
      mapLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 150, 0));
      backgroundLabel.add(mapLabel, gbc);
      add(layeredPane, BorderLayout.CENTER);
    
      if (Game.DesblockedPontuation <= 1) {
        if (Game.MapDungeon) {
          DungeonButton = new JButton("Masmorra", buttonDungeonBack);
        } else {
          DungeonButton = new JButton("Masmorra", buttonDungeonINCBack);
        }
      } else {
        DungeonButton = new JButton("Masmorra", buttonBlockedDungeon);
      }
      DungeonButton.setFont(Fonts);
      buttons.add(DungeonButton);
      DungeonButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          if (Game.DesblockedPontuation <= 1) {
            Game.MapDungeon = true;
            Game.MapField = false;
            Game.MapSwamp = false;
            DungeonButton.setIcon(buttonDungeonBack);
            SwampButton.setIcon(buttonSwampINCBack);
            FieldButton.setIcon(buttonFieldINCBack);
            resetButtonSizes();
            DungeonButton.setPreferredSize(new Dimension(400, 130));
            AnimationTextSelection.Text = "Selecionado";
          } else {
            AnimationTextSelection.Text = "Bloqueado";
          }
          if (MapPanel.Position < 0) {
            AnimationTextSelection.animacaoSelecionadoTimer.cancel();
            AnimationTextSelection.animacaoSelecionadoTimer.purge();
          }
          AnimationTextSelection.Transper = 0;
          MapPanel.Position = 0;
          AnimationTextSelection.AnimationText();
        }
      });
      ReturnButtonImage(DungeonButton, 300, 100, Fonts);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.insets = new Insets(-150, 0, -150, 0);
      backgroundLabel.add(DungeonButton, gbc);
      if (Game.DesblockedPontuation <= 2) {
        if (Game.MapSwamp) {
          SwampButton = new JButton("Pântano", buttonSwampBack);
        } else {
          SwampButton = new JButton("Pântano", buttonSwampINCBack);
        }
      } else {
        SwampButton = new JButton("Pântano", buttonBlockedSwamp);
      }
      SwampButton.setFont(Fonts);
      buttons.add(SwampButton);
      SwampButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          if (Game.DesblockedPontuation <= 2) {
            Game.MapDungeon = false;
            Game.MapField = false;
            Game.MapSwamp = true;
            if (Game.DesblockedPontuation <= 1) {
              DungeonButton.setIcon(buttonDungeonINCBack);
            } else {
              DungeonButton.setIcon(buttonBlockedDungeon);
            }
            SwampButton.setIcon(buttonSwampBack);
            FieldButton.setIcon(buttonFieldINCBack);
            resetButtonSizes();
            SwampButton.setPreferredSize(new Dimension(400, 130));
            AnimationTextSelection.Text = "Selecionado";
          } else {
            AnimationTextSelection.Text = "Bloqueado";
          }
          if (MapPanel.Position < 0) {
            AnimationTextSelection.animacaoSelecionadoTimer.cancel();
            AnimationTextSelection.animacaoSelecionadoTimer.purge();
          }
          AnimationTextSelection.Transper = 0;
          MapPanel.Position = 0;
          AnimationTextSelection.AnimationText();
        }
      });
      ReturnButtonImage(SwampButton, 300, 100, Fonts);
      gbc.gridx = 0;
      gbc.gridy = 2;
      backgroundLabel.add(SwampButton, gbc);

      if (Game.MapField) {
        FieldButton = new JButton("Planície", buttonFieldBack);
      } else {
        FieldButton = new JButton("Planície", buttonFieldINCBack);
      }
      FieldButton.setFont(Fonts);
      ReturnButtonImage(FieldButton, 300, 100, Fonts);
      buttons.add(FieldButton);
      FieldButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          Game.MapDungeon = false;
          Game.MapField = true;
          Game.MapSwamp = false;
          if (Game.DesblockedPontuation <= 1) {
            DungeonButton.setIcon(buttonDungeonINCBack);
          } else {
            DungeonButton.setIcon(buttonBlockedDungeon);
          }
          if (Game.DesblockedPontuation <= 2) {
            SwampButton.setIcon(buttonSwampINCBack);
          } else {
            SwampButton.setIcon(buttonBlockedSwamp);
          }
          FieldButton.setIcon(buttonFieldBack);
          resetButtonSizes();
          FieldButton.setPreferredSize(new Dimension(400, 130));
          AnimationTextSelection.Text = "Selecionado";
          if (MapPanel.Position < 0) {
            AnimationTextSelection.animacaoSelecionadoTimer.cancel();
            AnimationTextSelection.animacaoSelecionadoTimer.purge();
          }
          AnimationTextSelection.Transper = 0;
          MapPanel.Position = 0;
          AnimationTextSelection.AnimationText();
        }
      });

      gbc.gridy = 3;
      backgroundLabel.add(FieldButton, gbc);
      gbc.gridy = 2;
      ImagemFundo();
      backgroundLabel.add(backgroundLabel2, gbc);
    
      TextSelection = new JLabel("");
      gbc.gridy = 1;
      backgroundLabel.add(TextSelection, gbc);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void ImagemFundo() {
    try {
      String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
      backgroundImageMenu = ImageIO.read(new File(basePath + "Menu" + File.separator + "fundoMenu.png"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    Dimension imageSize = new Dimension(500, 600);
    backgroundImageMenu = backgroundImageMenu.getScaledInstance((int) imageSize.getWidth(), (int) imageSize.getHeight(),
        Image.SCALE_SMOOTH);
    backgroundLabel2 = new JLabel(new ImageIcon(backgroundImageMenu));
    backgroundLabel2.setSize(imageSize);
    backgroundLabel2.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
  }

  public static void ReturnButtonImage(JButton button, int width, int height, Font font) {
    button.setForeground(new Color(0, 0, 0, 50));
    button.revalidate();
    button.repaint();
    button.setPreferredSize(new Dimension(width, height));
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setOpaque(false);
    button.setContentAreaFilled(false);
    button.setBorderPainted(false);
    button.setFocusable(false);
    button.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        button.setForeground(Color.BLACK);
        button.setSize(new Dimension(width - 15, height - 10));
        button.revalidate();
        button.repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        button.setForeground(new Color(0, 0, 0, 50));
        button.setSize(new Dimension(width, height));
        button.revalidate();
        button.repaint();
      }
    });
  }

  public static void resetButtonSizes() {
    for (JButton button : buttons) {
      button.setPreferredSize(new Dimension(300, 100));
      button.revalidate();
      button.repaint();
    }
  }
}
