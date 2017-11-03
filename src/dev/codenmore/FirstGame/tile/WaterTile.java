package dev.codenmore.FirstGame.tile;

import dev.codenmore.FirstGame.gfx.Annimation;
import dev.codenmore.FirstGame.gfx.Assets;

public class WaterTile extends Tile{
	
	private final static Annimation water = new Annimation(1000, Assets.water);

	public WaterTile(int id) 
	{
		super(water.getCurrentFrame(), id);
	}

	@Override
	public boolean isSolid()
	{
		return true;
	}
}
