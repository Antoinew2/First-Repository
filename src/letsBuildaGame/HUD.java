package letsBuildaGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
public static int Health=100;
private int greenValue=255;
public static int score=0;
private int level=1;
public void tick()
	{
		
		Health=Game.clamp(Health,0,100);
		greenValue=Game.clamp(greenValue,0,255);
		greenValue=Health*2;
;	}
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(15,15,200,32);
		g.setColor(new Color(75,greenValue,0));
		g.fillRect(15,15,Health*2,32);
		g.setColor(Color.white);
		g.drawRect(15,15,Health*2,32);
		g.drawString("Score "+ score,15,64);
		g.drawString("Level "+ level,15,80);
	}
	public void score(int score)
	{
		this.score=score;
	}
	public static int getScore()
	{
		return score;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level=level;
	}
}
