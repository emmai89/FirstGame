package dev.codenmore.FirstGame.states;

import java.awt.Graphics;

import dev.codenmore.FirstGame.Game;
import dev.codenmore.FirstGame.Handler;

public abstract class State
{
	//Class
	
	protected Handler handler;
	public State(Handler handler)
	{
		this.handler = handler;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	// Pretty much a separate Class
	private static State currentState = null;
	
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
		return currentState;
	}
}
