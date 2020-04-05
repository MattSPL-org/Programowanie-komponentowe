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
	
	public void createDigit(int number) throws IOException 
	{
		BufferedImage temp = ImageIO.read(basicDigitPath);
		
		try {
			//ImageIO.write(temp, "png", new File("test.png"));
			ImageIO.write(basicDigit, "png",new File("szkic.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		switch(number)
		{
		case 0:
			
			 //temp = basicDigit;
			for(int i=0; i<94;i++)
			{
				for(int j=0;j<144;j++)
				{
					if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segCcolor|| basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segFcolor)
					{
						temp.setRGB(i, j, primaryColor.getRGB());
						
					}
					
					else if(basicDigit.getRGB(i, j)==segGcolor)
					{
						temp.setRGB(i, j, secondaryColor.getRGB());
					}
				}
			}
			try {
				ImageIO.write(temp, "png", new File(""+number+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			temp=basicDigit;
			break;
			
		case 1:
		
		//	temp = basicDigit;
			for(int i=0; i<94;i++)
			{
				for(int j=0;j<144;j++)
				{
					if( basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segCcolor )
					{
						temp.setRGB(i, j, primaryColor.getRGB());
						
					}
					
					else if(basicDigit.getRGB(i, j)==segAcolor|| basicDigit.getRGB(i, j)==segGcolor || basicDigit.getRGB(i, j)==segDcolor|| basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segFcolor)
					{
						temp.setRGB(i, j, secondaryColor.getRGB());
					}
				}
			}
			try {
				ImageIO.write(temp, "png", new File(""+number+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			temp=basicDigit;
			break;
			
		case 2:
			
			//temp = basicDigit;
			for(int i=0; i<94;i++)
			{
				for(int j=0;j<144;j++)
				{
					if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segEcolor|| basicDigit.getRGB(i, j)==segGcolor )
					{
						temp.setRGB(i, j, primaryColor.getRGB());
						
					}
					
					else if(basicDigit.getRGB(i, j)==segCcolor || basicDigit.getRGB(i, j)==segFcolor)
					{
						temp.setRGB(i, j, secondaryColor.getRGB());
					}
				}
			}
			try {
				ImageIO.write(temp, "png", new File(""+number+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			case 3:
			
			//temp = basicDigit;
			for(int i=0; i<94;i++)
			{
				for(int j=0;j<144;j++)
				{
					if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segDcolor || basicDigit.getRGB(i, j)==segCcolor|| basicDigit.getRGB(i, j)==segGcolor )
					{
						temp.setRGB(i, j, primaryColor.getRGB());
						
					}
					
					else if(basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segFcolor)
					{
						temp.setRGB(i, j, secondaryColor.getRGB());
					}
				}
			}
			try {
				ImageIO.write(temp, "png", new File(""+number+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			case 4:
				
				//temp = basicDigit;
				for(int i=0; i<94;i++)
				{
					for(int j=0;j<144;j++)
					{
						if(basicDigit.getRGB(i, j)==segBcolor || basicDigit.getRGB(i, j)==segCcolor || basicDigit.getRGB(i, j)==segFcolor|| basicDigit.getRGB(i, j)==segGcolor )
						{
							temp.setRGB(i, j, primaryColor.getRGB());
							
						}
						
						else if(basicDigit.getRGB(i, j)==segAcolor || basicDigit.getRGB(i, j)==segEcolor || basicDigit.getRGB(i, j)==segDcolor)
						{
							temp.setRGB(i, j, secondaryColor.getRGB());
						}
					}
				}
				try {
					ImageIO.write(temp, "png", new File(""+number+".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
		}
	}
}

