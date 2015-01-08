package day8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Painter extends JPanel {
    int x = 20;
    BufferedImage image = null;
     BufferedImage imageCover = null;
    
	public Painter(){
		JFrame jf = new JFrame();
		jf.setMinimumSize(new Dimension(800,600));
		jf.setLocation(80,80);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.getContentPane().add(this);
		Label label = new Label();
		label.setFont(new Font("TimesNewRoman",Font.BOLD,18));
		label.setText("My first text!");
		this.add(label);
		
		
		try {
			image = ImageIO.read(new File("RedTankLeft.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			imageCover = ImageIO.read(new File("MyWater1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		jf.pack();
		
		jf.setVisible(true);
		
		//repaint(); 
	}

	@Override
	protected void paintComponent(Graphics g)  {
		super.paintComponent(g);
				
		g.setColor(Color.BLUE);
		g.drawRect(x, 120, 50, 50);
		
		g.setColor(Color.green);
		g.setFont(new Font("Areal",Font.BOLD,14));
		g.drawString("HELLO!!!", 50, 50);
		
		g.drawImage(image, 250, x+250, null);
		g.drawImage(imageCover, 250, x+250, null);
		
		
	}
	
}
