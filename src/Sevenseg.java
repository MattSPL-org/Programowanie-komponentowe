import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sevenseg extends JPanel {
	
	private Color primaryColor;
	private Color secondaryColor;
	private Color backgroundColor;
	
	private File basicDigitPath = new File("7seg.png");
	private BufferedImage basicDigit;
	
	private int segAcolor= new Color(255,255,255).getRGB();
	private int segBcolor= new Color(0,0,255).getRGB();
	private int segCcolor= new Color(0,255,0).getRGB();
	private int segDcolor= new Color(0,255,255).getRGB();
	private int segEcolor= new Color(255,0,0).getRGB();
	private int segFcolor= new Color(255,0,255).getRGB();
	private int segGcolor= new Color(255,255,0).getRGB();
	
	
	{
	
	try {
	basicDigit = ImageIO.read(basicDigitPath);
	}
	catch(FileNotFoundException e) {
		System.out.println("Brak wzoru wyświetlacza 7segmentowego!");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			}
	
	public void setPrimaryColor(Color paint)
	{
		this.primaryColor=paint;
	}
	
	public void setSecondaryColor(Color paint)
	{
		this.secondaryColor=paint;
	}
	
	public void setBackgroundColor(Color paint)
	{
		this.backgroundColor=paint;
	}
	
	public Color getPrimaryColor()
	{
		return primaryColor;
	}
	
	public Color getSecondaryColor()
	{
		return secondaryColor; 
	}
	
	public Color getBackgroundColor()
	{
		return backgroundColor;
	}
	
	public void displayDigit(int number)
	{
		switch(number)
		{
		case 0:
			for(int i=0; i<94;i++)
			{
				for(int j=0;j<144;j++)
				{
					if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segCcolor|| basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segFcolor)
					{
						
						
					}
				}
			}
		}
	}
}

