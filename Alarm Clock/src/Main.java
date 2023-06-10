import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sound.sampled.*;

public class Main implements Runnable{
	

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		
		MyFrame f = new MyFrame();
		
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
		File file = new File("Alarm Clock.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					Date currentDate = new Date();
					String t = timeFormat.format(currentDate);
					f.setS(t);
					f.setHH(t.substring(0, 2));
					f.setMM(t.substring(3, 5));
					f.setZM(t.substring(9, 11));

					if (f.getahour().equals(f.getHH())) {
						if (f.getaminute().equals(f.getMM())) {
							if (f.getym().equals(f.getZM())) {
								clip.start();
								try {
									Thread.sleep(5000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								System.exit(0);
							}
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.run();
	}

	@Override
	public void run() {
		
		
	}

}
