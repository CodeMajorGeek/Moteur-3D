package fr.EasyGameMotor.Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import fr.EasyGameMotor.Core.Frame;
import fr.EasyGameMotor.Core.Main;

public class KeyControl extends KeyAdapter{
	
	private Frame frame;
	
	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == KeyEvent.VK_UP) {
			
			Frame.Camera[0] += 1;
			Frame.Camera[3] += 1;
		}
		if(k == KeyEvent.VK_DOWN) {
			
			Frame.Camera[0] -= 1;
			Frame.Camera[3] -= 1;
		}
		if(k == KeyEvent.VK_LEFT) {
			
			Frame.Camera[2] += 1;
			Frame.Camera[5] += 1;
		}
		if(k == KeyEvent.VK_RIGHT) {
			
			Frame.Camera[2] -= 1;
			Frame.Camera[5] -= 1;
		}
		
		if(k == KeyEvent.VK_F11) Main.frame.setFullScreen(!Main.frame.getFullScreen());
		if(k == KeyEvent.VK_ESCAPE) System.exit(0);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int k = e.getKeyCode();
		
		
	}

}
