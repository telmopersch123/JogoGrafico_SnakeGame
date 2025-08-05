import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

public class CustomSlider extends JSlider {
    private Image backgroundImage;
    private Image thumbImage;
    private Preferences prefs;
    private String sliderPositionKey;
    static int sliderPosition;

    public CustomSlider(Image backgroundImage, Image thumbImage, Preferences prefs, String sliderPositionKey) {
        super();
        this.backgroundImage = backgroundImage;
        this.thumbImage = thumbImage;
        this.prefs = prefs;
        this.sliderPositionKey = sliderPositionKey;

        if (Game.userInteracted) {
            resetPreferences();
            sliderPosition = 80;

            setValue(sliderPosition);
        } else {
            sliderPosition = prefs.getInt(sliderPositionKey, 80);

            setValue(sliderPosition);

        }

        setUI(new CustomSliderUI(this));
        setOpaque(false);
        setPreferredSize(new Dimension(200, 40));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Game.userInteracted = false;
                int mouseX = e.getX();
                int thumbWidth = thumbImage.getWidth(null);
                int minPos = thumbWidth / 2;
                int maxPos = getWidth() - thumbWidth / 2;
                int newValue = (int) Math.round((double) (mouseX - minPos) / (maxPos - minPos) * getMaximum());
                if (newValue >= -10 && newValue <= 0) {
                    setValue(0);
                } else {
                    setValue(newValue);
                }
            }
        });
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int newValue = getValue();
                prefs.putInt(sliderPositionKey, newValue);
                repaint();
            }
        });

    }

    private void resetPreferences() {
       
        prefs.remove(sliderPositionKey);
    }

    public void updateImages(Image background, Image thumb) {
        this.backgroundImage = background;
        this.thumbImage = thumb;
        repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        super.paintComponent(g);
    }

    private class CustomSliderUI extends BasicSliderUI {
        public CustomSliderUI(JSlider b) {
            super(b);
        }

        @Override
        public void paintTrack(Graphics g) {
            // Não pintar a trilha
        }

        private static final int OFFSET = 5;

        @Override
        public void paintThumb(Graphics g) {
            int thumbWidth = thumbImage.getWidth(null);
            int thumbHeight = thumbImage.getHeight(null);
            int x = thumbRect.x - thumbWidth / 2;
            int y = thumbRect.y + (thumbRect.height - thumbHeight) / 2;

            if (slider.getValue() == slider.getMinimum()) {
                x = Math.max(0, thumbRect.x - thumbWidth / 2 + OFFSET + 10);
            } else if (slider.getValue() == slider.getMaximum()) {
                x = Math.min(slider.getWidth() - thumbWidth, thumbRect.x - thumbWidth / 2 - OFFSET);
            }

            g.drawImage(thumbImage, x, y, thumbWidth, thumbHeight, null);
        }

    }

}
