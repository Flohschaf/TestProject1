package pp2013.gruppe07.client.gui.daniel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Minibild extends JPanel{
	Image img;
	String name;
	
	Font font;
	public Minibild(Image img,String name,Font font ){
		this.img = img;
		this.name = name;
		this.font = font;
		this.setPreferredSize(new Dimension(60	,70));
		//this.setLayout(new BorderLayout());
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void paint(Graphics g){
		super.paintComponents(g);
		g.drawImage(img, 0, 0,this);
		g.setColor(Color.GREEN);
		g.setFont(font);
		g.drawString(name, 70, 0);
	}
	
	
	
	
	
}
