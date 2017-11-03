package dev.codenmore.FirstGame;

public class Launcher 
{
	public static void main(String[] args)
	{
		Game game = new Game("Tile Game!", 700, 700/ 12 * 9);
		game.start();
	}

}
