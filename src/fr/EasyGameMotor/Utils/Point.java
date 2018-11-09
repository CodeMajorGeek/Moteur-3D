package fr.EasyGameMotor.Utils;

public class Point {
	
	double X;
	double Y;
	double Z;
	double A;
	double B;
	double C;
	
	public Point(double x, double y, double z, double a, double b, double c) {
		
		X = x;
		Y = y;
		Z = z;
		A = a;
		B = b;
		C = c;
	}
	
	public double getX() {
		
		return X;
	}
	
	public double getY() {
		
		return Y;
	}
	
	public double getZ() {
		
		return Z;
	}
	
	public double getA() {
		
		return A;
	}
	
	public double getB() {
		
		return B;
	}
	
	public double getC() {
		
		return C;
	}
	
	public void setX(double x) {
		
		X = x;
	}
	
	public void setY(double y) {
		
		Y = y;
	}
	
	public void setZ(double z) {
		
		Z = z;
	}
	
	public void setA(double a) {
		
		A = a;
	}
	
	public void setB(double b) {
		
		B = b;
	}
	
	public void setC(double c) {
		
		C = c;
	}
}
