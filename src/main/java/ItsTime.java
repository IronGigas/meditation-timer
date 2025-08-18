import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ItsTime {
	
	int loop = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	
	static int time = 0;
	public static Timer timer;
	
		public void play() { 
		   renewTime();
		   if(Interface.waitFlag == 0){getTime();}
		   timer.schedule(new TimerTask() {
			   @Override
			   public void run() {
				   		   
				   	sound();
				   	loop++;
				   	if(loop == 1) this.cancel();
			   }
		   }, time, 2000); 
		}
		
		public void stopTimer(){
			try {
				timer.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void sound(){
	      try {
	    	  
	    	  URL url = this.getClass().getClassLoader().getResource("tada.wav");
	          // Open an audio input stream.
	    	  if(Interface.tadaButton.isSelected() == true) {url = this.getClass().getClassLoader().getResource("sounds/tada.wav");}
	    	  if(Interface.pulupiRadioButton.isSelected() == true) {url = this.getClass().getClassLoader().getResource("sounds/pulupi.wav");}
	    	  if(Interface.tuduRadioButton.isSelected() == true) {url = this.getClass().getClassLoader().getResource("sounds/tudu.wav");}
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	          
	          // Get a sound clip resource.
	          Clip clip = AudioSystem.getClip();
	          
	          // Open audio clip and load samples from the audio input stream.
	          clip.open(audioIn);
	          clip.start();
	          
	       } catch (UnsupportedAudioFileException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace();
	       } catch (LineUnavailableException e) {
	          e.printStackTrace();
	       } 
	     
		}
		
		public void getTime() {
			hours = Integer.parseInt(Interface.interfaceHours.getSelectedItem().toString());
			minutes = Integer.parseInt(Interface.interfaceMinutes.getSelectedItem().toString());
			seconds = Integer.parseInt(Interface.interfaceSeconds.getSelectedItem().toString());
			time = (hours * 60 * 60 * 1000) + (minutes * 60 * 1000) + (seconds * 1000);
		}
		
		public static void renewTime() {
			Timer updTimer = new Timer();
			timer = updTimer;
		}
}	

