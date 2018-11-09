package fr.EasyGameMotor.Geometry;

import java.awt.Color;

import fr.EasyGameMotor.Core.Frame;

public class ColorSquare {

	public ColorSquare(int x, int y, int z, int width) {
		
		Frame.createPoint(x + width, y + width, z + width);
		Frame.createPoint(x + width, y + width, z - width);
		Frame.createPoint(x + width, y - width, z + width);
		Frame.createPoint(x + width, y - width, z - width);
		Frame.createPoint(x - width, y + width, z + width);
		Frame.createPoint(x - width, y + width, z - width);
		Frame.createPoint(x - width, y - width, z + width);
		Frame.createPoint(x - width, y - width, z - width);
		
		Frame.createEdge(Frame.Points.size() - 5, Frame.Points.size() - 1);
		Frame.createEdge(Frame.Points.size() - 2, Frame.Points.size() - 1);
		Frame.createEdge(Frame.Points.size() - 2, Frame.Points.size() - 6);
		Frame.createEdge(Frame.Points.size() - 5, Frame.Points.size() - 6);
		Frame.createEdge(Frame.Points.size() - 5, Frame.Points.size() - 7);
		Frame.createEdge(Frame.Points.size() - 3, Frame.Points.size() - 1);
		Frame.createEdge(Frame.Points.size() - 2, Frame.Points.size() - 4);
		Frame.createEdge(Frame.Points.size() - 8, Frame.Points.size() - 6);
		Frame.createEdge(Frame.Points.size() - 3, Frame.Points.size() - 7);
		Frame.createEdge(Frame.Points.size() - 3, Frame.Points.size() - 4);
		Frame.createEdge(Frame.Points.size() - 7, Frame.Points.size() - 8);
		Frame.createEdge(Frame.Points.size() - 4, Frame.Points.size() - 8);
		
		/*Frame.createTexture("/res/dirt.png", Frame.Points.size() - 3, Frame.Points.size() - 8, Frame.Points.size() - 4);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 3, Frame.Points.size() - 7, Frame.Points.size() - 8);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 1, Frame.Points.size() - 5, Frame.Points.size() - 3);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 5, Frame.Points.size() - 7, Frame.Points.size() - 3);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 1, Frame.Points.size() - 4, Frame.Points.size() - 2);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 1, Frame.Points.size() - 3, Frame.Points.size() - 4);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 4, Frame.Points.size() - 6, Frame.Points.size() - 2);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 4, Frame.Points.size() - 8, Frame.Points.size() - 6);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 5, Frame.Points.size() - 6, Frame.Points.size() - 8);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 5, Frame.Points.size() - 8, Frame.Points.size() - 7);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 1, Frame.Points.size() - 2, Frame.Points.size() - 6);
		Frame.createTexture("/res/dirt.png", Frame.Points.size() - 1, Frame.Points.size() - 6, Frame.Points.size() - 5);*/
		
		Frame.createFace(Frame.Points.size() - 3, Frame.Points.size() - 8, Frame.Points.size() - 4, Color.YELLOW);
		Frame.createFace(Frame.Points.size() - 3, Frame.Points.size() - 7, Frame.Points.size() - 8, Color.YELLOW);
		Frame.createFace(Frame.Points.size() - 1, Frame.Points.size() - 5, Frame.Points.size() - 3, Color.BLUE);
		Frame.createFace(Frame.Points.size() - 5, Frame.Points.size() - 7, Frame.Points.size() - 3, Color.BLUE);
		Frame.createFace(Frame.Points.size() - 1, Frame.Points.size() - 4, Frame.Points.size() - 2, Color.RED);
		Frame.createFace(Frame.Points.size() - 1, Frame.Points.size() - 3, Frame.Points.size() - 4, Color.RED);
		Frame.createFace(Frame.Points.size() - 4, Frame.Points.size() - 6, Frame.Points.size() - 2, Color.GREEN);
		Frame.createFace(Frame.Points.size() - 4, Frame.Points.size() - 8, Frame.Points.size() - 6, Color.GREEN);
		Frame.createFace(Frame.Points.size() - 5, Frame.Points.size() - 6, Frame.Points.size() - 8, Color.ORANGE);
		Frame.createFace(Frame.Points.size() - 5, Frame.Points.size() - 8, Frame.Points.size() - 7, Color.ORANGE);
		Frame.createFace(Frame.Points.size() - 1, Frame.Points.size() - 2, Frame.Points.size() - 6, Color.WHITE);
		Frame.createFace(Frame.Points.size() - 1, Frame.Points.size() - 6, Frame.Points.size() - 5, Color.WHITE);
	}
	
}
