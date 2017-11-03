package dev.codenmore.FirstGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
	private boolean[] keys;
	public boolean up, down, left, right, esc, sUp, sDown, sLeft, sRight;
	public boolean attack;
	
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	public void tick()
	{
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];		
		
		sUp = keys[KeyEvent.VK_UP];
		sDown = keys[KeyEvent.VK_DOWN];
		sLeft = keys[KeyEvent.VK_LEFT];
		sRight = keys[KeyEvent.VK_RIGHT];
		
		esc = keys[KeyEvent.VK_ESCAPE];
		
		attack = keys[KeyEvent.VK_SPACE];
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}

}
