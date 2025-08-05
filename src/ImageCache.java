import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageCache {
  private static Map<String, Image> imageCache = new HashMap<>();

  public static Image getImage(String path) throws IOException {
    String basePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator;
    String fullPath = basePath + path;
    
    if (!imageCache.containsKey(fullPath)) {
      Image image = ImageIO.read(new File(fullPath));
      imageCache.put(fullPath, image);
    }
    return imageCache.get(fullPath);
  }
}
