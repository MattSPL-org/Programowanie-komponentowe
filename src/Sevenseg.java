import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sevenseg extends JPanel {
	
	private File basicDigitPath = new File("7seg.png");{
	
	try {
	BufferedImage basicDigit = ImageIO.read(basicDigitPath);
	}
	catch(FileNotFoundException e) {
		System.out.println("Brak wzoru wyświetlacza 7segmentowego!");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			}
}

