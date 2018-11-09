package fr.EasyGameMotor.Core;

import fr.EasyGameMotor.Geometry.ColorSquare;

public class Main {
	
	private static double a = 0;
	
	public static Frame frame = new Frame("3D EasyGameMotor", 500, 500);
	
	public static void main(String[] args) {
		Texture texture = new Texture();
		
		//new ColorSphere(10, 10, 10);
		new ColorSquare(0, 0, 0, 10);
		//new ColorSquare(0, 0, 20, 10);
		frame.apllyScene();
		rotate.start();
	}

	
	private static Thread rotate = new Thread("rotating") {
		public void run() {
			while(true) {
				
				a += .0000001;
				Frame.Camera[0] = Math.sin(a)*80;
				Frame.Camera[2] = Math.cos(a)*80;	
			}
		}
	};
}
