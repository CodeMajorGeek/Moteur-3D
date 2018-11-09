package fr.EasyGameMotor.Utils;

import fr.EasyGameMotor.Core.Frame;

public class Edge {

	final int X;
	final int Y;
	
	public Edge(int x, int y) {
		
		X = x;
		Y = y;
	}
	
	public int getX() {
		
		return X;
	}
	
	public int getY() {
		
		return Y;
	}
	
	public static double length(int a, int b){
		
		return Math.sqrt(Math.pow(Frame.Points.get(b).getX()-Frame.Points.get(a).getX(), 2) + Math.pow(Frame.Points.get(b).getY()-Frame.Points.get(a).getY(), 2) + Math.pow(Frame.Points.get(b).getZ()-Frame.Points.get(a).getZ(), 2));
	}
}
