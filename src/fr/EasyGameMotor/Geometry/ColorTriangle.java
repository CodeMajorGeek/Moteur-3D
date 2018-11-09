package fr.EasyGameMotor.Geometry;

import java.awt.Color;

import fr.EasyGameMotor.Core.Frame;

public class ColorTriangle {

	public ColorTriangle(int size) {
		
		Frame.createPoint(0, 0, 0);
		Frame.createPoint(0, size, 0);
		Frame.createPoint(-size, 0, size);
		Frame.createPoint(size, 0, size);
		
		Frame.createEdge(1, 0);
		Frame.createEdge(1, 2);
		Frame.createEdge(1, 3);
		Frame.createEdge(2, 3);
		Frame.createEdge(0, 2);
		Frame.createEdge(0, 3);
		
		Frame.createFace(0, 1, 3, Color.ORANGE);
		Frame.createFace(0, 1, 2, Color.BLUE);
		Frame.createFace(1, 2, 3, Color.RED);
		Frame.createFace(0, 2, 3, Color.WHITE);
	}
	
}
