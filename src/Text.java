import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

class TextShadow extends JLabel {
  private Color shadowColor;

  public TextShadow(String text, Color textColor, Color shadowColor, Font font) {
    super(text);
    this.setForeground(textColor);
    this.shadowColor = shadowColor;
    if (font != null) {
      this.setFont(font);
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
   
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

 
    int shadowOffset = 0;
    g2.setColor(shadowColor);
    g2.drawString(getText(), shadowOffset, getHeight() - shadowOffset);

  
    g2.setColor(getForeground());
    g2.drawString(getText(), 0, getHeight() - 2);

    g2.dispose();
  }

  public void setShadowColor(Color black) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setShadowColor'");
  }

  public void setColor(Color white) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setColor'");
  }

  public void setForegroundColor(Color color) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setForegroundColor'");
  }

  public void setShadowOpacity(float f) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setShadowOpacity'");
  }

  public void setForegroundOpacity(float f) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setForegroundOpacity'");
  }
}
