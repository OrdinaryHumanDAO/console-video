package console_video;

import org.bytedeco.javacv.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class App {
    private static long startTime = 0;

    public static void main(String[] args) {
    	if(args.length != 1) {
			System.out.println("add file path");
			System.exit(0);
		}
		File file = new File(args[0]);
		if(!file.exists()) {
			System.out.println("not exist file");
			System.exit(0);
		}
		
        clearConsole();
        
        FrameGrabber grabber = new FFmpegFrameGrabber(file);
        Java2DFrameConverter frameConverter = new Java2DFrameConverter();
        ConsoleImage ci = new ConsoleImage();
        
        try {
			grabber.start();
			
			Frame frame = null;
	        while ((frame = grabber.grab()) != null) {
	        	System.out.print("\u001b[H");
	        	
	            BufferedImage img = frameConverter.convert(frame);
	            if (img == null) {
	            	// Sometimes I can't get the BufferedImage
	                continue;
	            }
	            
	            waitForTimestamp(frame);
	            BufferedImage resizeImage = ci.resizeImage(img, 110, 110);
	    		BufferedImage greyScaleImage = ci.grayScaleImage(resizeImage);
	    		char[][] consoleImage = ci.ImageToConsoleImage(greyScaleImage);
	    		System.out.print(ci.printConsoleImage(consoleImage));
	    		
	    		
	        }
	        
	        grabber.stop();
	        grabber.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    public static void waitForTimestamp(Frame frame) throws Exception {
    	if (startTime == 0) {
            startTime = System.nanoTime() / 1000 - frame.timestamp;
        } else {
            long delay = frame.timestamp - (System.nanoTime() / 1000 - startTime);
            if (delay > 0) {
                Thread.sleep(delay / 1000, (int)(delay % 1000) * 1000);
            }
        }
    }
   
	
	@SuppressWarnings("deprecation")
	private static void clearConsole() {
        final String os = System.getProperty("os.name");

        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
