package letsBuildaGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import letsBuildaGame.Game.STATE;

public class Menu extends MouseAdapter {
	public static final int WIDTH=640,HEIGHT=WIDTH/12*9;
	private Game game;
	private Handler handler;
	private Random r;
	private HUD hud;
public Menu(Game game,Handler handler,HUD hud)
{
	this.game=game;
	this.handler=handler;
	this.hud=hud;
}
public void MousePressed(MouseEvent e)
{
	int Mx = e.getX();
	int My= e.getY();
	//Play Button
	if( mouseOver(Mx,My,210,150,200,64))
	{
		
		game.gameState=STATE.Game;
		r= new Random();
		handler.clearEnemies();
		handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player,handler));
		handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.BasicEnemy,handler));
	}
	//Help Button
	if(mouseOver(Mx,My,210,250,200,64))
	{
		Game.gameState= STATE.Help;
	}
	
	//back Button for help
	if(Game.gameState==STATE.Help)
	{
		if(mouseOver(Mx,My,210,350,200,64))
		{
			Game.gameState=STATE.Menu;
			return;
		}
	}
	//Quit Button
	if(mouseOver(Mx,My,210,350,200,64))
	{
		System.exit(1);
	}
	//Try again
	if(Game.gameState==STATE.End)
	{
		if(mouseOver(Mx,My,210,350,200,64))
		{
			Game.gameState=STATE.Game;
			hud.score(0);
			handler.clearEnemies();
			handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player,handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50),r.nextInt(Game.HEIGHT-50),ID.BasicEnemy,handler));
			return;
		}
	}
}
public void MouseReleased(MouseEvent e)
{
	
}

private boolean mouseOver(int Mx,int My,int x,int y,int width, int height)
{
	
	if(Mx > x && Mx < x + width)
	{
		if(My>y && My < y + height)
		{
			return true;
		}
			return false;
	}
	return false;
	
}

public void tick()
{
	
}
	
	
	
public void render(Graphics g)
{
	if(Game.gameState==Game.STATE.Menu)
	{
	Font font = new Font("arial",1,50);
	Font font2= new Font("arial",1,50);
	
	g.setFont(font);
	g.setColor(Color.white);
	g.drawString("Menu",240,70);
	
	g.setFont(font2);
	g.drawString("Play",270, 190);
	g.setColor(Color.white);
	
	g.drawRect(210, 150, 200, 64);
	g.drawString("Help",270, 290);
	
	g.setColor(Color.white);
	g.drawRect(210, 250, 200, 64);
	
	g.drawString("Quit",270, 390);
	g.setColor(Color.white);
	
	g.drawRect(210, 350, 200, 64);
	}
	else if(Game.gameState==Game.STATE.Help)
	{
		Font font = new Font("arial",1,50);
		Font font2= new Font("arial",1,20);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Help",240,70);
		
		g.setFont(font2);
		g.drawString("Use wasd keys to use players and dodge enemies",50,100);
		
		
		g.drawString("Quit",270, 390);
		g.setColor(Color.white);
		g.drawRect(210, 350, 200, 64);
		
	}
	else if (Game.gameState==Game.STATE.End)
	{
		Font font1=new Font("arial",1,50);
		Font font2= new Font("arial",1,20);
		g.setFont(font1);
		g.drawString("Game Over",200, 70);
		
		g.setFont(font2);
		g.drawString("You lost with a score of: "+hud.getScore(),150,150);
		
		g.setFont(font2);
		g.drawRect(210, 350, 200, 64);
		g.drawString("Try Again", 270,390);
	}
}
}
