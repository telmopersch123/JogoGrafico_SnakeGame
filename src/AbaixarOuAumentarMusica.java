import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AbaixarOuAumentarMusica {
  private static float MIN_VOLUME = -20.0f; 
  private static float MAX_VOLUME = 6.0f; 

  public static void setVolumeForAllClips(int volumePercentage) {
   
    if (volumePercentage < 0) {
      volumePercentage = 0;
    }
    if (volumePercentage > 100) {
      volumePercentage = 100;
    }
    float volume;

    if (volumePercentage == 0) {
      volume = -100.00f;
    } else {

      float normalizedVolume = volumePercentage / 100.0f;
      volume = MIN_VOLUME + (MAX_VOLUME - MIN_VOLUME) * normalizedVolume;
    }

    for (Clip audioClip : MusicPlayer.audioClips) {
      FloatControl volumeControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);

      volume = Math.min(volume, volumeControl.getMaximum());

      volume = Math.max(volume, volumeControl.getMinimum());

      volumeControl.setValue(volume);
    }
  }
  
  public static void setVolumeEffectsForAllClips(int volumePercentage) {
    if (volumePercentage < 0) {
      volumePercentage = 0;
    }
    if (volumePercentage > 100) {
      volumePercentage = 100;
    }
    float volume;

    if (volumePercentage == 0) {
      volume = -100.00f;
    } else {

      float normalizedVolume = volumePercentage / 100.0f;
      volume = MIN_VOLUME + (MAX_VOLUME - MIN_VOLUME) * normalizedVolume;
    }

    for (Clip effectClip : MusicPlayer.effectsClips) {
      FloatControl volumeControl = (FloatControl) effectClip.getControl(FloatControl.Type.MASTER_GAIN);

      volume = Math.min(volume, volumeControl.getMaximum());

      volume = Math.max(volume, volumeControl.getMinimum());

      volumeControl.setValue(volume);
    }
  }
}
