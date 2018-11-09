package fr.EasyGameMotor.Core;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import fr.EasyGameMotor.GameConfig.FPSConfig;
import fr.EasyGameMotor.Input.KeyControl;
import fr.EasyGameMotor.Input.MouseControl;
import fr.EasyGameMotor.Utils.Edge;
import fr.EasyGameMotor.Utils.Face;
import fr.EasyGameMotor.Utils.Point;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = -921909087672333483L;
	
	public static ArrayList<Point> Points = new ArrayList<Point>();
	public static ArrayList<Boolean> PointIs = new ArrayList<Boolean>();
	public static ArrayList<Edge> Edges = new ArrayList<Edge>();
	public static ArrayList<Boolean> EdgeIs  = new ArrayList<Boolean>();
	public static ArrayList<Face> Faces = new ArrayList<Face>();
	public static ArrayList<String> Textures = new ArrayList<String>();
	public static ArrayList<Boolean> FaceIs = new ArrayList<Boolean>();
	public static double focale = .6;
	public static double focaleE = 300;
	public static double Camera[] = new double[6];
	public static boolean Euclidian = false;
	private static boolean FULL_SCREEN = false;
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	private final int X, Y;
	
	private static Timer t = new Timer();
	private static int totalFrameCount = 0;
	public static int FPS;
	
	
	static Panel panel = new Panel();
	
	public Frame(String title, int x, int y) {
		this.X = x;
		this.Y = y;
		
		panel.addKeyListener(new KeyControl());
		panel.addMouseListener(new MouseControl());
		setTitle(title);
		setSize(X, Y);
		setContentPane(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setCursor(panel.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new java.awt.Point(0, 0), null));
		
		t.scheduleAtFixedRate(updateFPS, 1000, 1000);
		
		Camera[0] = -90;
		Camera[1] = 20;
		Camera[2] = -40;
	}
	
	private static TimerTask updateFPS = new TimerTask() {
	    public void run() {
	        
	    	FPS = totalFrameCount;
	    	
	        totalFrameCount = 0;
	    }
	};
	
	public void setFullScreen(boolean full_screen) {
		
		FULL_SCREEN = full_screen;
		if(FULL_SCREEN) device.setFullScreenWindow(this);
		else device.setFullScreenWindow(null);
	}
	
	public boolean getFullScreen() {
		
		return FULL_SCREEN;
	}
	
	private static Thread display = new Thread("EasyGameMotor_Display") {
		public void run() {
			
			double attente = 1000/FPSConfig.getFPSConfig();
			
			while(true) {
				
				double start = System.nanoTime();
				
				for(int i = 0; i < Points.size(); i++)if(PointIs.get(i)) Engine.calculPoint(i);
				for(int i = 0; i < Faces.size(); i++)if(FaceIs.get(i)) Engine.calculFace(i);
				panel.repaint();
				
				totalFrameCount++;
				
				double TimePassed = System.nanoTime() - start;
				
				int wait = (int) (attente - TimePassed/1000000);
				
				if(wait < 0) wait = 0;
				
				try{
					
					Thread.sleep(wait);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	};
	
	public static void createPoint(double x, double y, double z) {
		
		Points.add(new Point(x, y, z, 0., 0., 0.));
		PointIs.add(false);
		
		int i = 0;
		while(PointIs.get(i)) i++;
		
		Points.set(i, new Point(x, y, z, 0., 0., 0.));
		PointIs.add(i, true);
	}
	
	public static void createEdge(int x, int y) {
		
		Edges.add(new Edge(x, y));
		EdgeIs.add(false);
		
		int i = 0;
		while(EdgeIs.get(i)) i++;
		
		Edges.set(i, new Edge(x, y));
		EdgeIs.add(i, true);
	}
	
	public static void createFace(int A, int B, int C, Color c) {
		
		Faces.add(new Face(A, B, C, c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha(), 0, 0));
		FaceIs.add(false);
		
		int i = 0;
		while(FaceIs.get(i)) i++;
		
		Faces.set(i, new Face(A, B, C, c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha(), 0, 0));
		FaceIs.set(i, true);
	}
	
	public static void createTexture(String src, int A, int B, int C) {
		
		Faces.add(new Face(A, B, C, 0, 0, 0, 0, 0, 1));
		Textures.add(src);
		FaceIs.add(false);
		
		int i = 0;
		while(FaceIs.get(i)) i++;
		
		Faces.set(i, new Face(A, B, C, 0, 0, 0, 0, 0, 1));
		Textures.set(i, src);
		FaceIs.set(i, true);
	}
	
	public void apllyScene() {
		
		if(!display.isAlive()) display.start();
	}
}
