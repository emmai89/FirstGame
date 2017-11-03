package dev.codenmore.FirstGame.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width = 100, height = 100, pHeight = 200;
	
	public static BufferedImage dirt, grass, stone, tree, flower, rock, log, standUp, standDown, standLeft, standRight;
	public static BufferedImage[] playerUp, playerDown, playerLeft, playerRight, start_image, atUp, atDown, atLeft, atRight, water;
	
	public static void init()
	{
		//Player
		SpriteSheet sheet_player = new SpriteSheet(ImageLoader.loadImage("/textures/person1.gif"));
		
		playerUp = new BufferedImage[4];
		playerDown = new BufferedImage[4];
		playerLeft = new BufferedImage[4];
		playerRight = new BufferedImage[4];
		
		standUp = sheet_player.crop(0, pHeight, width, pHeight);
		playerUp[0] = sheet_player.crop(width, pHeight, width, pHeight);
		playerUp[1] = sheet_player.crop(2*width, pHeight, width, pHeight);
		playerUp[2] = sheet_player.crop(3*width, pHeight, width, pHeight);
		playerUp[3] = sheet_player.crop(4*width, pHeight, width, pHeight);

		standDown = sheet_player.crop(0, 0, width, pHeight);
		playerDown[0] = sheet_player.crop(width, 0, width, pHeight);
		playerDown[1] = sheet_player.crop(2*width, 0, width, pHeight);
		playerDown[2] = sheet_player.crop(3*width, 0, width, pHeight);
		playerDown[3] = sheet_player.crop(4*width, 0, width, pHeight);

		standLeft = sheet_player.crop(0, 2*pHeight, width, pHeight);
		playerLeft[0] = sheet_player.crop(width, 2*pHeight, width, pHeight);
		playerLeft[1] = sheet_player.crop(2*width, 2*pHeight, width, pHeight);
		playerLeft[2] = sheet_player.crop(3*width, 2*pHeight, width, pHeight);
		playerLeft[3] = sheet_player.crop(4*width, 2*pHeight, width, pHeight);

		standRight = sheet_player.crop(0, 3*pHeight, width, pHeight);
		playerRight[0] = sheet_player.crop(width, 3*pHeight, width, pHeight);
		playerRight[1] = sheet_player.crop(2*width, 3*pHeight, width, pHeight);
		playerRight[2] = sheet_player.crop(3*width, 3*pHeight, width, pHeight);
		playerRight[3] = sheet_player.crop(4*width, 3*pHeight, width, pHeight);
		
		//Attack

		atUp = new BufferedImage[2];
		atDown = new BufferedImage[2];
		atLeft = new BufferedImage[2];
		atRight = new BufferedImage[2];
		
		atUp[0] = sheet_player.crop(5*width, pHeight, width, pHeight);
		atUp[1] = standUp;
				
		atDown[0] = sheet_player.crop(5*width, 0, width, pHeight);
		atDown[1] = standDown;

		atLeft[0] = sheet_player.crop(5*width, 2*pHeight, width, pHeight);
		atLeft[1] = standLeft;

		atRight[0] = sheet_player.crop(5*width, 3*pHeight, width, pHeight);
		atRight[1] = standRight;
		
		//Menu
		SpriteSheet sheet_start = new SpriteSheet(ImageLoader.loadImage("/textures/start.png"));
		start_image = new BufferedImage[2];
		start_image[0] = sheet_start.crop(0, 0, width, height);
		start_image[1] = sheet_start.crop(0, height, width, height);
		
		//World textures
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/testSheet.gif"));

		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(0, 0, width, height);
		stone = sheet.crop(2*width, 0, width, height);
		tree = sheet.crop(width, height, width-2, height);
		flower = sheet.crop(2*width, height, width, height);
		rock = sheet.crop(2*width, 2*height, width, height);
		log = sheet.crop(width, 2*height, width, height);
		
		water = new BufferedImage[2];
		water[0] = sheet.crop(0, height, width, height);
		water[1] = sheet.crop(0, 2*height, width, height);
	}
}
