package dev.codenmore.FirstGame.worlds;

import java.awt.Graphics;
import java.util.Random;

import dev.codenmore.FirstGame.Handler;
import dev.codenmore.FirstGame.entities.EntityManager;
import dev.codenmore.FirstGame.entities.creature.Player;
import dev.codenmore.FirstGame.entities.statics.Rock;
import dev.codenmore.FirstGame.entities.statics.Tree;
import dev.codenmore.FirstGame.tile.Tile;
import dev.codenmore.FirstGame.utils.Utils;

public class World 
{
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private Random r;
	
	//Entities
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public World(Handler handler, String path)
	{
		r = new Random();
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		for(int ii = 0; ii < 10; ii++)
		{
			entityManager.addEntity(new Tree(handler, r.nextInt(1000), r.nextInt(1000)));
			entityManager.addEntity(new Rock(handler, r.nextInt(1000), r.nextInt(1000)));

		}
		LoadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick()
	{
		entityManager.tick();
	}
	
	public void render(Graphics g)
	{
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT );
		int xEnd = (int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y< yEnd; y++)
			for(int x = xStart; x < xEnd; x++)
				getTile(x,y).render(g,(int)(x*Tile.TILE_HEIGHT - handler.getGameCamera().getxOffset()),
											(int)(y*Tile.TILE_WIDTH - handler.getGameCamera().getyOffset()));
	
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y)
	{
		if(x < 0 || y <0 || x >= width || y >= height)
			return Tile.dirtTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void LoadWorld(String path)
	{
		String file = Utils.loadFileAsString(path);
		String[] token = file.split("\\s+");
		width = Utils.paraseInt(token[0]);
		height = Utils.paraseInt(token[1]);
		spawnX = Utils.paraseInt(token[2]);
		spawnY = Utils.paraseInt(token[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.paraseInt(token[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
