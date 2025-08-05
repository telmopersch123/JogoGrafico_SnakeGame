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

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SkinPanel extends JPanel {
  static JLabel backgroundLabel;
  private JButton ReturnButton;
  static Font selectionFont;
  static JButton ClassicSkinButton;
  static JButton PoisonSkinButton;
  static JButton FireSkinButton;
  static JLabel TextSelection;
  static GridBagConstraints gbc;

  public SkinPanel(ImageIcon buttonReturn) {
    MapPanel.buttons = new ArrayList<>();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setLayout(null);
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    layeredPane.setPreferredSize(screenSize);
    layeredPane.setBounds(0, 0, screenSize.width, screenSize.height);

    try {
      String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;

      Font Fonts = loadFont.loadFont(basePath + "fontes" + File.separator + "fontGeral.ttf", 16);
      Font FontsTitulo = loadFont.loadFont(basePath + "fontes" + File.separator + "fontGeral.ttf", 34);
      Image backgroundImage = ImageIO.read(new File(basePath + "Menu" + File.separator + "backgroundMenu.png"));
      selectionFont = loadFont.loadFont(basePath + "fontes" + File.separator + "fontGeral.ttf", 64);
     
      ImageIcon buttonclassicoINCsnake = new StretchIcon(basePath + "Menu" + File.separator + "botaoclassicoinativo.png");
      ImageIcon buttonpoisonINCsnake = new StretchIcon(basePath + "Menu" + File.separator + "botaopoisoninativo.png");
      ImageIcon buttonfireINCsnake = new StretchIcon(basePath + "Menu" + File.separator + "botaofireinativo.png");
     
      ImageIcon buttonclassicosnake = new StretchIcon(basePath + "Menu" + File.separator + "botaoclassico.png");
      ImageIcon buttonpoisonsnake = new StretchIcon(basePath + "Menu" + File.separator + "botaoposion.png");
      ImageIcon buttonfiresnake = new StretchIcon(basePath + "Menu" + File.separator + "botaosnake.png");
     
      ImageIcon buttonclassicohover = new StretchIcon(basePath + "Menu" + File.separator + "hover1.png");
      ImageIcon buttonpoisonhover = new StretchIcon(basePath + "Menu" + File.separator + "hover2.png");
      ImageIcon buttonfirehover = new StretchIcon(basePath + "Menu" + File.separator + "hover3.png");
     
      ImageIcon buttonclassicohoverinc = new StretchIcon(basePath + "Menu" + File.separator + "hoverinc1.png");
      ImageIcon buttonpoisonhoverinc = new StretchIcon(basePath + "Menu" + File.separator + "hoverinc2.png");
      ImageIcon buttonfirehoverinc = new StretchIcon(basePath + "Menu" + File.separator + "hoverinc3.png");
     
      ImageIcon blockedFire = new StretchIcon(basePath + "Menu" + File.separator + "BlockedFire.png");
      ImageIcon blockedPoison = new StretchIcon(basePath + "Menu" + File.separator + "BlockedPoison.png");
      backgroundImage = backgroundImage.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH); 
      backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
      backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
      backgroundLabel.setLayout(new GridBagLayout());
      backgroundLabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          MapPanel.resetButtonSizes();
        }
      });
      layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

      ReturnButton = new JButton("", buttonReturn);
      ReturnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(SkinPanel.this);
          MenuPanel menuPanel = new MenuPanel(); 
          topFrame.getContentPane().removeAll();
          topFrame.getContentPane().add(menuPanel);
          topFrame.revalidate();
          topFrame.repaint();
        }
      });
      ReturnButton.setBounds(10, 10, 100, 80); 
      MapPanel.ReturnButtonImage(ReturnButton, 100, 80, Fonts);

      layeredPane.add(ReturnButton, JLayeredPane.PALETTE_LAYER);

      JLabel mapLabel = new JLabel("Skins Alternativas");
      mapLabel.setFont(FontsTitulo);
      mapLabel.setForeground(Color.WHITE);
      mapLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 150, 0));
      gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.insets = new Insets(10, 0, 10, 0);
      gbc.anchor = GridBagConstraints.CENTER;
      backgroundLabel.add(mapLabel, gbc);
     
      if (Game.snakeClassica) {
        ClassicSkinButton = new JButton("Clássica", buttonclassicosnake);
      } else {
        ClassicSkinButton = new JButton("Clássica", buttonclassicoINCsnake);
      }
      Font fontClassic = Fonts;
      ClassicSkinButton.setFont(fontClassic);
      MapPanel.buttons.add(ClassicSkinButton);
      ClassicSkinButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          Game.snakeClassica = true;
          Game.snakePoison = false;
          Game.snakeFire = false;
          ClassicSkinButton.setIcon(buttonclassicosnake);
          if (Game.DesblockedPontuation <= 1) {
            PoisonSkinButton.setIcon(buttonpoisonINCsnake);
          } else {
            PoisonSkinButton.setIcon(blockedPoison);
          }
          if (Game.DesblockedPontuation < 1) {
            FireSkinButton.setIcon(buttonfireINCsnake);
          } else {
            FireSkinButton.setIcon(blockedFire);
          }
          ClassicSkinButton.setPreferredSize(new Dimension(400, 130));
          PoisonSkinButton.setPreferredSize(new Dimension(300, 100));
          FireSkinButton.setPreferredSize(new Dimension(300, 100));
          ClassicSkinButton.revalidate();
          ClassicSkinButton.repaint();
       
          AnimationTextSelection.Text = "Selecionado";
          if (MapPanel.Position < 0) {
            AnimationTextSelection.animacaoSelecionadoTimer.cancel();
            AnimationTextSelection.animacaoSelecionadoTimer.purge();
          }
          AnimationTextSelection.Transper = 0;
          MapPanel.Position = 0;
          AnimationTextSelection.AnimationTextSkin();
        }
      });
      MapPanel.ReturnButtonImage(ClassicSkinButton, 300, 100, Fonts);

      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.insets = new Insets(-150, 0, -150, 0);
      backgroundLabel.add(ClassicSkinButton, gbc);
     
      if (Game.DesblockedPontuation <= 1) {
        if (Game.snakePoison) {
          PoisonSkinButton = new JButton("Venenosa", buttonpoisonsnake);
        } else {
          PoisonSkinButton = new JButton("Venenosa", buttonpoisonINCsnake);
        }
      } else {
        PoisonSkinButton = new JButton("Venenosa", blockedPoison);
      }
      Font fontPoison = Fonts;
      PoisonSkinButton.setFont(fontPoison);
      MapPanel.buttons.add(PoisonSkinButton);
      PoisonSkinButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          if (Game.DesblockedPontuation <= 1) {
            Game.snakeClassica = false;
            Game.snakePoison = true;
            Game.snakeFire = false;
            ClassicSkinButton.setIcon(buttonclassicoINCsnake);
            PoisonSkinButton.setIcon(buttonpoisonsnake);
            if (Game.DesblockedPontuation < 1) {
              FireSkinButton.setIcon(buttonfireINCsnake);
            } else {
              FireSkinButton.setIcon(blockedFire);
            }
            ClassicSkinButton.setPreferredSize(new Dimension(300, 100));
            PoisonSkinButton.setPreferredSize(new Dimension(400, 130));
            FireSkinButton.setPreferredSize(new Dimension(300, 100));
            PoisonSkinButton.revalidate();
            PoisonSkinButton.repaint();
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
          AnimationTextSelection.AnimationTextSkin();
        }
      });
      MapPanel.ReturnButtonImage(PoisonSkinButton, 300, 100, Fonts);
      gbc.gridx = 0;
      gbc.gridy = 2;
      backgroundLabel.add(PoisonSkinButton, gbc);
    
      if (Game.DesblockedPontuation < 1) {
        if (Game.snakeFire) {
          FireSkinButton = new JButton("Boitatá", buttonfiresnake);
        } else {
          FireSkinButton = new JButton("Boitatá", buttonfireINCsnake);
        }
      } else {
        FireSkinButton = new JButton("Boitatá", blockedFire);
      }
      Font fontFire = Fonts;
      FireSkinButton.setFont(fontFire);
      MapPanel.buttons.add(FireSkinButton);
      FireSkinButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          MusicPlayer.AudioClick();
          if (Game.DesblockedPontuation < 1) {
            Game.snakeClassica = false;
            Game.snakePoison = false;
            Game.snakeFire = true;
            ClassicSkinButton.setIcon(buttonclassicoINCsnake);
            PoisonSkinButton.setIcon(buttonpoisonINCsnake);
            FireSkinButton.setIcon(buttonfiresnake);
            ClassicSkinButton.setPreferredSize(new Dimension(300, 100));
            PoisonSkinButton.setPreferredSize(new Dimension(300, 100));
            FireSkinButton.setPreferredSize(new Dimension(400, 130));
            FireSkinButton.revalidate();
            FireSkinButton.repaint();
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
          AnimationTextSelection.AnimationTextSkin();
        }
      });
      MapPanel.ReturnButtonImage(FireSkinButton, 300, 100, Fonts);

      gbc.gridx = 0;
      gbc.gridy = 3;
      backgroundLabel.add(FireSkinButton, gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      MapPanel.ImagemFundo();
      backgroundLabel.add(MapPanel.backgroundLabel2, gbc);
     
      gbc.gridy = 1;
      TextSelection = new JLabel("");
      backgroundLabel.add(TextSelection, gbc);
  
      hoveres(ClassicSkinButton, PoisonSkinButton, FireSkinButton, 300,
          100, buttonclassicohover, buttonpoisonhover,
          buttonfirehover,
          buttonclassicohoverinc, buttonpoisonhoverinc, buttonfirehoverinc, buttonclassicosnake, buttonpoisonsnake,
          buttonfiresnake, buttonclassicoINCsnake, buttonpoisonINCsnake, buttonfireINCsnake);
      add(layeredPane);
      setPreferredSize(screenSize);
      setBounds(0, 0, screenSize.width, screenSize.height);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void hoveres(JButton buttonClassico,
      JButton buttonPoison,
      JButton buttonFire, int width, int height, ImageIcon buttonclassicohover,
      ImageIcon buttonpoisonhover, ImageIcon buttonfirehover, ImageIcon buttonclassicohoverinc,
      ImageIcon buttonpoisonhoverinc, ImageIcon buttonfirehoverinc, ImageIcon buttonclassicosnake,
      ImageIcon buttonpoisonsnake, ImageIcon buttonfiresnake, ImageIcon buttonclassicoINCsnake,
      ImageIcon buttonpoisonINCsnake, ImageIcon buttonfireINCsnake) {
    buttonClassico.setPreferredSize(new Dimension(width, height));
    buttonClassico.setBorder(BorderFactory.createEmptyBorder());
    buttonClassico.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        if (Game.snakeClassica) {
          buttonClassico.setForeground(Color.BLACK);
          buttonClassico.setIcon(buttonclassicohover);
        } else {
          buttonClassico.setForeground(Color.BLACK);
          buttonClassico.setIcon(buttonclassicohoverinc);
        }

        buttonClassico.revalidate();
        buttonClassico.repaint();
      }

      @Override
      public void mouseExited(MouseEvent e) {
        if (Game.snakeClassica) {
          buttonClassico.setForeground(new Color(0, 0, 0, 50));
          buttonClassico.setIcon(buttonclassicosnake);
        } else {
          buttonClassico.setForeground(new Color(0, 0, 0, 50));
          buttonClassico.setIcon(buttonclassicoINCsnake);
        }

        buttonClassico.revalidate();
        buttonClassico.repaint();
      }
    });
    if (Game.DesblockedPontuation <= 1) {
      buttonPoison.setPreferredSize(new Dimension(width, height));
      buttonPoison.setBorder(BorderFactory.createEmptyBorder());
      buttonPoison.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
          if (Game.snakePoison) {
            buttonPoison.setForeground(Color.BLACK);
            buttonPoison.setIcon(buttonpoisonhover);
          } else {
            buttonPoison.setForeground(Color.BLACK);
            buttonPoison.setIcon(buttonpoisonhoverinc);
          }
          buttonPoison.revalidate();
          buttonPoison.repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
          if (Game.snakePoison) {
            buttonPoison.setForeground(new Color(0, 0, 0, 50));
            buttonPoison.setIcon(buttonpoisonsnake);
          } else {
            buttonPoison.setForeground(new Color(0, 0, 0, 50));
            buttonPoison.setIcon(buttonpoisonINCsnake);
          }
          buttonPoison.revalidate();
          buttonPoison.repaint();
        }
      });
    }
    if (Game.DesblockedPontuation < 1) {
      buttonFire.setPreferredSize(new Dimension(width, height));
      buttonFire.setBorder(BorderFactory.createEmptyBorder());
      buttonFire.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
          if (Game.snakeFire) {
            buttonFire.setForeground(Color.BLACK);
            buttonFire.setIcon(buttonfirehover);
          } else {
            buttonFire.setForeground(Color.BLACK);
            buttonFire.setIcon(buttonfirehoverinc);
          }
          buttonFire.revalidate();
          buttonFire.repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
          if (Game.snakeFire) {
            buttonFire.setForeground(new Color(0, 0, 0, 50));
            buttonFire.setIcon(buttonfiresnake);
          } else {
            buttonFire.setForeground(new Color(0, 0, 0, 50));
            buttonFire.setIcon(buttonfireINCsnake);
          }
          buttonFire.revalidate();
          buttonFire.repaint();
        }
      });
    }
  }
}
