package fr.EasyGameMotor.Core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private static final long serialVersionUID = -6328638505394978503L;
	private Texture texture = new Texture();
	
	public Panel() {
		
		setFocusable(true);
		requestFocus();
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g);
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, getSize().width, getSize().height);
		
		double Size = (getSize().width+getSize().height)/2;
		
		for(int i = 0; i < Frame.Faces.size(); i++) {
			if(Frame.FaceIs.get(i) && Frame.Faces.get(i).getH() == 1 && Frame.Faces.get(i).getI() == 0) {
				
				g2.setColor(new Color(Frame.Faces.get(i).getD(), Frame.Faces.get(i).getE(), Frame.Faces.get(i).getF(), Frame.Faces.get(i).getG()));
				int[] x = {(int)(Frame.Points.get(Frame.Faces.get(i).getA()).getA()*Size-2+getSize().width/2),(int)(Frame.Points.get(Frame.Faces.get(i).getB()).getA()*Size-2+getSize().width/2),(int)(Frame.Points.get(Frame.Faces.get(i).getC()).getA()*Size-2+getSize().width/2)};
				int[] y = {(int)(Frame.Points.get(Frame.Faces.get(i).getA()).getB()*Size-2+getSize().height/2),(int)(Frame.Points.get(Frame.Faces.get(i).getB()).getB()*Size-2+getSize().height/2),(int)(Frame.Points.get(Frame.Faces.get(i).getC()).getB()*Size-2+getSize().height/2)};
				g2.fillPolygon(x, y, 3);
			} else if(Frame.FaceIs.get(i) && Frame.Faces.get(i).getH() == 1 && Frame.Faces.get(i).getI() == 1) {
				
				int[] x = {(int)(Frame.Points.get(Frame.Faces.get(i).getA()).getA()*Size-2+getSize().width/2),(int)(Frame.Points.get(Frame.Faces.get(i).getB()).getA()*Size-2+getSize().width/2),(int)(Frame.Points.get(Frame.Faces.get(i).getC()).getA()*Size-2+getSize().width/2)};
				int[] y = {(int)(Frame.Points.get(Frame.Faces.get(i).getA()).getB()*Size-2+getSize().height/2),(int)(Frame.Points.get(Frame.Faces.get(i).getB()).getB()*Size-2+getSize().height/2),(int)(Frame.Points.get(Frame.Faces.get(i).getC()).getB()*Size-2+getSize().height/2)};
				g2.setPaint(texture.getTexture(Frame.Textures.get(i)));
				g2.fillPolygon(x, y, 3);
			}
		}
		
		g2.setColor(Color.WHITE);
		for(int i = 0; i < Frame.Points.size(); i++) {
			if(Frame.PointIs.get(i)) {
				
				g2.fillRect((int)(Frame.Points.get(i).getA()*Size-2+getSize().width/2), (int)(Frame.Points.get(i).getB()*Size-2+getSize().height/2), 4, 4);
				g2.drawString(Integer.toString(i), (int)(Frame.Points.get(i).getA()*Size-2+getSize().width/2), (int)(Frame.Points.get(i).getB()*Size-2+getSize().height/2));
			}
		}
		
		for(int i = 0; i < Frame.Edges.size(); i ++) {
			if(Frame.EdgeIs.get(i)) {
				
				g2.drawLine((int)(Frame.Points.get(Frame.Edges.get(i).getX()).getA()*Size-2+getSize().width/2), (int)(Frame.Points.get(Frame.Edges.get(i).getX()).getB()*Size-2+getSize().height/2), (int)(Frame.Points.get(Frame.Edges.get(i).getY()).getA()*Size-2+getSize().width/2), (int)(Frame.Points.get(Frame.Edges.get(i).getY()).getB()*Size-2+getSize().height/2));
			}
		}
		g2.setColor(Color.YELLOW);
		g2.drawString("FPS: " + Frame.FPS, 10, 10);
	}
}
