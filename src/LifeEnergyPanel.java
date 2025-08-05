import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class LifeEnergyPanel extends JPanel {
    private BufferedImage lifeEnergyImage;
    private int frameIndex;
    private int numFramesX = 2;
    private int numFramesY = 11;
    private boolean gameOver;
    private int totalFrames;
    static int WidthBarraEnergy;
    static int HeightBarraEnergy;
    static BufferedImage ImageLifeEnergy;
    static long lastFrameTime = 0;
    static long frameInterval = 440;
    static float ValueTransperLifeEnergy = 0.5f;

    public LifeEnergyPanel(Graphics g, BufferedImage lifeEnergyImage, int numFramesX, int numFramesY) {
        this.lifeEnergyImage = lifeEnergyImage;
        this.numFramesX = numFramesX;
        this.numFramesY = numFramesY;
        this.totalFrames = numFramesX * numFramesY;
        this.frameIndex = totalFrames - 1;
        this.gameOver = false;
        updateDimensions(g);
        setOpaque(false);
    }

    private void updateDimensions(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (Game.ControlTamanho) {
            WidthBarraEnergy = 200;
            HeightBarraEnergy = 50;
            ValueTransperLifeEnergy = 1.0f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, ValueTransperLifeEnergy));
        } else {
            frameIndex = totalFrames - 1;
            WidthBarraEnergy = 100;
            HeightBarraEnergy = 25;
            ValueTransperLifeEnergy = 0.5f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, ValueTransperLifeEnergy));
        }
        setPreferredSize(new Dimension(WidthBarraEnergy, HeightBarraEnergy));
        setMinimumSize(new Dimension(WidthBarraEnergy, HeightBarraEnergy));
        setMaximumSize(new Dimension(WidthBarraEnergy, HeightBarraEnergy));
        revalidate();
        repaint();
    }

    public void setFrameIndex(int frameIndex) {
        this.frameIndex = frameIndex;
        repaint();
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (lifeEnergyImage != null && !gameOver) {
            updateDimensions(g);
            int frameWidth = lifeEnergyImage.getWidth() / numFramesX;
            int frameHeight = lifeEnergyImage.getHeight() / numFramesY;
            int sx1 = (frameIndex % numFramesX) * frameWidth;
            int sy1 = (frameIndex / numFramesX) * frameHeight;
            BufferedImage currentFrame = lifeEnergyImage.getSubimage(sx1, sy1, frameWidth, frameHeight);

            Graphics2D g2d = (Graphics2D) g;
            AffineTransform at = new AffineTransform();
            at.scale((double) getWidth() / frameWidth, (double) getHeight() / frameHeight);
            AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            BufferedImage scaledImage = op.filter(currentFrame, null);
            g2d.drawImage(scaledImage, 0, 0, WidthBarraEnergy, HeightBarraEnergy, null);
            if (Game.VelocityControl && Game.ColisionEnergy) {
                updateFrame();
            }
        }
    }

    public void updateFrame() {
        if (!gameOver) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastFrameTime >= frameInterval) {
                lastFrameTime = currentTime - (currentTime % frameInterval);
                frameIndex = (frameIndex + 1) % (numFramesX * numFramesY);
                repaint();
            }
        }
    }
}
