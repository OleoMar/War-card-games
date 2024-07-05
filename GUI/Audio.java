package GUI;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
	@SuppressWarnings("static-access")
	public static void BGM(String path) {
		try {
			//Obtain an AudioInputStream from the file path
			AudioInputStream music = AudioSystem.getAudioInputStream(new File(path));
			Clip clip = AudioSystem.getClip();
			clip.open(music); //start music
			clip.loop(clip.LOOP_CONTINUOUSLY); //make in play in loop
		}catch(UnsupportedAudioFileException e) { //incase the audio file is in format that is not supported 
			e.printStackTrace();
		}catch(IOException e) { //in case there are issues with reading the audio file 
			e.printStackTrace();
		} catch (LineUnavailableException e) { //incase a line cannot be opened because it is unavailable
			e.printStackTrace();
		}
	}
	

}
