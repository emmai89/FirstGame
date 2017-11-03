package dev.codenmore.FirstGame.states;

import java.awt.Graphics;

import dev.codenmore.FirstGame.Handler;
import dev.codenmore.FirstGame.entities.creature.Player;
import dev.codenmore.FirstGame.entities.statics.Tree;
import dev.codenmore.FirstGame.worlds.World;

public class GameState extends State
{
	private World world;
	
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}

	@Override
	public void tick() 
	{
		if(handler.getKeyManager().esc)
			State.setState(handler.getGame().menuState);
		world.tick();
	}

	@Override
	public void render(Graphics g) 
	{
		world.render(g);
	}
	
}
