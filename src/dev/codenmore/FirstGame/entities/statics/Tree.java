package dev.codenmore.FirstGame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.FirstGame.Handler;
import dev.codenmore.FirstGame.gfx.Assets;
import dev.codenmore.FirstGame.tile.Tile;

public class Tree extends SaticEntity
{

	public Tree(Handler handler, float x, float y) 
	{
		super(handler, x, y, Tile.TILE_WIDTH*2, Tile.TILE_HEIGHT * 3);
		
		bounds.x = 28*2;
		bounds.y = 44*3;
		bounds.width = 7*3;
		bounds.height = 19*3;
	}

	@Override
	public void tick() 
	{
		
	}
	
	@Override
	public void die()
	{
		
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);
	
		/*g.setColor(Color.blue);
		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				(int)(y + bounds.y - handler.getGameCamera().getyOffset()), 
				bounds.width, bounds.height);*/ 
		  //Collision test
		}

}
