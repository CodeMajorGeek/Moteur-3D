package fr.EasyGameMotor.Core;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Texture {
	
    public TexturePaint getTexture(String src) {
    	
    	ImageIcon i = new ImageIcon(getClass().getResource(src));
    	Image img = i.getImage();
    	TexturePaint texture = new TexturePaint(toBufferedImage(img), new Rectangle2D.Double(0.0, 0.0, img.getWidth(null), img.getHeight(null)));
    	
    	return texture;
    }
    
    private BufferedImage toBufferedImage(Image img) {
    	
    	if(img instanceof BufferedImage) {
    		
    		return (BufferedImage) img;
    	}
    	
    	BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    	
    	Graphics2D bGr = bimage.createGraphics();
    	bGr.drawImage(img, 0, 0, null);
    	bGr.dispose();
    	
    	return bimage;
    }
}