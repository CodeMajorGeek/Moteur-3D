package fr.EasyGameMotor.Geometry;

import fr.EasyGameMotor.Core.Frame;
import fr.EasyGameMotor.Utils.Edge;
import fr.EasyGameMotor.Utils.Point;

public class ColorSphere {
	
	public ColorSphere(float radius, int latitudes, int longitudes) {
		
		Point[] spherePoints = generateSphere(radius, latitudes, longitudes);
		for(int i = 0; i < spherePoints.length; i++) {
			
			Frame.createPoint(spherePoints[i].getX(), spherePoints[i].getY(), spherePoints[i].getZ());
		}
		
		for(int i = 0; i < spherePoints.length - 1; i++) {
			
			if(Math.abs(spherePoints[i+1].getY()-spherePoints[i].getY()) <= radius) {
				
				Frame.createEdge(i, i + 1);
			}
			
			
		}
		
		for(int i = 1; i < (latitudes*longitudes-longitudes-1); i++) {
			
			if(Edge.length(i, i + longitudes+1) < radius) Frame.createEdge(i, i + longitudes+1);
			System.out.println(i + " " + (i + longitudes+1));
		}
		
		double[] ally = new double[spherePoints.length];
		for(int i = 0; i < spherePoints.length - 1; i++) ally[i] = spherePoints[i].getY();
		
		for(int i = 0; i < spherePoints.length - 1; i++) {
			for(int u = 0; u < ally.length - 1; u++) {
				
				if(ally[i] == ally[u] && Math.abs(i-u) < latitudes + 1) Frame.createEdge(i, u);
			}
		}
		
		for(int i = 1; i < longitudes; i++) Frame.createEdge(i, i + latitudes*longitudes-latitudes);
	}
	
	static Point[] generateSphere(float radius, int latitudes, int longitudes) {

	    float latitude_increment = 360.0f / latitudes;
	    float longitude_increment = 180.0f / longitudes;
	    
	    Point[] vertices = new Point[latitudes*longitudes + 1];

	    int counter = 0;

	    for (float u = 0; u < 360.0f; u += latitude_increment) {
	        for (float t = 0; t < 180.0f; t += longitude_increment) {

	            float rad = radius;

	            float x = (float) (rad * Math.sin(Math.toRadians(t)) * Math.sin(Math.toRadians(u)));
	            float y = (float) (rad * Math.cos(Math.toRadians(t)));
	            float z = (float) (rad * Math.sin(Math.toRadians(t)) * Math.cos(Math.toRadians(u)));

	            vertices[counter++] = new Point(x, y, z, 0, 0, 0);
	        }
	    }
	    
	    vertices[vertices.length - 1] = new Point(0, -radius, 0, 0, 0, 0);
	    return vertices;
	}
}
