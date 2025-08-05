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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ComoPanel extends JPanel {
  private Image backgroundImage;
  private static Font Fonts;
  private static Font FontsTitulo;
  private static JLabel backgroundLabel;
  private static GridBagConstraints gbc;
  private static JLabel textRemocao;
  private static ImageIcon botafundobotao1;
  private static JLabel fotoPrimaria;
  private static JLabel textJoga;
  private static JLabel fotoSegundaria;
  private static ImageIcon botafundobotao2;
  private static JLabel textRemocao1;
  private static ImageIcon botafundobotao3;
  private static JLabel fotoTerciaria;
  private JButton ReturnButton;

  public ComoPanel(ImageIcon buttonReturn) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
try {
    String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
    backgroundImage = ImageIO.read(new File(basePath + "Menu" + File.separator + "backgroundMenu.png"));
    backgroundImage = backgroundImage.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
    Fonts = loadFont.loadFont(basePath + "fontes" + File.separator + "fontGeral.ttf", 16);
    FontsTitulo = loadFont.loadFont(basePath + "fontes" + File.separator + "fontGeral.ttf", 34);
} catch (IOException ex) {
    ex.printStackTrace();
}

    setLayout(null);
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    layeredPane.setPreferredSize(screenSize);
    layeredPane.setBounds(0, 0, screenSize.width, screenSize.height);
    backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 0, screenSize.width, screenSize.height);
    backgroundLabel.setLayout(new GridBagLayout());
    layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

    gbc = new GridBagConstraints();

    gbc.anchor = GridBagConstraints.CENTER;

    ReturnButton = new JButton("", buttonReturn);
    ReturnButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MusicPlayer.AudioClick();
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(ComoPanel.this);
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

    Elements();

    add(layeredPane);
    setPreferredSize(screenSize);
    setBounds(0, 0, screenSize.width, screenSize.height);
  }

  public static void Elements() {
    gbc.gridy = 0;
    gbc.gridx = 0;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new Insets(10, 10, 10, 10);
    textJoga = new JLabel(
        "Como Joga?");
    textJoga.setFont(FontsTitulo);
    textJoga.setForeground(Color.WHITE);
    backgroundLabel.add(textJoga, gbc);

    int width = 120;
    int height = 90;
    gbc.insets = new Insets(10, 10, 10, 10);
    botafundobotao1 = new ImageIcon("resources/Menu/foto1.png");
    Image image = botafundobotao1.getImage();
    Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    botafundobotao1 = new ImageIcon(newImage);
    fotoPrimaria = new JLabel(botafundobotao1);
    fotoPrimaria.setPreferredSize(new Dimension(width, height));

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.insets = new Insets(100, 0, 0, 0);
    gbc.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(fotoPrimaria, gbc);

    gbc.gridy = 2;
    gbc.insets = new Insets(0, 0, 0, 0);
    textRemocao = new JLabel(
        "<html><div style='width:200px; text-align: center;'>No jogo, você precisa coletar frutas que fornecem pontos para aumentar sua pontuação total.</div></html>");
    textRemocao.setFont(Fonts);
    textRemocao.setPreferredSize(new Dimension(260, 100));
    textRemocao.setForeground(Color.WHITE);
    backgroundLabel.add(textRemocao, gbc);

    botafundobotao1 = new ImageIcon("resources/Menu/foto2.png");
    Image image2 = botafundobotao1.getImage();
    Image newImage2 = image2.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    botafundobotao2 = new ImageIcon(newImage2);
    fotoSegundaria = new JLabel(botafundobotao2);
    fotoSegundaria.setPreferredSize(new Dimension(width, height));

    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.insets = new Insets(50, 0, 0, 0);
    gbc.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(fotoSegundaria, gbc);

    gbc.gridy = 4;
    gbc.insets = new Insets(15, 0, 0, 0);
    textRemocao1 = new JLabel(
        "<html><div style='width:250px; text-align: center;'> Para vencer (ZERAR) cada mapa do jogo, é necessário alcançar 200 pontos, tanto no modo Normal, Fácil ou Difícil. Isso pode ser feito ao comer as frutas corretas.</div></html>");
    textRemocao1.setFont(Fonts);
    textRemocao1.setPreferredSize(new Dimension(320, 130));
    textRemocao1.setForeground(Color.WHITE);
    backgroundLabel.add(textRemocao1, gbc);

    botafundobotao3 = new ImageIcon("resources/Menu/foto3.png");
    Image image3 = botafundobotao3.getImage();
    Image newImage3 = image3.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    botafundobotao3 = new ImageIcon(newImage3);
    fotoTerciaria = new JLabel(botafundobotao3);
    fotoTerciaria.setPreferredSize(new Dimension(width, height));

    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.insets = new Insets(50, 0, 0, 0);
    gbc.anchor = GridBagConstraints.CENTER;
    backgroundLabel.add(fotoTerciaria, gbc);
    //
    gbc.gridy = 6;
    gbc.insets = new Insets(5, 0, 0, 0);
    textRemocao1 = new JLabel(
        "<html><div style='width:260px; text-align: center;'>As frutas no jogo têm diferentes efeitos e valores de pontos. A fruta comum ajuda a acumular pontos de maneira constante. A de Energia concede um aumento temporário na velocidade <strong style='color:rgb(146, 255, 255);''>a depender da velocidade da cobra</strong>, a um período curto. E a de Veneno Reduz a pontuação do jogador pela metade.</div></html>");
    textRemocao1.setFont(Fonts);
    textRemocao1.setPreferredSize(new Dimension(350, 200));
    textRemocao1.setForeground(Color.WHITE);
    backgroundLabel.add(textRemocao1, gbc);
  }
}
