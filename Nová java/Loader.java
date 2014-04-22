import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Loader {
	
	public ArrayList<String[]> imageNames = new ArrayList<String[]>();
	public ArrayList<String[]> soundNames = new ArrayList<String[]>();
	public String[][] imageNamesToLoad;
	public String[][] soundNamesToLoad;
	public HashMap<String, Image> imageStorage = new HashMap<String, Image>();
	public HashMap<String, Clip> soundStorage = new HashMap<String, Clip>();
	
	public float progress = 0;
	
	public Loader(){
		
	}
	
	private boolean systemMessage(Exception ex){
		System.out.println(ex.getMessage());
		return false;
	}
	
	public boolean loadImage(int i){
		try{
			String key = imageAlreadyLoaded(imageNamesToLoad[i][0]);
			if(key == "NOT"){
				File file = new File(imageNamesToLoad[i][0]);
				Image img = ImageIO.read(file);
				imageStorage.put(imageNamesToLoad[i][1], img);
				String[] imageIDs = new String[2];
				imageIDs[0] = imageNamesToLoad[i][0];
				imageIDs[1] = imageNamesToLoad[i][1];
				imageNames.add(imageIDs);
				return true;
			}
			else{
				imageStorage.put(imageNamesToLoad[i][1], imageStorage.get(key));
				return true;
			}
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
			String key = soundAlreadyLoaded(soundNamesToLoad[i][0]);
			if(key == "NOT"){
				File file = new File(soundNamesToLoad[i][0]);
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(file));
				soundStorage.put(soundNamesToLoad[i][1], clip);
				String[] soundIDs = new String[2];
				soundIDs[0] = soundNamesToLoad[i][0];
				soundIDs[1] = soundNamesToLoad[i][1];
				soundNames.add(soundIDs);
				return true;
			}
			else {
				soundStorage.put(soundNamesToLoad[i][0], soundStorage.get(key));
				return true;
			}
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
	
	public boolean loadAssets(){
		long overallSize = 0;
		long sizeLoaded = 0;
		long[] imageSizes = new long[imageNamesToLoad.length];
		long[] soundSizes = new long[soundNamesToLoad.length];
		for(int i = 0; i < imageNamesToLoad.length; i++){
			imageSizes[i] = new File(imageNamesToLoad[i][0]).length();
			overallSize += imageSizes[i];
		};
		for(int i = 0; i < soundNamesToLoad.length; i++){
			soundSizes[i] = new File(soundNamesToLoad[i][0]).length();
			overallSize += soundSizes[i];
		};
		for(int i = 0; i < imageNamesToLoad.length; i++){
			loadImage(i);
			sizeLoaded += imageSizes[i];
			progress = (float) sizeLoaded/overallSize;
		};
		for(int i = 0; i < soundNamesToLoad.length; i++){
			loadSound(i);
			sizeLoaded += soundSizes[i];
			progress = (float) sizeLoaded/overallSize;
		};
		return true;
	}
	
	public String imageAlreadyLoaded(String src){
		for(String[] imageIDs : imageNames){
			if(imageIDs[0] == src){
				return imageIDs[1];
			}
		};
		return "NOT";
	};
	
	public String soundAlreadyLoaded(String src){
		for(String[] soundIDs : soundNames){
			if(soundIDs[0] == src){
				return soundIDs[1];
			}
		};
		return "NOT";
	}
}
