package fr.EasyGameMotor.Core;

public class Engine {
	
	
	public static void calculPoint(int i) {
		double c1x = Frame.Camera[3] - Frame.Camera[0];
		double c1y = Frame.Camera[4] - Frame.Camera[1];
		double c1z = Frame.Camera[5] - Frame.Camera[2];
		
		double p1x = Frame.Points.get(i).getX() - Frame.Camera[0];
		double p1y = Frame.Points.get(i).getY() - Frame.Camera[1];
		double p1z = Frame.Points.get(i).getZ() - Frame.Camera[2];
		
		double a1 = calculAngle(c1x, c1z);
		double b[] = cartRotate(c1x, c1z, a1);
		
		double c2y = c1y;
		double c2z = b[1];
		
		b = cartRotate(p1x, p1z, a1);
		
		double p2x = b[0];
		double p2y = p1y;
		double p2z = b[1];
		
		double a2 = calculAngle(c2z, c2y);
		b = cartRotate(p2z, p2y, a2);
		
		double p3x = p2x;
		double p3y = b[1];
		double p3z = b[0];
		
		Frame.Points.get(i).setC(calculLength(p1x, p1y, p1z));
		
		if(Frame.Euclidian) {
			
			Frame.Points.get(i).setA(p3x/Frame.focaleE);
			Frame.Points.get(i).setB(p3x/Frame.focaleE);
		} else {
			
			Frame.Points.get(i).setA(calculAngleReal(p3x, p3y)/Frame.focale);
			Frame.Points.get(i).setB(calculAngleReal(p3z, p3y)/Frame.focale);
		}
	}
	
	public static double calculAngle(double x, double y) {
		double a = 0;
		
		if(x > 0 && y > 0) a = Math.atan(Math.abs(x)/Math.abs(y));
		else if(x > 0 && y < 0) a = Math.atan(Math.abs(y)/Math.abs(x))+Math.PI/2;
		else if(x < 0 && y < 0) a = Math.atan(Math.abs(x)/Math.abs(y))+Math.PI;
		else if(x < 0 && y > 0) a = Math.atan(Math.abs(y)/Math.abs(x))+3*Math.PI/2;
		else if(x == 0 && y > 0)a = 0;
		else if(x == 0 && y < 0)a = Math.PI;
		else if(x > 0 && y == 0)a = Math.PI/2;
		else if(x < 0 && y == 0)a =3*Math.PI/2; 
		else a = 0;
		
		return a;
	}
	
	public static double calculAngleReal(double x, double y) {
		double a = 0;
		
		if(x > 0 && y > 0) a = Math.atan(Math.abs(x)/Math.abs(y));
		else if(x > 0 && y < 0) a = Math.atan(Math.abs(y)/Math.abs(x))+Math.PI/2;
		else if(x < 0 && y < 0) a = -(Math.atan(Math.abs(y)/Math.abs(x))+Math.PI/2);
		else if(x < 0 && y > 0) a = -(Math.atan(Math.abs(x)/Math.abs(y)));
		else if(x == 0 && y > 0)a = 0;
		else if(x == 0 && y < 0)a = Math.PI;
		else if(x > 0 && y == 0)a = Math.PI/2;
		else if(x < 0 && y == 0)a = -(Math.PI/2); 
		else a = 0;
		
		return a;
	}
	
	public static double calculLength(double x, double y) {
		
		return Math.sqrt(Math.pow(Math.abs(x), 2)+Math.pow(Math.abs(y), 2));
	}
	
	public static double calculLength(double x, double y, double z) {
		
		return Math.sqrt(Math.pow(Math.abs(x), 2)+Math.pow(Math.abs(calculLength(y, z)), 2));
	}
	
	public static double[] cartRotate(double x, double y, double a) {
		double a2 = calculAngle(x, y);
		double l = calculLength(x, y);
		a2-=a;
		double r[] = new double[2];
		r[0] = Math.sin(a2)*l;
		r[1] = Math.cos(a2)*l;
		
		return r;
	}
	
	public static void calculFace(int i) {
		
		double U[] = new double[3];
		U[0] = Frame.Points.get((int)Frame.Faces.get(i).getB()).getX()-Frame.Points.get((int)Frame.Faces.get(i).getA()).getX();
		U[1] = Frame.Points.get((int)Frame.Faces.get(i).getB()).getY()-Frame.Points.get((int)Frame.Faces.get(i).getA()).getY();
		U[2] = Frame.Points.get((int)Frame.Faces.get(i).getB()).getZ()-Frame.Points.get((int)Frame.Faces.get(i).getA()).getZ();
		double V[] = new double[3];
		V[0] = Frame.Points.get((int)Frame.Faces.get(i).getC()).getX()-Frame.Points.get((int)Frame.Faces.get(i).getA()).getX();
		V[1] = Frame.Points.get((int)Frame.Faces.get(i).getC()).getY()-Frame.Points.get((int)Frame.Faces.get(i).getA()).getY();
		V[2] = Frame.Points.get((int)Frame.Faces.get(i).getC()).getZ()-Frame.Points.get((int)Frame.Faces.get(i).getA()).getZ();
		double N[] = new double[3];
		N[0] = U[1]*V[2]-U[2]*V[1];
		N[1] = U[2]*V[0]-U[0]*V[2];
		N[2] = U[0]*V[1]-U[1]*V[0];
		double M[] = new double[3];
		M[0] = Frame.Points.get((int)Frame.Faces.get(i).getA()).getX()-Frame.Camera[0];
		M[1] = Frame.Points.get((int)Frame.Faces.get(i).getA()).getY()-Frame.Camera[1];
		M[2] = Frame.Points.get((int)Frame.Faces.get(i).getA()).getZ()-Frame.Camera[2];
		double P[] = new double[3];
		P[0] = Frame.Points.get((int)Frame.Faces.get(i).getA()).getX()+N[0];
		P[1] = Frame.Points.get((int)Frame.Faces.get(i).getA()).getY()+N[1];
		P[2] = Frame.Points.get((int)Frame.Faces.get(i).getA()).getZ()+N[2];
		double O[] = new double[3];
		O[0] = P[0]-Frame.Camera[0];
		O[1] = P[1]-Frame.Camera[1];
		O[2] = P[2]-Frame.Camera[2];
		double l1 = calculLength(M[0], M[1], M[2]);
		double l2 = calculLength(N[0], N[1], N[2]);
		double l3 = calculLength(O[0], O[1], O[2]);
		double a1 = Math.acos((Math.pow(l1, 2)+Math.pow(l2, 2)-Math.pow(l3, 2))/(2*l1*l2));
		if(a1 < Math.PI/2) Frame.Faces.get(i).setH(0);
		else Frame.Faces.get(i).setH(1);
	}
}
