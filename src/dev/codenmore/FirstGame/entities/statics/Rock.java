package dev.codenmore.FirstGame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.codenmore.FirstGame.Handler;
import dev.codenmore.FirstGame.gfx.Assets;
import dev.codenmore.FirstGame.tile.Tile;

public class Rock extends SaticEntity
{

	public Rock(Handler handler, float x, float y) 
	{
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		
		bounds.x = 15;
		bounds.y = 0;
		bounds.width = 43;
		bounds.height = 60;
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
		
		/*g.setColor(Color.blue);
		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				(int)(y + bounds.y - handler.getGameCamera().getyOffset()), 
				bounds.width, bounds.height); */
		  //Collision test
		
		g.drawImage(Assets.rock, (int)(x - handler.getGameCamera().getxOffset()), 
				(int)(y - handler.getGameCamera().getyOffset()), width, height, null);

		}

}
