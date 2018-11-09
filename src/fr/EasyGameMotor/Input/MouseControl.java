package fr.EasyGameMotor.Input;

import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.EasyGameMotor.Core.Frame;

public class MouseControl extends MouseAdapter{

	int prev_x, prev_y, x, y;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		prev_x = e.getX();
		prev_y = e.getY();
		if(!t.isAlive()) t.start();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	private Thread t = new Thread("Mouse Controller") {
		public void run() {
			while(true) {
				
				x = MouseInfo.getPointerInfo().getLocation().x;
				if(prev_x > x) {
					
					Frame.Camera[3] -= 0.5;
					prev_x = x;
				}
				if(prev_x < x) {
					
					Frame.Camera[3] += 0.5;
					prev_x = x;
				}
				
				if(prev_x > x) {
					
					Frame.Camera[3] -= 0.5;
					prev_x = x;
				}
				if(prev_x < x) {
					
					Frame.Camera[3] += 0.5;
					prev_x = x;
				}
				
			}
		}
	};
	
}
