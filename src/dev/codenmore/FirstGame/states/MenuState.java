package dev.codenmore.FirstGame.states;

import java.awt.Graphics;

import dev.codenmore.FirstGame.Game;
import dev.codenmore.FirstGame.Handler;
import dev.codenmore.FirstGame.gfx.Assets;
import dev.codenmore.FirstGame.ui.ClickListener;
import dev.codenmore.FirstGame.ui.UIImageButton;
import dev.codenmore.FirstGame.ui.UIManager;

public class MenuState extends State
{
	private UIManager uiManager;

	public MenuState(Handler handler)
	{
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200, 200, 100, 100, Assets.start_image, new ClickListener(){

			@Override
			public void onClick() {
				//handler.getMouseManager().setUIManager(null); // makes it not run after the click
				State.setState(handler.getGame().gameState);
			}}));
	}
	
	@Override
	public void tick()
	{
		uiManager.tick();
	}

	@Override
	public void render(Graphics g)
	{
		uiManager.render(g);
	}

}
