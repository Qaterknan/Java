import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Loader {
	
	public String[][] imageNames;
	public String[][] soundNames;
	public HashMap<String, Image> imageStorage = new HashMap<String, Image>();
	public HashMap<String, Clip> soundStorage = new HashMap<String, Clip>();
	
	public Loader(){
		
	}
	
	private boolean systemMessage(Exception ex){
		System.out.println(ex.getMessage());
		return false;
	}
	
	public boolean loadImage(int i){
		try{
			File file = new File(imageNames[i][0]);
			Image img = ImageIO.read(file);
			imageStorage.put(imageNames[i][1], img);
			return true;
		}
		catch(NullPointerException ex){
			return systemMessage(ex);
		}
		catch(IOException ex){
			return systemMessage(ex);
		}
	}
	
	public boolean loadSound(int i){
		try{
			File file = new File(soundNames[i][0]);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			soundStorage.put(soundNames[i][1], clip);
			return true;
		}
		catch(NullPointerException ex){
			return systemMessage(ex);
		}
		catch(IOException ex){
			return systemMessage(ex);
		}
		catch(LineUnavailableException ex){
			return systemMessage(ex);
		}
		catch(UnsupportedAudioFileException ex){
			return systemMessage(ex);
		}
	}
}
