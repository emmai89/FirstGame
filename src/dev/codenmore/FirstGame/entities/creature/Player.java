package dev.codenmore.FirstGame.entities.creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.codenmore.FirstGame.Handler;
import dev.codenmore.FirstGame.entities.Entity;
import dev.codenmore.FirstGame.gfx.Annimation;
import dev.codenmore.FirstGame.gfx.Assets;

public class Player extends Creature
{
	//Animations
	private Annimation walkDown, walkUp, walkLeft, walkRight, atUp, atDown, atLeft, atRight;
	private int pos = 4;
	
	//Attack Timer
	private long lastAttackTimer, attackCoolDown = 1400, attackTimer = attackCoolDown;
	
	public Player(Handler handler, float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 11;
		bounds.y = 35;
		bounds.width = 28;
		bounds.height = 38;
		
		//Animations
		walkUp = new Annimation(100, Assets.playerUp);
		walkDown = new Annimation(100, Assets.playerDown);
		walkLeft = new Annimation(100, Assets.playerLeft);
		walkRight = new Annimation(100, Assets.playerRight);
		
		atUp = new Annimation(400, Assets.atUp);
		atDown = new Annimation(400, Assets.atDown);
		atLeft = new Annimation(400, Assets.atLeft);
		atRight = new Annimation(400, Assets.atRight);

	}

	@Override
	public void tick() 
	{
		//Animations
		atUp.tick();
		atDown.tick();
		atLeft.tick();
		atRight.tick();
		walkUp.tick();
		walkDown.tick();
		walkLeft.tick();
		walkRight.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//Attack
		checkAttacks();
		
	}
	
	private void checkAttacks()
	{
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCoolDown)
			return;
		
		Rectangle cb = getCollisionBounds(0,0);
		
		Rectangle a = new Rectangle();
		int aSize = 20;
		a.width = aSize;
		a.height = aSize;
		
		if(handler.getKeyManager().attack)
		{
			if(pos==1)
			{
				a.x = cb.x - aSize;
				a.y = cb.y +cb.height/2 - aSize/2;
			}
				
			if(pos==2)
			{
				a.x = cb.x + cb.width;
				a.y = cb.y +cb.height/2 - aSize/2;
			}
					
			if(pos==3)
			{
				a.x = cb.x + cb.width/2 - aSize/2;
				a.y = cb.y - aSize/2;
			}
			if(pos==4)
			{
				a.x = cb.x + cb.width/2 - aSize/2;
				a.y = cb.y + cb.height;
			}
			
			attackTimer = 0;
			
			for(Entity e: handler.getWorld().getEntityManager().getEntities())
			{
				if(e.equals(this))
					continue;
				if(e.getCollisionBounds(0, 0).intersects(a))
				{
					e.hurt(5);
					return;
				}
			}
		}
	}
	
	@Override
	public void die()
	{
		System.out.println("Game Over");
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(handler.getKeyManager().sUp)
			yMove = -speed;
		if(handler.getKeyManager().sDown)
			yMove = speed;
		if(handler.getKeyManager().sLeft)
			xMove = -speed;
		if(handler.getKeyManager().sRight)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) 
	{	
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
		/*g.setColor(Color.blue);
		g.fillRect((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				(int)(y + bounds.y - handler.getGameCamera().getyOffset()), 
				bounds.width, bounds.height);*/
	}
	
	private BufferedImage getCurrentAnimationFrame()
	{
		if(xMove < 0)
		{
			pos=1;
			if(handler.getKeyManager().attack)
				return atLeft.getCurrentFrame();
			else
				return walkLeft.getCurrentFrame();
		}
		if(xMove > 0)
		{
			pos=2;
			if(handler.getKeyManager().attack)
				return atRight.getCurrentFrame();
			else
				return walkRight.getCurrentFrame();		
		}
		if(yMove < 0)
		{
			pos=3;
			if(handler.getKeyManager().attack)
				return atUp.getCurrentFrame();
			else
				return walkUp.getCurrentFrame();
		}
		if(yMove > 0)
		{
			pos=4;
			if(handler.getKeyManager().attack)
				return atDown.getCurrentFrame();
			else
				return walkDown.getCurrentFrame();
		}
		
		if(pos==1)
			if(handler.getKeyManager().attack)
				return atLeft.getCurrentFrame();
			else
				return Assets.standLeft;
		if(pos==2)
			if(handler.getKeyManager().attack)
				return atRight.getCurrentFrame();
			else
				return Assets.standRight;
		if(pos==3)
			if(handler.getKeyManager().attack)
				return atUp.getCurrentFrame();
			else
				return Assets.standUp;
		else
			if(handler.getKeyManager().attack)
				return atDown.getCurrentFrame();
			else
				return Assets.standDown;
	}

}
